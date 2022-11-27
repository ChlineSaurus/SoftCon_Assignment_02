package cards.cards.cardtypes;


import cards.AbstractCard;

public class PlusMinus extends AbstractCard {
    private final String name="PlusMinus";
    int TuttoRequiredForPoints = 1;
    boolean EndTurn = false;
    boolean KeepAllValidDice = false;
    boolean Immunity = false;
    boolean EndGame = false;
    int TuttoRequiredForBonus = 1;


    public PlusMinus() {
        diceTower.setDiceTowerNonStraight();
    }
}
