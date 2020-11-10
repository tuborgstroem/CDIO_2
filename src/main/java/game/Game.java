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
    //private final int numberOfTiles = 25;
    private final int maxNumberOfPlayers = 4;
    private final Color[] colors= {Color.RED, Color.BLUE, Color.GREEN,
                            Color.YELLOW, Color.CYAN, Color.PINK};
    GUI_Field[] fields = {
            new GUI_Start(),
            new GUI_Street(),
            new GUI_Street(),
            new GUI_Chance(),
            new GUI_Street(),
            new GUI_Street(),
            new GUI_Jail(),
            new GUI_Street(),
            new GUI_Street(),
            new GUI_Chance(),
            new GUI_Street(),
            new GUI_Street(),
            new GUI_Street(),   //Special
            new GUI_Street(),
            new GUI_Street(),
            new GUI_Chance(),
            new GUI_Street(),
            new GUI_Street(),
            new GUI_Street(),   //Special
            new GUI_Street(),
            new GUI_Street(),
            new GUI_Chance(),
            new GUI_Street(),
            new GUI_Street()
    };

    public Game() {
        gui = new GUI(fields);
        totalNumPlayers = gui.getUserInteger("Enter number of players. 1-4.",1,maxNumberOfPlayers);

        board = new GameBoard(gui.getFields().length, gui.getFields());
        addPlayers(totalNumPlayers);
        cup = new DiceCup(1);
        playGame();
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
