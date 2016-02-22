package com.cameo;

import java.util.ArrayList;
import java.util.Scanner;

public class Hand {
    private ArrayList<Card> handOfCards = new ArrayList<>();
    String playerName;

    public Hand() {}

    public void addCard(Card card) {
        handOfCards.add(card);
    }

    //displays the cards in hand
    public void displayNumericOptions() {
        for (int i = 0; i < handOfCards.size(); i++) {
            System.out.println("Enter " + i + " for " + handOfCards.get(i));
        }
    }

    public Card getCard(int index) {
        return handOfCards.get(index);
    }

    public int numberOfCardsInHand() {
        return handOfCards.size();
    }

    //removes the card from the had that the user wants to play
    public Card playCard(int indexOfCard) {
        Card discard = handOfCards.get(indexOfCard);
        handOfCards.remove(indexOfCard);
        return discard;
    }

    //method called when player has only one card left in hand
    public String oneCard(Scanner s, Hand player) {
        System.out.println(player.getPlayerName() + " You only have one card left. Would you like to alert everyone of this?\n" +
                "Enter Y for yes, or any key for no.");
        String answer = s.nextLine();
        return answer;
    }

    public String getPlayerName() {
        return playerName;
    }

    public void setPlayerName(String playerName) {
        this.playerName = playerName;
    }

    public int pointsPerHand() {
        int totalPoints = 0;
        for (Card card : handOfCards) {
            totalPoints += card.getValue(card.getRank());
        }
        return totalPoints;
    }

    @Override
    public String toString() {
        String whatsInYourHand = "";
        for (Card card : handOfCards) {
            whatsInYourHand += card.toString() + "; ";
        }
        return whatsInYourHand;
    }
}
