import Turn.State.TurnState;
import exceptions.IllegalUserInputExeption;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException, IllegalUserInputExeption {

        //SetUp.setUpGame();



        TurnState.Turn aTurn = new TurnState.Turn();
        //TurnState aEnd = new EndTurn(aTurn);
        //aTurn.setState(aEnd);
        aTurn.nextState();

    }

}