package Input;

import dice.DiceFace;
import exceptions.IllegalUserInputExeption;

import java.util.ArrayList;

public class TuttoInput extends Input{
    public static ArrayList<DiceFace> takeDiceListInput() throws IllegalUserInputExeption {
        ArrayList<Integer> input = Input.takeIntegerListInput();
        ArrayList<DiceFace> returnList = new ArrayList<DiceFace>();
        for (Integer aInputInteger: input){
            DiceFace aDiceFace = DiceFace.get_Enum(aInputInteger);
            if(aDiceFace == null) {
                throw new IllegalUserInputExeption("Your input contained numbers that are not on a six " +
                        "faced Dice. Please give a valid Input.");
            }
            returnList.add(aDiceFace);
        }
        return returnList;
    }

    public static Character takeRestrictedCharInput(ArrayList<Character> allowedChars) throws IllegalUserInputExeption {
        Character input = Input.takeCharInput();
        if (!(allowedChars.contains(input))) {
            throw new IllegalUserInputExeption("Your gave a Character as Input for which no command" +
                    "exists. Please give a valid Input");
        }
        return input;
    }
}
