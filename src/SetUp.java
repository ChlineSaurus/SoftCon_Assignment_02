import Enums.GameConstants;
import Enums.Msg;
import Input.Input;
import exceptions.IllegalUserInputExeption;
import players.Player;
import players.PlayerManager;

import java.io.IOException;
import java.util.ArrayList;

public class SetUp {

    static void setUpGame() throws IOException, IllegalUserInputExeption {
        int necessaryPoints;
        while (true) {
            System.out.println(Msg.necessaryPointsQuestion.message);
            try {
                //make sure that is within in the limit the input and lower level
                necessaryPoints = Input.takeIntegerInput();
                if (necessaryPoints<GameConstants.minAllowedPoints.definedConstant || necessaryPoints>GameConstants.maxAllowedPoints.definedConstant){
                throw new IllegalUserInputExeption("The minimum necessary points is "
                        + GameConstants.minAllowedPoints.definedConstant + "the maximum is" +GameConstants.maxAllowedPoints.definedConstant);
                }
                break;
            } catch (IllegalUserInputExeption e) {
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
        PlayerManager.getInstance().nextPlayersTurn(0);
    }
}