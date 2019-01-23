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
                roll = 5;
                ticker++;
                break;
            case 1:
                roll = 6;
                ticker++;
                break;

            case 2:
                roll = 5;
                ticker++;
                break;
            case 3:
                roll = 5;
                ticker++;
                break;

            case 4:
                roll = 3;
                ticker++;
                break;
            case 5:
                roll = 2;
                ticker++;
                break;

            case 6:
                roll = 1;
                ticker++;
                break;
            case 7:
                roll = 1;
                ticker++;
                break;

            case 8:
                roll = 6;
                ticker++;
                break;
            case 9:
                roll = 6;
                ticker++;
                break;

            case 10:
                roll = 5;
                ticker++;
                break;
            case 11:
                roll = 5;
                ticker++;
                break;

            case 12:
                roll = 3;
                ticker++;
                break;
            case 13:
                roll = 1;
                ticker++;
                break;

            case 14:
                roll = 5;
                ticker++;
                break;
            case 15:
                roll = 3;
                ticker++;
                break;

            case 16:
                roll = 6;
                ticker++;
                break;
            case 17:
                roll = 4;
                ticker++;
                break;

            case 18:
                roll = 6;
                ticker++;
                break;
            case 19:
                roll = 6;
                ticker++;
                break;

            case 20:
                roll = 1;
                ticker++;
                break;
            case 21:
                roll = 2;
                ticker++;
                break;

            case 22:
                roll = 5;
                ticker++;
                break;
            case 23:
                roll = 5;
                ticker++;
                break;

            case 24:
                roll = 2;
                ticker++;
                break;
            case 25:
                roll = 2;
                ticker++;
                break;

            case 26:
                roll = 1;
                ticker++;
                break;
            case 27:
                roll = 1;
                ticker++;
                break;

            case 28:
                roll = 4;
                ticker++;
                break;
            case 29:
                roll = 6;
                ticker++;
                break;

            case 30:
                roll = 1;
                ticker++;
                break;
            case 31:
                roll = 6;
                ticker++;
                break;

            case 32:
                roll = 6;
                ticker++;
                break;
            case 33:
                roll = 6;
                ticker++;
                break;

            case 34:
                roll = 5;
                ticker++;
                break;
            case 35:
                roll = 2;
                ticker++;
                break;

            case 36:
                roll = 2;
                ticker++;
                break;
            case 37:
                roll = 5;
                ticker++;
                break;

            case 38:
                roll = 5;
                ticker++;
                break;
            case 39:
                roll = 2;
                ticker++;
                break;

            case 40:
                roll = 2;
                ticker++;
                break;
            case 41:
                roll = 3;
                ticker++;
                break;

            case 42:
                roll = 2;
                ticker++;
                break;
            case 43:
                roll = 1;
                ticker++;
                break;

            case 44:
                roll = 1;
                ticker++;
                break;
            case 45:
                roll = 2;
                ticker++;
                break;

            case 46:
                roll = 5;
                ticker++;
                break;
            case 47:
                roll = 6;
                ticker++;
                break;

            case 48:
                roll = 5;
                ticker++;
                break;
            case 49:
                roll = 1;
                ticker++;
                break;

            case 50:
                roll = 1;
                ticker++;
                break;
            case 51:
                roll = 1;
                ticker++;
                break;

            case 52:
                roll = 4;
                ticker++;
                break;
            case 53:
                roll = 5;
                ticker++;
                break;

            case 54:
                roll = 2;
                ticker++;
                break;
            case 55:
                roll = 2;
                ticker++;
                break;

            case 56:
                roll = 3;
                ticker++;
                break;
            case 57:
                roll = 2;
                ticker++;
                break;

            case 58:
                roll = 5;
                ticker++;
                break;
            case 59:
                roll = 2;
                ticker++;
                break;

            case 60:
                roll = 5;
                ticker++;
                break;
            case 61:
                roll = 5;
                ticker++;
                break;

            case 62:
                roll = 5;
                ticker++;
                break;
            case 63:
                roll = 4;
                ticker++;
                break;

            case 64:
                roll = 3;
                ticker++;
                break;
            case 65:
                roll = 4;
                ticker++;
                break;

            case 66:
                roll = 1;
                ticker++;
                break;
            case 67:
                roll = 1;
                ticker++;
                break;

            case 68:
                roll = 1;
                ticker++;
                break;
            case 69:
                roll = 1;
                ticker++;
                break;

        }return roll;
    }
}
