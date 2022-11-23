import Turn.State.TurnState;
import dice.Dice;
import exceptions.IllegalUserInputExeption;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException, IllegalUserInputExeption {
        Dice d1=new Dice();
        //Deck deck = new Deck();
        //System.out.println(deck.draw());
        d1.roll();
        System.out.println(d1.getFaceValue());
        TurnState.Turn aTurn = new TurnState.Turn();
        aTurn.nextState();
    }
}