package org.matteog2023.designproject;

import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

public class Player {
    private double width;
    private Color color;
    public boolean up = true;
    public boolean down = false;
    public boolean jump;
    public double base_height;
    public double x, y;     //Center point of the square
    public double velX, velY;
    public boolean gravity = true;
    public boolean on_ground;
    //So I can tell if the ball is on the ceiling and set jump to false
    public boolean on_ceiling;



    private double[] boundX, boundY;
    /**
     * Creates a rectangle with a wdith of one
     */
    public Player(){
        this(1);
    }

    /**
     * Creates a square with a custom width (in pixels)
     * @param width the width (in pixels) to set of the rectangle; Non-positives are reset to one
     *  (add this comment before a non public method)(this is a constructor)
     */
    public Player( double width ){
        color = Color.BLACK;
        if (width <= 0){
            width = 1;
        }
        this.width = width;

        boundX = new double[2];
        boundY = new double[2];
    }

    /**
     * Set the width of this object.  A rectangle's width must be positive.
     * @param width the new, positive, width of this object
     * @return true if the width is set, false if width is not changed
     */
    public boolean setWidth(double width){
        boolean rtn = false;
        if(width > 0){
            this.width = width;
            rtn = true;
        }
        return rtn;
    }

    /**
     * Get the current width of this object
     * @return a positive width
     */
    public double getWidth(){
        return this.width;
    }

    /**
     * Sets the color of the ball
     * @param c the new color of the ball (cannot be null)
     * @return true if the color has changed, false otherwise
     */
    public boolean setColor( Color c ){
        if(c == null){
            return false;
        }
        this.color = c;
        return true;
    }

    /**
     * Get the current color of the ball
     * @return the current color of the ball
     */
    public Color getColor(){
        return this.color;
    }


    /**
     * Move the ball along its trajectory vector
     */
    public void move(){

        double moveVelX = this.velX;
        double moveVelY = this.velY;

        this.x += moveVelX;
        this.y += moveVelY;

    }

    public void jump(int base_height, Player player ){
        int height = (int) (base_height - player.y );

        //Increasing the denominator here increases the amount of time in the air (more x's)
        int x = (int) Math.sqrt((height*8-14)/.4) + 1 ;
        int downx = (int) Math.sqrt((Math.abs(height)*8-14)/.4) + 1;

        if (x > 35 || !gravity){
            up = false;
            x = 1;
        }
        if (downx > 35 || gravity) {
            down = false;
            downx = 1;
        }
        double acceleration_formula = (.05 * ((x - 35) * (x - 35)) + 14) / 8;
        double acceleration_formula_down = (.05 * ((downx - 35) * (downx - 35)) + 14) / 8;
        if(up) {
            player.y -= acceleration_formula;

        } else if (gravity){
            player.y += acceleration_formula;
        }
        if(down) {
            player.y += acceleration_formula_down;
        } else if (!gravity){
            player.y -= acceleration_formula_down;
        }
    }

    /**
     * Check to see if two objects overlap each other
     * Will not be that accurate because this is for circles, but it is good enough for checking player
     * collisions with the goal
     * @param other the other object
     * @return true is this object intersects with other, false otherwise
     */
    public boolean intersects(goal other){
        double xd = (other.x - this.x);
        xd = Math.pow(xd, 2);

        double yd = (other.y - this.y);
        yd = Math.pow(yd, 2);


        double rad = other.getWidth()/2 + this.width/2;
        rad *= rad;

        double distance = xd + yd;
        return (distance < rad);
    }
    /**
     * Check to see if two objects overlap each other
     * Will not be that accurate because this is for circles, but it is good enough for checking player
     * collisions with the goal
     * @param other the other object
     * @return true is this object intersects with other, false otherwise
     */
    public boolean intersects_player(Player other){
        double xd = (other.x - this.x);
        xd = Math.pow(xd, 2);
        double yd = (other.y - this.y);
        yd = Math.pow(yd, 2);


        double rad = other.getWidth()/2 + this.width/2;
        rad *= rad;


        double distance = xd + yd;
        return (distance < rad);
    }

    /**
     * in case you hit a wall
     */
    public void bounce(){
        this.velX *= -1;
    }

    public void render( Canvas canvas ){

        GraphicsContext gc = canvas.getGraphicsContext2D();
        gc.setFill(this.color);
        gc.fillRect(x, y, width, width );
    }

}

