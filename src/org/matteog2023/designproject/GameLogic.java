package org.matteog2023.designproject;

import javafx.animation.AnimationTimer;
import javafx.scene.canvas.Canvas;
import javafx.scene.paint.Color;

import java.util.ArrayList;

public class GameLogic {
    private Player player;
    private Maze maze;
    private ArrayList<Enemy_Blob> blobs;
    private double width, height;
    private GameTimer gameTimer;
    public static final double GAME_STEP_TIMER = 12;




    public enum DIRECTION {
        LEFT,
        UP,
        RIGHT,
        DOWN,
        GRAVITY,
    }



    public GameLogic(double width, double height){
        gameTimer = new GameTimer();
        player = new Player();
        player.setWidth(10);
        player.setColor(Color.BLACK);
        maze = new Maze();
        player.x = 200;
        player.y = 400;
        blobs = new ArrayList<>();
        for(int i = 0; i < 5; i++){
            Enemy_Blob blob = new Enemy_Blob();
            blob.setWidth(10);
            blob.setColor(Color.RED);
            blob.x = 200;
            blob.y = 200;
            blobs.add(blob);
        }



    }

    public void render(Canvas canvas){
        width = canvas.getWidth();
        height = canvas.getHeight();
        player.render(canvas);
        for (Enemy_Blob blob : blobs) {
            blob.render(canvas);
        }
        maze.render_Maze1(canvas);
    }
    public void stop_player(){
        player.velX = 0;
        player.velY = 0;
    }
    public void applyForce(DIRECTION direction){
        if(direction == DIRECTION.LEFT){
            player.velX = 0;
            player.velX -= 5;
        }
        if(direction == DIRECTION.RIGHT){
            player.velX = 0;
            player.velX += 5;
        }
        if(direction == DIRECTION.UP){
            //Putting it behind this requirement so you can't jump more than once
            if(!player.jump) {
                player.jump = true;
                player.base_height = player.y;
                player.up = true;
            }
        }
        if(direction == DIRECTION.DOWN){
            player.velY = 0;
            player.velY += 5;
        }
        if(direction == DIRECTION.GRAVITY){
            player.gravity = !player.gravity;
        }
    }
    /**
     * Pause or unpause the game
     * @param setPaused true to pause, false otherwise
     */
    public void pause(boolean setPaused ){
        if( setPaused ){
            gameTimer.stop();
        }
        else {
            gameTimer.start();
        }
    }

    private class GameTimer extends AnimationTimer {
        // The last nanosecond
        private long lastUpdate;

        public GameTimer() {
            lastUpdate = 0;
        }

        @Override
        public void handle(long now) {
            // Covert the time_elapsed from nanoseconds to milliseconds
            long time_elaped = (now - lastUpdate) / 1000000;
            if (time_elaped > GameLogic.GAME_STEP_TIMER) {
                if (player.jump){

                    if (player.y > player.base_height){
                        player.jump = false;

                    }else{
                        player.jump((int) player.base_height, player);
                    }
                }

                player.move();
                maze.check_collisions(player);
                maze.falling(player);
                for(Enemy_Blob blob: blobs){
                    maze.falling(blob);
                    maze.check_collisions(blob);
                }

                lastUpdate = now;
            }
        }
    }
}
