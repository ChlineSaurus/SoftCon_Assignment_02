package players;

import Enums.GameConstants;
import exceptions.IllegalUserInputExeption;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static java.lang.System.exit;


//singleton!!!
public class PlayerManager {

    private static PlayerManager uniqueInstance;
    private final ArrayList<Player> players;
    private final int necessaryPoints;
    private Player currentPlayer;
    private int currentPlayerIndex;

    public static synchronized PlayerManager getInstance(){
        assert uniqueInstance != null;
        return uniqueInstance;
    }

    public static synchronized PlayerManager getInstance(ArrayList<Player> players,int necessaryPoints) throws IOException, IllegalUserInputExeption {
        if(uniqueInstance==null){
            uniqueInstance = new PlayerManager(players, necessaryPoints);
        }
        return uniqueInstance;
    }

    private PlayerManager(ArrayList<Player> players, int necessaryPoints) throws IOException, IllegalUserInputExeption {
        assert necessaryPoints > 0;
        this.necessaryPoints = necessaryPoints;
        assert players.size() >= GameConstants.minAllowedPlayers.definedConstant &&
                players.size() <= GameConstants.maxAllowedPlayers.definedConstant;
        this.players = players;
        Collections.sort(this.players);
        currentPlayer = this.players.get(0);
        currentPlayerIndex = 0;
    }

    public String currentPlayerName() {
        return currentPlayer.name;
    }

    public void nextPlayersTurn(int pointsToAdd) {
        currentPlayer.updateScore(pointsToAdd);
        currentPlayerIndex++;
        if (currentPlayerIndex >= players.size()) {
            for(Player aPlayer: players) {
                if(aPlayer.getScore() >= necessaryPoints) {
                    declareWinner();
                }
            }
            currentPlayerIndex = 0;
        }
        currentPlayer = players.get(currentPlayerIndex);
    }

    public void addPlayer(Player player){
        uniqueInstance.players.add(player);
    }

    private boolean currentPlayerIsPointLeader(){
        int currentPlayersScore=currentPlayer.getScore();
        for (Player aPlayer:players){
            if (!aPlayer.equals(currentPlayer) && aPlayer.getScore()>=currentPlayersScore){
                return false;
            }
        }
        return true;
    }
    private int getMaxScore(Player currentPlayer){
        int maxScore=-100000;
        for (Player aPlayer:players){
            if (aPlayer.getScore()>maxScore){
                maxScore= aPlayer.getScore();
            }
        }
        return maxScore;

    }
    private List<Player> getPlayersWithMaxScore(){
        assert !currentPlayerIsPointLeader();
        int maxScore=getMaxScore(currentPlayer);
        List<Player> playersWithMaxScore=new ArrayList<Player>();

        for (Player aPlayer:players){
            if (!aPlayer.equals(currentPlayer) && aPlayer.getScore()==maxScore){
                playersWithMaxScore.add(aPlayer);
            }
        }
        return playersWithMaxScore;
    }
    public void deductLeadingPlayersPoints(int deductpoints){
        if (!currentPlayerIsPointLeader()){
            List<Player> deductPlayerspoints=getPlayersWithMaxScore();
            for (Player aPlayer: deductPlayerspoints){
                aPlayer.updateScore(-deductpoints);
            }
        }
    }

    public List<String> getPlayersName(){
        List<String> playersName=new ArrayList<String>();
        for (Player aPlayer:players){
            playersName.add(aPlayer.name);
        }
        return playersName;
    }
    public List<Integer> getPlayersScore(){
        List<Integer> playersScore=new ArrayList<Integer>();
        for (Player aPlayer:players){
            playersScore.add(aPlayer.getScore());
        }
        return playersScore;
    }

    private void declareWinner() {
        Player winner = players.get(1);
        for(Player aPlayer: players) {
            if (aPlayer.getScore() > winner.getScore()) {
                winner = aPlayer;
            }
        }
        UI.Display.declareWinner(winner.name);
        exit(0);
    }
}
