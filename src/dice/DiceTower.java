package dice;

import java.util.*;

public class DiceTower {
    final private ArrayList<Dice> notTakenDices;
    final private ArrayList<Dice> takenDices;
    private ArrayList<Integer> possibleDiceToTake;
    private ArrayList<Integer> diceToTake;
    private Boolean hasValidDice = Boolean.FALSE;
    private int valueOfDice = 0;
    private int quantityOfSameDice = 0;
    public DiceTower() {
        notTakenDices = new ArrayList<Dice>();
        for(int i = 0; i < 6; i++) {
            notTakenDices.add(new Dice());
        }
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
        for(Dice dice: notTakenDices) {
            dice.roll();
        }
    }
    public Boolean ValidateDice() {
        for(int i = 1; i<7; i++){
            quantityOfSameDice =0;
        for (Dice dice : notTakenDices) {
            if (dice.getFaceValue() == 1 || dice.getFaceValue() == 5) {
                hasValidDice = Boolean.TRUE;
            }
            if(dice.getFaceValue()==i) {
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
    public void RemoveDice(String diceToRemove){
        List<String> listDiceToRemove = new ArrayList<String>(Arrays.asList(diceToRemove.split(",")));
        List<Integer> listDiceToRemoveInt = new ArrayList<Integer>(listDiceToRemove.size());
        for(String current: listDiceToRemove){
            listDiceToRemoveInt.add(Integer.parseInt(current));
        }
        //track all same dice
        //how to make bullet prove??
        //my idea with new array copy, then make same thing, and it error, throw it back...
        // make shure, that input string is sorted...
        /*for(int i = 0; i < listDiceToRemoveInt.size(); i=0){
            valueOfDice = showNotTakenDices().get(i);
            if(i< listDiceToRemoveInt.size()-1){
                for(int j = i; j<listDiceToRemoveInt.size(); j++){
                    if(showNotTakenDices().get(listDiceToRemoveInt.get(i))==showNotTakenDices().get(j)){
                        possibleDiceToTake.add(showNotTakenDices().get(j));
                    }

                }
                System.out.println(possibleDiceToTake);
            }


        }*/
    }
    public boolean madeTutto() {
        return notTakenDices.isEmpty();
    }

    public ArrayList<Integer> showTakenDices() {
        return diceListToValueList(takenDices);
    }

    public ArrayList<Integer> showNotTakenDices() {
        return diceListToValueList(notTakenDices);
    }

    private ArrayList<Integer> diceListToValueList(ArrayList<Dice> diceList) {
        ArrayList<Integer> returnList = new ArrayList<Integer>();
        for(Dice dice: diceList) {
            returnList.add(dice.getFaceValue());
        }
        return returnList;
    }
}
