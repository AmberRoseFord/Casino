package Casino;

import java.util.*;
import java.lang.*;
import java.util.Random;
import java.util.Date;
public class Deck {
    public String[] cardValue =  {"Ace", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine", "Ten", "Jack", "Queen", "King"};
    
    public String[] cardSuit = {"Spades", "Hearts", "Diamonds", "Clubs"};
    
    public int[] value = { 11, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 10, 10, 10};
        
    public int cardsNeeded;
    private static String yourCard;
    private static int cardWorth;
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
        System.out.println("Your card is worth: " + cardWorth);
        //System.out.println("Ammount of cards left in the Deck: " + deck);
    }
    private void setUp() {
        if (cardsUsed <= shuffleDeck) {
            int v = (int)(Math.random() * cardValue.length);
            int s = (int)(Math.random() * cardSuit.length);
            String yourCardsValue = cardValue[v];
            String yourCardsSuit = cardSuit[s];
            int yourCardsWorth = value[v + 1];
            this.yourCard = yourCardsValue + " of " + yourCardsSuit;
            this.cardWorth = yourCardsWorth;
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
