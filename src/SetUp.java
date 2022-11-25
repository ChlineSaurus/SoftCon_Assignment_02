import Enums.GameConstants;
import Enums.Messages;
import Input.Input;
import exceptions.IllegalUserInputExeption;
import players.Player;
import players.PlayerManager;

import java.util.ArrayList;

public class SetUp {

    static PlayerManager setUpGame() {
        int necessaryPoints;
        while (true) {
            System.out.println(Messages.necessaryPointsQuestion.message);
            try {
                //make sure that is within in the limit the input
                necessaryPoints = Input.takeIntegerInput();
                break;
            } catch (IllegalUserInputExeption e) {
                System.out.println(e.getMessage());
            }
        }
        ArrayList<Player> players = new ArrayList<Player>();
        int playerCounter = 0;
        while (playerCounter < GameConstants.maxAllowedPlayers.definedConstant) {
            System.out.println(Messages.setUpInstruction.message);
            String name = Input.takeStringInput();
            if (name.length() > GameConstants.maxAllowedNameLength.definedConstant) {
                System.out.println(Messages.playerNameInputToSmall.message);
            } else if (name.length() == 0) {
                if (playerCounter < GameConstants.minAllowedPlayers.definedConstant) {
                    System.out.println(Messages.notEnoughPlayer.message);
                }
            } else {
                players.add(new Player(name));
                playerCounter++;
            }
        }
        return new PlayerManager(players, necessaryPoints);
    }
}