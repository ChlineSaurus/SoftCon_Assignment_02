package dice;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class RollPointsNonStraight implements CalculateRollPoints{
    private Map<DiceFace,Integer> diceCounter=new HashMap<DiceFace,Integer>();
    private int points=0;

    private void setUpDiceCounter(List<Dice> newlyTakenDices){
        for (Dice aDice:newlyTakenDices){
            DiceFace faceValue=aDice.getFaceValue();

            if (diceCounter.containsKey(faceValue)){
                diceCounter.put(faceValue,diceCounter.get(faceValue)+1);
            }
            else{
                diceCounter.put(faceValue,1);
            }
        }
    }

    public int calculatePoints(List<Dice> newlyTakenDices) {
        setUpDiceCounter(newlyTakenDices);
        for (Map.Entry<DiceFace, Integer> entry : diceCounter.entrySet()){
            DiceFace faceValue=entry.getKey();
            Integer occurences=entry.getValue();

            while (occurences>=3){
                if (faceValue==DiceFace.One){
                    points+=1000;
                }
                else{
                    points+=100*faceValue.integerValue;
                }
                occurences-=3;
            }

            while (occurences>0){
                if (faceValue==DiceFace.Five){
                    points+=50;
                }
                else if (faceValue==DiceFace.One){
                    points+=100;
                }
                else{ points+=0;}
                occurences-=1;
            }
        }
        return points;
    }

}
