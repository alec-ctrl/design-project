package org.matteog2023.designproject;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.*;
import javafx.stage.Stage;

public class StartGraphic extends BorderPane {


    StartGraphic(){
        VBox buttonbox = new VBox();

        this.setCenter(buttonbox);

        //buttonbox
        Button start = new Button("Start");
        start.setMinSize(150, 40);
        Button shop = new Button("Shop");
        shop.setMinSize(150, 40);
        Button howtoplay = new Button("How To Play");
        howtoplay.setMinSize(150, 40);

        Pane spacerVertical = new Pane();
        spacerVertical.setMinSize(1,10);
        Pane spacerVertical2 = new Pane();
        spacerVertical2.setMinSize(1,10);

        buttonbox.getChildren().addAll(start, spacerVertical, shop, spacerVertical2, howtoplay);
        buttonbox.setAlignment(Pos.CENTER);
        buttonbox.setPadding(new Insets(10,10,10,10));




        start.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                Scene s = null;

                GameGUI g = new GameGUI(5);
                s = new Scene(g, 500, 500);
                ((Stage) getScene().getWindow()).setScene(s);
                g.pause(false);
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