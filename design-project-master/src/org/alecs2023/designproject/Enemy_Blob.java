package org.alecs2023.designproject;

public class Enemy_Blob extends Player{
    /**
     *
     * @return how much damage this enemy does
     */
    public int Damage(){
        return -1;
    }

    /**
     * in case you hit a wall
     */
    public void bounce(){
        this.velX *= -1;
    }
}
