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
import java.util.Stack;


public class App extends Application
{
    Group sp;		
    Label label1, label2, label3, validLabel;	
    TextField tf1, tf2;
    Image card1, card2, card3, card4;
    Rectangle r1, r2, r3, r4;
    int val1, val2, val3, val4;
    
    public boolean validInput(String userInput, int num1, int num2, int num3, int num4){
        boolean valid = true;

        char cnum1 = (char)num1;
        char cnum2 = (char)num2;
        char cnum3 = (char)num3;
        char cnum4 = (char)num4;

        for (int i = 0; i < userInput.length(); i++){
            char c = userInput.charAt(i);

            if ((c != ')') || (c != '(') || (c != '+') || (c != '-') || (c != '*') || (c!= '/') || (c != cnum1) || (c != cnum2)){
                valid = false;
            }
            else{
                valid = true;
            }
        }

        return valid;

    }
    
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
       
        Label validLabel = new Label("Is your expression valid?");
        validLabel.setLayoutX(250);
        validLabel.setLayoutY(250);
        sp.getChildren().add(validLabel);
        
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
        
        tf2 = new TextField("");
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

        val1 = deck1.getCardValue(0);
        val2 = deck1.getCardValue(1);
        val3 = deck1.getCardValue(2);
        val4 = deck1.getCardValue(3);
        
        var scene = new Scene(sp, 500, 300, Color.LIGHTGREEN);   
        stage.setScene(scene);
        stage.setTitle("PlayingCard24");
        stage.show();
        
    }
     




    public void processBtn1(ActionEvent arg0){
        
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
        
        val1 = deck1.getCardValue(0);
        val2 = deck1.getCardValue(1);
        val3 = deck1.getCardValue(2);
        val4 = deck1.getCardValue(3);
    }

    public void processBtn3(ActionEvent arg2){

       String fieldInput = tf2.getText().trim();

            if (validInput(fieldInput, val1, val2, val3, val4) == false){
                validLabel.setText("Input is INVALID");
            }
            else{
                int solution = evaluate(fieldInput);
                String numString = Integer.toString(solution);
                validLabel.setText(numString);
            }



    }


 public static void main(String[] args) {
        launch();
    }
    
}
