package GameLogic;

import java.util.Random;
public class L_ChanceCard {

    public int drawChCard() {
        Random cardRand = new Random();
        int card = cardRand.nextInt(37);

        return card;
    }

    public int ch_PayOrReceive(int cardamount, int playerstartbalance) {
        int newbalance = playerstartbalance;
        newbalance += cardamount;
        return newbalance;
    }

    public int ch_Move(int cardamount, int playerstartposition) {
        int newPosition = playerstartposition;
        newPosition += cardamount;
        return newPosition;


    }

    public int ch_MoveSpecific(int cardamount, int playerstartposition) {
        int newPosition = playerstartposition;
        newPosition = cardamount;
        return newPosition;

    }

    public int ch_MoveShip(int playerstartposition) {
        int newPosition = playerstartposition;
        if (newPosition == 2 || newPosition == 36) {
            newPosition = 5;
        }
        if (newPosition == 7) {
            newPosition = 15;
        }
        if (newPosition == 17 || newPosition == 22) {
            newPosition = 25;
        }
        if (newPosition == 33) {
            newPosition = 35;
        }
        return newPosition;
    }
}
