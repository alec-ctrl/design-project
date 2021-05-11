package org.alecs2023.designproject;

import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;

public class goal {
    public double x;
    public double y;
    private double width;

    goal(){
        width = 30;
    }
    public double getWidth(){
        return this.width;
    }

    public void render(Canvas canvas, Image image){
        GraphicsContext gc = canvas.getGraphicsContext2D();
        gc.drawImage(image, x,y, width,width);
    }




}
