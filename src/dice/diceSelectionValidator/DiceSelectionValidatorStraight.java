package dice.diceSelectionValidator;

import dice.Dice;
import dice.DiceFace;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DiceSelectionValidatorStraight implements DiceSelectionValidator {
    @Override
    public boolean isUserSelectionValid(List<Dice> chosenDicesToKeep, List<Dice> rolledDices, List<Dice> takenDices) {
        if (checkIfDuplicates(chosenDicesToKeep)){
            return false;
        }
        for (Dice chosenDice : chosenDicesToKeep) {
            for (Dice takenDice : takenDices) {
                if (chosenDice.getFaceValue() == takenDice.getFaceValue()) {
                    return false;
                }
            }
        }
        return true;
    }

    private boolean checkIfDuplicates(List<Dice> chosenDiceToKeep) {
        Map<DiceFace, Integer> chosenDiceMap = new HashMap<>();
        for (Dice chosenDice : chosenDiceToKeep) {
            DiceFace diceFace = chosenDice.getFaceValue();
            if (chosenDiceMap.containsKey(diceFace)) {
                chosenDiceMap.put(diceFace, chosenDiceMap.get(diceFace)+1);
            } else {
                chosenDiceMap.put(diceFace, 1);
            }
        }
        for (Map.Entry<DiceFace, Integer> entry : chosenDiceMap.entrySet()) {
            Integer occurences = entry.getValue();
            if (occurences != 1) {
                return true;
            }
        }
        return false;
    }
}