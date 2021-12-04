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

	// Step1: Create an String array containing all 52 hyperlinks.
	// String [] cardurls = new string[] {"https://imgur.com/UEsYyRp","https://imgur.com/npJmTXm", "https://imgur.com/4SrLlby"};

	String[] cardurls = new String[] {
"https://imgur.com/UEsYyRp.jpg", "https://imgur.com/npJmTXm.jpg", "https://imgur.com/4SrLlby.jpg", "https://imgur.com/3kAGaQB.jpg", "https://imgur.com/dn1XHYt.jpg", "https://imgur.com/lSXAhpj.jpg", "https://imgur.com/j9o233I.jpg", "https://imgur.com/ExqGRFl.jpg", "https://imgur.com/TXdwWlt.jpg", "https://imgur.com/W4Wf2Fb.jpg", "https://imgur.com/a3ZT2CL.jpg", "https://imgur.com/447bS09.jpg", "https://imgur.com/8u99tyx.jpg", "https://imgur.com/qWBoxbQ.jpg", "https://imgur.com/zs3p5EJ.jpg", "https://imgur.com/JJfugpe.jpg", "https://imgur.com/xjkDQN8.jpg", "https://imgur.com/Gs8F27c.jpg", "https://imgur.com/DI0A0ms.jpg", "https://imgur.com/1BZoI8Z.jpg", "https://imgur.com/YGxegCw.jpg", "https://imgur.com/zLBUPdn.jpg", "https://imgur.com/v9wIhhL.jpg", "https://imgur.com/SsVGy3M.jpg", "https://imgur.com/tOLr16X.jpg", "https://imgur.com/yYBQrSQ.jpg", "https://imgur.com/94Ys8cF.jpg", "https://imgur.com/XhJykKV.jpg", "https://imgur.com/IGiEAmv.jpg", "https://imgur.com/lxdq8ST.jpg", "https://imgur.com/hF61fbB.jpg", "https://imgur.com/uVeogQE.jpg", "https://imgur.com/WZRMPqX.jpg", "https://imgur.com/x6gE3wt.jpg", "https://imgur.com/UWVzOou.jpg", "https://imgur.com/6AtEzDs.jpg", "https://imgur.com/BDUmxan.jpg", "https://imgur.com/LlYl5Bg.jpg", "https://imgur.com/Rmfjs8C.jpg", "https://imgur.com/PhJua6z.jpg", "https://imgur.com/8BpwqHa.jpg", "https://imgur.com/vNG5cF6.jpg", "https://imgur.com/gnJ9eB4.jpg", "https://imgur.com/OUALf6o.jpg", "https://imgur.com/3TPAB3g.jpg", "https://imgur.com/KcQqfnN.jpg", "https://imgur.com/R3SWN6w.jpg", "https://imgur.com/4lehTuY.jpg", "https://imgur.com/HTDrwqx.jpg", "https://imgur.com/fddbq6u.jpg", "https://imgur.com/eLLjD2f.jpg", "https://imgur.com/APusIob.jpg" };
	
	// Next steps: Create an int array which represents the values of all the cards linked above.
	//			   When you select a random url, also select the corresponding value of that card.
	
	// 			   Create an ArrayList<Integer> to hold the values of the four selected cards. 
	//			   You'll use this for your expression.

    @Override
    public void start(Stage stage) {
        sp = new Group();		// <-- 
        var scene = new Scene(sp, 500, 300);       
        
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