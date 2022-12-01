package Turn;

import Turn.State.StartPlayerTurn;
import Turn.State.TurnState;
import cards.AbstractCard;
import cards.Deck;
import dice.DiceFace;
import dice.DiceTower;
import exceptions.IllegalUserInputExeption;
import players.PlayerManager;

import java.util.ArrayList;

public class Turn {
    private final DiceTower aDiceTower;
    private Deck aDeck;
    public AbstractCard turnCard;
    public int temporaryScore;
    public int pointsToDeduct;
    private TurnState currentState = new StartPlayerTurn(this);

    public Turn () {
        aDeck = new Deck();
        aDiceTower = new DiceTower();
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

    public boolean validDiceExist() {
        return aDiceTower.notNullRoll();
    }

    public void rollNotTakenDices() {
        aDiceTower.rollNotTakenDices();
    }

    public int removeDice(ArrayList<DiceFace> dicesToRemove) throws IllegalUserInputExeption{
        return aDiceTower.removeDice(dicesToRemove);
    }

    public boolean tuttoMade() {
        return aDiceTower.tuttoAccomplished();
    }

    public boolean isDiceTakenSinceRoll(){
        return aDiceTower.diceTakenSinceRoll();
    }
}
