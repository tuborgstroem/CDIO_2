

package game;


import  java.util.Random;

public class Dice {
    private int value;
    private Random rand;
    private int sides;

    public Dice(int numberOfSides){
        rand = new Random();

        sides = numberOfSides;
    }
    public Dice(){
        rand = new Random();
        sides = 6;
    }

    public int roll(){
        value = rand.nextInt(sides) + 1;
        return value;
    }

    public int getValue() {
        return value;
    }

    public int getSides(){
        return sides;
    }
}
