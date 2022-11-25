package dice.userDiceSelectionValidation;

import dice.Dice;
import dice.DiceFace;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MustTakeAllValidDice implements ValidateUserSelectedDice{
    private Map<DiceFace,Integer> requiredToBeSelected=new HashMap<DiceFace,Integer>();

    private void setUpRequiredDice(List<Dice> rolledDices){
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
                //make sure the correct amount of dice are there for nonguaranteed points
            }
        }
    }
    private boolean areAllValidDiceTaken(){
        for (Map.Entry<DiceFace, Integer> entry : requiredToBeSelected.entrySet()){
            Integer occurences=entry.getValue();
            if (occurences!=0){
                return false;
            }

        }
        return true;
    }

    @Override
    public boolean isUserSelectionValid(List<Dice> chosenDicesToKeep, List<Dice> rolledDices, List<Dice> takenDices) {
        setUpRequiredDice(rolledDices);
        for (Dice chosenDice: chosenDicesToKeep){
            DiceFace faceValue=chosenDice.getFaceValue();
            requiredToBeSelected.put(faceValue,requiredToBeSelected.get(faceValue)-1);
        }
        return areAllValidDiceTaken();
    }
}
