import Turn.Turn;
import exceptions.IllegalUserInputExeption;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException, IllegalUserInputExeption {

        SetUp.setUpGame();
        Turn aTurn = new Turn();
        while (true) {
            aTurn.execute();
        }

        //TurnState.Turn aTurn = new TurnState.Turn();

        //aTurn.nextState();

    }

}