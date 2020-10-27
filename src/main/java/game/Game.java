package game;



import gui_fields.GUI_Car;
import gui_fields.GUI_Player;
import gui_main.GUI;
import main.java.game.DiceCup;
import main.java.game.GameBoard;

import java.awt.*;
import java.util.ArrayList;
import java.util.Scanner;

public class Game implements englishStrings {
    private int totalNumPlayers;
    private int totalNumDice;
    private Player[] playerList;
    private DiceCup cup;
    private GameBoard board;
    private Color[] colors = {Color.BLUE, Color.RED};
    GUI gui;
    private final int startBalance = 1000;
    private final int startLocation = 1;

    public Game() {
        gui = new GUI();
        System.out.println("hej");
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
        initGUI();
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
//                int a = 0;
//                int b = 0;

                int a = cup.getDiceinCup().get(0).getValue();
                int b = cup.getDiceinCup().get(1).getValue();
                gui.setDice(a,b);
//                gui.removeCar(player.getLocation(), player.getName());

//
//                if (a == b) {
//                    if (a == 1) {
//                        playerList.get(i).setGameScore(0);
//                        gui.showMessage(playerList.get(i).getName()+stringPointReset);
//                    } else {
//                        playerList.get(i).addToScore(cup.getSum());
//                    }
//                } else {
//                    playerList.get(i).addToScore(cup.getSum());
//                }

//                gui.setBalance(player.getName(),player.getGameScore());
                player.moveLocation(a+b);
//                gui.setCar(player.getLocation(), player.getName());
                if (player.getBalance() >= 40) {
                    winnerID = i;
                    break;
                }
            }
        }
//        gui.showMessage(playerList.get(winnerID).getName()+stringPlayerWon);
    }

    private void initGUI() {

    }

    private void addPlayers(int a) {
        Scanner input = new Scanner(System.in);
        playerList = new Player[a];
        for (int i = 0; i < a; i++) {
            System.out.println(stringEnterPlayerNamesA+i+stringEnterPlayerNamesB);
            String name = input.nextLine();
            GUI_Car car = new GUI_Car();
            GUI_Player gui_player = new GUI_Player(name, startBalance ,car);
            gui.addPlayer(gui_player);
            Player p = new Player(name, startBalance, startLocation, gui_player, car);
            playerList[i] = p;
        }
        input.close();
    }



}
