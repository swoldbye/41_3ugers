package Controllers;

import Entities.Dice;
import Entities.PlayerArchetype;
import Entities.PlayerList;
import Boundary.GUI_Monopoly;
import gui_main.GUI;
import java.util.ArrayList;


public class GameTurn{
    public static GUI gui;



    // This controller checks if the game is still eligible to play
    public void checkTurn(){
        int run = 1;
       while (PlayerList.playerArr.size()>=2){
           // Start turn for every player sequentially
           playerTurn();
       }
    }

    public void playerTurn(){
        GUI_Monopoly instance = new GUI_Monopoly();
        for (int i=0;i<PlayerList.playerArr.size();i++){
            // For loop that runs a standard turn for each player.
            instance.rollButton(i);

            int roll1=Dice.roll();
            int roll2=Dice.roll();

            instance.dieSetter(roll1,roll2,i);
          //  PlayerList.playerArr[i].position += Dice.roll();
        }
        return;
    }
}
