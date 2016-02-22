package com.cameo;

import java.util.LinkedList;
import java.util.Scanner;

public class StockPile {
    private LinkedList<Card> stock = new LinkedList<>();

    public StockPile(){}

    public boolean addCardToStockPile(Card cardThePlayerIsTryingToPlay){
        if (stock.isEmpty()){
            stock.add(cardThePlayerIsTryingToPlay);
        }
        if (cardThePlayerIsTryingToPlay.getRank().equals("8")){
            Scanner s = new Scanner(System.in);
            System.out.println("What suit would you like to change to?");
            String[] suits = new Deck().getSuits();
            int count = 0;
            for (String suit : suits){
                System.out.println("Enter " + count + " for " + suit);
                count++;
            }
            int newSuitIndex = s.nextInt();
            cardThePlayerIsTryingToPlay.setSuit(suits[newSuitIndex]);
            stock.add(cardThePlayerIsTryingToPlay);
            return true;
        }
        else if (cardThePlayerIsTryingToPlay.getSuit().equals(stock.peekLast().getSuit())){
            stock.add(cardThePlayerIsTryingToPlay);
            return true;
        }
        else if (cardThePlayerIsTryingToPlay.getRank().equals(stock.peekLast().getRank())){
            //
            stock.add(cardThePlayerIsTryingToPlay);
            return true;
        }
        else {
            System.out.println("Trying to play: " + cardThePlayerIsTryingToPlay.getRank() + cardThePlayerIsTryingToPlay.getSuit());
            System.out.println("Program thinks the top card is: " + stock.peekLast().getRank() + stock.peekLast().getSuit());
            return false;
        }
    }

    public void showTopCard(){
        Card topCard = stock.peekLast();
        System.out.println("\nThe current top card is the " + topCard + "\n");
    }
}
