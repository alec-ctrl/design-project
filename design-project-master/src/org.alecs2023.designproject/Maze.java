package org.alecs2023.designproject;

import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

import java.util.ArrayList;

public class Maze {
    private double width, height;
    //the arraylist storing all the maze1 walls
    private ArrayList<Rectangle>  Maze1_walls;
    private ArrayList<Rectangle>  Maze2_walls;
    private ArrayList<Rectangle>  Maze3_walls;


    public void render_Maze1(Canvas canvas) {
        GraphicsContext gc = canvas.getGraphicsContext2D();
        gc.setFill(Color.BLACK);
        //Drawing all the walls here
        gc.fillRect(width / 2 + 20, height - 30, width / 2 - 20, 30);
        gc.fillRect(width / 2 + 20, height - 50, 20, 30);
        gc.fillRect(0, height - 30, width / 2 - 20, 30);
        gc.fillRect(width / 3, height / 2 + 50, width / 2, 30);
        gc.fillRect(0, height / 2, 30, height / 2);
        gc.fillRect(width - 30, height / 2 - 50, 30, height / 2 + 50);
        gc.fillRect(width - 60, 3 * height / 4, 30, 10);
        gc.fillRect(width / 2 - 30, height / 4, 30, 200);

        gc.fillRect(width / 2, height / 4 + 100, 30, 10);
        gc.fillRect(0, height / 4, 250, 30);
        gc.fillRect(2 * width / 3, height / 2 - 50, width / 2, 30);

        gc.fillRect(width / 2 + 100, height / 4 - 30, 30, 10);
        gc.fillRect(width - 30, height / 4 - 30, 30, 10);

    }
    public void render_Maze2(Canvas canvas) {
        GraphicsContext gc = canvas.getGraphicsContext2D();
        gc.setFill(Color.BLACK);
        //Drawing all the walls here
        gc.fillRect(width / 2 + 20, height - 30, width / 2 - 20, 30);
        gc.fillRect(0, height - 30, width / 2 - 20, 30);
        gc.fillRect(width / 2 + 20,height - 40, 10,10);
        gc.fillRect(width / 2 + 20,height - 105, 10,10);
        gc.fillRect(width / 2 + 130,height - 80, 20,10);
        gc.fillRect(width / 2 - 30,height - 40, 10,10);
        gc.fillRect(50,377, width - 90,20);
        gc.fillRect(width - 20, 250, 20, 250);
        gc.fillRect(width - 45, height-40, 11, 11);
        gc.fillRect(width/2 + 25, height/2, width/2 - 25, 20);
        gc.fillRect(width/2 - 10, 0, 20, 379);
        gc.fillRect(width/2 + 60, height/2 -20 , 8, 20);
        gc.fillRect(width/2 + 40, height/2 -20 , 20, 8);
        gc.fillRect(width/2 , height/2 - 100, width/2 - 100, 20);
        gc.fillRect(width - 20, 0, 20, 250);
        gc.fillRect(width/2 +140,height/2 - 110, 10,10);
        gc.fillRect(width/2 + 50,height/2 - 110, 10,10);
        gc.fillRect(width/2 + 70,height/2 - 140, 30,10);
        gc.fillRect(width/2 + 160,height/2 - 100, 30,10);
        gc.fillRect(width/2 + 200,height/2 - 50, 30,10);

        gc.fillRect(30, height - 200, width / 2 - 90, 10);
        gc.fillRect(125,height - 150, 30,10);
        gc.fillRect(185,height - 150, 30,10);
        gc.fillRect(50,height - 133, 11,13);
        gc.fillRect(130,height /2, 20,10);
        gc.fillRect(80,height /2 - 60, 30,10);
        gc.fillRect(150,height /2 - 50, 30,10);
        gc.fillRect(30,height /2 - 110, 30,10);
        gc.fillRect(100,height /2 - 150, 30,10);
        gc.fillRect(150,height /2 - 200, 40,10);
        gc.fillRect(0,height /2 - 30, 40,10);
    }
    public void render_Maze3(Canvas canvas){
        GraphicsContext gc = canvas.getGraphicsContext2D();
        gc.setFill(Color.BLACK);
        //Drawing all the walls here
        gc.fillRect(0, height - 30, width, 30);
        gc.fillRect(width - 20, 0, 20, height);
        gc.fillRect(0, 0, 20, height);
        gc.fillRect(width/2 + 70,height - 90, 30,5);
        gc.fillRect(width/2 + 75,height - 200, 45,5);
        gc.fillRect(width/2 + 80,height - 200, 11,20);
        gc.fillRect(width/2 + 110,height - 200, 11,20);
        gc.fillRect(width/2 + 40, height/2 - 50, width/2 - 40, 15);
        gc.fillRect(width/2 + 40,height/2, 30,5);
        gc.fillRect(width/2 + 10,height/2 - 120, 60,5);
        gc.fillRect(width/2 + 10,height/2 - 160, width/2 - 50,15);
        gc.fillRect(0,0, width,5);
        gc.fillRect(width/2 - 10,0, 20,height- 50);
        gc.fillRect(width/2 - 150,height/2 + 160, 150,15);
        gc.fillRect(0,height/2 + 50, 200,15);
        gc.fillRect(100,height /2 - 40, 150,15);

    }
    //So I only am adding to the arraylist once, instead of each time I render
    public void save_Maze1(double Width, double Height){
        width = Width;
        height = Height;
        Maze1_walls = new ArrayList<>();
        //adding the rectangles to the Maze1 array list so I can detect collisions for this maze later
        Maze1_walls.add(new Rectangle(width - 30, height / 4 - 30, 30, 10));
        Maze1_walls.add(new Rectangle(width / 2 + 100, height / 4 - 30, 30, 10));
        Maze1_walls.add(new Rectangle(2 * width / 3, height / 2 - 50, width / 2, 30));
        Maze1_walls.add(new Rectangle(0, height / 4, 250, 30));
        Maze1_walls.add(new Rectangle(width / 2, height / 4 + 100, 30, 10));
        Maze1_walls.add(new Rectangle(width / 2 - 30, height / 4, 30, 200));
        Maze1_walls.add(new Rectangle(width - 60, 3 * height / 4, 30, 10));
        Maze1_walls.add(new Rectangle(width - 30, height / 2 - 50, 30, height / 2 + 50));
        Maze1_walls.add(new Rectangle(0, height / 2, 30, height / 2));
        Maze1_walls.add(new Rectangle(width / 3, height / 2 + 50, width / 2, 30));
        Maze1_walls.add(new Rectangle(0, height - 30, width / 2 - 20, 30));
        Maze1_walls.add(new Rectangle(width / 2 + 20, height - 50, 20, 30));
        Maze1_walls.add(new Rectangle(width / 2 + 20, height - 30, width / 2 - 20, 30));
    }
    public void save_Maze2(double Width, double Height){
        width = Width;
        height = Height;
        Maze2_walls = new ArrayList<>();
        Maze2_walls.add(new Rectangle(width / 2 + 20, height - 30, width / 2 - 20, 30));
        Maze2_walls.add(new Rectangle(0, height - 30, width / 2 - 20, 30));
        Maze2_walls.add(new Rectangle(width / 2 + 20,height - 40, 10,10));
        Maze2_walls.add(new Rectangle(width / 2 + 20,height - 105, 10,10));
        Maze2_walls.add(new Rectangle(width / 2 + 130,height - 80, 20,10));
        Maze2_walls.add(new Rectangle(width / 2 - 30,height - 40, 10,10));
        Maze2_walls.add(new Rectangle(50,377, width - 90,20));
        Maze2_walls.add(new Rectangle(width - 20, 250, 20, 250));
        Maze2_walls.add(new Rectangle(width - 45, height-40, 11, 11));
        Maze2_walls.add(new Rectangle(width/2 + 25, height/2, width/2 - 25, 20));
        Maze2_walls.add(new Rectangle(width/2 - 10, 0, 20, 379));
        Maze2_walls.add(new Rectangle(width/2 + 60, height/2 -20 , 8, 20));
        Maze2_walls.add(new Rectangle(width/2 + 40, height/2 -20 , 20, 8));
        Maze2_walls.add(new Rectangle(width/2 , height/2 - 100, width/2 - 100, 20));
        Maze2_walls.add(new Rectangle(width - 20, 0, 20, 250));
        Maze2_walls.add(new Rectangle(width/2 +140,height/2 - 110, 10,10));
        Maze2_walls.add(new Rectangle(width/2 + 50,height/2 - 110, 10,10));
        Maze2_walls.add(new Rectangle(width/2 + 70,height/2 - 140, 30,10));
        Maze2_walls.add(new Rectangle(width/2 + 160,height/2 - 100, 30,10));
        Maze2_walls.add(new Rectangle(width/2 + 200,height/2 - 50, 30,10));

        Maze2_walls.add(new Rectangle(30, height - 200, width / 2 - 90, 10));
        Maze2_walls.add(new Rectangle(125,height - 150, 30,10));
        Maze2_walls.add(new Rectangle(185,height - 150, 30,10));
        Maze2_walls.add(new Rectangle(50,height - 133, 11,13));
        Maze2_walls.add(new Rectangle(130,height /2, 30,10));
        Maze2_walls.add(new Rectangle(80,height /2 - 60, 30,10));
        Maze2_walls.add(new Rectangle(150,height /2 - 50, 30,10));
        Maze2_walls.add(new Rectangle(30,height /2 - 110, 30,10));
        Maze2_walls.add(new Rectangle(100,height /2 - 150, 30,10));
        Maze2_walls.add(new Rectangle(150,height /2 - 200, 40,10));
        Maze2_walls.add(new Rectangle(0,height /2 - 30, 40,10));
    }
    public void save_Maze3(double Width, double Height){
        width = Width;
        height = Height;
        Maze3_walls = new ArrayList<>();
        //saving all the walls here
        Maze3_walls.add(new Rectangle(0, height - 30, width, 30));
        Maze3_walls.add(new Rectangle(width - 20, 0, 20, height));
        Maze3_walls.add(new Rectangle(0, 0, 20, height));
        Maze3_walls.add(new Rectangle(width/2 + 70,height - 90, 30,5));
        Maze3_walls.add(new Rectangle(width/2 + 75,height - 200, 45,5));
        Maze3_walls.add(new Rectangle(width/2 + 85,height - 200, 5,20));
        Maze3_walls.add(new Rectangle(width/2 + 110,height - 200, 5,20));
        Maze3_walls.add(new Rectangle(width/2 + 40, height/2 - 50, width/2 - 40, 15));
        Maze3_walls.add(new Rectangle(width/2 + 40,height/2, 30,5));
        Maze3_walls.add(new Rectangle(width/2 + 10,height/2 - 120, 60,5));
        Maze3_walls.add(new Rectangle(width/2 + 10,height/2 - 160, width/2 - 50,15));
        Maze3_walls.add(new Rectangle(0,0, width,5));
        Maze3_walls.add(new Rectangle(width/2 - 10,0, 20,height- 50));
        Maze3_walls.add(new Rectangle(width/2 - 150,height/2 + 160, 150,15));
        Maze3_walls.add(new Rectangle(0,height/2 + 50, 200,15));
        Maze3_walls.add(new Rectangle(width/2 + 85,height - 200, 5,20));
        Maze3_walls.add(new Rectangle(100,height /2 - 40, 150,15));

    }

