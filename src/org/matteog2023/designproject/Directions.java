package org.matteog2023.designproject;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;



import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Directions extends BorderPane {
    private Label how_to_play;
    private Pane top_box;
    Directions(){
        Button back = new Button("Back");
        how_to_play = new Label();
        how_to_play.setText("You can move side to side with A and D. Switch gravity with the spacebar " +
                " If you hit the top of an unprotected (no wall) ceiling, you will lose one life and be teleported" +
                " to the bottom of the screen. On each level, you will be able to choose to go left or right. " +
                "Once you have moved enough in a certain direction, the other option will be closed to you and " +
                "you will not be able to go back. The yellow squares are coins, and you will be able to exchange them " +
                "in the shop throughout your run. Keep in mind, though that if you try to shop in the middle of a level, you " +
                "will be plunked right back at the start once you are finished shopping. The blue enemies are bats, which " +
                "swoop from left to right, and the red ones simply move statically on the ground. They will also switch gravity with " +
                "you.");

        how_to_play.setMaxWidth(450);
        how_to_play.setWrapText(true);
        back.setMinSize(100,100);

        how_to_play.setMinSize(300,300);
        how_to_play.setLayoutX(10);
        how_to_play.setLayoutY(100);
        back.setLayoutX(400);
        back.setLayoutY(400);

        back.setOnAction(new EventHandler<ActionEvent>(){
            @Override
            public void handle(ActionEvent actionEvent) {
                Scene s = null;

                StartGraphic d = new StartGraphic();
                s = new Scene(d, 500, 500);
                ((Stage) getScene().getWindow()).setScene(s);

            }
        });
        top_box = new Pane();
        top_box.getChildren().addAll(how_to_play, back);
        this.getChildren().add(top_box);
    }
}
