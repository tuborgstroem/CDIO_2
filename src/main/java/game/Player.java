package main.java.game;

public class Player {

    //player variables
    private int id;
    private String name;
    private int score;

    //constructs player
    public Player(int id) {
        this.id = id;
    }

    //returns playerid
    public int getId() {
        return id;
    }

    //returns playername
    public String getName() {
        return name;
    }

    //sets playername
    public void setName(String name) {
        this.name = name;
    }

    //returns playerscore
    public int getGameScore() {
        return score;
    }

    //sets gamescore
    public void setGameScore(int newScore) {
        this.score = newScore;
    }

    //adds to gamescore
    public void addToScore(int scoreGain) {
        this.score += scoreGain;
    }

    //returns playerstring
    public String toString() {
        return id + "";
    }
}
