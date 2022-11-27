package cards.cards.cardtypes;


import cards.AbstractCard;

public class Bonus extends AbstractCard {


    public Bonus(int points){
        assert points>0;
        diceTower.setDiceTowerNonStraight();
        this.bonusPoints=points;
        this.name="Bonus "+points;
        this.descripiton="bla bla";
        this.endTurn=false;


    }
    }

