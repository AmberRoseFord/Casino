package CasinoGame;

import java.util.*;
import java.lang.*;
import java.util.Random;
import java.util.Date;
public class Deck {
   private String[] cardValue = {"Ace", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine", "Ten", "Jack", "Queen", "King"};
   private String[] cardSuit = {"Spades", "Hearts", "Dimonds", "Clubs"};
   public int cardsNeeded;
   private static String yourCard;
   private int cardsUsed;
   private int deck;
   private int shuffleDeck;
   public Deck() {
       cardsNeeded = 0;
       deck = 52;
       
       BlackJack blackjack = new BlackJack();
       cardsNeeded = cardsNeeded + blackjack.cardsNeeded();
   
       TexasHoldEm texasholdem = new TexasHoldEm();
       cardsNeeded = cardsNeeded + texasholdem.cardsNeeded();
   
       FiveCard fivecard = new FiveCard();
       cardsNeeded = cardsNeeded + fivecard.cardsNeeded();
              
       this.cardsUsed = 0 + cardsNeeded;
       this.shuffleDeck = deck - cardsUsed;
   }
   public void Run(){
       setUp();
       shuffle();
       System.out.println(yourCard);
   }
   private void setUp() {
       if (cardsUsed <= shuffleDeck) {
            int randValue = (int)(Math.random() * cardValue.length);
            int randSuit = (int)(Math.random() * cardSuit.length);
            String yourCardsValue = cardValue[randValue];
            String yourCardsSuit = cardSuit[randSuit];
            this.yourCard = yourCardsValue + " of " + yourCardsSuit;
        } else if(deck <= 0) {
            shuffle();
        }
   }
   private void shuffle () {
        if(cardsUsed <= shuffleDeck ) {
            setUp();
        } else if(cardsUsed > shuffleDeck )  {
            System.out.println("Sorry there are not enough cards left in this deck. I need to reshuffle.");
            try {
               Thread.sleep(3000);
            } catch(InterruptedException ex) {
               Thread.currentThread().interrupt();
            }
            this.cardsUsed = 0;
            this.cardsNeeded = 0;
        } else {
            System.out.println("System error");
        }
   }
}
