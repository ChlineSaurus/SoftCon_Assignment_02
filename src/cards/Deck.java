package cards;

import cards.cards.cardtypes.*;

import java.util.ArrayList;
import java.util.Collections;

public class Deck
{
    private DeckStack aCards;
    private ArrayList<AbstractCard> cards;

    public Deck()
    {
        createDeckStack();
    }

    public void createDeckStack(){
        cards=new ArrayList<AbstractCard>();

        Cloverleaf cloverleaf = new Cloverleaf();
        cards.add(cloverleaf);

        for(int i=0;i<5;i++){
            Fireworks fireworks = new Fireworks();
            cards.add(fireworks);
            Straight straight = new Straight();
            cards.add(straight);
            PlusMinus plusminus = new PlusMinus();
            cards.add(plusminus);
            X2 x2= new X2();
            cards.add(x2);
        }

        for(int i=0;i<10;i++)
        {
            Stop stop = new Stop();
            cards.add(stop);
        }

        int bonusPoints=200;
        for(int i=0;i<5;i++){

            for(int j=0;j<5;j++){
                Bonus bonusCard = new Bonus(bonusPoints);
                cards.add(bonusCard);
            }
            bonusPoints+=100;
        }
        for(int i=0;i<5000;i++) {
            Fireworks fireworks = new Fireworks();
        }
        shuffle();
        aCards=new DeckStack(cards);
    }

    private void shuffle() {
        Collections.shuffle(cards);
    }

    public AbstractCard draw() {
        if (isEmpty()){
            createDeckStack();
        }
        return aCards.pop();
    }

    public boolean isEmpty() {
        return aCards.isEmpty();
    }
}




