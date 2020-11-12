package game;



import gui_fields.*;
import gui_main.GUI;

import java.awt.*;

public class Game implements englishStrings {
    private final int totalNumPlayers;
    private Player[] playerList;
    private DiceCup cup;
    private GameBoard board;
    private GUI gui;
    private final int startBalance = 1000;
    private final int startLocation = 0;
    private final int numberOfTiles = 24;
    private final int maxNumberOfPlayers = 4;
    private final int chancePerSide = 1;
    private final Color[] colors= {Color.RED, Color.BLUE, Color.GREEN,
                            Color.YELLOW,/*, Color.CYAN, Color.PINK};*/Color.PINK};
    GUI_Field[] fields;

    public Game() {
        initGUIFields();
        gui = new GUI(fields);
        totalNumPlayers = gui.getUserInteger("Enter number of players. 1-4.",1,maxNumberOfPlayers);

        board = new GameBoard(gui.getFields().length, gui.getFields());
        addPlayers(totalNumPlayers);
        cup = new DiceCup(1);
        playGame();
    }

    private void initGUIFields() {
        fields = new GUI_Field[numberOfTiles];
        int sideLength = numberOfTiles/4;
        final int chanceFreq = sideLength/(chancePerSide*2);
        int i =0;
        fields[i] = new GUI_Start();
        for( i = 1; i<numberOfTiles; i++){
            if(i%chanceFreq == 0){
                if(i%2 == 0){ //Only works with this size
                    switch (i){
                        case(6):
                            fields[i] = new GUI_Jail();
                        break;
                        case(12):
                            fields[i] = new GUI_Refuge();
                        break;
                        case(18):
                            fields[i] = new GUI_Jail();
                            fields[i].setSubText("Go to Jail!");
                        break;
                    }
                }
                else {
                    fields[i] = new GUI_Chance();
                }
            }
            else{
                fields[i]= new GUI_Street();
            }

        }
    }

    public void playGame() {
        int winnerID = -1;

        while (winnerID == -1) //Game loop till winner is found
        {
            for (int i = 0; i < playerList.length; i++) {   //A full round
                Player player = playerList[i];
                gui.getUserButtonPressed("Player "+(i+1)+"'s turn.","Roll");
                cup.rollDice();
                int a = cup.getDiceinCup().get(0).getValue();
                gui.setDie(a);
                player.moveLocation(a, this);
                gui.getFields()[player.getLocation()].setCar(player, true);
                if (player.getBalance() >= 3000) {
                    winnerID = i;
                    break;
                }
                if (board.getTiles()[player.getLocation()].getExtraTurn()) {
                    gui.showMessage(player.getName()+stringExtraTurn);
                    i--;
                }
            }
        }
        gui.showMessage(playerList[winnerID].getName()+stringPlayerWon);
    }

    private void addPlayers(int a) {
        //Scanner input = new Scanner(System.in);
        playerList = new Player[a];
        for (int i = 0; i < a; i++) {
            //System.out.println(stringEnterPlayerNamesA+i+stringEnterPlayerNamesB);
            //String name = input.nextLine();
            GUI_Car car = new GUI_Car();
            car.setPrimaryColor(colors[i]);
            System.out.println("FOLLOWING SHOULD BE CHANGED TO STRING VARIABLE FROM INTERFACE!!!!!");
            Player p = new Player(gui.getUserString("Enter name of player "+(i+1)), startBalance, startLocation, car);
            gui.addPlayer(p);
            playerList[i] = p;
            gui.getFields()[p.getLocation()].setCar(p, true);
        }
        //input.close();
    }

    public Player[] getPlayerList() {

        return playerList;
    }

    public GUI getGui() {
        return gui;
    }

    public int getTotalNumPlayers() {
        return totalNumPlayers;
    }

    public GameBoard getBoard() {
        return board;
    }
}
