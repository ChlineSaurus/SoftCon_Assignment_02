package Turn.State;

import Input.TuttoInput;
import Turn.HumanInteractionManager;
import UI.Display;
import dice.DiceFace;
import dice.DiceTower;
import exceptions.IllegalUserInputExeption;

import java.io.IOException;
import java.util.ArrayList;

public class CurrentlyPlaying implements TurnState{
    Turn aTurn;
    private boolean turnFinished = false;
    private boolean interactionFinished = false;
    private boolean tutto =false;

    private ArrayList<DiceFace> diceToRemove;

    public CurrentlyPlaying(Turn pTurn){
        aTurn = pTurn;
        System.out.println("I am in CurrentlyPlaying");
    }


    private DiceTower currentPlayerDice = aTurn.turnCard.getDiceTower();
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

    private void ManageGame() throws IllegalUserInputExeption, IOException {
        Setup();
        TurnFlow();
    }
    //wenns funktioniert, chamer die Methode lösche und d Funktionalität in ManageGame übere tue...
    //evtl. chamer au die ganzi manage game denne lösche...
    private void Setup() throws IllegalUserInputExeption {
        humanInteraction.DisplayOrRoll();
    }
    private void TurnFlow() throws IllegalUserInputExeption, IOException {
        while(!turnFinished){
            currentPlayerDice.rollNotTakenDices();
            if (!currentPlayerDice.notNullRoll()){
                if (!aTurn.turnCard.isImmunity()){
                aTurn.score = 0;
                aTurn.pointsToDeduct = 0;

                }
                aTurn.setState(new EndTurn(aTurn));
            }
            //ka, ob das stimmt, chas aber nid teschte, da ich mitem Error voretäre nid z schlag chume...
            while(!interactionFinished)
            if(currentPlayerDice.notNullRoll()){
                Display.displayMessage("If you want to take some of the Dice type \"Y\" if not type \"N\" ");
                System.out.println(currentPlayerDice.showNotTakenDices());
                char takeDice = TuttoInput.takeCharInput();
                String takeDices = String.valueOf(takeDice);
                if (takeDices.equals("Y")){
                    diceToRemove = humanInteraction.ChoseDice();
                    //currentPlayerDice.removeDice(diceToRemove);
                    System.out.println(diceToRemove);
                    aTurn.score += currentPlayerDice.removeDice(diceToRemove);
                }else{
                    interactionFinished = humanInteraction.Reroll();
                }

            }
            else{
                if(/* getImmunity*/true){
                    interactionFinished = humanInteraction.Reroll();
                }else{
                    aTurn.score = 0;
                    aTurn.setState(new EndTurn(aTurn));
                }
            }
            System.out.println("interaction finished");
            break;

        }
    }
}