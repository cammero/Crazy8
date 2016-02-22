package com.cameo;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Deck crazy8Deck = new Deck(); //Instantiate the deck

        //Instantiate two hands for two players
        Hand player1Hand = new Hand();
        player1Hand.setPlayerName("Player 1");
        Hand player2Hand = new Hand();
        player2Hand.setPlayerName("Player 2");
        //TODO Version 2 Instantiate Players first and have the Players set their own names.

        ArrayList<Hand> players = new ArrayList<>();
        players.add(player1Hand);
        players.add(player2Hand);

        //Create 2 hands. Deal 7 cards to each hand
        for (int i = 0; i < 7; i++) {
            player1Hand.addCard(crazy8Deck.dealCard());
            player2Hand.addCard(crazy8Deck.dealCard());
        }

        StockPile stock = new StockPile();
        Card topCard = crazy8Deck.dealCard();
        stock.addCardToStockPile(topCard);
        /*TODO if the first card added to the stockpile from the deck is an 8, another card needs to be drawn on top and
        must disregard regular "addToStockPile" rules. The following code currently doesn't work to do so */
//        if (topCard.getRank() == "8"){
//            stock.addCardToStockPile(crazy8Deck.dealCard());
//        }

        boolean gameOver = false;
        while (!gameOver) {
            for (Hand playerHand : players) {
                stock.showTopCard();

                //It will continue to be one player's turn until played = true
                boolean played = false;
                while (!played) {
                    System.out.println(playerHand.getPlayerName() + ", which card would you like to play?\n" +
                            "If you can't play, press D to draw a card.\n");
                    playerHand.displayNumericOptions();

                    Scanner s = new Scanner(System.in);
                    String choice = s.nextLine();

                    try {
                        if (choice.equalsIgnoreCase("d")) {
                            if (crazy8Deck.remainingCardsInDeck() == 0) {
                            /*If there aren't any cards remaining in the deck, the player automatically
                            passes and it is the next player's turn.*/
                                System.out.println("There are no remaining cards to draw. You must pass.");
                                played = true;
                            } else {
                                playerHand.addCard(crazy8Deck.dealCard()); //adds card to players hand
                                played = true;
                            }

                        } else if (Integer.parseInt(choice) < playerHand.numberOfCardsInHand()) {
                            Card card = playerHand.getCard(Integer.parseInt(choice));
                            played = stock.addCardToStockPile(card); //returns boolean
                            if (played) {
                                playerHand.playCard(Integer.parseInt(choice)); //returns boolean

                                if (playerHand.numberOfCardsInHand() == 1) {
                                    String oneCardAnswer = playerHand.oneCard(s, playerHand);
                                    if (oneCardAnswer.equalsIgnoreCase("y")) {
                                        System.out.println(playerHand.getPlayerName() + " only has one card left!");
                                    } else {
                                        System.out.println("You didn't alert everyone that you only had one card.\n" +
                                                "Two cards have been added to your hand.");
                                        playerHand.addCard(crazy8Deck.dealCard());
                                        playerHand.addCard(crazy8Deck.dealCard());
                                    }
                                }
                                if (playerHand.numberOfCardsInHand() == 0){
                                    System.out.println("You've won the game " + playerHand.getPlayerName() + "!");
                                    gameOver = true;
                                }
                            }
                        }
                            else {
                                System.out.println("You've keyed an invalid number. Please try again.");
                            }

                    } catch (IndexOutOfBoundsException ioe){
                    System.out.println("Please type a valid entry.");

                    } catch (NumberFormatException nfe){
                        System.out.println("Please type a valid entry.");
                    }

                    //if there are no remaining cards to draw, the game is over
                    if (crazy8Deck.remainingCardsInDeck() == 0){
                        System.out.println("There aren't any remaining cards to draw from the deck. \nGame over.");
                        gameOver = true;
                    }
                }
                if (gameOver == true){
                    break;
                }
            }
            for (Hand player : players){
                player.toString();
            }
        }
        for (Hand player : players)
            System.out.println(player.getPlayerName() + ", your hand is worth " + player.pointsPerHand() + " points.");
    }
}
