package cards.cards.cardtypes;


import cards.AbstractCard;

public class Bonus extends AbstractCard {

    private final String name="Bonus";
    int points;
    int TuttoRequiredForPoints = 0;
    boolean EndTurn = false;
    boolean KeepAllValidDice = false;
    boolean Immunity = false;
    boolean EndGame = false;
    int TuttoRequiredForBonus = 1;

    public Bonus(int points){

        super("Bonus","You get a bonus", PlusPoints,100,0,1,null, PointsStraightNonNullRoll, MustTakeAllValidDice);
    }
    }

