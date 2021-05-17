package org.matteog2023.designproject;

import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.input.KeyEvent;
import javafx.stage.Stage;
import javafx.animation.AnimationTimer;

public class Main extends Application {

    static Stage stage;



    @Override
    public void start(Stage primaryStage) throws Exception {

        stage = primaryStage;

        StartGraphic root = new StartGraphic();

        primaryStage.setScene(new Scene(root, 500, 500));
        stage.show();
        primaryStage.setTitle("Templer");
    }

    public static void switchscene(Scene scene) {
        stage.setScene(scene);
        stage.show();

    }

    public static void main(String[] args) {

        launch(args);
    }
}