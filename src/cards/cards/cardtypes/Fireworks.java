package cards.cards.cardtypes;


import cards.AbstractCard;
import cards.TuttoRequired;
import dice.DiceTower;
import dice.notNullRoll.NotNullRollStandard;
import dice.pointCalculator.PointCalculatorStandard;
import dice.diceSelectionValidator.DiceSelectionValidatorFirework;
import exceptions.IllegalUserInputException;

public class Fireworks extends AbstractCard {


    public Fireworks(){
        immunity=true;
        bonusPoints=0;
        name="Fireworks";
        description = """
                You have to keep throwing the dice until you roll a null. After each roll, you need to keep
                all valid single dice and triplets. If you accomplish a 'Tutto' you have to continue without revealing
                revealing a new card. Your turn ends only when you roll a null. However, you score all points you have
                rolled so far.
                
                """ +  "\u001B[35m" + "Please make sure to take ALL valid dice at once, otherways the game won't allow it." + "\u001B[0m";
        requiredForPoints= TuttoRequired.Zero;
        requiredForBonus=TuttoRequired.Zero;


    }
    @Override
    public void injectStrategyToTower(DiceTower aDiceTower) {
        aDiceTower.setStrategy(new PointCalculatorStandard(), new DiceSelectionValidatorFirework(), new NotNullRollStandard());
    }
    @Override
    public void userTriesToEndTurn() throws IllegalUserInputException {
        throw new IllegalUserInputException("Your Card is a Firework, you are not allowed to stop. Press 'r'" +
                "to continue.");
    }

    @Override
    public boolean haveToContinueRolling(){
        return true;
    }
}
