package Turn.State;

import Input.TuttoInput;
import Turn.HumanInteractionManager;
import UI.Display;
import cards.AbstractCard;
import cards.Deck;
import dice.DiceFace;
import dice.DiceTower;
import exceptions.IllegalUserInputExeption;
import players.PlayerManager;

import java.io.IOException;
import java.util.ArrayList;

public class CurrentlyPlaying implements TurnState{
    Turn aTurn;
    private boolean turnFinished = false;
    private boolean interactionFinished = false;
    private boolean tuto =false;

    private ArrayList<DiceFace> diceToRemove;

    public CurrentlyPlaying(Turn aTurn){this.aTurn = aTurn;}
    //die Paramter für den Dicetower muss currentlyPlaying von der Karte bekommen.
    AbstractCard card= PlayerManager.getInstance().getCard();
    private DiceTower currentPlayerDice = card.getDiceTower();
    public HumanInteractionManager humanInteraction = new HumanInteractionManager();
    @Override
    public void next(Turn aTurn) throws IOException, IllegalUserInputExeption {
        int i = 1;
        System.out.println("I am currently playing");
        ManageGame();
        if (i ==0){
            aTurn.setState(new Tutto(aTurn));
        }
        else{
            aTurn.setState(new NoMoreValidDice(aTurn));
        }
    }

    private void ManageGame() throws IllegalUserInputExeption {
        Setup();
        TurnFlow();
    }
    private void Setup() throws IllegalUserInputExeption {
        humanInteraction.DisplayOrRoll();
        Deck myStack = new Deck();
        myStack.createDeckStack();
        AbstractCard playerCard = card;
        System.out.println("hi");
        currentPlayerDice = playerCard.getDiceTower();
        currentPlayerDice.newTurn();

    }
    private void TurnFlow() throws IllegalUserInputExeption{
        while(turnFinished != true){
            currentPlayerDice.rollNotTakenDices();
            while(interactionFinished != true)
            if(currentPlayerDice.notNullRoll()){
                Display.displayMessage("If you want to take some of the Dice type \"Y\" if not type \"N\" ");
                System.out.println(currentPlayerDice.showNotTakenDices());
                char takeDice = TuttoInput.takeCharInput();
                String takeDices = String.valueOf(takeDice);
                if (takeDices.equals("Y")){
                    diceToRemove = humanInteraction.ChoseDice();
                    //currentPlayerDice.removeDice(diceToRemove);
                    System.out.println(diceToRemove);
                    currentPlayerDice.removeDice(diceToRemove);
                }else{
                    interactionFinished = humanInteraction.Reroll();
                }

            }
            else{
                interactionFinished = humanInteraction.Reroll();
            }
            System.out.println("interaction finished");
            break;

        }
    }
}