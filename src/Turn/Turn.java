package Turn;

import Turn.State.StartPlayerTurn;
import Turn.State.TurnState;
import cards.AbstractCard;
import cards.Deck;
import dice.DiceTower;
import exceptions.IllegalUserInputExeption;
import players.PlayerManager;

public class Turn {
    private DiceTower aDiceTower;
    private Deck aDeck;
    public AbstractCard turnCard;
    public int temporaryScore;
    public int pointsToDeduct;

    private TurnState currentState = new StartPlayerTurn(this);

    public Turn (PlayerManager players) {
        aDiceTower = new DiceTower();
        aDeck = new Deck();
        temporaryScore = 0;
        pointsToDeduct = 0;
    }

    public void newTurn() {
        PlayerManager playerManager=PlayerManager.getInstance();
        playerManager.deductLeadingPlayersPoints(pointsToDeduct);
        playerManager.nextPlayersTurn(temporaryScore);
        temporaryScore = 0;
        pointsToDeduct = 0;
        setCurrentState(new StartPlayerTurn(this));
    }

    public void draw() {
        if (aDeck.isEmpty()) {
            aDeck = new Deck();
        }
        turnCard = aDeck.draw();
        aDiceTower.newTurn();
        turnCard.injectStrategyToTower(aDiceTower);
    }

    public void setCurrentState(TurnState currentState) {
        this.currentState = currentState;
        currentState.next();
    }
    public void nextState() throws IllegalUserInputExeption {
        currentState.next();
    }

    public void displayTurn(String message) {
        PlayerManager thePlayerManager = PlayerManager.getInstance();
        UI.Display.displayGameState(aDiceTower.showNotTakenDices(), aDiceTower.showTakenDices(),
                thePlayerManager.currentPlayerName(), turnCard.getName(), turnCard.getDescription(),
                temporaryScore, message);
    }
}