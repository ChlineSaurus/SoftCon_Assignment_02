package cards;

import org.junit.jupiter.api.Test;

public class DeckTest {
    Deck deck=new Deck();
    @Test
    public void draw57cards(){
        for (int i=0;i<100;i++){
            AbstractCard tookenCard=deck.draw();
            System.out.println(tookenCard.name);
        }
    }
}
