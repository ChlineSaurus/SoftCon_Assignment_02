package Input;

import exceptions.IllegalUserInputExeption;

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
        String input = readInput();
        if(input.length() != 1) {
            throw new IllegalUserInputExeption("You were supposed to input a single char, but your input" +
                    "was not of length one");
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
            throw new IllegalUserInputExeption("You input contained other symbols than number and \",\"." +
                    "Please give a valid Input");
        }
        return returnList;
    }
}
