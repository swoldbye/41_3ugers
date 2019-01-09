package Controllers;

import Entities.PlayerArchetype;
import Entities.PlayerList;
import Boundary.GUI_Monopoly;
public class GameTurn{

    // This controller checks if the game is still eligible to play
    public void checkTurn(){
        int run = 1;
       while (PlayerList.playerArr.size()>=2){
           // Start turn for every player sequentially
           playerTurn();
       }
    }

    public void playerTurn(){
        for (int i=0;i<PlayerList.playerArr.size();i++){
            // For loop that runs a standard turn for each player.

        }
        return;
    }
}
