package cards;


import cards.cards.cardtypes.*;

import java.util.ArrayList;
import java.util.List;

public class Deck
{
    private DeckStack aCards;

    //Creates a new deck of 56 cards, shuffled.
    public Deck()
    {
        shuffle();
    }
    public void createDeckStack(){
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

        /*for(int i=0;i<5;i++){
            Double d = new Double();
            cards.add(d);
            }*/



        int p=100;
        for(int i=0;i<5;i++){
            p+=100;
            for(int j=0;j<5;j++){
                //Bonus b = new Bonus(p);
                //cards.add(b);
            }
        }
        shuffle();
        aCards=new DeckStack(cards);
    }

    public void shuffle()
    {
        //Collections.shuffle(cards);
        }


    //}

    public AbstractCard draw()
    {
        return aCards.pop();
    }


    public boolean isEmpty()
    {
        return aCards.isEmpty();
    }
}




