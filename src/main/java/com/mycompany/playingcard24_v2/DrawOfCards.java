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
     "https://imgur.com/BDUmxan.png", //1C
     "https://imgur.com/LlYl5Bg.png", //1D
     "https://imgur.com/Rmfjs8C.png", //1H
     "https://imgur.com/PhJua6z.png", //1S
   
     "https://imgur.com/dn1XHYt.png", //2C
     "https://imgur.com/lSXAhpj.png", //2D
     "https://imgur.com/j9o233I.png", //2H
     "https://imgur.com/ExqGRFl.png", //2S
    
     "https://imgur.com/TXdwWlt.png", //3C
     "https://imgur.com/W4Wf2Fb.png", //3D
     "https://imgur.com/a3ZT2CL.png", //3H
     "https://imgur.com/447bS09.png", //3S
    
     "https://imgur.com/8u99tyx.png", //4C
     "https://imgur.com/qWBoxbQ.png", //4D
     "https://imgur.com/zs3p5EJ.png", //4H
     "https://imgur.com/JJfugpe.png", //4S
    
     "https://imgur.com/xjkDQN8.png", //5C
     "https://imgur.com/Gs8F27c.png", //5D
     "https://imgur.com/DI0A0ms.png", //5H
     "https://imgur.com/1BZoI8Z.png", //5S
    
     "https://imgur.com/YGxegCw.png", //6C
     "https://imgur.com/zLBUPdn.png", //6D
     "https://imgur.com/v9wIhhL.png", //6H
     "https://imgur.com/SsVGy3M.png", //6S
    
     "https://imgur.com/tOLr16X.png", //7C
     "https://imgur.com/yYBQrSQ.png", //7D
     "https://imgur.com/94Ys8cF.png", //7H
     "https://imgur.com/XhJykKV.png", //7S
    
     "https://imgur.com/IGiEAmv.png", //8C
     "https://imgur.com/lxdq8ST.png", //8D
     "https://imgur.com/hF61fbB.png", //8H
     "https://imgur.com/uVeogQE.png", //8S
    
     "https://imgur.com/WZRMPqX.png", //9C
     "https://imgur.com/x6gE3wt.png", //9D
     "https://imgur.com/UWVzOou.png", //9H
     "https://imgur.com/6AtEzDs.png", //9S
    
     "https://imgur.com/UEsYyRp.png", //10C
     "https://imgur.com/npJmTXm.png", //10D
     "https://imgur.com/4SrLlby.png", //10H
     "https://imgur.com/3kAGaQB.png", //10S
    
     "https://imgur.com/8BpwqHa.png", //JC
     "https://imgur.com/vNG5cF6.png", //JD
     "https://imgur.com/gnJ9eB4.png", //JH
     "https://imgur.com/OUALf6o.png", //JS
    
     "https://imgur.com/HTDrwqx.png", //QC
     "https://imgur.com/fddbq6u.png", //QD
     "https://imgur.com/eLLjD2f.png", //QH
     "https://imgur.com/APusIob.png", //QS
    
     "https://imgur.com/3TPAB3g.png", //KC
     "https://imgur.com/KcQqfnN.png", //KD
     "https://imgur.com/R3SWN6w.png", //KH
     "https://imgur.com/4lehTuY.png" //KS
    
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
    
    public int getCardValue(int n){
        int value = randDeck[n].getRank();
        return value;
    }
    
    public String getCardImage(int n){
        String image = randDeck[n].getImage();
        return image;
    }
    
    public void printDraw(){
        for (int i = 0; i < this.randDeck.length; i++){
            System.out.println(this.randDeck[i].cardDesc());
        }
    }
    
}
