package com.cameo;

import java.util.Collections;
import java.util.LinkedList;

public class Deck {

    private String[] suits = {"hearts", "diamonds", "clubs", "spades"};
    private String[] rank = {"Ace", "2", "3", "4", "5", "6", "7", "8", "9", "10", "Jack", "Queen", "King"};
    private LinkedList<Card> deckOfCards =  new LinkedList<>();

    //constructor
    public Deck() {

        this.deckOfCards = createDeckOfCards();
        this.shuffle();
    }

    private LinkedList<Card> createDeckOfCards() {
        LinkedList<Card> deck = new LinkedList<>();
        for(String suit : suits){
            for(String rankOf : rank){
                Card eachCard = new Card(suit, rankOf);
                deck.add(eachCard);
            }
        }
        return deck;
    }

    public LinkedList shuffle(){
        Collections.shuffle(deckOfCards);
        return deckOfCards;
    }

    public Card dealCard(){
        Card nextCard = deckOfCards.removeFirst();
        return nextCard;
    }

    public int remainingCardsInDeck(){
        int cardsLeft = deckOfCards.size();
        return cardsLeft;
    }

    public String[] getSuits() {
        return suits;
    }
}
