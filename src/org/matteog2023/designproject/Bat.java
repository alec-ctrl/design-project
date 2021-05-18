package org.matteog2023.designproject;

import javafx.scene.paint.Color;

//because it has the same damage output and takes the same shape
public class Bat extends Enemy_Blob{
    //The x value from which the bat is starting out at
    public int base_x;

    /**
     * making a 10x10 square that is blue; a 'bat'
     */
    Bat(){
        this.setColor(Color.BLUE);
        this.setWidth(10);
    }

    /**
     * makes the bat swoop realistically to the right, then once it gets past a certain distance from the
     * base_x, putting it back there and starting the loop again
     */
    public void swoop(){
        double x_dif = base_x - this.x;
        if(x_dif < -70){
            this.x = base_x;
            this.y = base_height;

        }

        //The value subtracted will get bigger and then smaller; forming a parabola shaped flight path for
        //the bat
        this.y = this.base_height - .02*(-x_dif-35)*(-x_dif-35);
        this.x += 1.5;
    }

    /**
     * Moving the player just to the left of the bat
     * @param player the player that you are moving
     */
    public void move_player(Player player){
        player.x = this.x - player.getWidth();
    }

    /**
     * returns false because the bat does not get removed if you hit it
     */
    @Override
    public boolean remove_blob() {
        return false;
    }
}
