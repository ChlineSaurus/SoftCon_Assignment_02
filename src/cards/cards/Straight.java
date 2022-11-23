package cards.cards;

import dice.Dice;
import dice.DiceFace;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Straight implements TuttoCondition {
    private Map<Integer,Integer> diceCounter = new HashMap<Integer, Integer>();

    @Override
    public boolean tutoRequirements(List<Dice> dices) {

        for (Dice dice: dices){
            DiceFace faceValue = dice.getFaceValue();

            if (diceCounter.containsKey(faceValue)){
                return false;}

            else{
                //diceCounter.put(faceValue,1); Mit em aktuelle DiceTower mues d'Karte zuegriff uf de ha aber nüm merke was scho gmacht worde isch
            }




        }
        return true;
    }

}
