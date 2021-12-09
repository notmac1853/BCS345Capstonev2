/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.playingcard24_v2;

import java.util.ArrayList;
import java.util.Collections;

/**
 *
 * @author Marco
 */
public class DrawOfCards {
    private Card[] cards;
    private Card[] randDeck;
    
    private String[] cardurls = new String[] {
     "https://imgur.com/BDUmxan", //1C
     "https://imgur.com/LlYl5Bg", //1D
     "https://imgur.com/Rmfjs8C", //1H
     "https://imgur.com/PhJua6z", //1S
   
     "https://imgur.com/dn1XHYt", //2C
     "https://imgur.com/lSXAhpj", //2D
     "https://imgur.com/j9o233I", //2H
     "https://imgur.com/ExqGRFl", //2S
    
     "https://imgur.com/TXdwWlt", //3C
     "https://imgur.com/W4Wf2Fb", //3D
     "https://imgur.com/a3ZT2CL", //3H
     "https://imgur.com/447bS09", //3S
    
     "https://imgur.com/8u99tyx", //4C
     "https://imgur.com/qWBoxbQ", //4D
     "https://imgur.com/zs3p5EJ", //4H
     "https://imgur.com/JJfugpe", //4S
    
     "https://imgur.com/xjkDQN8", //5C
     "https://imgur.com/Gs8F27c", //5D
     "https://imgur.com/DI0A0ms", //5H
     "https://imgur.com/1BZoI8Z", //5S
    
     "https://imgur.com/YGxegCw", //6C
     "https://imgur.com/zLBUPdn", //6D
     "https://imgur.com/v9wIhhL", //6H
     "https://imgur.com/SsVGy3M", //6S
    
     "https://imgur.com/tOLr16X", //7C
     "https://imgur.com/yYBQrSQ", //7D
     "https://imgur.com/94Ys8cF", //7H
     "https://imgur.com/XhJykKV", //7S
    
     "https://imgur.com/IGiEAmv", //8C
     "https://imgur.com/lxdq8ST", //8D
     "https://imgur.com/hF61fbB", //8H
     "https://imgur.com/uVeogQE", //8S
    
     "https://imgur.com/WZRMPqX", //9C
     "https://imgur.com/x6gE3wt", //9D
     "https://imgur.com/UWVzOou", //9H
     "https://imgur.com/6AtEzDs", //9S
    
     "https://imgur.com/UEsYyRp", //10C
     "https://imgur.com/npJmTXm", //10D
     "https://imgur.com/4SrLlby", //10H
     "https://imgur.com/3kAGaQB", //10S
    
     "https://imgur.com/8BpwqHa", //JC
     "https://imgur.com/vNG5cF6", //JD
     "https://imgur.com/gnJ9eB4", //JH
     "https://imgur.com/OUALf6o", //JS
    
     "https://imgur.com/HTDrwqx", //QC
     "https://imgur.com/fddbq6u", //QD
     "https://imgur.com/eLLjD2f", //QH
     "https://imgur.com/APusIob", //QS
    
     "https://imgur.com/3TPAB3g", //KC
     "https://imgur.com/KcQqfnN", //KD
     "https://imgur.com/R3SWN6w", //KH
     "https://imgur.com/4lehTuY" //KS
    
    };
    
    public DrawOfCards(int numberOfCards){
        this.cards = new Card[52];
        int index = 0;
            for (int suit = 0; suit <= 3; suit++){
                for (int rank = 1; rank <=13; rank++){
                    this.cards[index] = new Card(rank, suit, cardurls[index]);
                    index++;

                }
            }
        
        this.randDeck = new Card[numberOfCards];
                
        ArrayList numbers = new ArrayList();
        for(int i = 0; i < 52; i++){
            numbers.add(i+1);
        }
        
        Collections.shuffle(numbers);
        
        for (int j = 0; j < numberOfCards; j++){
            int i = (Integer)numbers.get(j)-1;
            randDeck[j] = this.cards[i];
        }
    }
    
    public void printDraw(){
        for (int i = 0; i < this.randDeck.length; i++){
            System.out.println(this.randDeck[i].cardDesc());
        }
    }
    
}
