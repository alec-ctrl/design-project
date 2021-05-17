package org.matteog2023.designproject;

import javafx.scene.paint.Color;

//because it has the same damage output and takes the same shape
public class Bat extends Enemy_Blob{
    public int base_x;
    private boolean reverse = false;

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
            reverse = !reverse;
            this.x = base_x;
            this.y = base_height;

        }

        this.y = this.base_height - .02*(-x_dif-35)*(-x_dif-35);

        this.x += 1.5;
    }
    public void move_player(Player player){
        player.x = this.x - player.getWidth();
    }

    @Override
    public boolean remove_blob() {
        return false;
    }
}
