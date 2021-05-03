package org.alecs2023.designproject;

import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;

public class StartGraphic extends BorderPane {

    StartGraphic(){
        Button start = new Button("Start");
        start.setPadding(new Insets(10,100,10,80));
        this.setCenter(start);
        start.addEventHandler(MouseEvent.MOUSE_CLICKED, new EventHandler<MouseEvent>() {
            @Override
            /**
             * Disabling all difficulty buttons except for medium, and un-disabling the play button
             */
            public void handle(MouseEvent mouseEvent) {
                GameGUI root = new GameGUI();
                Scene scene = new Scene(root, 500,500);

                Main.switchscene(scene);
            }
        });
    }


}
