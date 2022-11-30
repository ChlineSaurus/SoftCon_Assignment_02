package dice.diceSelectionValidator;

import dice.Dice;

import java.util.List;

public class DiceSelectionValidatorStraight implements DiceSelectionValidator {
    @Override
    public boolean isUserSelectionValid(List<Dice> chosenDicesToKeep, List<Dice> rolledDices, List<Dice> takenDices) {
        for (Dice chosenDice: chosenDicesToKeep){
            for (Dice takenDice: takenDices){
                if (chosenDice.getFaceValue()==takenDice.getFaceValue()){
                    return false;
                }
            }
        }
        return true;
    }
}
