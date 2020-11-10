package game;

import gui_fields.GUI_Car;
import gui_fields.GUI_Field;
import gui_fields.GUI_Player;

public class Player extends GUI_Player {

    //player variables
    private int balance;
    private int location;
    private Account account;

    /**
     *
     * @param playerName The name of the player string
     * @param playerBalance The amount of money the player starts with
     * @param startLocation The tile the player starts on
     * @param playerCar The GUI implementation for the car
     */
    public Player(String playerName, int playerBalance, int startLocation, GUI_Car playerCar){
        super(playerName, playerBalance, playerCar);
        this.location = startLocation;
        account = new Account(playerBalance);
    }

    //adds to gamescore
    public void addToBalance(int balanceGain) {
        this.balance += balanceGain;
    }


    //returns player location
    public int getLocation() { return location;}

    //set location
    public void setLocation(int newLocation){
        location = newLocation;
    }

    /**
     *
     * @param moveNumber How many tiles should the player be moved?
     * @param game the game class for redrawing the cars in the gui
     */
    public void moveLocation(int moveNumber, Game game){
        removeOneCar(game);
        location += moveNumber;
        while (location >= 24) {
            location -= 24;
        }
        landOnField(game.getBoard().getTiles()[location]);
    }

    /**
     * This is what happens when a player lands on a new field
     * @param field the field the player lands on
     */
    private void landOnField(Tile tile) {
        tile.getGui_field().setCar(this, true);
        //int playerValue = getBalance()+tile.getEffect();
        int playerValue = account.getBalance()+tile.getEffect();
        account.setBalance(playerValue);
        setBalance(playerValue);
    }

    /**
     * removes the players car from the field and redraws the others
     * @param game the game
     */
    private void removeOneCar(Game game){
        GUI_Field field = game.getGui().getFields()[location];
        Player replaceCars[] = new Player[game.getTotalNumPlayers()];
        int j= 0;
        for(int i =0; i < game.getPlayerList().length; i++ ){
            if (field.hasCar(game.getPlayerList()[i]) & !game.getPlayerList()[i].getName().equals(this.getName()) ){
                replaceCars[j] = game.getPlayerList()[i];
                j++;
            }
        }
        field.removeAllCars();
        if (replaceCars.length > 0){
            for(int i =0; i < replaceCars.length; i++){
                if(replaceCars[i] != null){
                    field.setCar(replaceCars[i], true);
                }
            }
        }
    }
}

