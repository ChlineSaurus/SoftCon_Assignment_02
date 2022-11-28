package Turn.State;

import Enums.Messages;
import Input.Input;

import exceptions.IllegalUserInputExeption;


import java.io.IOException;

public class Tutto implements TurnState{
    Turn aTurn;

    public Tutto(Turn aTurn){this.aTurn = aTurn;}
    @Override
    public void next(Turn aTurn) throws IOException, IllegalUserInputExeption {
        System.out.println("I am in  Tutto");
        aTurn.score = aTurn.turnCard.addBonus(aTurn.score);
        System.out.println(Messages.stopOrContinueQuestion.message);
        if(Input.takeStringInput().equalsIgnoreCase("S")){
            aTurn.setState(new EndTurn(aTurn));
        }
        else if(Input.takeStringInput().equalsIgnoreCase("C")){
            System.out.println("Drawing new card");
            aTurn.setState(new CurrentlyPlaying(aTurn));
        }
    }

}
