package dice.diceSelectionValidator;

import dice.Dice;

import java.util.List;

public interface DiceSelectionValidator {
    public boolean isUserSelectionValid(List<Dice> chosenDicesToKeep, List<Dice> rolledDices, List<Dice> takenDices);
}
