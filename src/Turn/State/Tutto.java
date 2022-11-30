package Turn.State;

import Enums.Messages;
import Input.Input;
import Turn.Turn;
import UI.Display;
import exceptions.IllegalUserInputExeption;

public class Tutto implements TurnState{
    Turn aTurn;

    public Tutto(Turn aTurn){this.aTurn = aTurn;}
    @Override
    public void next() throws IllegalUserInputExeption {
        System.out.println("I am in  Tutto");
        if(aTurn.turnCard.getName().equals("Fireworks")){
            Display.displayMessage(Messages.tuttoAndCloverleafOrFireworks.message);
            aTurn.setCurrentState(new CurrentlyPlaying(aTurn));
        }
        if(aTurn.turnCard.haveToContinueRolling()){
            //something must be called to inform, that it was a tutto and Cloverleaf
            Display.displayMessage(Messages.tuttoAndCloverleafOrFireworks.message);
            aTurn.setCurrentState(new CurrentlyPlaying(aTurn));
        }
                System.out.println(Messages.stopOrContinueQuestion.message);
        if(Input.takeStringInput().equalsIgnoreCase("S")){
            aTurn.setCurrentState(new EndTurn(aTurn));
        }
        else if(Input.takeStringInput().equalsIgnoreCase("C")){
            System.out.println("Drawing new card");
            aTurn.setCurrentState(new CurrentlyPlaying(aTurn));
        }
        //else throw error
    }
}
