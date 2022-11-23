package dice;

import exceptions.IllegalUserInputExeption;

import java.util.*;

public class DiceTower {
    final private ArrayList<Dice> notTakenDices;
    final private ArrayList<Dice> takenDices;
    private Boolean hasValidDice = Boolean.FALSE;
    private int valueOfDice = 0;
    private boolean diceTakenSinceRoll;
    private int quantityOfSameDice = 0;
    public DiceTower() {
        notTakenDices = new ArrayList<Dice>();
        for(int i = 0; i < 6; i++) {
            notTakenDices.add(new Dice());
        }
        rollNotTakenDices();
        takenDices = new ArrayList<Dice>();
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
    public Boolean ValidateDice() {
        for(int i = 1; i<7; i++){
            quantityOfSameDice =0;
            for (Dice dice : notTakenDices) {
                if (dice.getFaceValue() == DiceFace.One || dice.getFaceValue() == DiceFace.Five) {
                    hasValidDice = Boolean.TRUE;
                }
                if(dice.getFaceValue().integerValue==i) {
                    quantityOfSameDice++;
                }
                if(quantityOfSameDice>2){
                    hasValidDice = Boolean.TRUE;
                }
            }
        }
        System.out.println(hasValidDice);
        return hasValidDice;
    }
    public void removeDice(ArrayList<DiceFace> dicesToRemove) throws IllegalUserInputExeption {
        if (dicesToRemove.size() == 0) {
            throw new IllegalUserInputExeption("Your input had no number between one and six. Please give" +
                    "a valid Input.");
        }
        if (dicesToRemove.size() > notTakenDices.size()) {
            throw new IllegalUserInputExeption("Your wanted to take more dices than you are currently " +
                    "not taken. Please give a valid Input.");
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
            throw new IllegalUserInputExeption("You wanted to take a dice, that doesn't exist. Please give" +
                    "a valid Input");
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
