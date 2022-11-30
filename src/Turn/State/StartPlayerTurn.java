package Turn.State;

import Input.TuttoInput;
import Turn.Turn;
import UI.Display;
import exceptions.IllegalUserInputExeption;
import players.PlayerManager;
import Turn.HumanInteractionManager;

import java.util.ArrayList;

public class StartPlayerTurn implements TurnState {
    Turn aTurn;
    public StartPlayerTurn(Turn aTurn){
        this.aTurn = aTurn;
    }
    @Override
    public void next() throws IllegalUserInputExeption {
        System.out.println("I am in StartPlayerTurn");
        DisplayOrRoll();
        PlayerManager currentPlayer = PlayerManager.getInstance();
        aTurn.turnCard = currentPlayer.getCard();
        aTurn.playerDice = currentPlayer.getCard().getDiceTower();
        aTurn.playerDice.newTurn();
        //aTurn.turnCard = PlayerManager.getInstance().getCard();
        System.out.println(aTurn.turnCard.getName());
        /*if stop card */
        if(aTurn.turnCard.isEndTurn()) {
            aTurn.score = 0;
            aTurn.setCurrentState(new EndTurn(aTurn));
        }

        aTurn.setCurrentState(new CurrentlyPlaying(aTurn));
    }

    private void DisplayOrRoll() throws IllegalUserInputExeption {
        Character nextAction = null;
        ArrayList<Character> possibleNextAction = new ArrayList<>();
        possibleNextAction.add('R');
        possibleNextAction.add('D');
        UI.Display.displayMessage("For displaying your score please enter \"D\" for rolling the Dice please enter \"R\"");
        boolean validInput = false;
        while (!validInput) {
            try {
                nextAction = TuttoInput.takeRestrictedCharInput(possibleNextAction);
                validInput = true;
            } catch (IllegalUserInputExeption e) {
                UI.Display.displayMessage(e.getMessage());
            }
        }
        if (nextAction.equals('D')) {
            Display.displayScores();
            DisplayOrRoll();
        }
    }

}
