package CasinoGame;

import java.util.Scanner;
public class FiveCard {
    public int cardsNeeded;
    private Scanner Info;
    public void Run() {

    }
    private void startingHand(){
        this.cardsNeeded = 5;
    }
    private void newCards(){
        Info = new Scanner(System.in);
        
        System.out.println("How many cards would you like to replace?: ");
        int secondDeal = Info.nextInt();
        
        this.cardsNeeded = secondDeal;
    }
    public int cardsNeeded(){
        return this.cardsNeeded;
    }
}