    public void check_collisions(Player ball, int num) {
        ArrayList<Rectangle> Maze_walls;
        Maze_walls = new ArrayList<>();
        if (num == 1){
            Maze_walls = Maze1_walls;
        }
        if(num == 2){
            Maze_walls = Maze2_walls;
        }
        if(num == 3){
            Maze_walls = Maze3_walls;
        }
        for (Rectangle maze_wall : Maze_walls) {
            //checking for which direction the wall is, and changing the coordinates accordingly
            //wall on left
                if (ball.y < maze_wall.getY() + maze_wall.getHeight() &&
                        //below top
                        ball.y > maze_wall.getY() &&
                        //left of right side
                        ball.x < maze_wall.getX() + maze_wall.getWidth() &&
                        //right of left side
                        ball.x > maze_wall.getX() &&
                        ball.y + ball.getWidth() < maze_wall.getY() + maze_wall.getHeight() &&
                        //below top
                        ball.y + ball.getWidth() > maze_wall.getY()) {
                    ball.x = maze_wall.getX() + maze_wall.getWidth();
                    System.out.println("hi");
                    if (ball instanceof Enemy_Blob) {
                        ball.bounce();
                    }
                }

                //wall right
                if (ball.y + ball.getWidth() < maze_wall.getY() + maze_wall.getHeight() &&
                        //below top
                        ball.y + ball.getWidth() > maze_wall.getY() &&
                        //left of right side
                        ball.x + ball.getWidth() < maze_wall.getX() + maze_wall.getWidth() &&
                        //right of left side
                        ball.x + ball.getWidth() > maze_wall.getX() &&
                        ball.y < maze_wall.getY() + maze_wall.getHeight() &&
                        //below top
                        ball.y > maze_wall.getY()
                    //left of right side

                ) {
                    ball.x = maze_wall.getX() - ball.getWidth();
                    if (ball instanceof Enemy_Blob) {
                        ball.bounce();
                    }
                }

            //Using i here so I can detect more precise lengths while still detecting larger lengths
            for (int i = (int) ball.getWidth(); i > 0; i--) {
                //bottom
                if (ball.x < maze_wall.getX() + maze_wall.getWidth() &&
                        //below top
                        ball.x > maze_wall.getX() &&
                        //left of right side
                        ball.y + ball.getWidth() < maze_wall.getY() + maze_wall.getHeight() &&
                        //right of left side
                        ball.y + ball.getWidth() > maze_wall.getY() &&
                        ball.x + ball.getWidth() - i < maze_wall.getX() + maze_wall.getWidth() &&
                        //below top
                        ball.x + ball.getWidth() - i > maze_wall.getX())
                //left of right side
                {
                    if (ball.gravity) {
                        ball.on_ground = true;
                        ball.jump = false;
                    }
                    ball.y = maze_wall.getY() - ball.getWidth();

                }
                //top
                if (ball.x < maze_wall.getX() + maze_wall.getWidth() &&
                        //below top
                        ball.x > maze_wall.getX() &&
                        //left of right side
                        ball.y < maze_wall.getY() + maze_wall.getHeight() &&
                        //right of left side
                        ball.y > maze_wall.getY() &&
                        ball.x + ball.getWidth() - i < maze_wall.getX() + maze_wall.getWidth() &&
                        //below top
                        ball.x + ball.getWidth() - i > maze_wall.getX()
                    //left of right side

                ) {
                    if (!ball.gravity) {
                        ball.on_ground = true;
                        ball.jump = false;
                    }

                    ball.y = maze_wall.getY() + maze_wall.getHeight();

                }
                if (ball.y == maze_wall.getY() + maze_wall.getHeight() && !ball.gravity &&
                        ball.x + ball.getWidth() - i < maze_wall.getX() + maze_wall.getWidth() &&
                        //below top
                        ball.x + ball.getWidth() - i > maze_wall.getX() &&
                        ball.x < maze_wall.getX() + maze_wall.getWidth() &&
                        //below top
                        ball.x > maze_wall.getX()
                    //left of right side
                ) {
                    ball.on_ground = true;
                }
                //If it is on the top and gravity is switched down, it is on the ceiling
                if (ball.y == maze_wall.getY() + maze_wall.getHeight() && ball.gravity &&
                        ball.x + ball.getWidth() - i < maze_wall.getX() + maze_wall.getWidth() &&
                        //below top
                        ball.x + ball.getWidth() - i > maze_wall.getX() &&
                        ball.x < maze_wall.getX() + maze_wall.getWidth() &&
                        //below top
                        ball.x > maze_wall.getX()
                    //left of right side
                ) {
                    ball.on_ceiling = true;

                }
            }
            for (int i = (int) ball.getWidth(); i > 0; i--) {
                //bottom
                if (ball.x + i < maze_wall.getX() + maze_wall.getWidth() &&
                        //below top
                        ball.x + i> maze_wall.getX() &&
                        //left of right side
                        ball.y + ball.getWidth() < maze_wall.getY() + maze_wall.getHeight() &&
                        //right of left side
                        ball.y + ball.getWidth() > maze_wall.getY() &&
                        ball.x + ball.getWidth()  < maze_wall.getX() + maze_wall.getWidth() &&
                        //below top
                        ball.x + ball.getWidth()  > maze_wall.getX())
                //left of right side
                {
                    if (ball.gravity) {
                        ball.on_ground = true;
                        ball.jump = false;
                    }
                    ball.y = maze_wall.getY() - ball.getWidth();

                }
                //top
                if (ball.x + i< maze_wall.getX() + maze_wall.getWidth() &&
                        //below top
                        ball.x + i > maze_wall.getX() &&
                        //left of right side
                        ball.y < maze_wall.getY() + maze_wall.getHeight() &&
                        //right of left side
                        ball.y > maze_wall.getY() &&
                        ball.x + ball.getWidth()  < maze_wall.getX() + maze_wall.getWidth() &&
                        //below top
                        ball.x + ball.getWidth() > maze_wall.getX()
                    //left of right side

                ) {
                    if (!ball.gravity) {
                        ball.on_ground = true;
                        ball.jump = false;
                    }

                    ball.y = maze_wall.getY() + maze_wall.getHeight();

                }
                if (ball.y == maze_wall.getY() + maze_wall.getHeight() && !ball.gravity &&
                        ball.x + ball.getWidth() < maze_wall.getX() + maze_wall.getWidth() &&
                        //below top
                        ball.x + ball.getWidth() > maze_wall.getX() &&
                        ball.x + i< maze_wall.getX() + maze_wall.getWidth() &&
                        //below top
                        ball.x + i > maze_wall.getX()
                    //left of right side
                ) {
                    ball.on_ground = true;
                }
                //If it is on the top and gravity is switched down, it is on the ceiling
                if (ball.y == maze_wall.getY() + maze_wall.getHeight() && ball.gravity &&
                        ball.x + ball.getWidth() < maze_wall.getX() + maze_wall.getWidth() &&
                        //below top
                        ball.x + ball.getWidth() > maze_wall.getX() &&
                        ball.x + i < maze_wall.getX() + maze_wall.getWidth() &&
                        //below top
                        ball.x + i > maze_wall.getX()
                    //left of right side
                ) {
                    ball.on_ceiling = true;

                }
            }
                if (ball.y + ball.getWidth() == maze_wall.getY() && ball.gravity &&
                        ball.x < maze_wall.getX() + maze_wall.getWidth() &&
                        //below top
                        ball.x > maze_wall.getX() &&
                        ball.x + ball.getWidth() < maze_wall.getX() + maze_wall.getWidth() &&
                        //below top
                        ball.x + ball.getWidth() > maze_wall.getX()) {
                    ball.on_ground = true;

                }
                //If it is on the bottom and gravity is switched up, it is on the ceiling
                if (ball.y + ball.getWidth() == maze_wall.getY() && !ball.gravity &&
                        ball.x < maze_wall.getX() + maze_wall.getWidth() &&
                        //below top
                        ball.x > maze_wall.getX() &&
                        ball.x + ball.getWidth() < maze_wall.getX() + maze_wall.getWidth() &&
                        //below top
                        ball.x + ball.getWidth() > maze_wall.getX()) {
                    ball.on_ceiling = true;
                }
        }
    }
    //TODO MOVE THIS TO THE PLAYER TAB WHY IS IT IN THE MAZE TAB
    public void falling(Player player){
        if(!player.on_ground && !player.jump && player.gravity){
            player.y += 4;

        } else if(!player.on_ground && !player.jump){
            player.y -= 2;
        }
        if(player.on_ceiling && player.gravity){
            player.y += 4;
            //need to break the jump so I dont get stuck in some loop
            player.jump = false;
        }
        if(player.on_ceiling && !player.gravity){

            player.y -= 2;
            //need to break the jump so I dont get stuck in some loop
            player.jump = false;
        }
        player.on_ground = false;
        player.on_ceiling = false;
    }
}
