package dice;

import java.util.concurrent.ThreadLocalRandom;

public class Dice {
    private final int MIN=1;
    private final int MAX=6;
    private int faceValue;

    public int roll(){
        faceValue= ThreadLocalRandom.current().nextInt(MIN, MAX+1);
        return faceValue;

    }

    public int getFaceValue()  {
        if (faceValue==0){
            roll();
        }
        return faceValue;
    }
}
