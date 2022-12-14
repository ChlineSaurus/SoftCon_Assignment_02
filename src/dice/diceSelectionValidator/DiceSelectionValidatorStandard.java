package dice.diceSelectionValidator;

import dice.Dice;
import dice.DiceFace;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DiceSelectionValidatorStandard implements DiceSelectionValidator {

    private Map<DiceFace,Integer> selectedDice;

    @Override
    public boolean isUserSelectionValid(List<Dice> chosenDicesToKeep, List<Dice> rolledDices, List<Dice> takenDices) {
        selectedDice=new HashMap<DiceFace, Integer>();
        for (Dice chosenDice: chosenDicesToKeep){
            DiceFace faceValue=chosenDice.getFaceValue();
            if (faceValue!=DiceFace.One && faceValue!=DiceFace.Five){
                if (!selectedDice.containsKey(faceValue)){
                    selectedDice.put(faceValue,1);
                }
                else {
                      selectedDice.put(faceValue,selectedDice.get(faceValue)+1);
                }
            }
        }
        for (Map.Entry<DiceFace, Integer> entry : selectedDice.entrySet()){
            Integer occurences=entry.getValue();
            if (occurences%3!=0){
                return false;
            }
        }
        return true;
    }
}
