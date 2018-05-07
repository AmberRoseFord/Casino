package Casino;

import java.util.*;
import java.lang.*;
import java.util.Random;
import java.util.Date;
public class Deck {
    private String[] cardValue = {"Ace", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine", "Ten", "Jack", "Queen", "King"};
    private String[] cardSuit = {"Spades", "Hearts", "Dimonds", "Clubs"};
    public int cardsNeeded;
    public int value;
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
       values();
       System.out.println(yourCard);
       System.out.println(value);
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
    private void values(){
        if (yourCard == "Ace of Spades") {
            value = 11;
        } else if(yourCard == "Two of Spades") {
            value = 2;
        } else if(yourCard == "Three of Spades") {
            value = 3;
        } else if(yourCard == "Four of Spades") {
            value = 4;
        } else if(yourCard == "Five of Spades") {
            value = 5;
        } else if(yourCard == "Six of Spades") {
            value = 6;
        } else if(yourCard == "Seven of Spades") {
            value = 7;
        } else if(yourCard == "Eight of Spades") {
            value = 8;
        } else if(yourCard == "Nine of Spades") {
            value = 9;
        } else if(yourCard == "Ten of Spades") {
            value = 10;
        } else if(yourCard == "Jack of Spades") {
            value = 10;
        } else if(yourCard == "Queen of Spades") {
            value = 10;
        } else if(yourCard == "King of Spades") {
            value = 10;
        } else if (yourCard == "Ace of Dimonds") {
            value = 11;
        } else if(yourCard == "Two of Dimonds") {
            value = 2;
        } else if(yourCard == "Three of Dimonds") {
            value = 3;
        } else if(yourCard == "Four of Dimonds") {
            value = 4;
        } else if(yourCard == "Five of Dimonds") {
            value = 5;
        } else if(yourCard == "Six of Dimonds") {
            value = 6;
        } else if(yourCard == "Seven of Dimonds") {
            value = 7;
        } else if(yourCard == "Eight of Dimonds") {
            value = 8;
        } else if(yourCard == "Nine of Dimonds") {
            value = 9;
        } else if(yourCard == "Ten of Dimonds") {
            value = 10;
        } else if(yourCard == "Jack of Dimonds") {
            value = 10;
        } else if(yourCard == "Queen of Dimonds") {
            value = 10;
        } else if(yourCard == "King of Dimonds") {
            value = 10;
        } else if (yourCard == "Ace of Hearts") {
            value = 11;
        } else if(yourCard == "Two of Hearts") {
            value = 2;
        } else if(yourCard == "Three of Hearts") {
            value = 3;
        } else if(yourCard == "Four of Hearts") {
            value = 4;
        } else if(yourCard == "Five of Hearts") {
            value = 5;
        } else if(yourCard == "Six of Hearts") {
            value = 6;
        } else if(yourCard == "Seven of Hearts") {
            value = 7;
        } else if(yourCard == "Eight of Hearts") {
            value = 8;
        } else if(yourCard == "Nine of Hearts") {
            value = 9;
        } else if(yourCard == "Ten of Hearts") {
            value = 10;
        } else if(yourCard == "Jack of Hearts") {
            value = 10;
        } else if(yourCard == "Queen of Hearts") {
            value = 10;
        } else if(yourCard == "King of Hearts") {
            value = 10;
        } else if (yourCard == "Ace of Clubs") {
            value = 10;
        } else if(yourCard == "Two of Clubs") {
            value = 2;
        } else if(yourCard == "Three of Clubs") {
            value = 3;
        } else if(yourCard == "Four of Clubs") {
            value = 4;
        } else if(yourCard == "Five of Clubs") {
            value = 5;
        } else if(yourCard == "Six of Clubs") {
            value = 6;
        } else if(yourCard == "Seven of Clubs") {
            value = 7;
        } else if(yourCard == "Eight of Clubs") {
            value = 8;
        } else if(yourCard == "Nine of Clubs") {
            value = 9;
        } else if(yourCard == "Ten of Clubs") {
            value = 10;
        } else if(yourCard == "Jack of Clubs") {
            value = 10;
        } else if(yourCard == "Queen of Clubs") {
            value = 10;
        } else if(yourCard == "King of Clubs") {
            value = 10;
        }
    } 
}
