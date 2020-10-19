package main.java.game;

public class Player {

    /* player id
     * player name
     * player's score in the game */
    private int id;
    private String name;
    private int score;

    /*
     * Constructs a new Player with the specified id.
     *
     * @param id player's id
     */
    public Player(int id) {
        this.id = id;
    }

    /*
     * Returns the id of player.
     *
     * @return player's id
     */
    public int getId() {
        return id;
    }

    /*
     * Returns the name of player.
     *
     * @return player's name
     */
    public String getName() {
        return name;
    }

    /*
     * Sets the name of player using the given parameter value.
     *
     * @param name value used to set the name of player
     */
    public void setName(String name) {
        this.name = name;
    }

    /*
     * Returns the player's score in the game.
     *
     * @return player's score in the game
     */
    public int getGameScore() {
        return score;
    }

    /*
     * Sets the game score of a player.
     *
     * @param score value used to set the game score of player
     */
    public void setGameScore(int newScore) {
        this.score = newScore;
    }

    /*
     * Add to score
     *
     * @param new score gain
     */
    public void addToScore(int scoreGain) {
        this.score += scoreGain;
    }

    /*
     * Returns a String representing a player.
     *
     * @return string form of this player
     */
    public String toString() {
        return id + "";
    }
}
