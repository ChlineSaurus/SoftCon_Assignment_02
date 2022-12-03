package input;

import Input.TuttoInput;
import dice.DiceFace;
import exceptions.IllegalUserInputException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;

public class TuttoInputTest {

    private Method getTuttoInputMethod() throws NoSuchMethodException{
        Method m = TuttoInput.class.getDeclaredMethod("transformDiceListInput", ArrayList.class);
        m.setAccessible(true);
        return m;
    }

    @Test
    public void ArrayListInputTest() throws Exception{
        ArrayList<Integer> dices = new ArrayList<>();
        dices.add(1);
        dices.add(5);
        ArrayList<DiceFace> expected = new ArrayList<>();
        expected.add(DiceFace.One);
        expected.add(DiceFace.Five);
        Method m = getTuttoInputMethod();
        Object o = m.invoke(null, dices);
        ArrayList actual = null;
        if(o.getClass() == ArrayList.class) {
            actual = (ArrayList) o;
        }
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void EmptyInput() throws Exception{
        Method m = getTuttoInputMethod();
        Object o = m.invoke(null, new ArrayList<Integer>());
        ArrayList actual = null;
        if(o.getClass() == ArrayList.class) {
            actual = (ArrayList) o;
        }
        Assertions.assertEquals(new ArrayList<DiceFace>(), actual);
    }

    @Test
    public void IllegalInput() throws Exception{
        ArrayList<Integer> illegalInput = new ArrayList<>();
        illegalInput.add(7);
        Method m = getTuttoInputMethod();
        Exception e = Assertions.assertThrows(InvocationTargetException.class, () -> {
            m.invoke(null, illegalInput);
        });
        Assertions.assertEquals(IllegalUserInputException.class, e.getCause().getClass());
    }
}
