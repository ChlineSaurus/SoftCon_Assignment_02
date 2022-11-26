package cards.cards.cardtypes;


import cards.AbstractCard;
import dice.diceTowerTypes.DiceTowerStraight;

public class Bonus extends AbstractCard {


    public Bonus(int points){
        assert points>0;
        this.diceTower=new DiceTowerStraight();
        this.bonusPoints=points;
        this.name="Bonus"+points;
        this.descripiton="bla bla";
        this.endTurn=false;


    }
    }

