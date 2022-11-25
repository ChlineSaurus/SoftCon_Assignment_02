package Turn.State;

import cards.AbstractCard;
import cards.cards.cardtypes.Bonus;
import dice.DiceFace;
import dice.DiceTower;
import Turn.HumanInteractionManager;
import exceptions.IllegalUserInputExeption;

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
    //die Idee wäre dass du die Karte vom Deck bekommst und nicht wie hier willkürlich intialiserd wird

    AbstractCard card=new Bonus();
    // functioniert noch nicht
    //der dicetower verhält sich verschieden jenachdme welche Karte ist deshalb ist es wichtig dass die Karte dies gibt
    private DiceTower currentPlayerDice = card.getDiceTower();
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
        while(turnFinished != true){
            currentPlayerDice.rollNotTakenDices();
            while(interactionFinished != true)
            if(currentPlayerDice.notNullRoll() == true){
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