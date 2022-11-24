package UI;

import dice.DiceFace;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Display {
    private static final String COLOR_RESET = "\u001B[0m";
    private static final String BLUE = "\u001B[34m";
    private static final String RED = "\u001B[31m";

    private static String diceToString(ArrayList<DiceFace> diceList) {
        ArrayList<List<String>> splitUpRepresentations = new ArrayList<>();
        for(DiceFace aDice: diceList) {
            String diceRepresentations = (aDice.represent());
            List<String> aSplitUpRepresentation = Arrays.asList(diceRepresentations.split("\n"));
            splitUpRepresentations.add(aSplitUpRepresentation);
        }
        System.out.println(splitUpRepresentations);
        String returnString = "";
        System.out.println(returnString);
        return returnString;
    }

    public static void displayGameState(ArrayList<DiceFace> notTakenDice, ArrayList<DiceFace> takenDice,
                                        String playerName, String cardTitel, String cardDescription,
                                        Integer temporaryPoints, String message) {
        clearScreen();
        String output = String.format("Current Player: %s\n\n", playerName);
        output += String.format("Your Card: %s\n", BLUE + cardTitel + COLOR_RESET);
        output += cardDescription + "\n\n";
        output += "Your rolled dice: \n";
        output += diceToString(notTakenDice) +"\n\n";
        output += "Dice you already took: \n";
        output += diceToString(takenDice) +"\n\n";
        output += String.format("Your temporary Points this turn: %s\n\n", temporaryPoints);
        output += message;
        System.out.println(output);
    }

    public static void displayScores(ArrayList<String> players, ArrayList<Integer> scores) {
        assert players.size() == scores.size();
        clearScreen();
        for(int player_index = 0; player_index < players.size(); player_index++) {
            System.out.printf("%s has %2d Points%n", players.get(player_index),scores.get(player_index));
        }
    }

    public static void displayMessage(String message) {
        clearScreen();
        System.out.println(message);
    }

    private static void clearScreen() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }
}
