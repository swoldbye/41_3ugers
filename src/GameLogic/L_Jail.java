package GameLogic;

import Boundary.GUI_Monopoly;
import Entities.PlayerArchetype;
import gui_main.GUI;

import java.util.ArrayList;

public class L_Jail {
    /*
        slå 2 ens
        betal 1000
        vent 3 ture
    */
    public void inJail(int playerId, ArrayList<PlayerArchetype> playerArr, GUI gui) {
        if (playerArr.get(playerId).getJailCounter() < 3) {
            if (playerArr.get(playerId).getBalance() >= 1000) {
                String answer = gui.getUserSelection("Vil du betale 1000kr. for at komme ud?", "Nej", "Ja", "Brug kort");
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
                } else{
                    
                    //du skal rulle igen
                    //hvis du ruller 2 ens så ud af fængsel
                    //hvis ikke så JailCounter++
                }
            }
        }
    }
}

