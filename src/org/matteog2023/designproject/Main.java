package org.matteog2023.designproject;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {

    static Stage stage;



    @Override
    public void start(Stage primaryStage) throws Exception {

        stage = primaryStage;

        StartGraphic root = new StartGraphic();

        primaryStage.setScene(new Scene(root, 500, 500));
        stage.show();
        primaryStage.setTitle("Gravity Dude");
    }

    /**
     * to switch the scene
     * @param scene the scene you are switching to
     */
    public static void switchscene(Scene scene) {
        stage.setScene(scene);
        stage.show();

    }

    public static void main(String[] args) {

        launch(args);
    }
}