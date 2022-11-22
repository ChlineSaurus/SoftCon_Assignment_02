package cards.cards;

import dice.Dice;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Straight implements TuttoCondition {
    private Map<Integer,Integer> diceCounter = new HashMap<Integer, Integer>();

    @Override
    public boolean tutoRequirements(List<Dice> dices) {

        for (Dice dice: dices){
            int faceValue=dice.getFaceValue();

            if (diceCounter.containsKey(faceValue)){
                return false;}
            else{
                diceCounter.put(faceValue,1);
            }




        }
        return true;
    }

}
