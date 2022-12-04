package dice.diceSelectionValidator;

import dice.Dice;
import dice.DiceFace;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DiceSelectionValidatorFirework implements DiceSelectionValidator {

    private Map<DiceFace, Integer> setUpRequiredDice(List<Dice> rolledDices){
        Map<DiceFace,Integer> requiredToBeSelected=new HashMap<DiceFace,Integer>();
        for (Dice aDice:rolledDices){
            DiceFace faceValue=aDice.getFaceValue();

            if (requiredToBeSelected.containsKey(faceValue)){
                requiredToBeSelected.put(faceValue,requiredToBeSelected.get(faceValue)+1);
            }
            else{
                requiredToBeSelected.put(faceValue,1);
            }
        }

        for (Map.Entry<DiceFace, Integer> entry : requiredToBeSelected.entrySet()){
            DiceFace faceValue=entry.getKey();
            Integer occurences=entry.getValue();
            if (faceValue!=DiceFace.One && faceValue!=DiceFace.Five){
                requiredToBeSelected.put(faceValue,occurences-(occurences%3));
            }
        }
        return requiredToBeSelected;
    }
    private boolean areAllValidDiceTaken(Map<DiceFace, Integer> requiredToBeSelected){
        for (Map.Entry<DiceFace, Integer> entry : requiredToBeSelected.entrySet()){
            Integer occurences=entry.getValue();
            if (occurences!=0){
                return false;
            }
        }
        return true;
    }

    @Override
    public boolean isUserSelectionValid(List<Dice> chosenDicesToKeep, List<Dice> rolledDices, List<Dice> takenDices)  {
        Map<DiceFace,Integer> requiredToBeSelected=setUpRequiredDice(rolledDices);
        for (Dice chosenDice: chosenDicesToKeep){
            DiceFace faceValue=chosenDice.getFaceValue();
            if (!requiredToBeSelected.containsKey(faceValue)){
                return false;
            }
            requiredToBeSelected.put(faceValue,requiredToBeSelected.get(faceValue)-1);
        }
        return areAllValidDiceTaken(requiredToBeSelected);
    }
}
