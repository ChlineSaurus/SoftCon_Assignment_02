package Turn;

public class EvaluateWon implements TurnState{
    Turn aTurn;
    public EvaluateWon(){}

    @Override
    public void next(Turn aTurn) {
        /* if player.won==true, dann in terminate gehen*/
        int i =0;
        System.out.println("We are in EvaluateWon");
        if(i ==0){
            aTurn.setState(new Terminate());
        }
        else{
            aTurn.setState(new StartPlayerTurn());
        }
    }
}
