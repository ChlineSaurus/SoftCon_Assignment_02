package Turn;

public class MoreValidDice implements  TurnState{
    Turn aTurn;
    public MoreValidDice(){}

    @Override
    public void next(Turn aTurn) {
        stateController();
        System.out.println("There are more valid die");
        aTurn.setState(new AddScore());
    }
    private void stateController(){
        Boolean terminateTurn = Boolean.FALSE;
        Boolean rollAgain = Boolean.FALSE;
        while(terminateTurn != Boolean.TRUE || rollAgain !=Boolean.TRUE){
            getUserInput();
        }

    }
    private void getUserInput(){
        /*
        smart algo to communicate with user
         */
    }
    private void updateTurnScore(){
        /*do something to update the turnscore

         */
    }
}
