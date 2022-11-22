package Turn.State;

public class EndTurn implements TurnState{
    Turn aTurn;

    public EndTurn(Turn aTurn){this.aTurn = aTurn;}
    @Override
    public void next(Turn aTurn) {
        System.out.println("Turn is finished");
    }
}
