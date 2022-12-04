package dice.pointCalculator;

import dice.Dice;
import dice.DiceFace;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PointCalculatorStandard implements PointCalculator {



    private void setUpDiceCounter(List<Dice> newlyTakenDices, Map<DiceFace,Integer> diceCounter){
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
        Map<DiceFace,Integer> diceCounter=new HashMap<DiceFace,Integer>();
        int points=0;
        setUpDiceCounter(newlyTakenDices,diceCounter);
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
