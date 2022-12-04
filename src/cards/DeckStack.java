package cards;

import java.util.ArrayList;

public class DeckStack {
    private final ArrayList<AbstractCard> aCards;
    public DeckStack(){
        aCards = new ArrayList<>();
    }

    public DeckStack(Iterable<AbstractCard> pCards){
        this();
        for(AbstractCard abstractCard : pCards)
        {
            aCards.add(abstractCard);
        }
    }

    public boolean isEmpty(){
        return aCards.size()==0;
    }

    public AbstractCard pop(){
        assert !isEmpty();
        return aCards.remove(aCards.size()-1);
    }
}
