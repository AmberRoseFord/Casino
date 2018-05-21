package Casino;

public class BlackJack {
    Deck deck = new Deck();
    Cash cash = new Cash();
    
    public int cardsNeeded;
    public BlackJack() {
        
    }
    public void Run() {
        cash.ante();
        startingHand();
        bet();
        hit();
    }
    private void win() {
        deck.winBlackjack();
    }
    private void startingHand() {
        this.cardsNeeded = 2;
        deck.blackjack();
    }
    private void hit() {
        this.cardsNeeded = cardsNeeded + 1;
        deck.hit();
    }
    private void bet() {
        cash.betting();
    }
    public int cardsNeeded(){
        return this.cardsNeeded;
    }
}
