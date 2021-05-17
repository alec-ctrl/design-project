package org.matteog2023.designproject;

import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;

public class Spikes extends Enemy_Blob{
    private double height;


    Spikes(){
        this.setWidth(60);
        this.setHeight(20);
    }
    /**
     * Set the height of this object. The height must be positive.
     * @param height the new, positive, width of this object
     * @return true if the width is set, false if width is not changed
     */
    public boolean setHeight(double height){
        boolean rtn = false;
        if(height > 0){
            this.height = height;
            rtn = true;
        }
        return rtn;
    }
    @Override
    public boolean remove_blob() {
        return false;
    }

    /**
     *
     */
    public void move_player(Player player){
        player.x = this.x - player.getWidth();
    }
    /**
     * @param canvas the canvas you are drawing onto
     * @param image the image you are rendering
     */
    public void render(Canvas canvas, Image image){
        GraphicsContext gc = canvas.getGraphicsContext2D();
        gc.drawImage(image, x,y, getWidth(),height);
    }
}