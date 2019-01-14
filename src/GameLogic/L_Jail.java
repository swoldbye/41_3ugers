package GameLogic;

import Boundary.GUI_Monopoly;
import Entities.Dice;
import Entities.PlayerArchetype;
import gui_main.GUI;

import java.util.ArrayList;

public class L_Jail {
    /*
        slå 2 ens
        betal 1000
        vent 3 ture
    */
    public void inJail(int playerId, ArrayList<PlayerArchetype> playerArr, GUI_Monopoly guiInstance) {
        if (playerArr.get(playerId).getJailCounter() < 3) {
            if (playerArr.get(playerId).getBalance() >= 1000) {
                String answer = guiInstance.jailMessage(playerId);
                if (answer.equals("Ja")) {
                    int previousBalance = playerArr.get(playerId).getBalance();
                    playerArr.get(playerId).setBalance(previousBalance - 1000);
                    playerArr.get(playerId).setJailed(false);
                    playerArr.get(playerId).setJailCounter(0);
                } else if(answer.equals("Brug kort")){
                    int previousGetOutOfJail = playerArr.get(playerId).getJailCard();
                    playerArr.get(playerId).setJailCard(previousGetOutOfJail - 1);
                    playerArr.get(playerId).setJailed(false);
                    playerArr.get(playerId).setJailCounter(0);
                }
            }
            else{
                guiInstance.rollButton(playerId); // Prompts the user to roll
                int roll1= Dice.roll();
                int roll2=Dice.roll();
                guiInstance.dieSetter(roll1,roll2,playerId); // Sets the die (based on what you roll) in the gui
                if(roll1 == roll2){
                    playerArr.get(playerId).setJailed(false);
                }
                else{
                    playerArr.get(playerId).setJailCounter(playerArr.get(playerId).getJailCounter() + 1);
                }
            }
        }
        else{
         playerArr.get(playerId).setJailed(false);
         playerArr.get(playerId).setJailCounter(0);
        }
    }
}



