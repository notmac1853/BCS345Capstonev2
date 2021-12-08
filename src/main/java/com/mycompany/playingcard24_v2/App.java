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

//for importing ctrl+space

// Info about what panes to use when:
// https://docs.oracle.com/javafx/2/layout/builtin_layouts.htm

/**
 * JavaFX App
 */
public class App extends Application 	// <-- 
{
    Group sp;
    HBox cardPane;		// <-- Change this from a StackPane to an HBox.
    int counter = 0;		
    Label label1, label2;	
    TextField tf1, tf2;

    @Override
    public void start(Stage stage) {
        sp = new Group();		// <-- 
        var scene = new Scene(sp, 500, 300, Color.LIGHTGREEN);   
        
        
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
        
      
      
        
        stage.setScene(scene);
        stage.setTitle("PlayingCard24");
        stage.show();
      
      	cardPane = new HBox();			// <-- Initialize our card pane
	cardPane.setLayoutX(20);			// <-- setup its layout (position and size)
        cardPane.setLayoutY(75);
      	sp.getChildren().add(cardPane);	
        
        Random rgen = new Random();
	cardPane.getChildren().clear();
        
        
        	for (int i = 0 ; i < 4 ; i++)
                {
      		int randomIndex = rgen.nextInt(52);
      		Image img = new Image( cardurls[randomIndex] , 100, 100, false, false);		// <--- We create our card image here.
        	ImageView imgView = new ImageView(img);		// <--- We create a JavaFX control for displaying the card image.
      		cardPane.getChildren().add(imgView);	// <-- Now we want to add that javafx control onto our window
		}
        
    }
     




    public void processBtn1(ActionEvent arg0){
        
        Image img = new Image("10_of_clubs.png", 100, 100, false, false);
        ImageView imgView = new ImageView(img);
        StackPane pane = new StackPane(imgView);
        pane.setLayoutX(250);
        pane.setLayoutY(250);
        sp.getChildren().add(pane);
        
        counter++;
        String numString = Integer.toString(counter);
        label1.setText(numString);
    }
    
    public void processBtn2(ActionEvent arg1)
    {
      	// Create our random number generator and clear our card pane.
      	Random rgen = new Random();
		cardPane.getChildren().clear();
      
      	// The following selects a random card and adds it to our window.
      	// We want this process to repeat four times, so that four cards get displayed on our window.
      
      	for (int i = 0 ; i < 4 ; i++)
        {
      		int randomIndex = rgen.nextInt(52);
      		Image img = new Image( cardurls[randomIndex] , 100, 100, false, false);		// <--- We create our card image here.
        	ImageView imgView = new ImageView(img);		// <--- We create a JavaFX control for displaying the card image.
      		cardPane.getChildren().add(imgView);	// <-- Now we want to add that javafx control onto our window.
		}
             
        counter++;
        String numString = Integer.toString(counter);
        label1.setText(numString);
           
    }

public void processBtn3(ActionEvent arg2)
{
  
  System.out.println("HI");
  
  
  
}


 public static void main(String[] args) {
        launch();
    }
    
}