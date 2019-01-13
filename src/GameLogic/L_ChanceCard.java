package GameLogic;

import java.util.Random;
public class L_ChanceCard {

    public int chanceCardDeck(int position,int playerBalance){
        Random cardRand = new Random();
        int card = cardRand.nextInt(40);

        return card;
    }




}
