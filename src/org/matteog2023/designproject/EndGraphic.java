package org.matteog2023.designproject;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.*;
import javafx.stage.Stage;

public class EndGraphic extends BorderPane{

    /**
     * A simple ending screen, with your 'Risk_rating' and a button to go back to the start screen
     * @param Risk_rating How many times you chose the 'riskier' side
     */
    EndGraphic(String Risk_rating) {
        VBox buttonbox = new VBox();

        this.setCenter(buttonbox);

        // Making a new 'restart' button
        //If clicked will call GameGUI on level 1
        Button start = new Button("Restart");
        start.setMinSize(150, 40);
        Label risk_level = new Label("Your risk level is: " + Risk_rating + " / 5");
        risk_level.setMinSize(150, 40);
        //Making sure everything is centered
        Pane spacerVertical = new Pane();
        spacerVertical.setMinSize(1, 10);
        Pane spacerVertical2 = new Pane();
        spacerVertical2.setMinSize(1, 10);

        buttonbox.getChildren().addAll(start, spacerVertical, spacerVertical2, risk_level);
        buttonbox.setAlignment(Pos.CENTER);
        buttonbox.setPadding(new Insets(10, 10, 10, 10));


        start.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            /**
             * If you click the start button, calling a new GameGUI on level 1
             */
            public void handle(ActionEvent actionEvent) {
                Scene s = null;

                GameGUI g = new GameGUI(1,3, 0, 0, false);
                s = new Scene(g, 500, 500);
                ((Stage) getScene().getWindow()).setScene(s);
                g.pause(false);
                //Turning a listener on for keys
                s.addEventHandler(KeyEvent.KEY_PRESSED, new EventHandler<KeyEvent>() {
                    @Override
                    public void handle(KeyEvent keyEvent) {
                        g.handleKeyPress(keyEvent);
                    }
                });
                s.addEventHandler(KeyEvent.KEY_RELEASED, new EventHandler<KeyEvent>() {
                    @Override
                    public void handle(KeyEvent keyEvent) {
                        g.handleKeyRelease(keyEvent);
                    }
                });
            }
        });
    }


}

