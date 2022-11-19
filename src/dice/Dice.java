package dice;

import java.util.concurrent.ThreadLocalRandom;

public class Dice {
    private final int MIN=1;
    private final int MAX=6;
    private boolean wasThrown=false;
    private int faceValue;

    public int roll(){
        wasThrown=true;
        faceValue= ThreadLocalRandom.current().nextInt(MIN, MAX+1);
        return faceValue;

    }

    public int getFaceValue()   {
        if (!wasThrown){
            //throw new IllegalgetValueException("The dice hasn't been thrown, you can't get the value.");
        }
        return faceValue;
    }
}
