package cards.cards.cardInterfaces.deductPoints;

import players.PlayerManager;

public class DoDeductPoints implements DeductPoints{

    @Override
    public void deductPoints(int pointsToDeduct) {
        PlayerManager playerManager=PlayerManager.getInstance();
        playerManager.deductLeadingPlayersPoints(pointsToDeduct);
    }
}
