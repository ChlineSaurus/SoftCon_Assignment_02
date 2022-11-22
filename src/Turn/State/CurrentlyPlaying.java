package Turn.State;

import dice.DiceTower;
import Turn.HumanInteractionManager;

import java.io.IOException;

public class CurrentlyPlaying implements TurnState{
    Turn aTurn;
    private Boolean turnFinished = Boolean.FALSE;
    private Boolean interactionFinished = Boolean.FALSE;
    private Boolean tuto = Boolean.FALSE;
    public CurrentlyPlaying(Turn aTurn){this.aTurn = aTurn;}
    public DiceTower currentPlayerDice = new DiceTower();
    public HumanInteractionManager humanInteraction = new HumanInteractionManager();
    @Override
    public void next(Turn aTurn) throws IOException {
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
    private void ManageGame() throws IOException {
        Setup();
        TurnFlow();
    }
    private void Setup() throws IOException {
        humanInteraction.DisplayOrRoll();
        currentPlayerDice.newTurn();
        //DrawCard
        System.out.println("Your card is XXXX");
    }
    private void TurnFlow(){
        while(turnFinished != Boolean.TRUE){
            currentPlayerDice.rollNotTakenDices();
            while(interactionFinished != Boolean.TRUE)
            if(EvaluateDice(currentPlayerDice) == Boolean.TRUE){
                humanInteraction.ChoseDice();
            }
            else{
                humanInteraction.Reroll();
            }


        }
    }
    private Boolean EvaluateDice(DiceTower currentPlayerDice){
        
        return Boolean.TRUE;
    }
}
