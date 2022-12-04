import Turn.Turn;
import exceptions.IllegalUserInputException;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException, IllegalUserInputException {

        SetUp.setUpGame();
        Turn aTurn = new Turn();
        while (true) {
            aTurn.execute();
        }
    }
}