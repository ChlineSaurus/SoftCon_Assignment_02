package Turn;

public class NoMoreValidDice implements TurnState{
    Turn aTurn;
    public NoMoreValidDice(){}

    @Override
    public void next(Turn aTurn) {
        System.out.println("Hey here is no more valid Dice");
        /*Ask user if he wants to reroll dice

         */
        int i = 1;
        if (i==0){
            aTurn.setState(new DrawCard());
        }
        else{
            aTurn.setState(new AddScore());
        }
    }
}
