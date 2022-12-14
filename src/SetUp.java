import Enums.GameConstants;
import Enums.Msg;
import Input.Input;
import exceptions.IllegalUserInputException;
import players.Player;
import players.PlayerManager;

import java.util.ArrayList;

public class SetUp {

    static void setUpGame() {
        int necessaryPoints;
        while (true) {
            System.out.println(Msg.necessaryPointsQuestion.message);
            try {
                necessaryPoints = Input.takeIntegerInput();
                if (necessaryPoints<GameConstants.minAllowedPoints.definedConstant || necessaryPoints>GameConstants.maxAllowedPoints.definedConstant){
                throw new IllegalUserInputException(Msg.pointInputOutOfBounds.message);
                }
                break;
            }
            catch (IllegalUserInputException e) {
                System.out.println(e.getMessage());
            }
        }
        ArrayList<Player> players = new ArrayList<Player>();
        int playerCounter = 0;
        while (playerCounter < GameConstants.maxAllowedPlayers.definedConstant) {
            System.out.println(Msg.setUpInstruction.message);
            String name = Input.takeStringInput();
            if (name.length() > GameConstants.maxAllowedNameLength.definedConstant) {
                System.out.println(Msg.playerNameInputToSmall.message);
            } else if (name.length() == 0) {
                if (playerCounter < GameConstants.minAllowedPlayers.definedConstant) {
                    System.out.println(Msg.notEnoughPlayer.message);
                } else {
                    break;
                }
            } else {
                players.add(new Player(name));
                playerCounter++;
            }
        }
        PlayerManager.getInstance(players,necessaryPoints);
    }
}