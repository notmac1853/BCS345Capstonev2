package com.mycompany.playingcard24_v2;

import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.event.ActionEvent;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.shape.Rectangle;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.scene.control.TextField;
import java.io.*;
import java.util.Stack;
import java.util.regex.Pattern;

/*
*    <h1>Playing Card 24</h1>
*    This is a simple application that displays four random card objects from a standard deck on a GUI. The cards are unique and have a rank, suit, and image url value. Using the cards displayed
*    on the GUI, and some approved special characters, the user must create a mathematical expression that evaluates to 24. There is also a button that allows the user to generate a new set of cards
*    and values if they would like to
*
*    @author Marco Chavez.
*
*/

public class App extends Application
{
    //Group where all elements of the GUI will be added
    Group sp;
    //Labels to display text
    Label label1, label2, label3, validLabel;
    //Text field to allow user input
    TextField tf1, tf2;
    //Images of the cards
    Image card1, card2, card3, card4;
    //Creating shapes to make the cards white and the edges black
    Rectangle r1, r2, r3, r4;
    //integers to store the values of the cards
    int val1, val2, val3, val4;
    
    //A method to validate that the user is only using numbers from the given card values; returns a boolean
    public boolean validInput(String userInput, int num1, int num2, int num3, int num4){
        //initialize boolean
        boolean valid = true;
        
        //parse the values to strings
        String num1s = Integer.toString(num1);
        String num2s = Integer.toString(num2);
        String num3s = Integer.toString(num3);
        String num4s = Integer.toString(num4);
        
        //use regex to create a pattern that limits allowed characters to numbers passed from card values as well as allowed symbols
        Pattern pattern = Pattern.compile("[" + num1s + num2s + num3s + num4s+ "\\)\\(\\*\\/\\+\\-]+");

        //if the user input does not match the pattern, set valid to false
        if (!pattern.matcher(userInput).matches()){
            valid = false;
        
        }
        //if it does, set valid to true
        else {
            valid = true;
        }
        
        //return valid
        return valid;
    }
        

        

        

    
    //Method to evaluate a mathematical expression
    //Credit to https://www.geeksforgeeks.org/expression-evaluation/
    public static int evaluate(String expression)
    {
        char[] tokens = expression.toCharArray();
 
         // Stack for numbers: 'values'
        Stack<Integer> values = new
                              Stack<Integer>();
 
        // Stack for Operators: 'ops'
        Stack<Character> ops = new
                              Stack<Character>();
 
        for (int i = 0; i < tokens.length; i++)
        {
             
            // Current token is a
            // whitespace, skip it
            if (tokens[i] == ' ')
                continue;
 
            // Current token is a number,
            // push it to stack for numbers
            if (tokens[i] >= '0' &&
                 tokens[i] <= '9')
            {
                StringBuffer sbuf = new
                            StringBuffer();
                 
                // There may be more than one
                // digits in number
                while (i < tokens.length &&
                        tokens[i] >= '0' &&
                          tokens[i] <= '9')
                    sbuf.append(tokens[i++]);
                values.push(Integer.parseInt(sbuf.
                                      toString()));
               
                // right now the i points to
                // the character next to the digit,
                // since the for loop also increases
                // the i, we would skip one
                //  token position; we need to
                // decrease the value of i by 1 to
                // correct the offset.
                  i--;
            }
 
            // Current token is an opening brace,
            // push it to 'ops'
            else if (tokens[i] == '(')
                ops.push(tokens[i]);
 
            // Closing brace encountered,
            // solve entire brace
            else if (tokens[i] == ')')
            {
                while (ops.peek() != '(')
                  values.push(applyOp(ops.pop(),
                                   values.pop(),
                                 values.pop()));
                ops.pop();
            }
 
            // Current token is an operator.
            else if (tokens[i] == '+' ||
                     tokens[i] == '-' ||
                     tokens[i] == '*' ||
                        tokens[i] == '/')
            {
                // While top of 'ops' has same
                // or greater precedence to current
                // token, which is an operator.
                // Apply operator on top of 'ops'
                // to top two elements in values stack
                while (!ops.empty() &&
                       hasPrecedence(tokens[i],
                                    ops.peek()))
                  values.push(applyOp(ops.pop(),
                                   values.pop(),
                                 values.pop()));
 
                // Push current token to 'ops'.
                ops.push(tokens[i]);
            }
        }
 
        // Entire expression has been
        // parsed at this point, apply remaining
        // ops to remaining values
        while (!ops.empty())
            values.push(applyOp(ops.pop(),
                             values.pop(),
                           values.pop()));
 
        // Top of 'values' contains
        // result, return it
        return values.pop();
    }
 
    // Returns true if 'op2' has higher
    // or same precedence as 'op1',
    // otherwise returns false.
    public static boolean hasPrecedence(
                           char op1, char op2)
    {
        if (op2 == '(' || op2 == ')')
            return false;
        if ((op1 == '*' || op1 == '/') &&
            (op2 == '+' || op2 == '-'))
            return false;
        else
            return true;
    }
 
