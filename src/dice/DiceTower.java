package dice;

import Enums.Msg;
import dice.diceSelectionValidator.DiceSelectionValidator;
import dice.notNullRoll.NotNullRoll;
import dice.pointCalculator.PointCalculator;
import exceptions.IllegalUserInputException;

import java.util.ArrayList;
import java.util.List;

public class DiceTower {

    final private ArrayList<Dice> notTakenDices;
    final private ArrayList<Dice> takenDices;
    private boolean diceTakenSinceRoll;
    private PointCalculator pointCalculator;
    private NotNullRoll notNullRollValidator;
    private DiceSelectionValidator diceSelectionValidator;

    public DiceTower(){
        notTakenDices = new ArrayList<Dice>();
        for(int i = 0; i < 6; i++) {
            notTakenDices.add(new Dice());
        }
        rollNotTakenDices();
        takenDices = new ArrayList<Dice>();

    }

    public void setStrategy(PointCalculator pPointStrategy, DiceSelectionValidator pValidationStrategy,NotNullRoll pNotNullRollValidator){
        pointCalculator = pPointStrategy;
        notNullRollValidator=pNotNullRollValidator;
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
                if (temporaryTakenDices.contains(aNotTakeDice)) {
                    continue;
                }
                if (aNotTakeDice.getFaceValue().equals(diceToRemove)) {
                    temporaryTakenDices.add(aNotTakeDice);
                    break;
                }
            }
        }
        return temporaryTakenDices;

    }
    private void removeTemporaryTakenDices(List<Dice> temporaryTakenDices){
        assert temporaryTakenDices!=null;
        assert temporaryTakenDices.size()<=notTakenDices.size();

        for (Dice aDice:temporaryTakenDices){
            takenDices.add(aDice);
            notTakenDices.remove(aDice);
        }
    }

    public boolean notNullRoll(){
        return notNullRollValidator.notNullRoll(notTakenDices, takenDices);
    }

    public int removeDice(ArrayList<DiceFace> dicesToRemove) throws IllegalUserInputException {
        assert notTakenDices.size()+takenDices.size()==6;
        if (dicesToRemove.size() == 0) {
            throw new IllegalUserInputException(Msg.noDiceTakenException.message);
        }
        if (dicesToRemove.size() > notTakenDices.size()) {
            throw new IllegalUserInputException(Msg.toManyDiceTakenException.message);
        }
        ArrayList<Dice> temporaryTakenDices = createTemporaryTakenDices(dicesToRemove);
        if (temporaryTakenDices.size() < dicesToRemove.size()) {
            throw new IllegalUserInputException(Msg.notExistingDiceTakenException.message);
        }
        if (!diceSelectionValidator.isUserSelectionValid(temporaryTakenDices,notTakenDices,takenDices)){
            throw new IllegalUserInputException(Msg.notAllowedDiceInInput.message);
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


