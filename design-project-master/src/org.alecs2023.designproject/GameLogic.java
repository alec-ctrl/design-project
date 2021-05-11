package org.alecs2023.designproject;

import javafx.animation.AnimationTimer;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.paint.Color;

import java.util.ArrayList;

public class GameLogic {
    private Player player;
    private Maze maze;
    //TODO DONT FORGET TO MAKE THIS AN ARRAYLIST IF YOU WANT MORE BATS
    private ArrayList<Bat> bats;
    private ArrayList<Enemy_Blob> blobs;
    private double width, height;
    private GameTimer gameTimer;
    public static final double GAME_STEP_TIMER = 15.75;
    private int Maze_num;
    private boolean shut_middle;
    private double lives = 3;
    goal Goal1 = new goal();
    goal Goal2 = new goal();
    Image image = new Image("https://cdn2.iconfinder.com/data/icons/symbol-gray-set-3a/100/1-15-512.png");





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
        blobs = new ArrayList<>();
        if(Maze_num == 1){
            Goal1.x = 470;
            Goal1.y = 60;
            Goal2.x = 10;
            Goal2.y = 270;
            maze.save_Maze1(width,height);
            for(int i = 0; i < 5; i++){
                Enemy_Blob blob = new Enemy_Blob();
                blob.setWidth(10);
                blob.setColor(Color.RED);
                blob.x = 300 + 20 * i;
                blob.y = 400;
                blobs.add(blob);
            }
            for(int i = 0; i < 5; i++){
                Enemy_Blob blob = new Enemy_Blob();
                blob.setWidth(10);
                blob.setColor(Color.RED);
                blob.x = 30 + 20 * i;
                blob.y = 400;
                blobs.add(blob);
            }
            for(int i = 0; i < 5; i++){
                Enemy_Blob blob = new Enemy_Blob();
                blob.setWidth(10);
                blob.setColor(Color.RED);
                blob.x = 250 + 20 * i;
                blob.y = 250;
                blobs.add(blob);
            }
        }
        if(Maze_num == 2){
            maze.save_Maze2(width,height);

            bats = new ArrayList<>();
            Bat bat1= new Bat();
            bats.add(bat1);
            bat1.y = 230;
            bat1.x = 340;
            bat1.base_x = 340;
            bat1.base_height = bat1.y;
            Bat bat2 = new Bat();
            bat2.y = 360;
            bat2.x = 320;
            bat2.base_x = 320;
            bat2.base_height = bat2.y;
            bats.add(bat2);
            Bat bat3 = new Bat();
            bat3.y = 90;
            bat3.x = 90;
            bat3.base_x = 100;
            bat3.base_height = bat3.y;
            bats.add(bat3);

            for(int i = 0; i < 5; i++){
                Enemy_Blob blob = new Enemy_Blob();
                blob.setWidth(10);
                blob.setColor(Color.RED);
                blob.x = 250 + 20 * i;
                blob.y = 400;
                blobs.add(blob);
            }
            for(int i = 0; i < 5; i++){
                Enemy_Blob blob = new Enemy_Blob();
                blob.setWidth(10);
                blob.setColor(Color.RED);
                blob.x = 310 + 20 * i;
                blob.y = 200;
                blobs.add(blob);
            }
            for(int i = 0; i < 3; i++){
                Enemy_Blob blob = new Enemy_Blob();
                blob.setWidth(10);
                blob.setColor(Color.RED);
                blob.x = 310 + 20 * i;
                blob.y = 100;
                blobs.add(blob);
            }
            for(int i = 0; i < 5; i++){
                Enemy_Blob blob = new Enemy_Blob();
                blob.setWidth(10);
                blob.setColor(Color.RED);
                blob.x = 100 + 20 * i;;
                blob.y = 100;
                blobs.add(blob);
            }
        }
        if(Maze_num == 3){
            bats = new ArrayList<>();
            Bat bat1 = new Bat();
            bat1.y = 90;
            bat1.x = 90;
            bat1.base_x = 90;
            bat1.base_height = bat1.y;
            bats.add(bat1);
            Bat bat2 = new Bat();
            bat2.y = 190;
            bat2.x = 300;
            bat2.base_x = 300;
            bat2.base_height = bat2.y;
            bats.add(bat2);
            for(int i = 0; i < 5; i++){
                Enemy_Blob blob = new Enemy_Blob();
                blob.setWidth(10);
                blob.setColor(Color.RED);
                blob.x = 100 + 20 * i;;
                blob.y = 100;
                blobs.add(blob);
            }
            for(int i = 0; i < 5; i++){
                Enemy_Blob blob = new Enemy_Blob();
                blob.setWidth(10);
                blob.setColor(Color.RED);
                blob.x = 300 + 20 * i;;
                blob.y = 300;
                blobs.add(blob);
            }
            for(int i = 0; i < 5; i++){
                Enemy_Blob blob = new Enemy_Blob();
                blob.setWidth(10);
                blob.setColor(Color.RED);
                blob.x = 300 + 20 * i;;
                blob.y = 100;
                blobs.add(blob);
            }
            maze.save_Maze3(width,height);
        }

