package Input;

import exceptions.IllegalUserInputExeption;
import Enums.Msg;

import java.util.ArrayList;
import java.util.Scanner;

public class Input {
    static private final Scanner scanner = new Scanner(System.in);

    private static String readInput() {
        return scanner.nextLine();
    }

    public static String takeStringInput() {
        return readInput();
    }

    public static Character takeCharInput() throws IllegalUserInputExeption {
        String input = readInput().toUpperCase();
        if(input.length() != 1) {
            throw new IllegalUserInputExeption(Msg.notACharException.message);
        }
        return input.charAt(0);
    }

    public static ArrayList<Integer> takeIntegerListInput() throws IllegalUserInputExeption{
        String input = readInput();
        input = input.replaceAll("\\s", "");
        input = input.replaceAll(",", "");
        ArrayList<Integer> returnList = new ArrayList<Integer>();
        try {
            for(int i = 0; i < input.length(); i++) {
                returnList.add(Integer.parseInt(Character.toString(input.charAt(i))));
            }
        } catch (NumberFormatException e) {
            throw new IllegalUserInputExeption(Msg.illegalCharException.message);
        }
        return returnList;
    }

    public static Integer takeIntegerInput() throws IllegalUserInputExeption{
        String input = readInput();
        int returnValue;
        try {
            returnValue = Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalUserInputExeption(Msg.notANumberException.message);
        }
        return returnValue;
    }
}
