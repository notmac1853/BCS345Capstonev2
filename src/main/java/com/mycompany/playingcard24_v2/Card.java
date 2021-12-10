package com.mycompany.playingcard24_v2;

/*
*   <h2>The Card Class</h2>
*   This card class creates card objects with a rank, suit, and string value for an image url
*
*/
public class Card {
    /*
    2-10
    Ace: 1
    Jack: 11
    Queen: 12
    King: 13
    */
    private final int rank;
    /*
    Clubs: 0
    Diamonds: 1
    Hearts: 2
    Spades : 3
    */
    private final int suit;
    //URL for the image of the card
    private String image;
    
    //constructor
    public Card(int rank, int suit, String image){
        this.rank = rank;
        this.suit = suit;
        this.image = image;
    }
    //possible suits and ranks stored in an array
    public static String[] suits = {"Clubs", "Diamonds", "Hearts", "Spades"};
    public static String[] ranks = {null, "Ace", "2", "3", "4", "5", "6",
           "7", "8", "9", "10", "Jack", "Queen", "King"}; 
    
    //accessor method for the rank of the card
    public int getRank(){
        return this.rank;
    }
    
    //accessor method for the suit of the card
    public int getSuit() {
        return this.suit;
    }
    
    //accessor method for hte image value of a card
    public String getImage(){
        return this.image;
    }
    
    //no setters since we want the values of the cards to be immutable
    
    //Get the description of a card as a string
    public String cardDesc() {
    String s = ranks[this.rank] + " of " + suits[this.suit] + " with the image " + image;
    return s;
    }
}

