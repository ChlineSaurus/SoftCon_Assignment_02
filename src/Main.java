import cards.Deck;
import dice.Dice;


public class Main {
    public static void main(String[] args) {
        Dice d1=new Dice();
        Deck deck = new Deck();
        System.out.println(deck.draw());
    }
}