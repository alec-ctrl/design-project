package org.matteog2023.designproject;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {

    static Stage stage;


    /**
     * Calling StartGraphic
     * @param primaryStage the stage you are seeing
     * @throws Exception in case it throws an exception
     */
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

    /**
     * The method from which we are launching everything
     * @param args stuff
     */
    public static void main(String[] args) {

        launch(args);
    }
}