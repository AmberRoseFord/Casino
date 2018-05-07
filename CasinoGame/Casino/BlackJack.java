package Casino;

public class BlackJack {
    public int cardsNeeded;
    private int BlackJack = 21;
    public BlackJack() {
        
    }
    public void Run() {

    }
    public void deal() {
        
    }
    private void startingHand() {
        this.cardsNeeded = 2;
    }
    private void hit() {
        this.cardsNeeded = 1;
    }
    private void bet() {
        Cash cash = new Cash();
        
    }
    public int cardsNeeded(){
        return this.cardsNeeded;
    }
}
