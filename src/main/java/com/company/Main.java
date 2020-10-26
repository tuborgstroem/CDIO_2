package main.java.com.company;

import main.java.game.Game;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner inp = new Scanner(System.in);
        String opt;
        while (true) {
            System.out.println("Please enter 'Play' to play dice roll game");
            opt = inp.nextLine();
            if (opt.equalsIgnoreCase("play")) {
                Game a = new Game(2, 2);
                break;
            }
        }
    }
}
