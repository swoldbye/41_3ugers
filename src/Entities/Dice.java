package Entities;

import java.util.Random;

public class Dice {


    public static int roll() {
        Random rand = new Random(); //Make an instance of Random
        int roll = rand.nextInt(6) + 1; //Random int between [0;max[ +1 ... therefore [1;max]
        //int equalDiceValue = SidesNum[roll-1];
        return roll;
    }
}
