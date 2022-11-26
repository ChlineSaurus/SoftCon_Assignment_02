import Turn.State.TurnState;
import cards.Deck;
import dice.DiceTower;
import dice.calculateRollPoints.PointsStraightNonNullRoll;
import dice.userDiceSelectionValidation.ValidateUserSelectedDice;
import exceptions.IllegalUserInputExeption;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException, IllegalUserInputExeption {


        Deck deck = new Deck();
        deck.createDeckStack();
        deck.draw();
        //This code is not working
        DiceTower a=new DiceTower(PointsStraightNonNullRoll, ValidateUserSelectedDice);

        TurnState.Turn aTurn = new TurnState.Turn();
        //TurnState aEnd = new EndTurn(aTurn);
        //aTurn.setState(aEnd);


    }

}