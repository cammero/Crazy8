package com.cameo;

import java.util.LinkedList;
import java.util.Scanner;

public class StockPile {
    private LinkedList<Card> stock = new LinkedList<>();

    public StockPile(){}

    public boolean addCardToStockPile(Card cardThePlayerIsTryingToPlay){
        //add the first card dealt to the stockpile
        if (stock.isEmpty()){
            stock.add(cardThePlayerIsTryingToPlay);
            return true;
        }
        //TODO this is part of the problem to be fixed that the first topcard cannot be an 8
//        if (stock.isEmpty() && cardThePlayerIsTryingToPlay.getRank() == "8"){
//            return false;
//        }

        //if the card played is an 8, ask the player what suit they would like to change it to, and then change the suit
        if (cardThePlayerIsTryingToPlay.getRank().equals("8")){
            Scanner s = new Scanner(System.in);
            System.out.println("What suit would you like to change to?");
            String[] suits = new Deck().getSuits();

            int count = 0;
            for (String suit : suits){
                System.out.println("Enter " + count + " for " + suit);
                count++;
            }
            //TODO Data validation for suit choice
            int newSuitIndex = s.nextInt();
            cardThePlayerIsTryingToPlay.setSuit(suits[newSuitIndex]); //sets suit to the players choice

            /*
            TODO currently the program tells the player the top card is the 8 (the rank) of the suit that the player
            chose, a better option may be to state only the suit, not the rank, in this situation.
            */
            stock.add(cardThePlayerIsTryingToPlay);
            return true;
        }

        //add the card to the stockpile if the suits are the same
        else if (cardThePlayerIsTryingToPlay.getSuit().equals(stock.peekLast().getSuit())){
            stock.add(cardThePlayerIsTryingToPlay);
            return true;
        }

        //add the card to the stockpile if the ranks are the same
        else if (cardThePlayerIsTryingToPlay.getRank().equals(stock.peekLast().getRank())){
            stock.add(cardThePlayerIsTryingToPlay);
            return true;
        }

        else {
            System.out.println("You cannot play the " + cardThePlayerIsTryingToPlay.toString() + " on the " +
                    stock.peekLast().toString() + ". Please try again.");
            return false;
        }
    }

    public void showTopCard(){
        Card topCard = stock.peekLast();
        System.out.println("\nThe current top card is the " + topCard + "\n");
    }
}
