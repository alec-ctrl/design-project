package org.matteog2023.designproject;

import javafx.animation.AnimationTimer;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Label;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;

public class  GameGUI extends BorderPane {
    private Canvas gameArea;
    private AnimationTimer animTimer;
    private GameLogic logic;
    private HBox topBox;
    private Label lifeNumberLabel;
    private HBox livesBox;

    public GameGUI(){

        gameArea = new Canvas();
        gameArea.heightProperty().bind(this.heightProperty());
        gameArea.widthProperty().bind(this.widthProperty());

        animTimer = new AnimTimer();

        logic = new GameLogic(gameArea.getWidth(), gameArea.getHeight());

        this.getChildren().add(gameArea);
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