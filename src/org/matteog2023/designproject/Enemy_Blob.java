package org.matteog2023.designproject;

public class Enemy_Blob extends Player{

    Enemy_Blob(){
        this.velX = 1;
    }
    /**
     * @return how much damage this enemy does
     */
    public int Damage(){
        return 1;
    }

    /**
     * @return if the blob is supposed to disappear after you hit it
     */
    public boolean remove_blob(){return true;}


}
