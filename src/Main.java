import Turn.State.TurnState;
import dice.Dice;

public class Main {
    public static void main(String[] args) {
        Dice d1=new Dice();
        //Deck deck = new Deck();
        //System.out.println(deck.draw());
        d1.roll();
        System.out.println(d1.getFaceValue());
        TurnState.Turn aTurn = new TurnState.Turn();
        aTurn.nextState();
    }
}