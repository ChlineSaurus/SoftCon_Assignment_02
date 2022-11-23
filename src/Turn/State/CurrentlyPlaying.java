package Turn.State;

import dice.DiceFace;
import dice.DiceTower;
import Turn.HumanInteractionManager;
import exceptions.IllegalUserInputExeption;

import java.io.IOException;
import java.util.ArrayList;

public class CurrentlyPlaying implements TurnState{
    Turn aTurn;
    private Boolean turnFinished = Boolean.FALSE;
    private Boolean interactionFinished = Boolean.FALSE;
    private Boolean tuto = Boolean.FALSE;
    private ArrayList<DiceFace> diceToRemove;
    public CurrentlyPlaying(Turn aTurn){this.aTurn = aTurn;}
    private DiceTower currentPlayerDice = new DiceTower();
    public HumanInteractionManager humanInteraction = new HumanInteractionManager();
    @Override
    public void next(Turn aTurn) throws IOException, IllegalUserInputExeption {
        int i = 0;
        System.out.println("I am currently playing");
        ManageGame();
        if (i ==0){
            aTurn.setState(new Tutto(aTurn));
        }
        else{
            aTurn.setState(new Tutto(aTurn));
        }
    }
    private void ManageGame() throws IOException, IllegalUserInputExeption {
        Setup();
        TurnFlow();
    }
    private void Setup() throws IllegalUserInputExeption {
        humanInteraction.DisplayOrRoll();
        currentPlayerDice.newTurn();
        //DrawCard
        System.out.println("Your card is XXXX");
    }
    private void TurnFlow() throws IOException, IllegalUserInputExeption{
        while(turnFinished != Boolean.TRUE){
            currentPlayerDice.rollNotTakenDices();
            while(interactionFinished != Boolean.TRUE)
            if(currentPlayerDice.ValidateDice() == Boolean.TRUE){
                diceToRemove = humanInteraction.ChoseDice();
                currentPlayerDice.removeDice(diceToRemove);

            }
            else{
                interactionFinished = humanInteraction.Reroll();
            }
            System.out.println("interactionFinished");

        }
    }
}