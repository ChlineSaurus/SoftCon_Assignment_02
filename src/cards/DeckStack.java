package cards;


import java.util.ArrayList;
import java.util.List;
import java.util.Iterator;


public class DeckStack implements Iterable<AbstractCard>
{
    private final List<AbstractCard> aCards;

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

    public Iterator<AbstractCard> iterator(){
        return aCards.iterator();
    }

    public AbstractCard pop(){
        assert !isEmpty();
        return aCards.remove(aCards.size()-1);
    }

    public void push(AbstractCard pCard){
        assert pCard != null;
        aCards.add(pCard);
    }

    public AbstractCard peek(){
        assert !isEmpty();
        return aCards.get(aCards.size()-1);
    }

    public int size(){
        return aCards.size();
    }
}
