package Turn.State;

import exceptions.IllegalUserInputExeption;

import java.io.IOException;

public class NoMoreValidDice implements TurnState {
    Turn aTurn;
    public NoMoreValidDice(Turn aTurn){
        this.aTurn = aTurn;
    }

    @Override
    public void next(Turn aTurn) throws IOException, IllegalUserInputExeption {
        System.out.println("Hey here is no more valid Dice");
        /*Ask user if he wants to reroll dice

         */
        int i = 1;
        if (i==0){
            aTurn.setState(new NoMoreValidDice(aTurn));
        }
        else{
            aTurn.setState(new Tutto(aTurn));
        }
    }
}
