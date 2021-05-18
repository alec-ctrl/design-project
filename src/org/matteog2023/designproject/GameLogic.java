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
    //the player
    private Player player;
    //The maze
    private Maze maze;
    //The Bats bats
    private ArrayList<Bat> bats;
    //The Enemy_Blob arraylist
    private ArrayList<Enemy_Blob> blobs;
    //the Coin arraylist
    private ArrayList<Coins> coins;
    private ArrayList<Spikes> spikes;
    //The width and height of the canvas
    private double width, height;
    private GameTimer gameTimer;
    private static final double GAME_STEP_TIMER = 15.75;
    //What level maze you are on
    private int Maze_num;
    //'True' if the middle is blocked off so you cant go over to the other side
    private boolean shut_middle;
    //how many lives the player is
    private int lives;
    //the number of coins the player has
    private int coin_num;
    //The two goals
    private goal Goal1 = new goal();
    private goal Goal2 = new goal();
    //The goal image
    private Image image = new Image("https://cdn2.iconfinder.com/data/icons/symbol-gray-set-3a/100/1-15-512.png");
    //spikes
    private Image image2 = new Image("http://piskel-resizer.appspot.com/resize?size=200&url=http%3A%2F%2Fwww.piskelapp.com%2Fimg%2Faf5ae09e-7f4e-11e6-ac94-3be9fd4c96e3.png");
    //Flipped over spikes
    private Image image3 = new Image("https://mpng.subpng.com/20190621/vvr/kisspng-2-18-mini-cooper-image-drawing-sprite-pixel-pixilart-backside2-by-zak123-5d0da0b377c724.8345581615611741954906.jpg");
    //Having this gameGUI here so I can pause it when I switch scenes
    private GameGUI gameGUi;
    //Counts up for each maze depending on if you took the riskier path
    //max of 5
    private int risk_num;
    //This is to make sure I am not counting up the risk_num when the player is just
    //on the same level and entering the shop
    boolean Same_level;

    public enum DIRECTION {
        LEFT,
        UP,
        RIGHT,
        DOWN,
        GRAVITY,
    }


    /**
     *
     * @param width The width of the canvas
     * @param height The height of the canvas
     * @param maze_num What Maze the player is on; here so after you shop you end up on the same maze
     * @param life_left how much life you have; a parameter here so that you can save the value after you go shop
     * @param coin_nums how many coins you have; it will change after you go shop
     * @param gameGUI the GameGui; here so I can pause animtimer and gametimer when I switch to a different scene
     * @param risk1_num what risk number you are at
     * @param same_level if you are spawning on the same level you were just on; ie. did you just use the shop
     */
    public GameLogic(double width, double height, int maze_num, int life_left, int coin_nums, GameGUI gameGUI, int risk1_num, boolean same_level){
        // Setting all the private attributes
        Same_level = same_level;
        risk_num = risk1_num;
        lives = life_left;
        gameGUi = gameGUI;
        coin_num = coin_nums;
        Maze_num = maze_num;
        gameTimer = new GameTimer();
        player = new Player();
        maze = new Maze();
        blobs = new ArrayList<>();
        coins = new ArrayList<>();
        spikes = new ArrayList<>();
        //Setting the attributes of the player
        player.setWidth(10);
        player.setColor(Color.BLACK);
        //Checking to see what maze you want to display
        if(Maze_num == 1){
            Goal1.x = 470;
            Goal1.y = 60;
            Goal2.x = 10;
            Goal2.y = 270;
            //saving Maze_1
            maze.save_Maze1(width,height);
            //placing two sets of three coins
            for(int i = 0; i < 3; i++){
                Coins coin = new Coins();
                coin.setWidth(10);
                //Spacing each coin from another in the 'set' by 20 pixels
                coin.x = 100 + 20 * i;
                coin.y = 375;
                coins.add(coin);
                Coins coin1 = new Coins();
                coin1.setWidth(10);
                coin1.x = 375 + 20 * i;
                coin1.y = 70;
                coins.add(coin1);
            }
            //Placing a set of 5 coins and three sets of 5 enemies
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
                Enemy_Blob blob2 = new Enemy_Blob();
                blob2.setWidth(10);
                blob2.setColor(Color.RED);
                blob2.x = 30 + 20 * i;
                blob2.y = 400;
                blobs.add(blob2);
                Enemy_Blob blob3 = new Enemy_Blob();
                blob3.setWidth(10);
                blob3.setColor(Color.RED);
                blob3.x = 250 + 20 * i;
                blob3.y = 250;
                blobs.add(blob3);
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
            //Placing 3 sets of coins and 3 sets of blobs, each with 5 enemies
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
                Enemy_Blob blob = new Enemy_Blob();
                blob.setWidth(10);
                blob.setColor(Color.RED);
                blob.x = 250 + 20 * i;
                blob.y = 400;
                blobs.add(blob);
                Enemy_Blob blob2 = new Enemy_Blob();
                blob2.setWidth(10);
                blob2.setColor(Color.RED);
                blob2.x = 310 + 20 * i;
                blob2.y = 200;
                blobs.add(blob2);
                Enemy_Blob blob3 = new Enemy_Blob();
                blob3.setWidth(10);
                blob3.setColor(Color.RED);
                blob3.x = 100 + 20 * i;
                blob3.y = 100;
                blobs.add(blob3);
            }
            //Adding a set of coins and blobs, each with 3 enemies
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
        }
        if(Maze_num == 3){
            Goal1.y = 10;
            Goal1.x = 150;
            Goal2.y = 60;
            Goal2.x = 300;
            //Adding two bats to the array list
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
            //Adding three sets of 5 blobs
            for(int i = 0; i < 5; i++){
                Enemy_Blob blob = new Enemy_Blob();
                blob.setWidth(10);
                blob.setColor(Color.RED);
                blob.x = 100 + 20 * i;
                blob.y = 100;
                blobs.add(blob);
                Enemy_Blob blob2 = new Enemy_Blob();
                blob2.setWidth(10);
                blob2.setColor(Color.RED);
                blob2.x = 300 + 20 * i;
                blob2.y = 300;
                blobs.add(blob2);
                Enemy_Blob blob3 = new Enemy_Blob();
                blob3.setWidth(10);
                blob3.setColor(Color.RED);
                blob3.x = 300 + 20 * i;
                blob3.y = 100;
                blobs.add(blob3);
                Coins coin = new Coins();
                coin.setWidth(10);
                coin.x = 300 + 20*i;
                coin.y = 70;
                coins.add(coin);
                Coins coin1 = new Coins();
                coin1.setWidth(10);
                coin1.x = 250 + 20*i;
                coin1.y = 180;
                coins.add(coin1);
                Coins coin2 = new Coins();
                coin2.setWidth(10);
                coin2.x = 400 + 20*i;
                coin2.y = 300;
                coins.add(coin2);
                Coins coin3 = new Coins();
                coin3.setWidth(10);
                coin3.x = 100 + 20*i;
                coin3.y = 70;
                coins.add(coin3);
            }
            //Saving the maze
            maze.save_Maze3(width,height);
        }
        //Placing the player
        player.x = 250;
        player.y = 450;
        if(maze_num == 4){
            maze.save_Maze4(width,height);
            Goal1.x = width/2 - 30;
            Goal1.y = 130;
            Goal2.x = width - 50;
            Goal2.y = 60;
            bats = new ArrayList<>();
            Bat bat1 = new Bat();
            bat1.y = height/2 + 15;
            bat1.x = 20;
            bat1.base_x = 20;
            bat1.base_height = bat1.y;
            bats.add(bat1);
            Bat bat2 = new Bat();
            bat2.y = height - 80;
            bat2.x = width/2 + 50;
            bat2.base_x = 310;
            bat2.base_height = bat2.y;
            bats.add(bat2);
            Bat bat3 = new Bat();
            bat3.y = 140;
            bat3.x = width/2 + 40;
            bat3.base_x = 300;
            bat3.base_height = bat3.y;
            bats.add(bat3);
            for(int i = 0; i < 2; i++) {
                Enemy_Blob blob = new Enemy_Blob();
                blob.setWidth(10);
                blob.setColor(Color.RED);
                blob.x = width / 2 + 40 + 20 * i;
                blob.y = height / 2 - 100;
                blobs.add(blob);
                Coins coin = new Coins();
                coin.setWidth(10);
                coin.x = 430 + 20 * i;
                coin.y = height / 2 + 50;
                coins.add(coin);
                Coins coin1 = new Coins();
                coin1.setWidth(10);
                coin1.x = 300 + 20 * i;
                coin1.y = height / 2 - 40;
                coins.add(coin1);
                Coins coin2 = new Coins();
                coin2.setWidth(10);
                coin2.x = 50 + 20 * i;
                coin2.y = 125;
                coins.add(coin2);
            }
                for(int i = 0; i < 4; i++) {

                Coins coin3 = new Coins();
                coin3.setWidth(10);
                coin3.x = 150 + 20 * i;
                coin3.y = 400;
                coins.add(coin3);
                }


        }
        if(maze_num == 5){
            maze.save_Maze5(width,height);
            Goal1.x = 10;
            Goal1.y = 5;
            Goal2.x = width - 30;
            Goal2.y = 30;

            Spikes spikes1 = new Spikes();
            spikes1.x = 390;
            spikes1.y = 290;
            spikes.add(spikes1);
            Spikes spikes2 = new Spikes();
            spikes2.x = 310;
            spikes2.y = 225;
            spikes2.flipped = true;
            spikes.add(spikes2);

            bats = new ArrayList<>();
            Bat bat1 = new Bat();
            bat1.y = 90;
            bat1.x = 50;
            bat1.base_x = 50;
            bat1.base_height = bat1.y;
            bats.add(bat1);
            Bat bat2 = new Bat();
            bat2.y = height - 110;
            bat2.x = width/2 + 10;
            bat2.base_x = 270;
            bat2.base_height = bat2.y;
            bats.add(bat2);
            Bat bat3 = new Bat();
            bat3.y = 140;
            bat3.x = width/2 + 60;
            bat3.base_x = 320;
            bat3.base_height = bat3.y;
            bats.add(bat3);
            Bat bat4 = new Bat();
            bat4.y = 40;
            bat4.x = 90;
            bat4.base_x = 90;
            bat4.base_height = bat4.y;
            bats.add(bat4);
            Bat bat5 = new Bat();
            bat5.y = 405;
            bat5.x = 45;
            bat5.base_x = 45;
            bat5.base_height = bat5.y;
            bats.add(bat5);
            Bat bat6 = new Bat();
            bat6.y = height - 220;
            bat6.x = 310;
            bat6.base_x = 310;
            bat6.base_height = bat6.y;
            bats.add(bat6);
            for(int i = 0; i < 4; i++) {
                Enemy_Blob blob = new Enemy_Blob();
                blob.setWidth(10);
                blob.setColor(Color.RED);
                blob.x = width - 80 + 20 * i;
                blob.y = height - 40;
                blobs.add(blob);
                Coins coin = new Coins();
                coin.setWidth(10);
                coin.x = width/2 - 100 + 20 * i;
                coin.y = height - 125;
                coins.add(coin);
                Coins coin1 = new Coins();
                coin1.setWidth(10);
                coin1.x = width/2 + 50 + 20 * i;
                coin1.y = height - 175;
                coins.add(coin1);

            }
            for(int i = 0; i < 2; i++) {
                Enemy_Blob blob = new Enemy_Blob();
                blob.setWidth(10);
                blob.setColor(Color.RED);
                blob.x = width/2 - 140 + 20 * i;
                blob.y = height/2 + 60;
                blobs.add(blob);
            }
        }
    }

    /**
     * rendering all the enemies, coins, player, maze, etc...
     * @param canvas the Canvas you are drawing onto
     */
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
        if(Maze_num == 4) {
            maze.render_Maze4(canvas);
            for(Bat bat : bats){
                bat.render(canvas);
            }
        }
        if(Maze_num == 5){
            maze.render_Maze5(canvas);
            for(Bat bat : bats) {
                bat.render(canvas);
            }
        }
        if((player.x > 270 || player.x < 230) && !shut_middle){
            maze.save_shut_middle(Maze_num);
            shut_middle = true;
            //The right side is the harder side so far
            if(player. x > 270 && !Same_level){
                risk_num++;
            }
        }
        if(shut_middle){
            maze.render_middle(canvas);
        }

        for(Spikes spike : spikes){
            //If the spike is upside down, displaying a different image
            if(spike.flipped){
                spike.render(canvas, image3);
            }
            else{
                spike.render(canvas, image2);
            }

        }
        GraphicsContext gc = canvas.getGraphicsContext2D();
        gc.setFill(Color.BLACK);
        gc.fillText("Lives Left: "+ lives, 10,20);
        gc.fillText("Coins Left: "+ coin_num, 10,40);
    }

    /**
     * stops the player
     */
    public void stop_player(){
        player.velX = 0;
        player.velY = 0;
    }

    /**
     * tying key presses and directions with actions like jumping
     * @param direction what direction you want to go to
     */
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


    /**
     * Returns how many coins you have
     */
    public int get_coins(){
        return coin_num;
    }

    /**
     * @return how many lives you have
     */
    public int get_lives(){
        return lives;
    }

    /**
     * @return what the risk level is
     * So I can keep it constant even when you go to the shop
     */
    public int getRisk_num(){
        return risk_num;
    }

    private void collideBlob(Enemy_Blob blob, ArrayList arrayList) {
        //if the player has already been dealt a damage by this blob
        boolean hit = false;
        //Essentially the same code from collideMaze except replacing the maze with a blob and ball with player


            //Using i here so I can detect more precise lengths while still detecting larger lengths
            for (int i = (int) player.getWidth(); i > 0; i--) {
                double width_blob = blob.getWidth();
                double height_blob = blob.getHeight();
                double player_width = player.getWidth();
                if (player.y + i < blob.y + height_blob &&
                        //below top
                        player.y + i > blob.y &&
                        //left of right side
                        player.x + player_width < blob.x + width_blob &&
                        //right of left side
                        player.x + player_width > blob.x &&
                        player.y + player_width - i < blob.y + height_blob &&
                        //below top
                        player.y + player_width - i > blob.y)
                        //left of right side
                {
                    if(!hit){
                        if (blob.remove_blob()) {
                            arrayList.remove(blob);
                        }

                        lives -= blob.Damage();
                        hit=true;
                        blob.move_player(player);
                    }
                }
                //top
                if (player.y + i < blob.y + height_blob &&
                        //below top
                        player.y + i > blob.y &&
                        //left of right side
                        player.x < blob.x + width_blob &&
                        //right of left side
                        player.x > blob.x &&
                        player.y + player_width - i < blob.y + height_blob &&
                        //below top
                        player.y + player_width - i > blob.y
                    //left of right side

                ) {
                    if(!hit){
                        if (blob.remove_blob()) {
                            arrayList.remove(blob);
                        }
                        lives -= blob.Damage();
                        hit=true;
                        blob.move_player(player);
                    }

                }
                //bottom
                if (player.x + i < blob.x + width_blob &&
                        //below top
                        player.x + i > blob.x &&
                        //left of right side
                        player.y + player_width < blob.y + height_blob &&
                        //right of left side
                        player.y + player_width > blob.y &&
                        player.x + player_width < blob.x + width_blob &&
                        //below top
                        player.x + player_width > blob.x)
                //left of right side
                {
                    if(!hit){
                        if (blob.remove_blob()) {
                            arrayList.remove(blob);
                        }
                        lives -= blob.Damage();
                        hit=true;
                        blob.move_player(player);
                    }
                }
                //top
                if (player.x + i < blob.x + width_blob &&
                        //below top
                        player.x + i > blob.x &&
                        //left of right side
                        player.y < blob.y + height_blob &&
                        //right of left side
                        player.y > blob.y &&
                        player.x + player_width < blob.x + width_blob &&
                        //below top
                        player.x + player_width > blob.x
                    //left of right side

                ) {
                    if(!hit){
                        if (blob.remove_blob()) {
                            arrayList.remove(blob);
                        }
                        lives -= blob.Damage();
                        hit=true;
                        blob.move_player(player);
                    }

                }
            }
    }
    private boolean collide_goal(goal Goal){
        return player.intersects(Goal);
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
                lives -= 1;
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

                player.falling();
                if (Maze_num == 2 || Maze_num == 3 || Maze_num == 4 || Maze_num == 5){
                    for(Bat bat : bats){
                        bat.swoop();
                        collideBlob(bat, bats);

                    }
                }
                if(Maze_num == 4 || Maze_num == 5){
                    for (Spikes spike : spikes){
                        collideBlob(spike, spikes);

                    }
                }

                for(int i = 0; i < blobs.size(); i++){
                    Enemy_Blob blob = blobs.get(i);
                    blob.falling();
                    maze.check_collisions(blob, Maze_num);
                    onScreen(blob);
                    collideBlob(blob, blobs);
                    blob.move();
                }


                if(collide_goal(Goal1) || collide_goal(Goal2)){
                    gameGUi.pause(true, true);
                    if(Maze_num == 5){
                        EndGraphic new_scene = new EndGraphic(Integer.toString(risk_num));
                        Scene scene = new Scene(new_scene, 500,500);
                        Main.switchscene(scene);
                    }else{
                        GameGUI new_scene= new GameGUI(Maze_num + 1, lives, coin_num, risk_num, false);
                        Scene scene = new Scene(new_scene, 500,500);
                        Main.switchscene(scene);
                        player.x = 250;
                        player.y = 300;
                        scene.addEventHandler(KeyEvent.KEY_PRESSED, new EventHandler<KeyEvent>() {
                            @Override
                            public void handle(KeyEvent keyEvent) {
                                new_scene.handleKeyPress(keyEvent);
                            }
                        });

                        scene.addEventHandler(KeyEvent.KEY_RELEASED, new EventHandler<KeyEvent>() {
                            @Override
                            public void handle(KeyEvent keyEvent) {
                                new_scene.handleKeyRelease(keyEvent);
                            }
                        });
                    }


                }


                if(lives <= 0){
                    EndGraphic endGraphic= new EndGraphic(String.valueOf(risk_num));
                    Scene scene = new Scene(endGraphic, 500,500);
                    pause(true);
                    Main.switchscene(scene);
                }
                lastUpdate = now;
            }
        }
    }
}
