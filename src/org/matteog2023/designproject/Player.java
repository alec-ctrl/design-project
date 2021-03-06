package org.matteog2023.designproject;

import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

public class Player {
    private double width;
    private Color color;
    //If you are jumping up
    public boolean up = true;
    //If you are jumping down
    public boolean down = false;
    //If you are actively in the middle of the jump
    //So you can't double-jump
    public boolean jump;
    //The base-height of your jump, so you return to that height
    //Reset when you hit ground again
    public double base_height;
    //top left of the player object
    public double x, y;
    public double velX, velY;
    //True if it is on, false if it is zero-gravity
    public boolean gravity = true;
    //If the player is on_ground
    public boolean on_ground;
    //So I can tell if the ball is on the ceiling and set jump to false
    public boolean on_ceiling;

    /**
     * Creates a rectangle with a width of one
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
     * Get the current height of this object
     * returning width because the player is a square
     * @return a positive width
     */
    public double getHeight(){
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

    /**
     * the function for jumping
     * @param base_height what height you began your jump at
     * @param player the player that is jumping
     */
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
     * checking if a player object is falling based on if it doesn't have ground under it and the gravity orientation
     */
    public void falling(){
        if(!this.on_ground && !this.jump && this.gravity){
            this.y += 4;

        } else if(!this.on_ground && !this.jump){
            this.y -= 2;
        }
        if(this.on_ceiling && this.gravity){
            this.y += 4;
            //need to break the jump so I dont get stuck in some loop
            this.jump = false;
        }
        if(this.on_ceiling && !this.gravity){

            this.y -= 2;
            //need to break the jump so I dont get stuck in some loop
            this.jump = false;
        }
        this.on_ground = false;
        this.on_ceiling = false;
    }

    /**
     * moving the player according to what type of enemy it is
     */
    public void move_player(Player player){
    }

    /**
     * in case you hit a wall
     */
    public void bounce(){
        this.velX *= -1;
    }


    /**
     * rendering everything
     * @param canvas what you are drawing on
     */
    public void render( Canvas canvas ){

        GraphicsContext gc = canvas.getGraphicsContext2D();
        gc.setFill(this.color);
        gc.fillRect(x, y, width, width );
    }

}

