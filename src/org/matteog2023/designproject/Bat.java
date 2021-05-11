package org.matteog2023.designproject;

import javafx.scene.paint.Color;

//because it has the same damage output and takes the same shape
public class Bat extends Enemy_Blob{
    public int base_x;
    private boolean reverse = false;
    Bat(){
        this.setColor(Color.BLUE);
        this.setWidth(10);
    }

    public void swoop(){
        double x_dif = base_x - this.x;
        if(x_dif < -70){
            reverse = !reverse;
            this.x = base_x;
            this.y = base_height;

        }

        this.y = this.base_height - .02*(-x_dif-35)*(-x_dif-35);

        this.x += 1.5;
    }
}
