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
        int newbalance = playerstartposition;
        newbalance += cardamount;
        return newbalance;


    }
}
