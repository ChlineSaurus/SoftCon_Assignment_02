import Input.Input;
import exceptions.IllegalUserInputExeption;
import players.Player;
import players.PlayerManager;

import java.util.ArrayList;

public class SetUp {
    private static final int minPlayer = 2;
    private static final int maxPlayer = 4;
    private static final int maxPlayerNameLength = 20;

    static PlayerManager setUpGame() {
        int necessaryPoints;
        while (true) {
            System.out.println("Until how many Points do you want to play the game? Please enter a Number");
            try {
                necessaryPoints = Input.takeIntegerInput();
                break;
            } catch (IllegalUserInputExeption e) {
                System.out.println(e.getMessage());
            }
        }
        ArrayList<Player> players = new ArrayList<Player>();
        int playerCounter = 0;
        while (playerCounter < maxPlayer) {
            System.out.println("You may play with %2d to %2d Players: Please enter a name if you want to add " +
                    "a Player. If you want to start press Enter!");
            String name = Input.takeStringInput();
            if (name.length() > maxPlayerNameLength) {
                System.out.println("Your Player name was to long. Please give a smaller Input");
            } else if (name.length() == 0) {
                if (playerCounter < minPlayer) {
                    System.out.println("You currently dont have enough players");
                }
            } else {
                players.add(new Player(name));
                playerCounter++;
            }
        }
        return new PlayerManager(players, necessaryPoints);
    }
}