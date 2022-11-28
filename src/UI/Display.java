package UI;

import dice.DiceFace;
import players.PlayerManager;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Display {
    private static final String COLOR_RESET = "\u001B[0m";
    private static final String RED = "\u001B[31m";

    private static String diceToString(ArrayList<DiceFace> diceList) {
        ArrayList<List<String>> splitUpRepresentations = new ArrayList<>();
        for(DiceFace aDice: diceList) {
            String diceRepresentations = (aDice.represent());
            List<String> aSplitUpRepresentation = Arrays.asList(diceRepresentations.split("\n"));
            splitUpRepresentations.add(aSplitUpRepresentation);
        }
        System.out.println(splitUpRepresentations);
        StringBuilder buildingString = new StringBuilder();
        for(int row = 0; row < splitUpRepresentations.get(0).size(); row++) {
            for (List<String> aDice : splitUpRepresentations) {
                buildingString.append(aDice.get(row));
            }
            buildingString.append("\n");
            buildingString.append("  ");
        }
        String returnString = RED + buildingString.toString() + COLOR_RESET;
        return returnString.replaceAll("o", COLOR_RESET + "o" + RED);
    }

    public static void displayGameState(ArrayList<DiceFace> notTakenDice, ArrayList<DiceFace> takenDice,
                                        String playerName, String cardTitel, String cardDescription,
                                        Integer temporaryPoints, String message) {
        clearScreen();
        String output = String.format("Current Player: %s\n\n", playerName) +
                String.format("Your Card: %s\n", cardTitel) +
                "Card description:" +
                cardDescription +
                "\n\n" +
                "Your rolled dice: \n" +
                diceToString(notTakenDice) +
                "\n\n" +
                "Dice you already took: \n" +
                diceToString(takenDice) +
                "\n\n" +
                String.format("Your temporary Points this turn: %s\n\n", temporaryPoints) +
                message;
        System.out.println(output);
    }

    public static void displayScores() {
        PlayerManager playerManager=PlayerManager.getInstance();
        List<String> players= playerManager.getPlayersName();
        List<Integer> scores= playerManager.getPlayersScore();

        assert players.size() == scores.size();
        clearScreen();
        System.out.println("Players points: \n");
        for(int player_index = 0; player_index < players.size(); player_index++) {
            System.out.printf("%s has %2d Points\n", players.get(player_index),scores.get(player_index));
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
