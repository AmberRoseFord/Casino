package Casino;  

public class Runner {
    public static void main(String[] args){
        Welcome welcome = new Welcome();
        Cash cash = new Cash();
        Choice choice = new Choice();
        welcome.Run();
        cash.ammount();
        choice.Run();
        
        /*Deck deck = new Deck();
        deck.Run();*/
    }
}