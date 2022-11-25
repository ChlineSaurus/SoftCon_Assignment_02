package dice.userDiceSelectionValidation;

import dice.Dice;

import java.util.List;

public interface ValidateUserSelectedDice {
    public boolean isUserSelectionValid(List<Dice> chosenDicesToKeep, List<Dice> rolledDices, List<Dice> takenDices);
}
