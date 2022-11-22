package dice;

import java.util.ArrayList;

public class DiceTower {
    final private ArrayList<Dice> notTakenDices;
    final private ArrayList<Dice> takenDices;

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
