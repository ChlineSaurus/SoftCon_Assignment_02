package cards.cards.cardtypes;


import cards.AbstractCard;

public class Straight extends AbstractCard {
   public Straight(int apoints){
        int points = apoints;

    }
    private final String name="Straight";
    public int bonusPoints(int points){
        return points;
    }
    int TuttoRequiredForPoints = 1;
    boolean EndTurn = false;
    boolean KeepAllValidDice = false;
    boolean Immunity = false;
    boolean EndGame = false;
    int TuttoRequiredForBonus = 1;
}
