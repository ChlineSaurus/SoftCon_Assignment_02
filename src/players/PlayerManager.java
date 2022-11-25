package players;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class PlayerManager {
    private final ArrayList<Player> players;
    private final int necessaryPoints;
    private final int totalPlayer;
    private boolean playerReachedNecessaryPoints;
    private Player currentPlayer;
    private int currentPlayerIndex;


    public PlayerManager(ArrayList<Player> players, int necessaryPoints) {
        assert necessaryPoints > 0;
        this.necessaryPoints = necessaryPoints;

        assert players.size() >= 2 && players.size() <= 4;
        this.players = players;
        Collections.sort(this.players);
        totalPlayer = players.size();
        playerReachedNecessaryPoints = false;
        currentPlayer = this.players.get(0);
        currentPlayerIndex = 0;
    }

    public String currentPlayerName() {
        return currentPlayer.name;
    }

    public void nextPlayersTurn(int pointsToAdd) {
        currentPlayer.updateScore(pointsToAdd);
        if (currentPlayer.getScore() >= necessaryPoints) {
            this.playerReachedNecessaryPoints = true;
        }
        currentPlayerIndex++;
        if (currentPlayerIndex >= totalPlayer) {
            if (playerReachedNecessaryPoints) {
                //Terminate the Game
                return;
            } else {
                currentPlayerIndex = 0;
            }
        }
        currentPlayer = players.get(currentPlayerIndex);
    }
    public boolean currentPlayerIsPointLeader(Player currentPlayer){
        int currentPlayersScore=currentPlayer.getScore();
        for (Player aPlayer:players){
            if (!aPlayer.equals(currentPlayer)&& aPlayer.getScore()>=currentPlayersScore){
                return false;
            }
        }
        return true;
    }
    private int getMaxScore(Player currentPlayer){
        int maxScore=-100000;
        for (Player aPlayer:players){
            if (!aPlayer.equals(currentPlayer) && aPlayer.getScore()>maxScore){
                maxScore= aPlayer.getScore();
            }
        }
        return maxScore;

    }
    public List<Player> getPlayersWithMaxScore(Player currentPlayer){
        assert !currentPlayerIsPointLeader(currentPlayer);
        int maxScore=getMaxScore(currentPlayer);
        List<Player> playersWithMaxScore=new ArrayList<Player>();

        for (Player aPlayer:players){
            if (!aPlayer.equals(currentPlayer) && aPlayer.getScore()==maxScore){
                playersWithMaxScore.add(aPlayer);
            }
        }
        return playersWithMaxScore;
    }
}
