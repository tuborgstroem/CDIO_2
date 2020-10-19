package main.java.game;


public class RollTester {
    private int totalThrows;
    private int numDice = 2;
    private int sum;
    private int pairs;
    private int sum2, sum3, sum4, sum5, sum6, sum7, sum8, sum9, sum10, sum11, sum12;
    public RollTester(int numberOfThrows){
        totalThrows = numberOfThrows;
    }

    public RollTester() {
        totalThrows = 1000;
    }

    public void runRollLoop() {

        int diceA, diceB;
        pairs = 0;
        DiceCup cup = new DiceCup(2);
        for (int i = 0; i < totalThrows; i++) {
            cup.rollDice();
            diceA = cup.getDiceinCup().get(0).getValue();
            diceB = cup.getDiceinCup().get(1).getValue();
            sum += diceA + diceB;
            if (diceA == diceB) {
                pairs++;
            }
            switch (diceA + diceB) {
                case 2:
                    sum2++;
                     break;
                case 3:
                    sum3++;
                    break;
                case 4:
                    sum4++;
                    break;
                case 5:
                    sum5++;
                    break;
                case 6:
                    sum6++;
                    break;
                case 7:
                    sum7++;
                    break;
                case 8:
                    sum8++;
                    break;
                case 9:
                    sum9++;
                    break;
                case 10:
                    sum10++;
                    break;
                case 11:
                    sum11++;
                    break;
                case 12:
                    sum12++;
                    break;

            }


        }

    }

    public void showResults(){

        System.out.println("Total number of throws with two dice: "+totalThrows);
        System.out.println("Total sum of dice throws: "+sum);

        System.out.println("Total number of pairs: "+pairs);

        System.out.println("Total number of sums of 2: "+sum2);
        System.out.println("Total number of sums of 3: "+sum3);
        System.out.println("Total number of sums of 4: "+sum4);
        System.out.println("Total number of sums of 5: "+sum5);
        System.out.println("Total number of sums of 6: "+sum6);
        System.out.println("Total number of sums of 7: "+sum7);
        System.out.println("Total number of sums of 8: "+sum8);
        System.out.println("Total number of sums of 9: "+sum9);
        System.out.println("Total number of sums of 10: "+sum10);
        System.out.println("Total number of sums of 11: "+sum11);
        System.out.println("Total number of sums of 12: "+sum12);
    }

    public int getSum(){
        return sum;
    }

    public int getPairs(){
        return pairs;
    }

}



