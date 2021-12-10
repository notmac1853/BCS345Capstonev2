package com.mycompany.playingcard24_v2;

import java.util.ArrayList;
import java.util.Collections;


/*
*   <h2>The Deck Class</h2>
*    This class has methods that allow the user to draw any number (As long as it is less than the number of cards in an actual deck) of cards from a deck randomly.
*    This method class is versatile and allows the user to specify the number of cards they want. Which gives it utility in the case of this GUI app, which needs 4 cards, but could also
*    make it useful with other card games as well.
*
*/

public class DrawOfCards {
    //an array of cards that will be a standard deck
    private Card[] cards;
    //an array that will store a user specified number of random cards from a standard deck
    private Card[] randDeck;
    
    //An array of web url's corresponding to each card
    private String[] cardurls = new String[] {
    "https://imgur.com/BDUmxan.png", //1C
    "https://imgur.com/dn1XHYt.png", //2C
    "https://imgur.com/TXdwWlt.png", //3C
    "https://imgur.com/8u99tyx.png", //4C
    "https://imgur.com/xjkDQN8.png", //5C
    "https://imgur.com/YGxegCw.png", //6C
    "https://imgur.com/tOLr16X.png", //7C
    "https://imgur.com/IGiEAmv.png", //8C
    "https://imgur.com/WZRMPqX.png", //9C
    "https://imgur.com/UEsYyRp.png", //10C
    "https://imgur.com/8BpwqHa.png", //JC
    "https://imgur.com/HTDrwqx.png", //QC
    "https://imgur.com/3TPAB3g.png", //KC
        
     "https://imgur.com/LlYl5Bg.png", //1D
     "https://imgur.com/lSXAhpj.png", //2D
     "https://imgur.com/W4Wf2Fb.png", //3D
     "https://imgur.com/qWBoxbQ.png", //4D
     "https://imgur.com/Gs8F27c.png", //5D
     "https://imgur.com/zLBUPdn.png", //6D
     "https://imgur.com/yYBQrSQ.png", //7D
     "https://imgur.com/lxdq8ST.png", //8D
     "https://imgur.com/x6gE3wt.png", //9D
     "https://imgur.com/npJmTXm.png", //10D
     "https://imgur.com/vNG5cF6.png", //JD
     "https://imgur.com/fddbq6u.png", //QD
     "https://imgur.com/KcQqfnN.png", //KD
     
     
     "https://imgur.com/Rmfjs8C.png", //1H
     "https://imgur.com/j9o233I.png", //2H
     "https://imgur.com/a3ZT2CL.png", //3H
     "https://imgur.com/zs3p5EJ.png", //4H
     "https://imgur.com/DI0A0ms.png", //5H
     "https://imgur.com/v9wIhhL.png", //6H
     "https://imgur.com/94Ys8cF.png", //7H
     "https://imgur.com/hF61fbB.png", //8H
     "https://imgur.com/UWVzOou.png", //9H
     "https://imgur.com/4SrLlby.png", //10H
     "https://imgur.com/gnJ9eB4.png", //JH
     "https://imgur.com/eLLjD2f.png", //QH
     "https://imgur.com/R3SWN6w.png", //KH
     
     "https://imgur.com/PhJua6z.png", //1S
     "https://imgur.com/ExqGRFl.png", //2S
     "https://imgur.com/447bS09.png", //3S
     "https://imgur.com/JJfugpe.png", //4S
     "https://imgur.com/1BZoI8Z.png", //5S
     "https://imgur.com/SsVGy3M.png", //6S
     "https://imgur.com/XhJykKV.png", //7S
     "https://imgur.com/uVeogQE.png", //8S
     "https://imgur.com/6AtEzDs.png", //9S
     "https://imgur.com/3kAGaQB.png", //10S
     "https://imgur.com/OUALf6o.png", //JS
     "https://imgur.com/APusIob.png", //QS
     "https://imgur.com/4lehTuY.png" //KS
    };
    
    public DrawOfCards(int numberOfCards){
        //create a standrad deck of 52 cards
        this.cards = new Card[52];
        int index = 0;
            for (int suit = 0; suit <= 3; suit++){
                for (int rank = 1; rank <=13; rank++){
                    this.cards[index] = new Card(rank, suit, cardurls[index]);
                    index++;

                }
            }
        
        //create the randomdeck array of card objects
        this.randDeck = new Card[numberOfCards];
        
        //create an arraylist of numbers
        ArrayList numbers = new ArrayList();
        for(int i = 0; i < 52; i++){
            numbers.add(i+1);
        }
        
        //shuffle said arraylist of numbers
        Collections.shuffle(numbers);
        
        //now we can pick the 4 first cards from the deck, which will be random because we shuffled the arraylist of numbers corresponding to indexes in the standard deck
        for (int j = 0; j < numberOfCards; j++){
            int i = (Integer)numbers.get(j)-1;
            randDeck[j] = this.cards[i];
        }
    }
    
    //accessor to get the rank value of a card
    public int getCardValue(int n){
        int value = randDeck[n].getRank();
        return value;
    }
    
    //accessor to get the string image value of a card
    public String getCardImage(int n){
        String image = randDeck[n].getImage();
        return image;
    }
    
    //Print the card objects from a draw you have created
    public void printDraw(){
        for (int i = 0; i < this.randDeck.length; i++){
            System.out.println(this.randDeck[i].cardDesc());
        }
    }
    
}
