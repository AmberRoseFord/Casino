package Casino;

public class BlackJack {
    Deck deck = new Deck();
    Cash cash = new Cash();
    
    public int cardsNeeded;
    private int BlackJack = 21;
    public BlackJack() {
        
    }
    public void Run() {
        cash.ante();
    }
    public void deal() {
        
    }
    private void startingHand() {
        this.cardsNeeded = 2;
    }
    private void hit() {
        this.cardsNeeded = cardsNeeded + 1;
    }
    private void bet() {
        cash.betting();
    }
    public int cardsNeeded(){
        return this.cardsNeeded;
    }
}
