package Input;

import Enums.Msg;
import dice.DiceFace;
import exceptions.IllegalUserInputExeption;

import java.util.ArrayList;

public class TuttoInput extends Input{

    public static ArrayList<DiceFace> takeDiceListInput() throws IllegalUserInputExeption {
        ArrayList<Integer> input = Input.takeIntegerListInput();
        ArrayList<DiceFace> returnList = new ArrayList<DiceFace>();
        for (Integer aInputInteger: input){
            DiceFace aDiceFace = DiceFace.getEnum(aInputInteger);
            if(aDiceFace == null) {
                throw new IllegalUserInputExeption(Msg.notAllowedNumberException.message);
            }
            returnList.add(aDiceFace);
        }
        return returnList;
    }

    public static Character takeRestrictedCharInput(ArrayList<Character> allowedChars) throws IllegalUserInputExeption {
        Character input = Input.takeCharInput();
        if (!(allowedChars.contains(input))) {
            throw new IllegalUserInputExeption(Msg.notAllowedCommandException.message);
        }
        return input;
    }
}
