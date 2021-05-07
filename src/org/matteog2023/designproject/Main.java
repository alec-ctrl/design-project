package org.matteog2023.designproject;

import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.input.KeyEvent;
import javafx.stage.Stage;

public class Main extends Application {

    static Stage stage;
    Scene startGraphic = new Scene(new GameGUI(), 500, 500);

    @Override
    public void start(Stage primaryStage) throws Exception{
        stage = primaryStage;
        StartGraphic root = new StartGraphic();
//        Scene scene = new Scene(root, 500, 500);
        primaryStage.setScene(new Scene(root, 500, 500));
//        switchscene(scene);
        stage.show();
        primaryStage.setTitle("Gravity man");
//        root.pause(false,false);
//        scene.addEventHandler(KeyEvent.KEY_PRESSED, new EventHandler<KeyEvent>() {
//            @Override
//            public void handle(KeyEvent keyEvent) {
//                root.handleKeyPress(keyEvent);
//            }
//        });
//        scene.addEventHandler(KeyEvent.KEY_RELEASED, new EventHandler<KeyEvent>() {
//            @Override
//            public void handle(KeyEvent keyEvent) {
//                root.handleKeyRelease(keyEvent);
//            }
//        });
    }

//    public static void switchscene(Scene scene) {
//        stage.setScene(scene);
//        stage.show();
//
//    }

    public static void main(String[] args) {
        launch(args);
    }
}
