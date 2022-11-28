package cards.cards.cardtypes;


import cards.AbstractCard;

public class X2 extends AbstractCard {
    private final String name="Double";
    int TuttoRequiredForPoints = 0;
    boolean EndTurn = false;
    boolean KeepAllValidDice = false;
    boolean Immunity = false;
    boolean EndGame = false;
    int TuttoRequiredForBonus = 1;
    public X2(){
        diceTower.setDiceTowerNonStraight();
    }
}