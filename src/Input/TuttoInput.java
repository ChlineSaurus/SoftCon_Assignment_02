package Input;

import Enums.Msg;
import dice.DiceFace;
import exceptions.IllegalUserInputException;

import java.util.ArrayList;

public class TuttoInput extends Input{

    public static ArrayList<DiceFace> takeDiceListInput() throws IllegalUserInputException {
        ArrayList<Integer> input = Input.takeIntegerListInput();
        return validateDiceListInput(input);

    }
    private static ArrayList <DiceFace> validateDiceListInput(ArrayList<Integer> input) throws IllegalUserInputException {
        ArrayList<DiceFace> returnList = new ArrayList<DiceFace>();
        for (Integer aInputInteger: input){
            DiceFace aDiceFace = DiceFace.getEnum(aInputInteger);
            if(aDiceFace == null) {
                throw new IllegalUserInputException(Msg.notAllowedNumberException.message);
            }
            returnList.add(aDiceFace);
        }
        return returnList;
    }


    public static Character takeRestrictedCharInput(ArrayList<Character> allowedChars) throws IllegalUserInputException {
        Character input = Input.takeCharInput();
        if (!(allowedChars.contains(input))) {
            throw new IllegalUserInputException(Msg.notAllowedCommandException.message);
        }
        return input;
    }
}
