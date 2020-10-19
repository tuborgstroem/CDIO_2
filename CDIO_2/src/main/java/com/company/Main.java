package main.java.com.company;

import main.java.game.Game;
import main.java.game.RollTester;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner inp = new Scanner(System.in);
        String opt;
        while (true) {
            System.out.println("Please enter either 'Play' to play dice roll game or 'Test' to test results from 1000 rolls");
            opt = inp.nextLine();
            if (opt.equalsIgnoreCase("test")) {
                RollTester tester = new RollTester();
                tester.runRollLoop();
                tester.showResults();
            } else if (opt.equalsIgnoreCase("play")) {
                Game a = new Game(2, 2);
                break;

                //test af commit
                //test 2
                //Kians commit wowee
            }
        }

    }
}
