package game;



import com.company.Main;
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
                            Color.YELLOW,/*, Color.CYAN, Color.PINK};*/};
    private ChanceCards chanceCards;
    private GUI_Field[] fields;

    public Game(Boolean test){
        initGUIFields();
        gui = new GUI(fields);
        board = new GameBoard(gui.getFields().length, gui.getFields());
        chanceCards = new ChanceCards(this);
        totalNumPlayers = 4;
        String[] playerNames = {"Thor", "Tobias", "Kian", "Sume"};
        playerList = new Player[totalNumPlayers];
        for(int i = 0; i < totalNumPlayers; i++){
            GUI_Car car = new GUI_Car();
            car.setPrimaryColor(colors[i]);
            Player p = new Player(playerNames[i], startBalance, startLocation, car);
            gui.addPlayer(p);
            playerList[i] = p;
            gui.getFields()[p.getLocation()].setCar(p, true);
        }
        cup = new DiceCup(1);
        playGame();
    }
    public Game() {
        initGUIFields();
        gui = new GUI(fields);
        board = new GameBoard(gui.getFields().length, gui.getFields());
        chanceCards = new ChanceCards(this);
        totalNumPlayers = gui.getUserInteger(Main.langStrings.getLine(0)+". 1-"+maxNumberOfPlayers,1,maxNumberOfPlayers);
        if(totalNumPlayers >1){
            addPlayers(totalNumPlayers);
        }
        else{
            addPlayers(1);
        }

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
                if(i%2 == 0 ){ //Only works with this size
                    switch (i){
                        case(6):
                            fields[i] = new GUI_Jail();
                        break;
                        case(12):
                            fields[i] = new GUI_Refuge();
                        break;
                        case(18):
                            fields[i] = new GUI_Jail();
                        break;
                    }
                }
                else {
                    fields[i] = new GUI_Chance();
                    fields[i].setSubText("Chancecard");
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
                gui.getUserButtonPressed(playerList[i].getName()+Main.langStrings.getLine(2),Main.langStrings.getLine(4));
                cup.rollDice();
                int a = cup.getDiceinCup().get(0).getValue();
//                int a = 3;
                gui.setDie(a);
                player.moveLocation(a, this);
                gui.getFields()[player.getLocation()].setCar(player, true);
                if (player.getBalance() >= 3000) {
                    winnerID = i;
                    break;
                }
/*                switch (player.getLocation()) {
                    case 2:
                        gui.showMessage(stringFlavourTile[2] + "250 gold");
                        break;
                    case 3:
                        gui.showMessage(stringFlavourTile[3] + "-100 gold");
                        break;
                    case 4:
                        gui.showMessage(stringFlavourTile[4] + "100 gold");
                        break;
                    case 5:
                        gui.showMessage(stringFlavourTile[5] + "-20 gold");
                        break;
                    case 6:
                        gui.showMessage(stringFlavourTile[6] + "180 gold");
                        break;
                    case 7:
                        gui.showMessage(stringFlavourTile[7] + "+ 0 gold");
                        break;
                    case 8:
                        gui.showMessage(stringFlavourTile[8] + "-70 gold");
                        break;
                    case 9:
                        gui.showMessage(stringFlavourTile[9] + "60 gold");
                        break;
                    case 10:
                        gui.showMessage(stringFlavourTile[10] + "-80 gold");
                        break;
                    case 11:
                        gui.showMessage(stringFlavourTile[11] + "-50 gold");
                        break;
                    case 12:
                        gui.showMessage(stringFlavourTile[12] + "650 gold");
                        break;
                    case 13:
                        gui.showMessage(stringFlavourTile[13] + "650 gold");
                        break;
                    case 14:
                        gui.showMessage(stringFlavourTile[14] + "650 gold");
                        break;
                    case 15:
                        gui.showMessage(stringFlavourTile[15] + "650 gold");
                        break;
                    case 16:
                        gui.showMessage(stringFlavourTile[16] + "650 gold");
                        break;
                    case 17:
                        gui.showMessage(stringFlavourTile[17] + "650 gold");
                        break;
                    case 18:
                        gui.showMessage(stringFlavourTile[18] + "650 gold");
                        break;
                    case 19:
                        gui.showMessage(stringFlavourTile[19] + "650 gold");
                        break;
                    case 20:
                        gui.showMessage(stringFlavourTile[20] + "650 gold");
                        break;
                    case 21:
                        gui.showMessage(stringFlavourTile[21] + "650 gold");
                        break;
                    case 22:
                        gui.showMessage(stringFlavourTile[22] + "650 gold");
                        break;
                    case 23:
                        gui.showMessage(stringFlavourTile[23] + "650 gold");
                        break;
                    case 24:
                        gui.showMessage(stringFlavourTile[24] + "650 gold");
                        break;
                }*/
            }
        }
        gui.showMessage(playerList[winnerID].getName()+Main.langStrings.getLine(3));
    }

    private void addPlayers(int a) {
        playerList = new Player[a];
        for (int i = 0; i < a; i++) {
            GUI_Car car = new GUI_Car();
            car.setPrimaryColor(colors[i]);

            Player p = new Player(gui.getUserString(Main.langStrings.getLine(1)+" "+(i+1)+"."), startBalance, startLocation, car);
            gui.addPlayer(p);
            playerList[i] = p;
            gui.getFields()[p.getLocation()].setCar(p, true);
        }
    }

    public Player[] getPlayerList() { return playerList; }

    public GUI getGui() {
        return gui;
    }

    public int getTotalNumPlayers() {
        return totalNumPlayers;
    }

    public GameBoard getBoard() {
        return board;
    }

    public void drawChance(Player player){
        chanceCards.DrawCard(player);
    }

    public int getNumberOfTiles(){return  numberOfTiles;}
}
