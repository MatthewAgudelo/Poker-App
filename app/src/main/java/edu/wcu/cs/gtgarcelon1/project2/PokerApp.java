package edu.wcu.cs.gtgarcelon1.project2;

import android.app.Application;

import edu.wcu.cs.gtgarcelon1.project2.poker.PokerGame;

/**
 * @author Matthew Agudelo
 * This is the application class for this app
 */
public class PokerApp extends Application {

    public static final String PLAYER_NAME = "player-name";
    private String playerName = "Player";
    private int playerBalance = 0;
    private int numGamesPlayed = 0;
    private PokerGame game;
    private boolean dealt = false;

    public void setPlayerName(String playerName) {
        this.playerName = playerName;
    }

    public String getPlayerName() {
        return this.playerName;
    }

    public void increaseBalence(int incrementAmount) {
        playerBalance += incrementAmount;
    }

    public void decreaseBalence(int incrementAmount) {
        playerBalance += incrementAmount;
    }

    public int getPlayerBalance() {
        return playerBalance;
    }

    public void incrementGamesPlayed() {
        numGamesPlayed++;
    }

    public int getGamesPlayed() {
        return numGamesPlayed;
    }

    public PokerGame getGame() {
        if (game == null) {
            game = new PokerGame();
        }
        return game;
    }

    public boolean getDealt() {
        return dealt;
    }

    public void setDealt(boolean dealt) {
        this.dealt = dealt;
    }


}
