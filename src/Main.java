import Turn.Turn;

public class Main {
    public static void main(String[] args) {
        Dice d1=new Dice();
        Deck deck = new Deck();
        System.out.println(deck.draw());

        Turn aTurn = new Turn();
        aTurn.nextState();
    }
}