import java.lang.*;
import java.util.Random;
import java.util.Scanner;
public class Deck
{
    private String[] cardValue = {"Ace", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine", "Ten", "Jack", "Queen", "King"};
    private String[] cardSuit = {"Spades", "Hearts", "Dimonds", "Clubs"};
    private int[] deck = new int[cardValue.length * cardSuit.length];
    private int cardsLeft = 52;
    public int num;
    public static String card;
    public Deck(){
        setUp();
        shuffle();
    }
    public void setUp () {
        for (int i = 0; i <= deck.length; i++) { 
            int randValue = (int)(Math.random() * cardValue.length);
            int randSuit = (int)(Math.random() * cardSuit.length);
            String yourCardsValue = cardValue[randValue];
            String yourCardsSuit = cardSuit[randSuit];
            card = yourCardsValue + " of " + yourCardsSuit;
        }
    }
    private void shuffle () {
        if (cardsLeft <= 0) {
            System.out.println("Sorry there are no cards left in the deck.");
            int cardsLeft = 52;
        }
    }
}

