package game;



import gui_fields.GUI_Car;
import gui_main.GUI;

import java.awt.*;
import java.util.Scanner;

import static game.englishFlavourStrings.stringFlavourTile;

public class Game implements englishStrings {
    private final int totalNumPlayers;
    private int totalNumDice;
    private Player[] playerList;
    private DiceCup cup;
    private GameBoard board;
    private GUI gui;
    private final int startBalance = 1000;
    private final int startLocation = 0;
    private final int numberOfTiles = 13;
    private final Color[] colors= {Color.RED, Color.BLUE, Color.GREEN,
                            Color.YELLOW, Color.CYAN, Color.PINK};

    public Game() {
        gui = new GUI();
        board = new GameBoard(numberOfTiles, gui.getFields());
        Scanner inp = new Scanner(System.in);
        int opt;
        System.out.println(stringNumberOfPlayers);
        opt = inp.nextInt();
        if (opt > 6){
            totalNumPlayers = 6;
        } else if (opt < 1) {
            totalNumPlayers = 1;
        } else {
            totalNumPlayers = opt;
        }

        addPlayers(totalNumPlayers);
        cup = new DiceCup(2);
        playGame();
    }

    public void playGame() {
        int winnerID = -1;

        while (winnerID == -1) //Game loop till winner is found
        {
            for (int i = 0; i < playerList.length; i++) {   //A full round
                Player player = playerList[i];
                gui.showMessage(player.getName()+stringNextTurn);
                //Scuffed way of awaiting user input(click)..
                cup.rollDice();
                int a = cup.getDiceinCup().get(0).getValue();
                int b = cup.getDiceinCup().get(1).getValue();
                gui.setDice(a,b);
                player.moveLocation(a+b, this);
                gui.getFields()[player.getLocation()].setCar(player, true);
                if (player.getBalance() >= 3000) {
                    winnerID = i;
                    break;
                }
                if (board.getTiles()[player.getLocation()].getExtraTurn()) {
                    gui.showMessage(player.getName()+stringExtraTurn);
                    i--;
                }
                switch (player.getLocation()) {
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
                }
            }
        }
        gui.showMessage(playerList[winnerID].getName()+stringPlayerWon);
    }

    private void addPlayers(int a) {
        Scanner input = new Scanner(System.in);
        playerList = new Player[a];
        for (int i = 0; i < a; i++) {
            System.out.println(stringEnterPlayerNamesA+i+stringEnterPlayerNamesB);
            String name = input.nextLine();
            GUI_Car car = new GUI_Car();
            car.setPrimaryColor(colors[i]);

            Player p = new Player(name, startBalance, startLocation, car);
            gui.addPlayer(p);
            playerList[i] = p;
            gui.getFields()[p.getLocation()].setCar(p, true);
        }
        input.close();
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
