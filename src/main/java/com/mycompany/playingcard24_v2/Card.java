/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.playingcard24_v2;

/**
 *
 * @author Marco
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
    
    public Card(int rank, int suit, String image){
        this.rank = rank;
        this.suit = suit;
        this.image = image;
    }
    
    public static String[] suits = {"Clubs", "Diamonds", "Hearts", "Spades"};
    public static String[] ranks = {null, "Ace", "2", "3", "4", "5", "6",
           "7", "8", "9", "10", "Jack", "Queen", "King"};   
    public int getRank(){
        return this.rank;
    }
    
    public int getSuit() {
        return this.suit;
    }
    
    public String getImage(){
        return this.image;
    }
    
    //Get the description of a card as a string
    public String cardDesc() {
    String s = ranks[this.rank] + " of " + suits[this.suit] + " with the image " + image;
    return s;
    }
}

