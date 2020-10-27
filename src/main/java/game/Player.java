package game;

import gui_fields.GUI_Car;
import gui_fields.GUI_Player;

public class Player {

    //player variables
    private String name;
    private int balance;
    private int location;
    private GUI_Player playerGUI;
    private GUI_Car car;

    //constructs player
//    public Player(int id){this.id = id; location = 1;}


    /**
     *
     * @param playerName The name of the player string
     * @param playerBalance The amount of money the player starts with
     * @param startLocation The tile the player starts on
     * @param gui_player The GUI implementation of the player
     * @param playerCar The GUI implementation for the car
     */
    public Player(String playerName, int playerBalance, int startLocation, GUI_Player gui_player, GUI_Car playerCar){
        this.name = playerName;
        this.balance = playerBalance;
        this.location = startLocation;
        this.playerGUI = gui_player;

    }
    //returns playerid
//    public int getId() {
//        return id;
//    }

    //returns playername
    public String getName() {
        return name;
    }

    //sets playername
    public void setName(String name) {
        this.name = name;
    }

    //returns playerscore
    public int getBalance() {
        return balance;
    }

    //sets gamescore
    public void setBalance(int newBalance) {
        this.balance = newBalance;
    }

    //adds to gamescore
    public void addToBalance(int balanceGain) {
        this.balance += balanceGain;
    }

    //returns playerstring
//    public String toString() {
//        return id + "";
//    }

    //returns player location
    public int getLocation() { return location;}

    //set location
    public void setLocation(int newLocation){
        location = newLocation;
    }

    //move x tiles
    public void moveLocation(int moveNumber){

        location =+ moveNumber;
        setBalance(location);
        while (location > 12) {
            location -= 11;
        }
    }

    //Set the player's GUI_player
    public void setGUIPlayer(GUI_Player gui_player) { this.playerGUI = gui_player; }
}
