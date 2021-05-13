package org.matteog2023.designproject;

import javafx.animation.AnimationTimer;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.input.KeyEvent;
import javafx.scene.paint.Color;

import java.util.ArrayList;

public class GameLogic {
    private Player player;
    private Maze maze;
    //TODO DONT FORGET TO MAKE THIS AN ARRAYLIST IF YOU WANT MORE BATS
    private ArrayList<Bat> bats;
    private ArrayList<Enemy_Blob> blobs;
    private ArrayList<Coins> coins;
    private double width, height;
    private GameTimer gameTimer;
    public static final double GAME_STEP_TIMER = 15.75;
    private int Maze_num;
    private boolean shut_middle;
    private int lives;
    private int coin_num;
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



    public GameLogic(double width, double height, int maze_num, int life_left, int coin_nums){
        lives = life_left;
        coin_num = coin_nums;
        Maze_num = maze_num;
        gameTimer = new GameTimer();
        player = new Player();
        player.setWidth(10);
        player.setColor(Color.BLACK);
        maze = new Maze();
        blobs = new ArrayList<>();
        coins = new ArrayList<>();
        if(Maze_num == 1){
            Goal1.x = 470;
            Goal1.y = 60;
            Goal2.x = 10;
            Goal2.y = 270;
            maze.save_Maze1(width,height);
            for(int i = 0; i < 3; i++){
                Coins coin = new Coins();
                coin.setWidth(10);
                coin.x = 100 + 20 * i;
                coin.y = 375;
                coins.add(coin);
                Coins coin1 = new Coins();
                coin1.setWidth(10);
                coin1.x = 375 + 20 * i;
                coin1.y = 70;
                coins.add(coin1);
            }
            for(int i = 0; i < 5; i++){
                Coins coin = new Coins();
                coin.setWidth(10);
                coin.x = 300 + 20 * i;
                coin.y = 350;
                coins.add(coin);
                Coins coin1 = new Coins();
                coin1.setWidth(10);
                coin1.x = 300 + 20 * i;
                coin1.y = 210;
                coins.add(coin1);
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
            Goal1.x = 160;
            Goal1.y = 20;
            Goal2.x = 330;
            Goal2.y = 70;
            maze.save_Maze1(width,height);
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
            for(int i = 0; i < 2; i++){
                Coins coin = new Coins();
                coin.setWidth(10);
                coin.x = 410 + 20 * i;
                coin.y = 130;
                coins.add(coin);
            }
            for(int i = 0; i < 5; i++){
                Coins coin = new Coins();
                coin.setWidth(10);
                coin.x = 240 + 20*i;
                coin.y = 350;
                coins.add(coin);
                Coins coin1 = new Coins();
                coin1.setWidth(10);
                coin1.x = 300 + 20 * i;
                coin1.y = 210;
                coins.add(coin1);
                Coins coin2 = new Coins();
                coin2.setWidth(10);
                coin2.x = 100 + 20*i;
                coin2.y = 320;
                coins.add(coin2);
            }
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
                Coins coin = new Coins();
                coin.setWidth(10);
                coin.x = 70 + 20*i;
                coin.y = 70;
                coins.add(coin);
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
            Goal1.y = 10;
            Goal1.x = 150;
            Goal2.y = 60;
            Goal2.x = 300;
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
        Goal2.render(canvas, image);
        Goal1.render(canvas, image);
        for(int i = 0; i < coins.size(); i++){
            Coins coin = coins.get(i);
            if(!coin.intersects_player(player) ){
                coin.render(canvas);
            }
            if(coin.intersects_player(player)){
                coin_num++;
                coins.remove(coin);
            }
        }
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

        if((player.x > 270 || player.x < 230) && !shut_middle){
            maze.save_shut_middle(Maze_num);
            shut_middle = true;
        }
        if(shut_middle){
            maze.render_middle(canvas);
        }
        GraphicsContext gc = canvas.getGraphicsContext2D();
        gc.setFill(Color.BLACK);
        gc.fillText("Lives Left: "+ lives, 10,20);
        gc.fillText("Coins Left: "+ coin_num, 10,40);
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
    private void collideBlob(Enemy_Blob blob) {
        //above bottom
        //For this you essentially only need one thing of code because as soon as it detects you
        //hitting the blob, it will just remove it from the ArrayLis
        if (player.y <= blob.y &&
                //below top
                player.y + player.getWidth() >= blob.y + blob.getWidth() &&
                //left of right side
                player.x <= blob.x + blob.getWidth() &&
                //right of left side
                player.x + player.getWidth() >= blob.x
        ) {
            blobs.remove(blob);
            lives -= blob.Damage();
        }
    }
    private boolean collide_goal(goal Goal){

        return player.intersects(Goal);

    }
    private void collide_bat(){
        for (Bat bat : bats) {
            //Essentially the same code from collideMaze except replacing the maze with blob and ball with player
            if (player.y < bat.y + bat.getWidth() &&
                    //below top
                    player.y >= bat.y &&
                    //left of right side
                    player.x < bat.x + bat.getWidth() &&
                    //right of left side
                    player.x > bat.x &&
                    player.y + player.getWidth() < bat.y + bat.getWidth() &&
                    //below top
                    player.y + player.getWidth() > bat.y) {
                player.x = bat.x + 30;
                lives--;
            }

            //wall right
            if (player.y + player.getWidth() < bat.y + bat.getWidth() &&
                    //below top
                    player.y + player.getWidth() > bat.y &&
                    //left of right side
                    player.x + player.getWidth() < bat.y + bat.getWidth() &&
                    //right of left side
                    player.x + player.getWidth() > bat.x &&
                    player.y < bat.y + bat.getWidth() &&
                    //below top
                    player.y >= bat.y
                //left of right side

            ) {
                player.x = bat.x + 30;
                lives--;
            }

            //Using i here so I can detect more precise lengths while still detecting larger lengths
            for (int i = (int) player.getWidth(); i > 0; i--) {
                //bottom
                if (player.x < bat.x + bat.getWidth() &&
                        //below top
                        player.x > bat.x &&
                        //left of right side
                        player.y + player.getWidth() < bat.y + bat.getWidth() &&
                        //right of left side
                        player.y + player.getWidth() > bat.y &&
                        player.x + player.getWidth() - i < bat.x + bat.getWidth() &&
                        //below top
                        player.x + player.getWidth() - i > bat.x)
                //left of right side
                {
                    player.x = bat.x + 30;
                    lives--;

                }
                //top
                if (player.x < bat.x + bat.getWidth() &&
                        //below top
                        player.x > bat.x &&
                        //left of right side
                        player.y < bat.y + bat.getWidth() &&
                        //right of left side
                        player.y > bat.y &&
                        player.x + player.getWidth() - i < bat.x + bat.getWidth() &&
                        //below top
                        player.x + player.getWidth() - i > bat.x
                    //left of right side

                ) {

                    player.x = bat.x +30;
                    lives--;

                }
            }
            for (int i = (int) player.getWidth(); i > 0; i--) {
                //bottom
                if (player.x + i < bat.x + bat.getWidth() &&
                        //below top
                        player.x + i > bat.x &&
                        //left of right side
                        player.y + player.getWidth() < bat.y + bat.getWidth() &&
                        //right of left side
                        player.y + player.getWidth() > bat.y &&
                        player.x + player.getWidth() < bat.x + bat.getWidth() &&
                        //below top
                        player.x + player.getWidth() > bat.x)
                //left of right side
                {

                    player.x = bat.x + 30;
                    lives--;

                }
                //top
                if (player.x + i < bat.x + bat.getWidth() &&
                        //below top
                        player.x + i > bat.x &&
                        //left of right side
                        player.y < bat.y + bat.getWidth() &&
                        //right of left side
                        player.y > bat.y &&
                        player.x + player.getWidth() < bat.x + bat.getWidth() &&
                        //below top
                        player.x + player.getWidth() > bat.x
                    //left of right side

                ) {
                    player.x = bat.x + 30;
                    lives--;

                }
            }
        }
    }


    /**
     * keeping the player (or any enemy) on screen
     * And if they are on top, sticking them there
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

            if(!player.gravity){
                //so you can jump
                player.base_height = 0;
                //so 'falling' method in Maze doesn't run after this
                player.on_ground = true;
                player.jump = false;
            }
            if(!(player instanceof Enemy_Blob)){
                // If you end up on the top, transporting you to the bottom with one less life
                player.y = 400;
                lives--;
            }
        }
        if (player.y + player.getWidth() >= height){
            player.y = height - player.getWidth();
            if(player.gravity){
                //so you can jump
                player.base_height = height - player.getWidth();
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
                    collide_bat();
                    for(Bat bat : bats){
                        bat.swoop();

                    }
                }

                for(int i = 0; i < blobs.size(); i++){
                    Enemy_Blob blob = blobs.get(i);
                    maze.falling(blob);
                    maze.check_collisions(blob, Maze_num);
                    onScreen(blob);
                    collideBlob(blob);
                    blob.move();
                }


                if(collide_goal(Goal1) || collide_goal(Goal2)){

                    GameGUI gameGUI= new GameGUI(Maze_num + 1, lives, coin_num);
                    Scene scene = new Scene(gameGUI, 500,500);
                    Main.switchscene(scene);
                    player.x = 250;
                    player.y = 300;
                    scene.addEventHandler(KeyEvent.KEY_PRESSED, new EventHandler<KeyEvent>() {
                        @Override
                        public void handle(KeyEvent keyEvent) {
                            gameGUI.handleKeyPress(keyEvent);
                        }
                    });

                    scene.addEventHandler(KeyEvent.KEY_RELEASED, new EventHandler<KeyEvent>() {
                        @Override
                        public void handle(KeyEvent keyEvent) {
                            gameGUI.handleKeyRelease(keyEvent);
                        }
                    });
                }
                if(lives <= 0){
                    //TODO MAKE A RISK_RATING HERE
                    EndGraphic endGraphic= new EndGraphic("3");
                    Scene scene = new Scene(endGraphic, 500,500);
                    pause(true);
                    Main.switchscene(scene);
                }


                lastUpdate = now;
            }
        }
    }
}
