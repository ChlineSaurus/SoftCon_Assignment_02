package Turn;

import Turn.State.StartPlayerTurn;
import Turn.State.TurnState;
import cards.AbstractCard;
import cards.Deck;
import dice.DiceFace;
import dice.DiceTower;
import exceptions.IllegalUserInputException;
import players.PlayerManager;

import java.util.ArrayList;

public class Turn {
    private final DiceTower diceTower;
    private Deck deck;
    public AbstractCard turnCard;
    public int temporaryScore;
    public int pointsToDeduct;
    private TurnState currentState = new StartPlayerTurn(this);

    public Turn () {
        deck = new Deck();
        diceTower = new DiceTower();
        temporaryScore = 0;
        pointsToDeduct = 0;
        draw();
    }

    public void newTurn() {
        PlayerManager playerManager=PlayerManager.getInstance();
        playerManager.deductLeadingPlayersPoints(pointsToDeduct);
        playerManager.nextPlayersTurn(temporaryScore);
        temporaryScore = 0;
        pointsToDeduct = 0;
        draw();
        setCurrentState(new StartPlayerTurn(this));
    }

    public void draw() {
        if (deck.isEmpty()) {
            deck = new Deck();
        }
        turnCard = deck.draw();
        diceTower.newTurn();
        turnCard.injectStrategyToTower(diceTower);
    }

    public void setCurrentState(TurnState currentState) {
        this.currentState = currentState;
    }
    public void execute() throws IllegalUserInputException {
        currentState.next();
    }
    public void displayTurn(String message) {
        PlayerManager thePlayerManager = PlayerManager.getInstance();
        UI.Display.displayGameState(diceTower.showNotTakenDices(), diceTower.showTakenDices(),
                thePlayerManager.currentPlayerName(), turnCard.getName(), turnCard.getDescription(),
                temporaryScore, message);
    }

    public boolean validDiceExist() {
        return diceTower.notNullRoll();
    }

    public void rollNotTakenDices() {
        diceTower.rollNotTakenDices();
    }

    public int removeDice(ArrayList<DiceFace> dicesToRemove) throws IllegalUserInputException {
        return diceTower.removeDice(dicesToRemove);
    }

    public boolean tuttoMade() {
        return diceTower.madeTutto();
    }

    public boolean isDiceTakenSinceRoll(){
        return diceTower.diceTakenSinceRoll();
    }

    public void newRoll(){
        aDiceTower.newTurn();
    }
}
