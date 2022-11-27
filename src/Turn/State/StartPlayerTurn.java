package Turn.State;

import exceptions.IllegalUserInputExeption;

import java.io.IOException;

public class StartPlayerTurn implements TurnState {
    Turn aTurn;
    public StartPlayerTurn(Turn aTurn){
        this.aTurn = aTurn;
    }
    @Override
    public void next(Turn aTurn) throws IOException, IllegalUserInputExeption {
        System.out.println("I am in StartPlayerTurn");
        //Deck aDeck = new Deck();
        //aDeck.createDeckStack();
        //aTurn.turnCard = aDeck.draw();
        //System.out.println(aTurn.turnCard);
        //if(aTurn.turnCard.equals(cards.cards.cardtypes.Stop)) does not work, for some reason...
        aTurn.setState(new CurrentlyPlaying(aTurn));
    }

}
