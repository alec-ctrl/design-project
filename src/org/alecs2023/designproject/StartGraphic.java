package org.alecs2023.designproject;

import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;

public class StartGraphic extends BorderPane {

    StartGraphic(){
        Button start = new Button("Start");
        start.setPadding(new Insets(10,100,10,80));
        this.setCenter(start);
    }


}