    // A utility method to apply an
    // operator 'op' on operands 'a'
    // and 'b'. Return the result.
    public static int applyOp(char op,
                           int b, int a)
    {
        switch (op)
        {
        case '+':
            return a + b;
        case '-':
            return a - b;
        case '*':
            return a * b;
        case '/':
            if (b == 0)
                throw new
                UnsupportedOperationException(
                      "Cannot divide by zero");
            return a / b;
        }
        return 0;
    }

    @Override
    public void start(Stage stage) {
        sp = new Group();
       
        //A button to generate a solution to the game (Work in Progress)
        Button btn1 = new Button("Find a Solution");
        btn1.setLayoutX(10);
        btn1.setLayoutY(5);
        btn1.setOnAction( this::processBtn1 );
        sp.getChildren().add(btn1);
        
        //A placeholder for the solution text field
        label2 = new Label("    Solution    ");
        //setting the x and y coordinates to display on the gui
        label2.setLayoutX(200);
        label2.setLayoutY(5);
        //set the border of the label to black ot make it a black box
        label2.setStyle("-fx-border-color: black;");
        //adding the node to the group
        sp.getChildren().add(label2);
        
        //A button that allows the user to refresh the four cards thye have displayed
        Button btn2 = new Button("Refresh");
        btn2.setLayoutX(300);
        btn2.setLayoutY(5);
        //tie the button to a mouse action that activates when the button is pressed
        btn2.setOnAction(this::processBtn2);      
        sp.getChildren().add(btn2);
        
        //label that tells the user where to enter their expression
        label1 = new Label("Enter an expression: ");
        label1.setLayoutX(10);
        label1.setLayoutY(270);
        sp.getChildren().add(label1);      
        
        //text field where the user enters their expression solution
        tf2 = new TextField("");
        tf2.setLayoutX(130);
        tf2.setLayoutY(270);
        sp.getChildren().add(tf2);
        
        //button that will verify that the solution enterd by the user is valid and evaluates to 24
        Button btn3 = new Button("Verify");
        btn3.setLayoutX(300);
        btn3.setLayoutY(270);
      	btn3.setOnAction(this::processBtn3);
        sp.getChildren().add(btn3);
        
        //create a drawofcrads object with 4 cards
        DrawOfCards deck1 = new DrawOfCards(4);
        
        //get the image urls of 4 cards
        card1 = new Image(deck1.getCardImage(0));
        card2 = new Image(deck1.getCardImage(1));
        card3 = new Image(deck1.getCardImage(2));
        card4 = new Image(deck1.getCardImage(3));
        
        //create rectangles that will serve as the backdrop and border of the cards         
        r1 = new Rectangle();
        r1.setX(50);
        r1.setY(100);
        //set the size of the rectangle
        r1.setHeight(100);
        r1.setWidth(75);
        //set the fill color of the rectangle
        r1.setFill(Color.WHITE);
        //set the border color of the rectangle
        r1.setStroke(Color.BLACK);
        sp.getChildren().add(r1);
        
        //create imageview objects that will be needed to actually display the images of the cards      
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

        //getting the rank values of the cards displayed
        val1 = deck1.getCardValue(0);
        val2 = deck1.getCardValue(1);
        val3 = deck1.getCardValue(2);
        val4 = deck1.getCardValue(3);
        
        //display the values of the cards; useful for debugging. Will also display whether or not the user's solution is correct
        validLabel = new Label(" Card 1 is: " + val1 + " Card 2 is: " + val2 + " Card 3: " + val3 + " Card 4: " + val4);
        validLabel.setLayoutX(10);
        validLabel.setLayoutY(250);
        sp.getChildren().add(validLabel);
        
        
        //set the scene and the background color, as well as the title of the window
        var scene = new Scene(sp, 500, 300, Color.LIGHTGREEN);   
        stage.setScene(scene);
        stage.setTitle("PlayingCard24");
        stage.show();
        
    }
     
    //the button action event that will generate a solution for the game
    public void processBtn1(ActionEvent arg0){
         //Work in progress
    }
    
    //this button action will reresh and draw four new cards to be displaye to the user, as well as updating the values of each cardValue
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
        
        val1 = deck1.getCardValue(0);
        val2 = deck1.getCardValue(1);
        val3 = deck1.getCardValue(2);
        val4 = deck1.getCardValue(3);
    }

    //this action event will call the user validation method on the user's input and determine if they expression they entered evaluates to 24. If hte input is invalid, an invalid input message is shown
    public void processBtn3(ActionEvent arg2){
        //trim the user's input into the text field of whitespace
       String fieldInput = tf2.getText().trim();
            
            //If the input validation method returns false, then display a message letting the user knows the input is invalid
            if (validInput(fieldInput, val1, val2, val3, val4) == false){
                validLabel.setText("Input is INVALID");
            }
            //otherwise, let the user know if the solution they entered for the game is correct
            else{
                //evaluate the expression and store the result in an int variable
                int solution = evaluate(fieldInput);
                
                //If the solution adds up to 24, the user is informed that it is correct
                if (solution == 24){
                    validLabel.setText("Correct answer! :)");
                }
                //If the solution does not addup to 24, then the user is informed of their incorrect acswer, and what it evaluates to
                else{
                    String numString = Integer.toString(solution);
                    validLabel.setText("Incorrect :( Your expression evaluates to: " + numString);
                }
            }
            
            



    }


 public static void main(String[] args) {
        launch();
    }
    
}
