package cards.cards.cardtypes;


import cards.AbstractCard;

public class Bonus extends AbstractCard {


    public Bonus(int points){
        assert points>0;
        diceTower.setDiceTowerNonStraight();

        name="Bonus "+points;
        descripiton="bla bla";
        bonusPoints=points;



    }
    }

