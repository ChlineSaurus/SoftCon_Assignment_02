package Turn;

import Enums.Messages;
import Input.TuttoInput;
import dice.DiceFace;
import exceptions.IllegalUserInputExeption;

import java.util.ArrayList;

public class HumanInteractionManager {
    private ArrayList<DiceFace> indices;
    private Character nextAction;
    private Boolean validInput = Boolean.FALSE;
    private final ArrayList<Character> possibleNextAction;

    public HumanInteractionManager() {
        possibleNextAction = new ArrayList<Character>();
        possibleNextAction.add('R');
        possibleNextAction.add('D');
    }
    public void DisplayOrRoll() throws IllegalUserInputExeption {
        {
            System.out.println("For displaying your score please enter \"D\" for rolling the Dice please enter \"R\"");
            validInput = Boolean.FALSE;
            while (validInput != Boolean.TRUE) {

                try {
                    nextAction = TuttoInput.takeRestrictedCharInput(possibleNextAction);
                } catch (IllegalUserInputExeption e) {
                    //Sött eingentli nüt da usgeh werde, das chan mer denn em UI überlah
                    System.out.println(e.getMessage());
                }
                validInput = Boolean.TRUE;
            }
        }
        //why doesn't it execute??
        if (nextAction.equals('D')) {
            //Call UI
            System.out.println("here should the call to the UI be displayed...");
            DisplayOrRoll();
        }
    }
// different checks: Check for duplicate, check for not valid input
    public ArrayList<DiceFace> ChoseDice() throws IllegalUserInputExeption {
        validInput = Boolean.FALSE;
        while (validInput == Boolean.FALSE) {
            try {
                indices = TuttoInput.takeDiceListInput();
            } catch (IllegalUserInputExeption e) {
                if(indices.equals(null)){
                    Reroll();
                }
                System.out.println(Messages.wrongDiceInputException.message);
            }
            validInput = Boolean.TRUE;
        }

        return indices;
    }
        public Boolean Reroll() throws IllegalUserInputExeption {

                System.out.println("Enter to reroll the dice \"R\" and if you want to end your turn \"E\"");
                char nextAction = TuttoInput.takeCharInput();
                String nextActions = String.valueOf(nextAction);
                System.out.println(nextActions);
                if(nextActions.equals("E")){
                    return true;
                }
                return false;

        }



    }
