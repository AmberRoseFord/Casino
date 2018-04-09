package CasinoGame;

import java.util.Scanner;
public class Cash {
    private Scanner Info;
    public int AmmountOfMoney;
    public Cash() {
        Info = new Scanner(System.in);
    }
    public void Run(){
        Ammount();
    }
    public void Ammount() {
        System.out.println("How much money worth of chips would you like?:");
        int i = Info.nextInt();
        int[] AmmountOfMoney = new int[i];
    }
}
