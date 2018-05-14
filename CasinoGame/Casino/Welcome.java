package Casino;

import java.util.Scanner;
public class Welcome {
    private Scanner Info;
    Cash cash = new Cash();
    public Welcome () {
     Info = new Scanner(System.in);   
    }
    public void Run(){
        System.out.println("Hello and welcome to the Casino.");
        Age();
        Name();
    }
    public void Age() {
        System.out.println("Are you over 21? yes or no");
        String age = Info.next(); 
        while (age == "no") {
            System.out.println("I'm sorry but you are not old enough to be here.");
            System.exit(0);
        }
    }
    public void Name() {
        System.out.println("What is your name?:");
        String name = Info.next();
        String playerName = new String(name);
        System.out.println("It is nice to meet you " + name + ".");
    }
    public void StartingCash() {
        cash.ammount();
    }
}
