package org.matteog2023.designproject;

import javafx.animation.AnimationTimer;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class GameGUI extends BorderPane {
    private Canvas gameArea;
    private AnimationTimer animTimer;
    private GameLogic logic;

    public GameGUI(int maze_num, int lives, int coin_num, int risk_num, boolean same_level){
        gameArea = new Canvas();
        gameArea.heightProperty().bind(this.heightProperty());
        gameArea.widthProperty().bind(this.widthProperty());
        Button shop = new Button("Shop");
        shop.setPadding(new Insets(-20));
        shop.setMinSize(100, 20);
        shop.setLayoutX(180);
        shop.setLayoutY(475);
        //to prevent the space bar from firing this button instead of changing the gravity
        shop.setFocusTraversable(false);

        Pane pane = new Pane();
        pane.getChildren().add(shop);
        animTimer = new AnimTimer();


        //giving it the width and height of the canvas
        //maze_num is what number Maze you want
        logic = new GameLogic(500,500,maze_num, lives, coin_num, this, risk_num, same_level);

        shop.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                pause(true,true);
                Shop g = new Shop( logic.get_coins(),logic.get_lives(), maze_num, logic.getRisk_num());
                Scene s = new Scene(g, 500, 500);
                Main.switchscene(s);
            }
        });
        pause(false, false);

        this.getChildren().addAll(gameArea, pane);

    }


    /**
     * Pause/unpause teh animation and game timer
     *
     * @param setAnimPause true to pause the animation timer
     * @param setGamePause true to pause the game timer
     */
    public void pause(boolean setAnimPause, boolean setGamePause) {
        this.pause(setAnimPause);
        logic.pause(setGamePause);
    }

    /**
     * Deal with key presses
     *
     * @param event the event to handle
     */
    public void handleKeyPress(KeyEvent event) {
        if (event.getCode() == KeyCode.D) {
            logic.applyForce(GameLogic.DIRECTION.RIGHT);
        }
        if (event.getCode() == KeyCode.S) {
            logic.applyForce(GameLogic.DIRECTION.DOWN);
        }
        if (event.getCode() == KeyCode.A) {
            logic.applyForce(GameLogic.DIRECTION.LEFT);
        }
        if (event.getCode() == KeyCode.W) {
            logic.applyForce(GameLogic.DIRECTION.UP);
        }
        if (event.getCode() == KeyCode.SPACE) {
            logic.applyForce(GameLogic.DIRECTION.GRAVITY);
        }
    }
    public void handleKeyRelease(KeyEvent event){
        logic.stop_player();
    }
    /**
     * Runs once per frame and handles all the drawing of each frame
     */
    private class AnimTimer extends AnimationTimer {

        @Override
        public void handle(long now) {
            GraphicsContext gc = gameArea.getGraphicsContext2D();
            gc.clearRect(0, 0, gameArea.getWidth(), gameArea.getHeight());

            logic.render(gameArea);
        }
    }
    public void pause(boolean setAnimPause) {
        if (setAnimPause) {
            animTimer.stop();
        } else {
            animTimer.start();
        }
    }
}
