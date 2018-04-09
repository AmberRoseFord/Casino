package CasinoGame;

public class TexasHoldEm {
    public int cardsNeeded;
    public void Run() {
    }
    private void startingHand() {
        this.cardsNeeded = 2;
    }
    private void flop() {
        this.cardsNeeded = 3;
    }
    private void turn() {
        this.cardsNeeded = 1;
    }
    private void river() {
        this.cardsNeeded = 1;
    }
    public int cardsNeeded(){
        return this.cardsNeeded;
    }
}
