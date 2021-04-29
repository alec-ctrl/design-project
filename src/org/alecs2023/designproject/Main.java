package org.alecs2023.designproject;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {

    static Stage stage;
    Scene startGraphic = new Scene(new StartGraphic(), 500, 500);

    @Override
    public void start(Stage primaryStage) throws Exception{
        //TODO make a simple UI here
        stage = primaryStage;
        stage.setScene(startGraphic);
        stage.show();
    }
    public static void switchscene(Scene scene) {
        stage.setScene(scene);
    }

    public static void main(String[] args) {
        launch(args);
    }
}
