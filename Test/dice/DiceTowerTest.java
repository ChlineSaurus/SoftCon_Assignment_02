package dice;

import org.junit.jupiter.api.Test;

import java.lang.reflect.Field;

public class DiceTowerTest {
    DiceTower diceTower=new DiceTower();

    @Test
    public void testStraightValidation(){
        diceTower.setDiceTowerNonStraight();
        diceTower.rollNotTakenDices();
        Field[] diceTowerFields = diceTower.getClass().getDeclaredFields();
        for (Field field : diceTowerFields) {
            if (field.getName().equals("notTakenDices")) {
                field.setAccessible(true);

            }


        }

    }
}
