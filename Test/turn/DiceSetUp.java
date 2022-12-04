package turn;

import Turn.Turn;
import dice.Dice;
import dice.DiceFace;
import dice.DiceTower;

import java.lang.reflect.Field;
import java.util.ArrayList;

public class DiceSetUp {

    public static void tuttoSetup(Turn aTurn) throws Exception{
        Field fDiceTower = aTurn.getClass().getDeclaredField("diceTower");
        fDiceTower.setAccessible(true);
        DiceTower theDiceTower = (DiceTower) fDiceTower.get(aTurn);
        theDiceTower.newTurn();
        Field fnotTakeDice = theDiceTower.getClass().getDeclaredField("notTakenDices");
        fnotTakeDice.setAccessible(true);
        Object o = fnotTakeDice.get(theDiceTower);
        ArrayList<Dice> notTakenDice = new ArrayList<>();
        if (o.getClass() == ArrayList.class) {
            notTakenDice = (ArrayList<Dice>) o;
        }
        for(Dice aDice: notTakenDice) {
            Field value = aDice.getClass().getDeclaredField("currentFaceValue");
            value.setAccessible(true);
            value.set(aDice, DiceFace.One);
        }
    }

    public static void NullSetup(Turn aTurn) throws Exception{
        Field fDiceTower = aTurn.getClass().getDeclaredField("diceTower");
        fDiceTower.setAccessible(true);
        DiceTower theDiceTower = (DiceTower) fDiceTower.get(aTurn);
        theDiceTower.newTurn();
        Field fnotTakeDice = theDiceTower.getClass().getDeclaredField("notTakenDices");
        fnotTakeDice.setAccessible(true);
        Object o = fnotTakeDice.get(theDiceTower);
        ArrayList<Dice> notTakenDice = new ArrayList<>();
        if (o.getClass() == ArrayList.class) {
            notTakenDice = (ArrayList<Dice>) o;
        }
        int i = 0;
        for(Dice aDice: notTakenDice) {
            Field value = aDice.getClass().getDeclaredField("currentFaceValue");
            value.setAccessible(true);
            if (i%3 == 0) {
                value.set(aDice, DiceFace.Two);
            } else if (i%3 == 1) {
                value.set(aDice, DiceFace.Three);
            } else {
                value.set(aDice, DiceFace.Four);
            }
            i++;
        }
    }
}
