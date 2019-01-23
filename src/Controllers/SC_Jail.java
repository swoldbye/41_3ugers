package Controllers;

import Boundary.GUI_Monopoly;
import Boundary.GUI_PlayerList;
import Entities.Dice;
import Entities.PlayerArchetype;
import gui_fields.GUI_Player;
import gui_main.GUI;

import java.util.ArrayList;

public class SC_Jail {

    public boolean inJail(int playerId, ArrayList<PlayerArchetype> playerArr, GUI_Monopoly guiInstance, GUI_Player[] guiPlayerList) {
        boolean getTurn = true;
        String answer = null;
        if (playerArr.get(playerId).isJailed() == true) {
            if (playerArr.get(playerId).getJailCounter() < 3) {
                //player status 1.
                if (playerArr.get(playerId).getBalance() >= 1000 && playerArr.get(playerId).getJailCard() > 0) {
                    answer = guiInstance.jailMessage(1,playerId);
                } else if (playerArr.get(playerId).getBalance() >= 1000 && playerArr.get(playerId).getJailCard() == 0) {
                    answer = guiInstance.jailMessage(2, playerId);
                } else if (playerArr.get(playerId).getBalance() < 1000 && playerArr.get(playerId).getJailCard() > 0) {
                    answer = guiInstance.jailMessage(3, playerId);
                } else {
                    answer = guiInstance.jailMessage(4, playerId);
                }
                if (answer.equals("Ja")) {
                    int previousBalance = playerArr.get(playerId).getBalance();
                    playerArr.get(playerId).setBalance(previousBalance - 1000);
                    guiInstance.pullMoney(playerId, 1000, guiPlayerList);
                    playerArr.get(playerId).setJailed(false);
                    playerArr.get(playerId).setJailCounter(0);
                    getTurn = true;
                } else if (answer.equals("Brug kort")) {
                    playerArr.get(playerId).setJailed(false);
                    playerArr.get(playerId).setJailCounter(0);
                    getTurn = true;
                } else if (answer.equals("Nej")) {
                    guiInstance.rollButton(playerId); // Prompts the user to roll
                    int roll1 = Dice.roll();
                    int roll2 = Dice.roll();
                    guiInstance.dieSetter(roll1, roll2, playerId); // Sets the die (based on what you roll) in the gui
                    if (roll1 == roll2) {
                        playerArr.get(playerId).setJailed(false);
                        playerArr.get(playerId).setJailCounter(0);
                        getTurn = true;
                    } else {
                        playerArr.get(playerId).setJailCounter(playerArr.get(playerId).getJailCounter() + 1);
                        getTurn = false;
                    }
                }

            } else if (playerArr.get(playerId).getJailCounter() == 3) {
                playerArr.get(playerId).setJailed(false);
                playerArr.get(playerId).setJailCounter(0);
                getTurn = true;
            }
        }return  getTurn;
    }
}



