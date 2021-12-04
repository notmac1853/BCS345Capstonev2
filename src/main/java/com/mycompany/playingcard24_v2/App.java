package com.mycompany.playingcard24_v2;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.event.ActionEvent;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.StackPane;
import javafx.scene.shape.Rectangle;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Polygon;
import javafx.stage.Stage;
import javafx.scene.control.TextField;

//for importing ctrl+space

/**
 * JavaFX App
 */
public class App extends Application {
    Group sp;
    int counter = 0;
    Label label1, label2;
    TextField tf1, tf2;

    @Override
    public void start(Stage stage) {
        sp = new Group();
        var scene = new Scene(sp, 400, 300);       

        
        Button btn1 = new Button("Find a Solution");
        btn1.setLayoutX(10);
        btn1.setLayoutY(5);
        btn1.setOnAction( this::processBtn1 );
        sp.getChildren().add(btn1);
        
        label2 = new Label("    Solution    ");
        label2.setLayoutX(200);
        label2.setLayoutY(5);
        label2.setStyle("-fx-border-color: black;");
        sp.getChildren().add(label2);
        
        
        Button btn2 = new Button("Refresh");
        btn2.setLayoutX(300);
        btn2.setLayoutY(5);
        btn2.setOnAction( this::processBtn2 );      
        sp.getChildren().add(btn2);
        
        label1 = new Label("Enter an expression: ");
        label1.setLayoutX(10);
        label1.setLayoutY(270);
        sp.getChildren().add(label1);      
        //String numString = Integer.toString(counter);
        //label1.setText(numString);
        
        tf2 = new TextField("Enter here");
        tf2.setLayoutX(130);
        tf2.setLayoutY(270);
        sp.getChildren().add(tf2);
        
        Button btn3 = new Button("Verify");
        btn3.setLayoutX(300);
        btn3.setLayoutY(270);
        sp.getChildren().add(btn3);

        
        stage.setScene(scene);
        stage.setTitle("PlayingCard24");
        stage.show();
        
    }
    
    public static void main(String[] args) {
        launch();
    }
    
    public void processBtn1(ActionEvent arg0){
        Image img = new Image("https://imgur.com/UEsYyRp.jpg", 100, 100, false, false);
        ImageView imgView = new ImageView(img);
        StackPane pane = new StackPane(imgView);
        pane.setLayoutX(250);
        pane.setLayoutY(250);
        sp.getChildren().add(pane);
        
        counter++;
        String numString = Integer.toString(counter);
        label1.setText(numString);
    }
    
    public void processBtn2(ActionEvent arg1){
        Image img = new Image("https://imgur.com/UEsYyRp.jpg", 100, 100, false, false);
        ImageView imgView = new ImageView(img);
        StackPane pane = new StackPane(imgView);
        pane.setLayoutX(250);
        pane.setLayoutY(250);
        sp.getChildren().add(pane);
        
        counter++;
        String numString = Integer.toString(counter);
        label1.setText(numString);
        
    }
    
    /*
    10C https://imgur.com/UEsYyRp
    10D https://imgur.com/npJmTXm
    10H https://imgur.com/4SrLlby
    10S https://imgur.com/3kAGaQB
    
    2C https://imgur.com/dn1XHYt
    2D https://imgur.com/lSXAhpj
    2H https://imgur.com/j9o233I
    2S https://imgur.com/ExqGRFl
    
    3C https://imgur.com/TXdwWlt
    3D https://imgur.com/W4Wf2Fb
    3H https://imgur.com/a3ZT2CL
    3S https://imgur.com/447bS09
    
    4C https://imgur.com/8u99tyx
    4D https://imgur.com/qWBoxbQ
    4H https://imgur.com/zs3p5EJ
    4S https://imgur.com/JJfugpe
    
    5C https://imgur.com/xjkDQN8
    5D https://imgur.com/Gs8F27c
    5H https://imgur.com/DI0A0ms
    5S https://imgur.com/1BZoI8Z
    
    6C https://imgur.com/YGxegCw
    6D https://imgur.com/zLBUPdn
    6H https://imgur.com/v9wIhhL
    6S https://imgur.com/SsVGy3M
    
    7C https://imgur.com/tOLr16X
    7D https://imgur.com/yYBQrSQ
    7H https://imgur.com/94Ys8cF
    7S https://imgur.com/XhJykKV
    
    8C https://imgur.com/IGiEAmv
    8D https://imgur.com/lxdq8ST
    8H https://imgur.com/hF61fbB
    8S https://imgur.com/uVeogQE
    
    9C https://imgur.com/WZRMPqX
    9D https://imgur.com/x6gE3wt
    9H https://imgur.com/UWVzOou
    9S https://imgur.com/6AtEzDs
    
    1C https://imgur.com/BDUmxan
    1D https://imgur.com/LlYl5Bg
    1H https://imgur.com/Rmfjs8C
    1S https://imgur.com/PhJua6z
    
    JC https://imgur.com/8BpwqHa
    JD https://imgur.com/vNG5cF6
    JH https://imgur.com/gnJ9eB4
    JS https://imgur.com/OUALf6o
    
    KC https://imgur.com/3TPAB3g
    KD https://imgur.com/KcQqfnN
    KH https://imgur.com/R3SWN6w
    KS https://imgur.com/4lehTuY
    
    QC https://imgur.com/HTDrwqx
    QD https://imgur.com/fddbq6u
    QH https://imgur.com/eLLjD2f
    QS https://imgur.com/APusIob
    */
    
    
    

}