package Controllers;

import Boundary.GUI_Monopoly;
import Entities.Dice;
import Entities.PlayerArchetype;
import Entities.PlayerList;
import gui_fields.GUI_Player;

import java.util.ArrayList;


public class GameTurn{
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
            //    TODO : Call jail method

            // 2) If the player owns all properties within one group, ask if he wants to buy houses
            //   TODO : Create buy house/hotel gamelogic

            // 3) The player rolls the dice
            guiInstance.rollButton(i); // Prompts the user to roll
            int roll1=Dice.roll();
            int roll2=Dice.roll();
            guiInstance.dieSetter(roll1,roll2,i); // Sets the die on of the rolls in the gui

            // 4) Checks if the player crosses the start
            //  TODO : check pass start method (below if-statement)
            if(((playerArr.get(i).getPosition())+roll1+roll2)>=40){
                playerArr.get(i).setBalance(playerArr.get(i).getBalance()+4000);
                System.out.println(playerArr.get(i).getBalance());
            }
            // 5) Gets and sets the new position of the player
            playerArr.get(i).setPosition(((playerArr.get(i).getPosition())+roll1+roll2)%40);
            int newPosition = playerArr.get(i).getPosition();
            guiInstance.movePlayer(i,oldPosition,newPosition, gui_playerList); // Moves the player in gui
        }
    }
}
