package cards.cards;

import dice.Dice;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class NonStraight implements TuttoCondition {
    private Map<Integer,Integer> diceCounter = new HashMap<Integer, Integer>();
    private final int guaranteedpointsI=1;
    private final int guaranteedPointsII=5;

    @Override
    public boolean tutoRequirements(List<Dice> dices) //throws IllegalgetValueException//
     {
        for (Dice dice: dices){
            //try{
            int faceValue=dice.getFaceValue().integerValue;//nonig suber nonig, implementiert mit de neue dicefaces
            //catch (IllegalgetValueException e){
            //    throw new IllegalgetValueException("You are a hipo");
            //}
            if (faceValue!=guaranteedpointsI && faceValue!=guaranteedPointsII){
                if (diceCounter.containsKey(faceValue)){
                    diceCounter.put(faceValue,diceCounter.get(faceValue)+1);
                }
                else{
                    diceCounter.put(faceValue,1);
                }
                {
                    for (Integer occurences:diceCounter.values()){
                        if (occurences!=3&&occurences!=0){
                            return false;
                        }
                    }
                }

            }


        }
        return true;
    }
}

