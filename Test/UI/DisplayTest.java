package UI;

import dice.DiceFace;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;

public class DisplayTest {
    ArrayList<DiceFace> dices = createDiceList();
    Display display = new Display();

    private ArrayList<DiceFace> createDiceList() {
        ArrayList<DiceFace> diceFaces = new ArrayList<>();
        diceFaces.add(DiceFace.Five);
        diceFaces.add(DiceFace.Three);
        diceFaces.add(DiceFace.Six);
        return diceFaces;
    }

    private Method diceToStringMethod() throws NoSuchMethodException{
        Method m = display.getClass().getDeclaredMethod("diceToString", ArrayList.class);
        m.setAccessible(true);
        return m;
    }

    @Test
    public void emptyDiceList() throws NoSuchMethodException, IllegalAccessException, InvocationTargetException {
        Method m = diceToStringMethod();
        String actual = (String) m.invoke(null, new ArrayList<DiceFace>());
        Assertions.assertEquals("", actual);
    }

    @Test
    public void normalDiceList() throws NoSuchMethodException, IllegalAccessException, InvocationTargetException {
        String COLOR_RESET = "\u001B[0m";
        String RED = "\u001B[31m";
        Method m = diceToStringMethod();
        String actual = (String) m.invoke(null, dices);
        System.out.println(actual);
        String expected = RED +"""
                +-------++-------++-------+
                | o   o || o     || o   o |
                |   o   ||   o   || o   o |
                | o   o ||     o || o   o |
                +-------++-------++-------+\n""" +COLOR_RESET;
        Assertions.assertEquals(expected.replaceAll("o", COLOR_RESET+"o"+RED), actual);
    }
}
