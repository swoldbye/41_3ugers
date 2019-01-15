package GameLogic;

import Boundary.GUI_Monopoly;
import Entities.Dice;
import Entities.PlayerArchetype;
import gui_main.GUI;

import java.util.ArrayList;

public class L_Jail {

    public void inJail(int playerId, ArrayList<PlayerArchetype> playerArr, GUI_Monopoly guiInstance) {
        String answer = null;
        if (playerArr.get(playerId).isJailed()) {
            if (playerArr.get(playerId).getJailCounter() < 4) {
                //player status 1.
                if (playerArr.get(playerId).getBalance() >= 1000 && playerArr.get(playerId).getJailCard() > 0) {
                    answer = guiInstance.jailMessage(playerId, 1);
                } else if (playerArr.get(playerId).getBalance() >= 1000 && playerArr.get(playerId).getJailCard() == 0) {
                    answer = guiInstance.jailMessage(playerId, 2);
                } else if (playerArr.get(playerId).getBalance() < 1000 && playerArr.get(playerId).getJailCard() > 0) {
                    answer = guiInstance.jailMessage(playerId, 3);
                } else {
                    answer = guiInstance.jailMessage(playerId, 4);
                }
                if (answer.equals("Ja")) {
                    int previousBalance = playerArr.get(playerId).getBalance();
                    playerArr.get(playerId).setBalance(previousBalance - 1000);
                    playerArr.get(playerId).setJailed(false);
                    playerArr.get(playerId).setJailCounter(0);
                } else if (answer.equals("Brug kort")) {
                    playerArr.get(playerId).setJailed(false);
                    playerArr.get(playerId).setJailCounter(0);
                } else if (answer.equals("Nej")) {
                    guiInstance.rollButton(playerId); // Prompts the user to roll
                    int roll1 = Dice.roll();
                    int roll2 = Dice.roll();
                    guiInstance.dieSetter(roll1, roll2, playerId); // Sets the die (based on what you roll) in the gui
                    if (roll1 == roll2) {
                        playerArr.get(playerId).setJailed(false);
                        playerArr.get(playerId).setJailCounter(0);
                    } else {
                        playerArr.get(playerId).setJailCounter(playerArr.get(playerId).getJailCounter() + 1);
                    }
                }

            } else if (playerArr.get(playerId).getJailCounter() == 4) {
                playerArr.get(playerId).setJailed(false);
                playerArr.get(playerId).setJailCounter(0);
            }
        }
    }
}



