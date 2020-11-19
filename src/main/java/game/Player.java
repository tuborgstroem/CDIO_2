package game;

import gui_fields.*;

public class Player extends GUI_Player {

    //player variables
    private int location;
    final private Account account;
    private boolean bankrrupt;
    private boolean prison;
    private int getOutOfJailCards;

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
        bankrrupt = false;
        getOutOfJailCards = 0;
    }

    public boolean getBankrrupt(){ return this.bankrrupt;}

    //adds to gamescore
    public void addToBalance(int balanceGain) {
        this.setBalance(this.getBalance()+balanceGain) ;
    }

    public boolean withdrawFromBalance(int payment){
        int newBalance = this.getBalance() - payment;
        if (newBalance < 0){
            bankrrupt = true;
            return false;
        }
        else{
            this.setBalance(newBalance);
            return true;
        }
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
        landOnField(game.getBoard().getTiles()[location], game);
    }

    /*
     * This is what happens when a player lands on a new field
     * @param field the field the player lands on
     */
    private void landOnField(Tile tile, Game game) {
        Text textStrings = game.getTextStrings();
        tile.getGui_field().setCar(this, true);
        int tileRent;
        int ownerValue;
        int tempTileNumber;

        if(tile.getGui_field() instanceof GUI_Street) {

            textStrings.TileMessage(this);
            if (tile.getOwner() == null){
                buyTile(this, tile, false);
//                game.getGui().showMessage(this.getName() + " buys " + tile.getGui_field().getTitle() + " for " + Integer.toString(tile.getRent()));
            } else if (tile.getOwner() != this && tile.getOwner() != null) {
                GameBoard b = game.getBoard();
                tempTileNumber = b.getColorArray(tile.getTileColor())[0];
                if (b.getTiles()[tempTileNumber].getOwner() == b.getTiles()[(tempTileNumber+1)].getOwner()) {
                    tileRent = tile.getRent() * 2;
                } else {
                    tileRent = tile.getRent();
                }
                payRent(this, tile.getOwner(), tileRent);
//                game.getGui().showMessage(this.getName() + " pays " + Integer.toString(tileRent) + " to " + tile.getOwner().getName());
            }
        }
        else if(tile.getGui_field() instanceof GUI_Chance){
            game.drawChance(this);
        }
    }

    public void buyTile(Player player, Tile tile, boolean getFree){
        if(!getFree){
            if(this.withdrawFromBalance(tile.getRent())){
                tile.setOwner(this);
            }
        }
        else {
            tile.setOwner(this);
        }
    }

    public void payRent(Player fromPlayer, Player toPlayer, int amount){
        if (fromPlayer.withdrawFromBalance(amount)){
            toPlayer.addToBalance(amount);
        }
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

    public void setPrison(boolean prison) {
        this.prison=prison;
    }

    public void setInPrison(boolean b) { prison = b;}

    public void setGetOutOfJailCards(int amount){ getOutOfJailCards = amount;}

    public int getGetOutOfJailCards(){return getOutOfJailCards;}
}

