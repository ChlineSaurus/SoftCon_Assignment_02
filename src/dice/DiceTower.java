package dice;

import Enums.Messages;
import dice.diceSelectionValidator.DiceSelectionValidator;
import dice.pointCalculator.PointCalculator;
import exceptions.IllegalUserInputExeption;

import java.util.ArrayList;
import java.util.List;

public class DiceTower {
     private ArrayList<Dice> notTakenDices;
    final private ArrayList<Dice> takenDices;

    //the dices the user selects
    private boolean diceTakenSinceRoll;

    protected PointCalculator pointCalculator;

    protected DiceSelectionValidator diceSelectionValidator;
    public DiceTower(){
        notTakenDices = new ArrayList<Dice>();
        for(int i = 0; i < 6; i++) {
            notTakenDices.add(new Dice());
        }
        rollNotTakenDices();
        takenDices = new ArrayList<Dice>();

    }

    public void setStrategy(PointCalculator pPointStrategy, DiceSelectionValidator pValidationStrategy){
        pointCalculator = pPointStrategy;
        diceSelectionValidator = pValidationStrategy;
    }

    public void newTurn() {
        notTakenDices.addAll(takenDices);
        takenDices.clear();
        this.rollNotTakenDices();
    }

    public void rollNotTakenDices() {
        diceTakenSinceRoll = false;
        for(Dice dice: notTakenDices) {
            dice.roll();
        }
    }
    private ArrayList<Dice> createTemporaryTakenDices(ArrayList<DiceFace> dicesToRemove){
        ArrayList<Dice> temporaryTakenDices = new ArrayList<>();
        for(DiceFace diceToRemove: dicesToRemove) {

            for(Dice aNotTakeDice: notTakenDices) {
                if (aNotTakeDice.getFaceValue().equals(diceToRemove)) {
                    temporaryTakenDices.add(aNotTakeDice);
                    break;

                }
            }
        }
        return temporaryTakenDices;

    }
    private void removeTemporaryTakenDices(List<Dice> temporaryTakenDices){

        for (Dice aDice:temporaryTakenDices){
            takenDices.add(aDice);
            assert notTakenDices.contains(aDice);
            notTakenDices.remove(aDice);
        }
    }


    public boolean notNullRoll(){
        return pointCalculator.validateDice(notTakenDices, takenDices);
    }

    public int removeDice(ArrayList<DiceFace> dicesToRemove) throws IllegalUserInputExeption {
        assert notTakenDices.size()+takenDices.size()==6;
        if (dicesToRemove.size() == 0) {
            throw new IllegalUserInputExeption(Messages.noDiceTakenException.message);
        }
        //one has to check if the taken dice are valid or can the user make mistakes
        if (dicesToRemove.size() > notTakenDices.size()) {
            throw new IllegalUserInputExeption(Messages.toManyDiceTakenException.message);
        }
        ArrayList<Dice> temporaryTakenDices = createTemporaryTakenDices(dicesToRemove);

        if (temporaryTakenDices.size() < dicesToRemove.size()) {

            throw new IllegalUserInputExeption(Messages.notAllowedNumberException.message);
        }

        if (!diceSelectionValidator.isUserSelectionValid(temporaryTakenDices,notTakenDices,takenDices)){
            throw new IllegalUserInputExeption("Make sure that only take valid dice");
        }
 else {
            diceTakenSinceRoll = true;
            removeTemporaryTakenDices(temporaryTakenDices);
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


