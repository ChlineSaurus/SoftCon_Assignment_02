package dice;

import Enums.Messages;
import dice.calculateRollPoints.CalculatePointsNonNullRoll;
import dice.calculateRollPoints.PointsNonStraightNonNullRoll;
import dice.calculateRollPoints.PointsStraightNonNullRoll;
import dice.userDiceSelectionValidation.MustTakeAllValidDice;
import dice.userDiceSelectionValidation.ValidUserSelectionStraight;
import dice.userDiceSelectionValidation.ValidateUserSelectedDice;
import dice.userDiceSelectionValidation.ValidateUserSelectionNonStraight;
import exceptions.IllegalUserInputExeption;

import java.util.ArrayList;

public class DiceTower {
    final private ArrayList<Dice> notTakenDices;
    final private ArrayList<Dice> takenDices;


    //the dices the user selects

    private boolean diceTakenSinceRoll;

    protected  CalculatePointsNonNullRoll pointCalculator;

    protected  ValidateUserSelectedDice validateUserSelectedDice;
    public DiceTower(){
        notTakenDices = new ArrayList<Dice>();
        for(int i = 0; i < 6; i++) {
            notTakenDices.add(new Dice());
        }
        rollNotTakenDices();
        takenDices = new ArrayList<Dice>();

    }
    public void setDiceTowerFirework(){
        pointCalculator=new PointsNonStraightNonNullRoll();
        validateUserSelectedDice=new MustTakeAllValidDice();
    }

    public void setDiceTowerNonStraight(){
        pointCalculator=new PointsNonStraightNonNullRoll();
        validateUserSelectedDice=new ValidateUserSelectionNonStraight();
    }

    public void setDiceTowerStraight(){
        pointCalculator=new PointsStraightNonNullRoll();
        validateUserSelectedDice=new ValidUserSelectionStraight();
    }



    public void newTurn() {
        for(Dice dice: takenDices) {
            notTakenDices.add(dice);
            takenDices.remove(dice);
        }
        this.rollNotTakenDices();
    }

    public void rollNotTakenDices() {
        diceTakenSinceRoll = false;
        for(Dice dice: notTakenDices) {
            dice.roll();
        }
    }

    public boolean notNullRoll(){
        return pointCalculator.validateDice(notTakenDices,takenDices);
    }


    public int removeDice(ArrayList<DiceFace> dicesToRemove) throws IllegalUserInputExeption {
        if (dicesToRemove.size() == 0) {
            throw new IllegalUserInputExeption(Messages.noDiceTakenException.message);
        }
        //one has to check if the taken dice are valid or can the user make mistakes
        if (dicesToRemove.size() > notTakenDices.size()) {
            throw new IllegalUserInputExeption(Messages.toManyDiceTakenException.message);
        }

        ArrayList<Dice> temporaryTakenDices = new ArrayList<>();
        for(DiceFace diceToRemove: dicesToRemove) {
            for(Dice aNotTakeDice: notTakenDices) {
                if (aNotTakeDice.getFaceValue().equals(diceToRemove)) {
                    temporaryTakenDices.add(aNotTakeDice);
                    notTakenDices.remove(aNotTakeDice);
                    break;
                }
            }
        }
        if (!validateUserSelectedDice.isUserSelectionValid(temporaryTakenDices,notTakenDices,takenDices)){
            notTakenDices.addAll(temporaryTakenDices);
            throw new IllegalUserInputExeption("Make sure that only take valid dice");
        }
        if (temporaryTakenDices.size() < dicesToRemove.size()) {
            notTakenDices.addAll(temporaryTakenDices);
            throw new IllegalUserInputExeption(Messages.notAllowedNumberException.message);
        } else {
            diceTakenSinceRoll = true;
            takenDices.addAll(temporaryTakenDices);
            return pointCalculator.calculatePoints(temporaryTakenDices);
        }
    }

    public boolean madeTutto() {
        return notTakenDices.isEmpty();
    }

    public ArrayList<DiceFace> showTakenDices() {
        return diceListToValueList(takenDices);
    }

    public ArrayList<DiceFace> showNotTakenDices() {
        return diceListToValueList(notTakenDices);
    }

    private ArrayList<DiceFace> diceListToValueList(ArrayList<Dice> diceList) {
        ArrayList<DiceFace> returnList = new ArrayList<DiceFace>();
        for(Dice aDice: diceList) {
            returnList.add(aDice.getFaceValue());
        }
        return returnList;
    }

    public boolean diceTakenSinceRoll() {
        return diceTakenSinceRoll;
    }
}