        player.x = 250;
        player.y = 450;

    }

    public void render(Canvas canvas){
        width = canvas.getWidth();
        height = canvas.getHeight();
        player.render(canvas);
        Goal1.render(canvas, image);
        Goal2.render(canvas, image);
        for (Enemy_Blob blob : blobs) {
            blob.render(canvas);
        }
        if(Maze_num == 1){
            maze.render_Maze1(canvas);
        }
        if(Maze_num == 2){
            maze.render_Maze2(canvas);
            for(Bat bat : bats){
                bat.render(canvas);
            }

        }
        if(Maze_num == 3){
            maze.render_Maze3(canvas);
            for(Bat bat : bats){
                bat.render(canvas);
            }
        }
        if( player.x > 270 || player.x < 230 || shut_middle){
            maze.shut_middle(Maze_num, canvas);
            shut_middle = true;
        }
        GraphicsContext gc = canvas.getGraphicsContext2D();
        gc.setFill(Color.BLACK);
        gc.fillText("Lives Left: "+ lives, 10,20);
    }
    public void stop_player(){
        player.velX = 0;
        player.velY = 0;
    }
    public void applyForce(DIRECTION direction){
        if(direction == DIRECTION.LEFT){
            player.velX = 0;
            player.velX -= 4;
        }
        if(direction == DIRECTION.RIGHT){
            player.velX = 0;
            player.velX += 4;
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
            if(blob instanceof Bat){
                player.bounce();
            } else{
                blob.bounce();
                player.bounce();
            }
            lives -= blob.Damage();
        }

    }
    private boolean collide_goal(goal Goal){
        //Just the standard pythagorean formula to determine the length between the centers of the
        //goal and player
        double distance_between = Math.sqrt(Math.pow((player.x - Goal.x + player.getWidth()/2 + Goal.getWidth()/2), 2) + Math.pow((player.y - Goal.y + player.getWidth()/2 + Goal.getWidth()/2), 2));
        //Returning true or false if the distance between the goal and player is
        //less than the sum of the radii
        return distance_between < player.getWidth()/2 + Goal.getWidth()/2;
    }


    /**
     * keeping the player (or any ememy) on screen
     * And if they are on top, sticking them there
     * @param player any like enemy or the player
     *
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
                if (Maze_num == 2 || Maze_num == 3){
                    for(Bat bat : bats){
                            bat.swoop();
                            collideBlob(bat);
                    }
                }



                for(Enemy_Blob blob: blobs){
                    maze.falling(blob);
                    maze.check_collisions(blob, Maze_num);
                    onScreen(blob);
                    collideBlob(blob);
                    blob.move();
                }
                if(collide_goal(Goal1) || collide_goal(Goal2)){
                    GameGUI gameGUI= new GameGUI(Maze_num + 1);
                    Scene scene = new Scene(gameGUI, 500,500);
                    Main.switchscene(scene);
                }


                lastUpdate = now;
            }
        }
    }
}
