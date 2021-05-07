package org.matteog2023.designproject;

import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

import java.util.ArrayList;

public class Maze {
    private double width, height;
    private ArrayList<Rectangle>  Maze1_walls = new ArrayList<Rectangle>();


    public void render_Maze1(Canvas canvas) {
        width = canvas.getWidth();
        height = canvas.getHeight();
        GraphicsContext gc = canvas.getGraphicsContext2D();
        gc.setFill(Color.BLACK);
        gc.fillRect(width / 2 + 20, height - 30, width / 2 - 20, 30);
        Maze1_walls.add(new Rectangle(width / 2 + 20, height - 30, width / 2 - 20, 30));
        gc.fillRect(0, height - 30, width / 2 - 20, 30);
        Maze1_walls.add(new Rectangle(0, height - 30, width / 2 - 20, 30));
        gc.fillRect(width / 3, height / 2 + 50, width / 2, 30);
        Maze1_walls.add(new Rectangle(width / 3, height / 2 + 50, width / 2, 30));
        gc.fillRect(0, height / 2, 30, height / 2);
        Maze1_walls.add(new Rectangle(0, height / 2, 30, height / 2));
        gc.fillRect(width - 30, height / 2 - 50, 30, height / 2 + 50);
        Maze1_walls.add(new Rectangle(width - 30, height / 2 - 50, 30, height / 2 + 50));
        gc.fillRect(width - 60, 3 * height / 4, 30, 10);
        Maze1_walls.add(new Rectangle(width - 60, 3 * height / 4, 30, 10));
        gc.fillRect(width / 2 - 30, height / 4, 30, 200);
        Maze1_walls.add(new Rectangle(width / 2 - 30, height / 4, 30, 200));
        gc.fillRect(width / 2, height / 4 + 100, 30, 10);
        Maze1_walls.add(new Rectangle(width / 2, height / 4 + 100, 30, 10));
        gc.fillRect(0, height / 4, 250, 30);
        Maze1_walls.add(new Rectangle(0, height / 4, 250, 30));
        gc.fillRect(2 * width / 3, height / 2 - 50, width / 2, 30);
        Maze1_walls.add(new Rectangle(2 * width / 3, height / 2 - 50, width / 2, 30));
        gc.fillRect(width / 2 + 100, height / 4 - 30, 30, 10);
        Maze1_walls.add(new Rectangle(width / 2 + 100, height / 4 - 30, 30, 10));
        gc.fillRect(width - 30, height / 4 - 30, 30, 10);
        Maze1_walls.add(new Rectangle(width - 30, height / 4 - 30, 30, 10));
    }

    public void check_collisions(Player player) {
        for (Rectangle maze1_wall : Maze1_walls) {
            //checking for which direction the wall is, and changing the coordinates accordingly
            //wall on left
            if (player.y < maze1_wall.getY() + maze1_wall.getHeight() &&
                    //below top
                    player.y > maze1_wall.getY() &&
                    //left of right side
                    player.x < maze1_wall.getX() + maze1_wall.getWidth() &&
                    //right of left side
                    player.x > maze1_wall.getX() &&
                    player.y + player.getWidth() < maze1_wall.getY() + maze1_wall.getHeight() &&
                    //below top
                    player.y + player.getWidth() > maze1_wall.getY()){
                player.x = maze1_wall.getX() + maze1_wall.getWidth();


            }

            //wall right
            if (player.y + player.getWidth() < maze1_wall.getY() + maze1_wall.getHeight() &&
                    //below top
                    player.y + player.getWidth() > maze1_wall.getY() &&
                    //left of right side
                    player.x + player.getWidth() < maze1_wall.getX() + maze1_wall.getWidth()&&
                    //right of left side
                    player.x + player.getWidth() > maze1_wall.getX() &&
                    player.y < maze1_wall.getY() + maze1_wall.getHeight() &&
                    //below top
                    player.y > maze1_wall.getY()
                    //left of right side

            ){
                player.x = maze1_wall.getX() - player.getWidth();

            }
            //bottom
            if (player.x + player.getWidth() <= maze1_wall.getX() + maze1_wall.getWidth() &&
                    //below top
                    player.x + player.getWidth() >= maze1_wall.getX() &&
                    //left of right side
                    player.y + player.getWidth() < maze1_wall.getY() + maze1_wall.getHeight()&&
                    //right of left side
                    player.y + player.getWidth() > maze1_wall.getY() &&
                    player.x <= maze1_wall.getX() + maze1_wall.getWidth() &&
                    //below top
                    player.x >= maze1_wall.getX()
                //left of right side


            ){
                if(player.gravity){
                    player.on_ground = true;
                }
                player.y = maze1_wall.getY() - player.getWidth();
                player.jump = false;


            }
            //top
            if (player.x + player.getWidth() <= maze1_wall.getX() + maze1_wall.getWidth() &&
                    //below top
                    player.x + player.getWidth() >= maze1_wall.getX() &&
                    //left of right side
                    player.y < maze1_wall.getY() + maze1_wall.getHeight()&&
                    //right of left side
                    player.y > maze1_wall.getY() &&
                    player.x <= maze1_wall.getX() + maze1_wall.getWidth() &&
                    //below top
                    player.x >= maze1_wall.getX()
                //left of right side

            ){
                if(!player.gravity){
                    player.on_ground = true;

                }
                player.y = maze1_wall.getY() + maze1_wall.getHeight();

            }
            if(player.y == maze1_wall.getY() + maze1_wall.getHeight() && !player.gravity &&
                    player.x < maze1_wall.getX() + maze1_wall.getWidth() &&
                    //below top
                    player.x > maze1_wall.getX() &&
                    player.x + player.getWidth() < maze1_wall.getX() + maze1_wall.getWidth() &&
                    //below top
                    player.x + player.getWidth() > maze1_wall.getX()
                //left of right side
            ){
                player.on_ground = true;

            }
            if(player.y + player.getWidth() == maze1_wall.getY() && player.gravity &&
                    player.x < maze1_wall.getX() + maze1_wall.getWidth() &&
                    //below top
                    player.x > maze1_wall.getX() &&
                    player.x + player.getWidth() < maze1_wall.getX() + maze1_wall.getWidth() &&
                    //below top
                    player.x + player.getWidth() > maze1_wall.getX()){
                player.on_ground = true;

            }


        }
    }

    public void falling(Player player){

        if(!player.on_ground && !player.jump && player.gravity){
            player.y += 4;
        } else if(!player.on_ground && !player.jump){
            player.y -= 2;
        }
        player.on_ground = false;
    }
}
