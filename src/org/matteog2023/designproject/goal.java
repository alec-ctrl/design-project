package org.matteog2023.designproject;

import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;

public class goal {
    public double x;
    public double y;
    private double width;

    /**
     * making a goal with width 30
     */
    goal(){
        width = 30;
    }

    /**
     * @return the width of the goal
     */
    public double getWidth(){
        return this.width;
    }

    /**
     * @param canvas the canvas you are drawing onto
     * @param image the image you are rendering
     */
    public void render(Canvas canvas, Image image){
        GraphicsContext gc = canvas.getGraphicsContext2D();
        gc.drawImage(image, x,y, width,width);
    }




}
