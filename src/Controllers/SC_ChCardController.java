package Controllers;

import Boundary.GUI_Monopoly;
import Entities.ChCardsArchetype;
import Entities.ChCardsList;
import Entities.PlayerArchetype;
import gui_fields.GUI_Player;

import java.util.ArrayList;

public class SC_ChCardController {

    ChCardsList deck = new ChCardsList();
    ChCardsArchetype[] cardList = deck.createChCardList();
    SC_ChanceCardEffect logicCard = new SC_ChanceCardEffect();

    public void cardController(int playerPosition , int playerBalance, GUI_Monopoly gui , ArrayList<PlayerArchetype> playerArr, int i , GUI_Player[] gui_playerList)
    {
        int var = logicCard.drawChCard();
        int newBalance = playerBalance;
        int newPosition = playerPosition;
        int cardAmount = cardList[var].getCardAmount();
        int cardEffect = cardList[var].getCardEffect();
        String cardMessage = cardList[var].getCardMessage();
        // TODO  send message to gui for player to read

        gui.chMessage(cardMessage);

        if (cardEffect==1) {
            newBalance = logicCard.ch_PayOrReceive(cardAmount, playerBalance);
            gui.payOrReceive(playerBalance, i, cardAmount , gui_playerList);
        }

        if (cardEffect==2){
            newPosition = logicCard.ch_Move(cardAmount , playerPosition);
            gui.movePlayer(i, playerPosition , newPosition , gui_playerList);

        }

        if (cardEffect==3){

            newPosition = logicCard.ch_MoveSpecific(cardAmount , playerPosition);
            if (playerPosition>cardAmount){
                newBalance += 4000;
                gui.passStart(i,newBalance,gui_playerList);
            }

            gui.movePlayer(i, playerPosition, newPosition , gui_playerList);
        }
        if (cardEffect==4){




        }

        if (cardEffect==5){
            newPosition = logicCard.ch_MoveShip(playerPosition);
            if(playerPosition == 36){
                newBalance += 4000;
                gui.passStart(i,newBalance,gui_playerList);
            }
            gui.movePlayer(i, playerPosition, newPosition , gui_playerList);
        }

        if (cardEffect==6){
            playerArr.get(i).setJailCard(playerArr.get(i).getJailCard()+1);
        }

        playerArr.get(i).setBalance(newBalance);
        playerArr.get(i).setPosition(newPosition);


    }



}
