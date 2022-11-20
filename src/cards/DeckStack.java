package cards;


import java.util.ArrayList;
import java.util.List;
import java.util.Iterator;


public class DeckStack implements Iterable<Card>
{
    private final List<Card> aCards;

    public DeckStack(){
        aCards = new ArrayList<>();
    }

    public DeckStack(Iterable<Card> pCards){
        this();
        for(Card card : pCards)
        {
            aCards.add(card);
        }
    }

    public boolean isEmpty(){
        return aCards.size()==0;
    }

    public Iterator<Card> iterator(){
        return aCards.iterator();
    }

    public Card pop(){
        assert !isEmpty();
        return aCards.remove(aCards.size()-1);
    }

    public void push(Card pCard){
        assert pCard != null;
        aCards.add(pCard);
    }

    public Card peek(){
        assert !isEmpty();
        return aCards.get(aCards.size()-1);
    }

    public int size(){
        return aCards.size();
    }
}
