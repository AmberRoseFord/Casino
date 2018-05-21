package Casino;

import java.util.*;
import java.lang.*;
import java.util.Random;
import java.util.Date;
import java.util.Scanner;
public class Deck {
    private Scanner Info;
    
    public String[] cardValue =  {"Ace", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine", "Ten", "Jack", "Queen", "King"};
    
    public String[] cardSuit = {"Spades", "Hearts", "Diamonds", "Clubs"};
    
    public int[] value = { 11, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 10, 10, 10};
    
    public int[] dealersHand = { 17, 18, 19, 20, 21, 22, 23, 24, 25};
        
    public int cardsNeeded;
    private static String yourCard;
    public static int cardWorth;
    private int cardsUsed;
    private int deck;
    private int shuffleDeck;
    public int sum;
    public String answer;
    public Deck() {
        Info = new Scanner(System.in);
        
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
    
    
    public void blackjack(){
        System.out.println(yourCard);
        System.out.println("Your card is worth: " + cardWorth);
        int sumFirst = Info.nextInt();
        System.out.println(yourCard);
        System.out.println("Your card is worth: " + cardWorth);
        int sumSecond = Info.nextInt();
        int sum = sumFirst + sumSecond;
        System.out.println(sum);
    }
    public void hit(){
         while (sum > 21) {
            System.out.println("Would you like to hit");
            System.out.println("yes or no?: ");
            String answer = Info.next();
        }
        if (answer == "yes") {
            System.out.println(yourCard);
            System.out.println("Your card is worth: " + cardWorth);
            int sumHit = Info.nextInt();
            this.sum = sum + sumHit;
        } else if (answer == "no") {
            winBlackjack();
        } else {
            System.out.println("I'm sorry I didn't quite get that.");
            hit();
        }
    }
    public void winBlackjack(){
        Cash cash = new Cash();
        
        int dealer = (int)(Math.random() * dealersHand.length + 1);
        int dHand = Info.nextInt();
        dHand = dealersHand[dHand];
        
        System.out.println("You have " + sum);
        System.out.println("The dealer has " + dHand);
        while (sum > 21) {
            cash.lost();
            System.out.println("You bust! Would you like to play again?");
            System.out.println("yes or no?: ");
            String answer = Info.next();
        }
        while (sum != dHand) {
            if(dHand > 21){
                System.out.println("You win! dealer bust.");
                cash.winnings();
            } else if (sum == 21) {
                System.out.println("BlackJack! You win!");
                cash.winnings();
            } else if (sum > dHand){
                System.out.println("You win!");
                cash.winnings();
            } else if (sum < dHand) {
                System.out.println("You lost.");
                cash.lost();
            }
            System.out.println("Would you like to play again?");
            System.out.println("yes or no?: ");
            String answer = Info.next();
        }
        while (sum == dHand) {
            cash.draw();
            System.out.println("You and the dealer drawed.");
            System.out.println("Would you like to play again?: ");
            System.out.println("yes or no?: ");
            String answer = Info.next();
        }
        if (answer == "yes") {
            BlackJack blackjack = new BlackJack();
            blackjack.Run();
        } else if (answer == "no") {
            System.out.println("You are being brought back to the casino.");
            System.out.println("One moment plaese.");
            try {
               Thread.sleep(3000);
            } catch(InterruptedException ex) { 
               Thread.currentThread().interrupt();
            }
            Choice choice = new Choice();
            choice.Run();
        } else {
            System.out.println("I'm sorry I didn't quite get that.");
            winBlackjack();
        }
    }
}
