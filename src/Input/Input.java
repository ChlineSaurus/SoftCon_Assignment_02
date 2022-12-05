package Input;

import exceptions.IllegalUserInputException;
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

    public static Character takeCharInput() throws IllegalUserInputException {
        String input = readInput().toUpperCase();
        if(input.length() != 1) {
            throw new IllegalUserInputException(Msg.notACharException.message);
        }
        return input.charAt(0);
    }

    public static ArrayList<Integer> takeIntegerListInput() throws IllegalUserInputException {
        String input = readInput();
        input = input.replaceAll("\\s", "");
        input = input.replaceAll(",", "");
        ArrayList<Integer> returnList = new ArrayList<Integer>();
        try {
            for(int i = 0; i < input.length(); i++) {
                returnList.add(Integer.parseInt(Character.toString(input.charAt(i))));
            }
        } catch (NumberFormatException e) {
            throw new IllegalUserInputException(Msg.illegalCharException.message+"if you want take a one and five enter 15 or 51");
        }
        return returnList;
    }

    public static Integer takeIntegerInput() throws IllegalUserInputException {
        String input = readInput();
        int returnValue;
        try {
            returnValue = Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalUserInputException(Msg.notANumberException.message);
        }
        return returnValue;
    }
}
