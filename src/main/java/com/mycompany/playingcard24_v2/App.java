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
import java.util.Random;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import java.io.*;

//for importing ctrl+space

// Info about what panes to use when:
// https://docs.oracle.com/javafx/2/layout/builtin_layouts.htm

/**
 * JavaFX App
 */
public class App extends Application 	// <-- 
{
    Group sp;		
    Label label1, label2, label3;	
    TextField tf1, tf2;
    Image card1, card2, card3, card4;
    Rectangle r1, r2, r3, r4;
    int val1, val2, val3, val4;

    @Override
    public void start(Stage stage) {
        sp = new Group();
        
        
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
        btn2.setOnAction(this::processBtn2);      
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
      	btn3.setOnAction(this::processBtn3);
        sp.getChildren().add(btn3);
        
        DrawOfCards deck1 = new DrawOfCards(4);
        
        card1 = new Image(deck1.getCardImage(0));
        card2 = new Image(deck1.getCardImage(1));
        card3 = new Image(deck1.getCardImage(2));
        card4 = new Image(deck1.getCardImage(3));
        
        
        r1 = new Rectangle();
        r1.setX(50);
        r1.setY(100);
        r1.setHeight(100);
        r1.setWidth(75);
        r1.setFill(Color.WHITE);
        r1.setStroke(Color.BLACK);
        sp.getChildren().add(r1);
        
               
        ImageView cardImage1 = new ImageView(card1);
        cardImage1.setX(50);
        cardImage1.setY(100);
        cardImage1.setFitHeight(100);
        cardImage1.setFitWidth(75);
        sp.getChildren().add(cardImage1);
        
        r2 = new Rectangle();
        r2.setX(150);
        r2.setY(100);
        r2.setHeight(100);
        r2.setWidth(75);
        r2.setFill(Color.WHITE);
        r2.setStroke(Color.BLACK);
        sp.getChildren().add(r2);
        
        ImageView cardImage2 = new ImageView(card2);
        cardImage2.setX(150);
        cardImage2.setY(100);
        cardImage2.setFitHeight(100);
        cardImage2.setFitWidth(75);
        sp.getChildren().add(cardImage2);
        
        r3 = new Rectangle();
        r3.setX(250);
        r3.setY(100);
        r3.setHeight(100);
        r3.setWidth(75);
        r3.setFill(Color.WHITE);
        r3.setStroke(Color.BLACK);
        sp.getChildren().add(r3);
        
        ImageView cardImage3 = new ImageView(card3);
        cardImage3.setX(250);
        cardImage3.setY(100);
        cardImage3.setFitHeight(100);
        cardImage3.setFitWidth(75);
        sp.getChildren().add(cardImage3);
        
        r4 = new Rectangle();
        r4.setX(350);
        r4.setY(100);
        r4.setHeight(100);
        r4.setWidth(75);
        r4.setFill(Color.WHITE);
        r4.setStroke(Color.BLACK);
        sp.getChildren().add(r4);
        
        ImageView cardImage4 = new ImageView(card4);
        cardImage4.setX(350);
        cardImage4.setY(100);
        cardImage4.setFitHeight(100);
        cardImage4.setFitWidth(75);
        sp.getChildren().add(cardImage4);
        
        
        
        
        
        
        
        
        
        
        int val1 = deck1.getCardValue(0);
        int val2 = deck1.getCardValue(1);
        int val3 = deck1.getCardValue(2);
        int val4 = deck1.getCardValue(3);
        
        var scene = new Scene(sp, 500, 300, Color.LIGHTGREEN);   
        stage.setScene(scene);
        stage.setTitle("PlayingCard24");
        stage.show();
        
    }
     




    public void processBtn1(ActionEvent arg0){
        /*
        Image img = new Image("10_of_clubs.png", 100, 100, false, false);
        ImageView imgView = new ImageView(img);
        StackPane pane = new StackPane(imgView);
        pane.setLayoutX(250);
        pane.setLayoutY(250);
        sp.getChildren().add(pane);
        
        counter++;
        String numString = Integer.toString(counter);
        label1.setText(numString);
*/
    }
    
    public void processBtn2(ActionEvent arg1)
    {
      	DrawOfCards deck1 = new DrawOfCards(4);
        
        card1 = new Image(deck1.getCardImage(0));
        card2 = new Image(deck1.getCardImage(1));
        card3 = new Image(deck1.getCardImage(2));
        card4 = new Image(deck1.getCardImage(3));
        
        
        r1 = new Rectangle();
        r1.setX(50);
        r1.setY(100);
        r1.setHeight(100);
        r1.setWidth(75);
        r1.setFill(Color.WHITE);
        r1.setStroke(Color.BLACK);
        sp.getChildren().add(r1);
        
               
        ImageView cardImage1 = new ImageView(card1);
        cardImage1.setX(50);
        cardImage1.setY(100);
        cardImage1.setFitHeight(100);
        cardImage1.setFitWidth(75);
        sp.getChildren().add(cardImage1);
        
        r2 = new Rectangle();
        r2.setX(150);
        r2.setY(100);
        r2.setHeight(100);
        r2.setWidth(75);
        r2.setFill(Color.WHITE);
        r2.setStroke(Color.BLACK);
        sp.getChildren().add(r2);
        
        ImageView cardImage2 = new ImageView(card2);
        cardImage2.setX(150);
        cardImage2.setY(100);
        cardImage2.setFitHeight(100);
        cardImage2.setFitWidth(75);
        sp.getChildren().add(cardImage2);
        
        r3 = new Rectangle();
        r3.setX(250);
        r3.setY(100);
        r3.setHeight(100);
        r3.setWidth(75);
        r3.setFill(Color.WHITE);
        r3.setStroke(Color.BLACK);
        sp.getChildren().add(r3);
        
        ImageView cardImage3 = new ImageView(card3);
        cardImage3.setX(250);
        cardImage3.setY(100);
        cardImage3.setFitHeight(100);
        cardImage3.setFitWidth(75);
        sp.getChildren().add(cardImage3);
        
        r4 = new Rectangle();
        r4.setX(350);
        r4.setY(100);
        r4.setHeight(100);
        r4.setWidth(75);
        r4.setFill(Color.WHITE);
        r4.setStroke(Color.BLACK);
        sp.getChildren().add(r4);
        
        ImageView cardImage4 = new ImageView(card4);
        cardImage4.setX(350);
        cardImage4.setY(100);
        cardImage4.setFitHeight(100);
        cardImage4.setFitWidth(75);
        sp.getChildren().add(cardImage4);
    }

public void processBtn3(ActionEvent arg2)
{
  
  System.out.println("HI");
  
  
  
}


 public static void main(String[] args) {
        launch();
    }
    
}