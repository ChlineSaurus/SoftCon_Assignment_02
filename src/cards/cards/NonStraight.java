package cards.cards;

import dice.Dice;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class NonStraight implements TuttoCondition {
    private Map<Integer,Integer> diceCountUngaranteedPoints = new HashMap<Integer, Integer>();
    private final int guaranteedpointsI=1;
    private final int guaranteedPointsII=5;

    @Override
    public boolean tutoRequirements(List<Dice> dices)
     {
        for (Dice dice: dices){

            int faceValue=dice.getFaceValue();

            if (faceValue!=guaranteedpointsI && faceValue!=guaranteedPointsII){
                if (diceCountUngaranteedPoints.containsKey(faceValue)){
                    diceCountUngaranteedPoints.put(faceValue,diceCountUngaranteedPoints.get(faceValue)+1);
                }
                else{
                    diceCountUngaranteedPoints.put(faceValue,1);
                }
                {
                    for (Integer occurences:diceCountUngaranteedPoints.values()){
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

