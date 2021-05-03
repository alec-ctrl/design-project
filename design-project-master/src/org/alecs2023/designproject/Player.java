package org.alecs2023.designproject;

import javafx.geometry.Point2D;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

public class Player {
    private double width;
    private Color color;
    public boolean up = true;
    public boolean jump;
    public double base_height;
    public double x, y;     //Center point of the square
    public double velX, velY;
    public boolean gravity = true;
    public boolean on_ground;



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

    public boolean jump(int base_height, Player player){
        int height = (int) (base_height - player.y );
        int x = (int) (Math.sqrt(-height + 10)+3);
        if (height > 70){
            up = false;
        }
        if(up){
            player.y -= ((((x+2)-3)*((x+2)-3))+10)/3;
        }else{
            player.y += ((((x+2)-3)*((x+2)-3))+10)/3;

        }


        if(player.y >= base_height){
            player.y = base_height+1;


            return false;
        }
        return true;

    }

    public void render( Canvas canvas ){

        GraphicsContext gc = canvas.getGraphicsContext2D();
        gc.setFill(this.color);
        gc.fillRect(x, y, width, width );
    }
}

