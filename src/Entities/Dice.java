package Entities;

import java.util.Random;

public class Dice {

    static int ticker = 0;
    static int roll;

    /*
    public static int roll() {
        Random rand = new Random(); //Make an instance of Random
        int roll = rand.nextInt(6) + 1; //Random int between [0;max[ +1 ... therefore [1;max]
        //int equalDiceValue = SidesNum[roll-1];
        return roll;
    }
    */

    public static int roll(){
        switch (ticker){
            case 0:
                roll = 0;
                ticker++;
                break;
            case 1:
                roll = 0;
                ticker++;
                break;
            case 3:
                roll = 0;
                ticker++;
                break;
            case 4:
                roll = 0;
                ticker++;
                break;
            case 5:
                roll = 0;
                ticker++;
                break;
            case 6:
                roll = 0;
                ticker++;
                break;
            case 7:
                roll = 0;
                ticker++;
                break;
            case 8:
                roll = 0;
                ticker++;
                break;
            case 9:
                roll = 0;
                ticker++;
                break;
            case 10:
                roll = 0;
                ticker++;
                break;
            case 11:
                roll = 0;
                ticker++;
                break;
            case 12:
                roll = 0;
                ticker++;
                break;

        }return roll;
    }
}
