package materials;


import materials.cards.cardtypes.*;
import materials.cards.cardtypes.Double;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


public class Deck
{
    private DeckStack aCards;

    //Creates a new deck of 56 cards, shuffled.
    public Deck()
    {
        shuffle();
    }

    public void shuffle()
    {
        List<AbstractCard> cards = new ArrayList<>();

        Cloverleaf cloverleaf = new Cloverleaf();
        cards.add(cloverleaf);

        for(int i=0;i<5;i++){
            Fireworks fireworks = new Fireworks();
            cards.add(fireworks);
        }

        for(int i=0;i<10;i++)
        {
            Stop stop = new Stop();
            cards.add(stop);
        }

        for(int i=0;i<5;i++){
            Straight straight = new Straight(2000);
            cards.add(straight);
        }

        for(int i=0;i<5;i++){
            PlusMinus plusminus = new PlusMinus();
            cards.add(plusminus);
        }

        for(int i=0;i<5;i++){
            Double d = new Double();
            cards.add(d);
            }

        int p=100;
        for(int i=0;i<5;i++){
            p+=100;
            for(int j=0;j<5;j++){
                Bonus bonus = new Bonus(p);
                cards.add(bonus);
            }
        }
        Collections.shuffle(cards);

    }

    public AbstractCard draw()
    {
        return aCards.pop();
    }

    public boolean isEmpty()
    {
        return aCards.isEmpty();
    }
}




