package dice;

import Enums.Messages;
import dice.calculateRollPoints.CalculateRollPoints;
import dice.notNullRoll.NotNullRoll;
import dice.userDiceSelectionValidation.ValidateUserSelectedDice;
import exceptions.IllegalUserInputExeption;

import java.util.ArrayList;

public class DiceTower {
    final private ArrayList<Dice> notTakenDices;
    final private ArrayList<Dice> takenDices;

    private ArrayList<Dice> recentlyTakenDice=new ArrayList<Dice>();
    //the dices the user selects

    private boolean diceTakenSinceRoll;

    private CalculateRollPoints pointCalculator;
    private NotNullRoll notNullRollValidator;
    private ValidateUserSelectedDice validateUserSelectedDice;

    public DiceTower(CalculateRollPoints pointCalculator, NotNullRoll notNullValidator, ValidateUserSelectedDice validateUserSelectedDice) {
        notTakenDices = new ArrayList<Dice>();
        for(int i = 0; i < 6; i++) {
            notTakenDices.add(new Dice());
        }
        rollNotTakenDices();
        takenDices = new ArrayList<Dice>();
        this.pointCalculator=pointCalculator;
        this.notNullRollValidator=notNullValidator;
        this.validateUserSelectedDice=validateUserSelectedDice;

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
        return notNullRollValidator.validateDice(notTakenDices,takenDices);
    }
    public int getRollPoints(){
        return pointCalculator.calculatePoints(recentlyTakenDice);
    }

    public void removeDice(ArrayList<DiceFace> dicesToRemove) throws IllegalUserInputExeption {
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
        if (temporaryTakenDices.size() < dicesToRemove.size()) {
            notTakenDices.addAll(temporaryTakenDices);
            throw new IllegalUserInputExeption(Messages.notAllowedNumberException.message);
        } else {
            diceTakenSinceRoll = true;
            takenDices.addAll(temporaryTakenDices);
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
