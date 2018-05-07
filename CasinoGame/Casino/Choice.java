package Casino;

import java.util.Scanner;
public class Choice {
    private String[] Games= {"1.BlackJack", "2.Texas Hold'em Poker", "3.Five Card Poker", "4.Slot Machines", "5.Craps", "6.Roulette"};
    private Scanner Info;
    private int userGame;
    public void Run() {
        Choice();
        userChoice();
    }
    private void Choice() {
         System.out.println(Games);
    }
    private void userChoice() {
        BlackJack blackjack = new BlackJack();
        TexasHoldEm texasholdem = new TexasHoldEm();
        FiveCard fivecard = new FiveCard();
        SlotMachines slotmachines = new SlotMachines();
        Craps craps = new Craps();
        Roulette roulette = new Roulette();
        
        Info = new Scanner(System.in);
        
        System.out.println("What game would you like to play? Please enter in the number: ");
        int userGame = Info.nextInt();
        

        if (userGame == 1) {
            blackjack.Run();
        } else if (userGame == 2) {
            texasholdem.Run();
        } else if (userGame == 3) {
            fivecard.Run();
        } else if (userGame == 4) {
            slotmachines.Run();
        } else if (userGame == 5) {
            craps.Run();
        } else if (userGame == 6) {
            roulette.Run();
        } else {
            System.out.println("I'm sorry we do not have that game here. Please select the number of which of the games you would like to play: ");
        }
    }
}
