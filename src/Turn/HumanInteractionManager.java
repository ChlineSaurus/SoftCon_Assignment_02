package Turn;

import Enums.Messages;
import Input.TuttoInput;
import dice.DiceFace;
import exceptions.IllegalUserInputExeption;

import java.util.ArrayList;

public class HumanInteractionManager {
    ;



// different checks: Check for duplicate, check for not valid input
    public ArrayList<DiceFace> ChoseDice() throws IllegalUserInputExeption {
        Boolean validInput = Boolean.FALSE;
        ArrayList<DiceFace> indices = null;
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
        public static Boolean Reroll() throws IllegalUserInputExeption {
                ArrayList<Character> allowedChar = new ArrayList<>();
                allowedChar.add('E');
                allowedChar.add('R');
                System.out.println("Enter to reroll the dice \"R\" and if you want to end your turn \"E\"");
                char nextAction = TuttoInput.takeRestrictedCharInput(allowedChar);
                String nextActions = String.valueOf(nextAction);
                System.out.println(nextActions);
                if(nextActions.equals("E")){
                    return true;
                }
                return false;

        }
    }
