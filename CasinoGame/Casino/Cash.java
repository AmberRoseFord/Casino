package Casino;

import java.util.Scanner;
public class Cash {
    private Scanner Info;
    public int cashLeft;
    public int cashBet;
    public int ante = 5;
    public int cashTotal;
    public int winnings;
    public int lost;
    public Cash() {
        Info = new Scanner(System.in);
        
        BlackJack blackjack = new BlackJack();
        TexasHoldEm texasholdem = new TexasHoldEm();
        FiveCard fivecard = new FiveCard();
        SlotMachines slotmachines = new SlotMachines();
        Craps craps = new Craps();
        Roulette roulette = new Roulette();
        
    }
    public void ammount() {
        System.out.println("How much money worth of chips would you like?:");
        this.cashLeft = Info.nextInt();
    }
    public void betting() {
        System.out.println("How much would you like to bet?: ");
        System.out.println("1, 5, 10, 25, 50, 100");
        this.cashBet = Info.nextInt();
        
        if(cashBet < cashLeft) {
            cashLeft = cashLeft - cashBet;
            this.cashTotal = cashBet + ante;
        } else if (cashBet > cashLeft) {
            moreCash();
        } else if (cashBet == cashLeft) {
            System.out.println("This is the last of your chips.");
            cashLeft = cashLeft - cashBet;
            moreCash();
        }
        
    }
    private void moreCash() {
        System.out.println("I'm sorry but you are all out of chips.");
        System.out.println("Would you like to buy more? yes or no: ");
        String answer = Info.next();
        
        if (answer == "yes") {
            System.out.println("How much would you like to buy?: ");
            int moreCash = Info.nextInt();
            this.cashLeft = cashLeft + moreCash;
        } else if (answer == "no") {
            System.out.println("We hope you had a fun time at the Casino. Bye.");
            System.exit(0);
        } else {
            System.out.println("I'm sorry I did catch that. yes or no: ");
            moreCash();
        }
    }
    public void ante() {
        System.out.println("The ante for this game is" +  ante +  ".");
        this.cashLeft = cashLeft - ante;
        System.out.println("Bank: " + cashLeft);
    }
    public void winnings(){
        this.winnings = cashTotal * 2;
        this.cashLeft = cashLeft + winnings;
        System.out.println("You won " + winnings);
        System.out.println("You have " + cashLeft);
    }
    public void lost() {
        this.lost = cashTotal;
        this.cashLeft = cashLeft - cashTotal;
        System.out.println("You have" + cashLeft);
    }
    public void draw() {
        this.cashLeft = cashLeft + cashBet - ante;
        System.out.println("You get all your money back except for the ante.");
        System.out.println("You have" + cashLeft);
    }
}
