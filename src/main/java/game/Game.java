package main.java.game;

import desktop_resources.GUI;

import java.util.ArrayList;
import java.util.Scanner;

public class Game {
    private int totalNumPlayers;
    private int totalNumDice;
    private ArrayList<Player> playerList;
    private DiceCup cup;
    private GameBoard board;
    public Game(int totalNumPlayers, int totalNumDice) {
        if (totalNumPlayers > 6){
            totalNumPlayers = 6;
        } else if (totalNumPlayers < 1) {
            totalNumPlayers = 1;
        }
        addPlayers(totalNumPlayers);
        cup = new DiceCup(totalNumDice);
        initGUI();
        playGame();
    }

    public void playGame() {
        int winnerID = -1;

        while (winnerID == -1) //Game loop till winner is found
        {
            for (int i = 0; i < playerList.size(); i++) {   //A full round
                GUI.showMessage(playerList.get(i).getName()+"'s turn, press OK to roll dice");
                //Scuffed way of awaiting user input(click)..

                cup.rollDice();
                int a = cup.getDiceinCup().get(0).getValue();
                int b = cup.getDiceinCup().get(1).getValue();
                GUI.setDice(a,b);

                if (a == b) {
                    if (a == 1) {
                        playerList.get(i).setGameScore(0);
                        GUI.showMessage("Oh no "+playerList.get(i).getName()+"'s points have been reset to 0 for throwing two 1's!");
                    } else {
                        playerList.get(i).addToScore(cup.getSum());
                    }
                } else {
                    playerList.get(i).addToScore(cup.getSum());
                }

                GUI.setBalance(playerList.get(i).getName(),playerList.get(i).getGameScore());
                if (playerList.get(i).getGameScore() >= 40) {
                    winnerID = i;
                    break;
                }
            }
        }
        GUI.showMessage(playerList.get(winnerID).getName()+" has won the game, congratulations!");
    }

    private void initGUI() {
        for (int i = 0; i < playerList.size(); i++) {
//            Color.
            GUI.addPlayer(playerList.get(i).getName(),0 );
            GUI.setCar(i+1, playerList.get(i).getName());
        }
    }

    private void addPlayers(int a) {
        Scanner input = new Scanner(System.in);
        playerList = new ArrayList<Player>();
        for (int i = 1; i <= a; i++) {
            Player p = new Player(i);
            System.out.println("Please enter name of Player "+i+" and press Enter");
            p.setName(input.nextLine());
            playerList.add(p);
        }
        input.close();
    }


}
