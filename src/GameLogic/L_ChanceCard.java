package GameLogic;

import java.util.Random;
public class L_ChanceCard {

    public int drawChCard() {
        Random cardRand = new Random();
        int card = cardRand.nextInt(40);

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
            newPosition = 17;
        }
        if (newPosition == 19 || newPosition == 24) {
            newPosition = 26;
        }
        if (newPosition == 33) {
            newPosition = 35;
        }
        return newPosition;
    }
}
