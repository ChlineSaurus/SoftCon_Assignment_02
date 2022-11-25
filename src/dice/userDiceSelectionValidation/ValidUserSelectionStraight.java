package dice.userDiceSelectionValidation;

import dice.Dice;

import java.util.List;

public class ValidUserSelectionStraight implements ValidateUserSelectedDice{
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
