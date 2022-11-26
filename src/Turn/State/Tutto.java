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
        System.out.println(Messages.stopOrContinueQuestion);
        if(Input.takeStringInput()=="s"){
            aTurn.setState(new EndTurn(aTurn));
        }
        else if(Input.takeStringInput()=="c"){
            System.out.println("Drawing new card");
            aTurn.setState(new CurrentlyPlaying(aTurn));
        }
    }
}
