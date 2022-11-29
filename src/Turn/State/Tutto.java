package Turn.State;

import Enums.Messages;
import Input.Input;
import UI.Display;
import exceptions.IllegalUserInputExeption;

import java.io.IOException;

public class Tutto implements TurnState{
    Turn aTurn;

    public Tutto(Turn aTurn){this.aTurn = aTurn;}
    @Override
    public void next(Turn aTurn) throws IOException, IllegalUserInputExeption {
        System.out.println("I am in  Tutto");
        if(aTurn.turnCard.getName().equals("Fireworks")){
            Display.displayMessage(Messages.tuttoAndCloverleafOrFireworks.message);
            aTurn.setState(new CurrentlyPlaying(aTurn));
        }
        if(aTurn.turnCard.haveToContinueRolling()){
            //something must be called to inform, that it was a tutto and Cloverleaf
            Display.displayMessage(Messages.tuttoAndCloverleafOrFireworks.message);
            aTurn.setState(new CurrentlyPlaying(aTurn));
        }
                System.out.println(Messages.stopOrContinueQuestion.message);
        if(Input.takeStringInput().equalsIgnoreCase("S")){
            aTurn.setState(new EndTurn(aTurn));
        }
        else if(Input.takeStringInput().equalsIgnoreCase("C")){
            System.out.println("Drawing new card");
            aTurn.setState(new CurrentlyPlaying(aTurn));
        }
        //else throw error
    }
}
