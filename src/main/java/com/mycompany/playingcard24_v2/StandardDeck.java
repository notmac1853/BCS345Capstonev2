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
public class StandardDeck extends DrawOfCards{
    private Card[] cards;
     
    
    public StandardDeck(){
        this.cards = new Card[52];
        int index = 0;
        for (int suit = 0; suit <= 3; suit++){
            for (int rank = 1; rank <=13; rank++){
                this.cards[index] = new Card(rank, suit, cardurls[index]);
                index++;
                
            }
        }
    }
}