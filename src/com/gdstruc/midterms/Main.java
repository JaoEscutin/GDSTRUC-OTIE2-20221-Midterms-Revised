package com.gdstruc.midterms;

import java.util.Scanner;
import java.util.Random;
public class Main {
    public static void main(String[] args) {

        Random random = new Random();
        CardStack playerDeck = new CardStack(30);
        CardStack playerHand = new CardStack(30);
        CardStack discardPile = new CardStack(30);

        playerDeck.placeCard(new Card("2-CLUBS"));
        playerDeck.placeCard(new Card("3-CLUBS"));
        playerDeck.placeCard(new Card("4-CLUBS"));
        playerDeck.placeCard(new Card("5-CLUBS"));
        playerDeck.placeCard(new Card("6-CLUBS"));
        playerDeck.placeCard(new Card("7-CLUBS"));
        playerDeck.placeCard(new Card("8-CLUBS"));
        playerDeck.placeCard(new Card("9-CLUBS"));
        playerDeck.placeCard(new Card("10-CLUBS"));
        playerDeck.placeCard(new Card("JACK-CLUBS"));
        playerDeck.placeCard(new Card("KING-CLUBS"));
        playerDeck.placeCard(new Card("QUEEN-CLUBS"));
        playerDeck.placeCard(new Card("ACE-CLUBS"));
        playerDeck.placeCard(new Card("2-DIAMONDS"));
        playerDeck.placeCard(new Card("3-DIAMONDS"));
        playerDeck.placeCard(new Card("4-DIAMONDS"));
        playerDeck.placeCard(new Card("5-DIAMONDS"));
        playerDeck.placeCard(new Card("6-DIAMONDS"));
        playerDeck.placeCard(new Card("7-DIAMONDS"));
        playerDeck.placeCard(new Card("8-DIAMONDS"));
        playerDeck.placeCard(new Card("9-DIAMONDS"));
        playerDeck.placeCard(new Card("10-DIAMONDS"));
        playerDeck.placeCard(new Card("JACK-DIAMONDS"));
        playerDeck.placeCard(new Card("KING-DIAMONDS"));
        playerDeck.placeCard(new Card("QUEEN-DIAMONDS"));
        playerDeck.placeCard(new Card("ACE-DIAMONDS"));
        playerDeck.placeCard(new Card("2-HEARTS"));
        playerDeck.placeCard(new Card("3-HEARTS"));
        playerDeck.placeCard(new Card("4-HEARTS"));
        playerDeck.placeCard(new Card("5-HEARTS"));

        playerDeck.printCards();

        int counter = 1;
        System.out.println("GAME START");
        System.out.println("====================");
        System.out.println("====================");
        while (!playerDeck.isEmpty()){
            System.out.println("TURN " + counter);
            int r = random.nextInt(3)+ 1;
            if (r == 1){
                int x = random.nextInt(5) + 1;
                System.out.println("Draw " + x + " cards from the deck");
                if (x > playerDeck.size()){
                    System.out.println("Player deck is less than " + x + ".Generating new command.");
                } else {
                    for (int i = 0; i < x; i++) {
                        playerHand.placeCard(playerDeck.removeCard());
                    }
                }
            }
            else if (r == 2){
                int x = random.nextInt(5) + 1;
                System.out.println("Discard " + x + " cards from your hand");
                if (playerHand.isEmpty()){
                    System.out.println("Player hand is empty. Generating new command.");
                } else if (x > playerHand.size()) {
                    System.out.println("Player hand is less than " + x + ".Generating new command.");
                }
                else {
                    for (int i = 0; i < x; i++) {
                        discardPile.placeCard(playerHand.removeCard());
                    }
                }
            }
            else if (r == 3){
                int x = random.nextInt(5) + 1;
                System.out.println("Draw " + x + " cards from the discard pile");
                if (discardPile.isEmpty()){
                    System.out.println("Discard pile is empty. Generating new command." );
                } else if (x > discardPile.size()){
                    System.out.println("Discard pile is less than " + x + ".Generating new command.");
                }
                else {
                    for (int i = 0; i < x; i++){
                        playerHand.placeCard(discardPile.removeCard());
                    }
                }

            }
            System.out.println("====================");
            System.out.println("List of cards on hand: ");
            playerHand.printCards();
            System.out.println("====================");
            System.out.println("Number of cards in player deck: " + playerDeck.size());
            System.out.println("====================");
            System.out.println("Number of cards in discard pile: " + discardPile.size());
            System.out.println("====================");
            counter++;

        }
        if (playerDeck.isEmpty()){
            System.out.println("Game has ended.");
        }
    }
}