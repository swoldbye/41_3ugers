package Controllers;

import Boundary.GUI_Monopoly;
import Entities.Dice;
import Entities.PlayerArchetype;
import Entities.PlayerList;
import gui_fields.GUI_Player;
import GameLogic.*;
import sun.rmi.runtime.Log;

import java.util.ArrayList;

public class GameTurn{
    L_ChanceCard Logic_chancecard = new L_ChanceCard();
    L_CheckField Logic_checkfield = new L_CheckField();
    L_Jail Logic_jail = new L_Jail();
    L_PropertyManagement Logic_propertymanagement = new L_PropertyManagement();

    // This method checks if the game is still eligible to play. You need to be at least 2 players
    public void checkTurn(ArrayList<PlayerArchetype> playerArr, GUI_Player[] gui_playerList, GUI_Monopoly guiInstance){
       while (playerArr.size()>=2){
           // Calls the playerTurn method
           playerTurn(playerArr, gui_playerList, guiInstance);
       }
       // The while loop ends when there is only 1 player left, the winner. Then we prompt the winMessage
        guiInstance.winMessage(); // Is displayed when there is only 1 player left (the winner :D)
    }
    // This method plays the turn for each player.
    public void playerTurn(ArrayList<PlayerArchetype> playerArr,GUI_Player[] gui_playerList,GUI_Monopoly guiInstance){
        // For loop that runs a standard turn for each player.
        for (int i=0;i<PlayerList.playerArr.size();i++) {
            // Check the current position of the player before he rolls the dice
            int oldPosition = playerArr.get(i).getPosition();
            // 1) Check if the person is in jail.
            Logic_jail.checkJail(playerArr);

            // 2) If the player owns all properties within one group, ask if he wants to buy houses
            Logic_propertymanagement.ownsGroup(playerArr);

            // 3) The player rolls the dice
            guiInstance.rollButton(i); // Prompts the user to roll
            int roll1=Dice.roll();
            int roll2=Dice.roll();
            guiInstance.dieSetter(roll1,roll2,i); // Sets the die on of the rolls in the gui

            // 4) Checks if the player crosses the start
            Logic_checkfield.checkStart(playerArr,oldPosition,i,roll1,roll2);
            int actualPosition = Logic_checkfield.setNewPosition(playerArr,oldPosition,i,roll1,roll2);
            guiInstance.movePlayer(i,oldPosition,actualPosition, gui_playerList); // Moves the player in gui
            Logic_checkfield.checkPosition(playerArr,i);

        }
    }
}
