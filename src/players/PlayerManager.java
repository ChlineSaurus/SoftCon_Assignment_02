package players;

import java.util.ArrayList;
import java.util.Collections;

public class PlayerManager {
    private final ArrayList<Player> players;
    private final int necessaryPoints;
    private final int totalPlayer;
    private boolean playerReachedNecessaryPoints;
    private Player currentPlayer;

    public PlayerManager(ArrayList<Player> players, int necessaryPoints) {
        assert necessaryPoints > 0;
        this.necessaryPoints = necessaryPoints;

        assert players.size() >= 2 && players.size() <= 4;
        this.players = players;
        Collections.sort(this.players);
        totalPlayer = players.size();
        playerReachedNecessaryPoints = false;
        currentPlayer = this.players.get(0);
    }

    public String currentPlayerName() {
        return currentPlayer.name;
    }

    public void updateCurrentPlayer(int pointsToAdd) {
        currentPlayer.updateScore(pointsToAdd);
    }

    public void nextPlayersTurn() {
        if (currentPlayer.getScore() >= necessaryPoints) {
            this.playerReachedNecessaryPoints = true;
        }

    }
}
