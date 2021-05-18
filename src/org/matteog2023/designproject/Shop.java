package org.matteog2023.designproject;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;

public class Shop extends BorderPane {
    //One heart
    private ImageView image = new ImageView("https://st2.depositphotos.com/2743147/9292/i/600/depositphotos_92920470-stock-photo-heart-isolated-on-white-and.jpg");
    //Three images
    private ImageView image2 = new ImageView("https://media.istockphoto.com/photos/red-hearts-isolated-on-white-background-picture-id531760105?k=6&m=531760105&s=612x612&w=0&h=DQdiam1L0x7s1OtNR2BVRnHd3dafPzh85th2_NNPm5w=");
    private Label lives_label;
    private Label coins_label;
    //Making these new variables so I can edit them in the handle methods
    private int coin_num1;
    private int lives_num1;

    /**
     * Making two buttons, one of which costs 3 coins and gives 1 life, and the other of which
     * costs 7 coins and gives 3 lives
     * @param coin_num your existing coin total
     * @param lives_num your existing life total
     * @param maze_num what maze you are on
     * @param risk_num your current risk level
     */

    Shop(int coin_num, int lives_num, int maze_num, int risk_num){
        coin_num1 = coin_num;

        lives_num1 = lives_num;
        Pane buttonbox = new Pane();
        this.setCenter(buttonbox);

        lives_label = new Label("Your Life: " + lives_num1);
        coins_label = new Label("Your Coins: " +coin_num1);
        coins_label.setLayoutX(400);
        lives_label.setLayoutX(300);
        //buttonbox
        Button one_life = new Button("1 Life, 3 Coins");
        one_life.setMinSize(150, 40);
        one_life.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                if(coin_num1 >= 3){
                    lives_num1++;
                    //it will cost 3 coins to buy 1 life
                    coin_num1 -= 3;
                }

                //Updating the label after you hit a button

                lives_label.setText("Your Life: " + lives_num1);
                coins_label.setText("Your Coins: " +coin_num1);
            }
        });
        Button three_lives = new Button("3 Lives, 7 Coins");
        three_lives.setMinSize(150, 40);
        three_lives.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                if(coin_num1 >= 7){
                    lives_num1 +=3;

                    //it will cost 7 coins to buy 3 lives
                    coin_num1 -= 7;
                }

                //Updating the label after you hit a button
                lives_label.setText("Your Life: " + lives_num1);
                coins_label.setText("Your Coins: " + coin_num1);

            }
        });

        Button back = new Button("Back");
        back.setMinSize(150, 40);
        back.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                GameGUI g = new GameGUI(maze_num, lives_num1, coin_num1, risk_num, true);
                Scene s = new Scene(g, 500,500);
                Main.switchscene(s);
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
        back.setLayoutX(300);
        back.setLayoutY(300);
        image.setX(10);
        image.setY(50);
        image.setFitWidth(200);
        image.setFitHeight(200);
        one_life.setLayoutY(250);
        one_life.setLayoutX(10);

        three_lives.setLayoutY(250);
        three_lives.setLayoutX(250);
        image2.setX(250);
        image2.setY(50);

        image2.setFitWidth(200);
        image2.setFitHeight(200);

        three_lives.setLayoutX(250);
        three_lives.setLayoutX(250);

        buttonbox.getChildren().addAll(one_life, image, image2, three_lives, coins_label, lives_label, back);
        buttonbox.setPadding(new Insets(10, 10, 10, 10));
    }


}
