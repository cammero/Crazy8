package com.cameo;

/**
 * Created by Cameo on 11/01/2015.
 */
public class Card {

    private String suit;
    private String rank;
    private int value;

    //constructor
    public Card(String suit, String rank) {
        this.suit = suit;
        this.rank = rank;
        this.value = getValue(rank);
    }

    //Value is only used at the end of the game to determine points
    public int getValue(String rank) {
        switch (rank) {
            case "Ace":
                value = 1;
            case "2":
                value = 2;
            case "3":
                value = 3;
            case "4":
                value = 4;
            case "5":
                value = 5;
            case "6":
                value = 6;
            case "7":
                value = 7;
            case "8":
                value = 50;
            case "9":
                value = 9;
            case "10":
            case "Jack":
            case "Queen":
            case "King":
                value = 10;
        }
        return value;
    }

    //TODO In the next version
    public void checkForSpecialCard(String rank){
        switch (rank){
            case "2":
                System.out.println("Draw two");
                //TODO where to create method to draw card in Deck? Hand?
            case "8":
                System.out.println("Wild card. What suit would you like to pick?");
                //TODO create changeSuit method
            case "Queen":
                System.out.println("Skip");
                //TODO create skip method
        }
    }

    public void displayCard(){
        System.out.println(rank + " of " + suit);
    }

    public String getSuit() {
        return suit;
    }
    public void setSuit(String suit) {
        this.suit = suit;
    }

    public String getRank() {
        return rank;
    }

 @Override
    public String toString() {
     return rank + " of " + suit;
 }
}
