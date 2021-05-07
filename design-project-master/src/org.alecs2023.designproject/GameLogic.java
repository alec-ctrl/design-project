package org.alecs2023.designproject;

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
    private int Maze_num;




    public enum DIRECTION {
        LEFT,
        UP,
        RIGHT,
        DOWN,
        GRAVITY,
    }



    public GameLogic(double width, double height, int maze_num){
        Maze_num = maze_num;
        gameTimer = new GameTimer();
        player = new Player();
        player.setWidth(10);
        player.setColor(Color.BLACK);
        maze = new Maze();
        if(Maze_num == 1){
            maze.save_Maze1(width,height);
        }
        if(Maze_num == 2){
            maze.save_Maze2(width,height);
        }
        if(Maze_num == 3){
            maze.save_Maze3(width,height);
        }

        player.x = 200;
        player.y = 400;
        blobs = new ArrayList<>();
        for(int i = 0; i < 5; i++){
            Enemy_Blob blob = new Enemy_Blob();
            blob.setWidth(10);
            blob.setColor(Color.RED);
            blob.x = 300 + 20 * i;
            blob.y = 400;
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
        if(Maze_num == 1){
            maze.render_Maze1(canvas);
        }
        if(Maze_num == 2){
            maze.render_Maze2(canvas);
        }
        if(Maze_num == 3){
            maze.render_Maze3(canvas);
        }
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
            //calling this here to reset the on_ground function and to make it so you cant
            //jump in the air
            maze.check_collisions(player, Maze_num);
            //Putting it behind this requirement so you can't jump more than once
            if(!player.jump && player.gravity && player.on_ground) {
                player.jump = true;
                player.base_height = player.y;
                player.up = true;
            }
        }
        if(direction == DIRECTION.DOWN){
            //calling this here to reset the on_ground function, and to make it so you cant
            //jump in the air
            maze.check_collisions(player, Maze_num);
            //TODO ONGROUND FUNCTION IS NOT WORKING
            if(!player.jump && !player.gravity && player.on_ground)  {
                player.jump = true;
                player.base_height = player.y;
                player.down = true;
            }
        }
        if(direction == DIRECTION.GRAVITY){
            player.gravity = !player.gravity;
            for(Enemy_Blob blob : blobs){
                blob.gravity = !blob.gravity;
            }
        }
    }
    private void collideBlob(Enemy_Blob blob){
        //above bottom

        if(player.y <= blob.y  &&
                //below top
                player.y + player.getWidth() >= blob.y - blob.getWidth() &&
                //left of right side
                player.x <= blob.x + blob.getWidth() &&
                //right of left side
                player.x + player.getWidth() >= blob.x
        ) {
            blob.bounce();
            player.bounce();
        }

    }

    /**
     * keeping the player (or any ememy) on screen
     * @param player any like enemy or the player
     */
    private void onScreen(Player player){
        if (player.x <= 0){
            player.x = 0;
            if(player instanceof Enemy_Blob){
                player.bounce();
            }
        }
        if(player.x >= width) {
            player.x = width - player.getWidth();
            if(player instanceof Enemy_Blob){
                player.bounce();
            }
        }
        if (player.y <= 0){
            player.y = 0;
            if(!player.gravity){
                //so you can jump
                player.base_height = 0;
                //so 'falling' method in Maze doesn't run after this
                player.on_ground = true;
                player.jump = false;
            }
        }
        if (player.y + player.getWidth() >= height){
            player.y = height - player.getWidth();
            if(player.gravity){
                //so you can jump
                player.base_height = height-player.getWidth();
                //so 'falling' method in Maze doesn't run after this
                player.on_ground = true;
                player.jump = false;

            }
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

                    player.jump((int) player.base_height, player);
                }


                player.move();
                maze.check_collisions(player, Maze_num);
                onScreen(player);

                maze.falling(player);


                for(Enemy_Blob blob: blobs){
                    maze.falling(blob);
                    maze.check_collisions(blob, Maze_num);
                    onScreen(blob);
                    collideBlob(blob);
                    blob.move();

                }

                lastUpdate = now;
            }
        }
    }
}
