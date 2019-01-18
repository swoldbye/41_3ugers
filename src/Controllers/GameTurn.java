package Controllers;

import Boundary.GUI_Monopoly;
import Boundary.GUI_PlayerList;
import Entities.Dice;
import Entities.Field_Abstract;
import Entities.PlayerArchetype;
import Entities.PlayerList;
import gui_fields.GUI_Player;
import GameLogic.*;
import gui_main.GUI;
import sun.rmi.runtime.Log;

import java.util.ArrayList;

public class GameTurn {
    L_ChanceCard Logic_chancecard = new L_ChanceCard();
    L_CheckField Logic_checkfield = new L_CheckField();
    L_Jail Logic_jail = new L_Jail();
    L_PropertyManagement Logic_propertymanagement = new L_PropertyManagement();
    private int bankruptedPlayers = 0;

    // This method checks if the game is still eligible to play. You need to be at least 2 players
    public void checkRound(ArrayList<PlayerArchetype> playerArr, GUI_Player[] gui_playerList, GUI_Monopoly guiInstance, Field_Abstract[] fieldArr, int[][] groupIndexes) {

        while (bankruptedPlayers < playerArr.size() - 1) {
            // Calls the playerTurn method
            playerTurn(playerArr, gui_playerList, guiInstance, fieldArr, groupIndexes);
        }
        // The while loop ends when there is only 1 player left, the winner. Then we prompt the winMessage
        guiInstance.winMessage(); // Is displayed when there is only 1 player left (the winner :D)
    }

    // This method plays the turn for each player.
    public void playerTurn(ArrayList<PlayerArchetype> playerArr, GUI_Player[] gui_playerList, GUI_Monopoly guiInstance, Field_Abstract[] fieldArr, int[][] groupIndexes) {
        // For loop that runs a standard turn for each player.
        for (int i = 0; i < PlayerList.playerArr.size(); i++) {
            // If the player is in jail.
            if (playerArr.get(i).isBankrupt() == false) {
                boolean getTurn = Logic_jail.inJail(i, playerArr, guiInstance);
                if (getTurn == true) {
                    // Check the current position of the player before he rolls the dice
                    int oldPosition = playerArr.get(i).getPosition();
                    Logic_propertymanagement.ownsGroupIncrement(playerArr, fieldArr, i);
                    // 2) If the player owns all properties within one group, ask if he wants to buy houses

                    boolean ownsGroup = Logic_propertymanagement.ownsGroup(playerArr, fieldArr, i);
                    if (ownsGroup == true) {
                        int buildField = Logic_propertymanagement.wantToBuy(playerArr, guiInstance, i, groupIndexes, fieldArr);
                        if(buildField > 0){
                            int houseAmount = guiInstance.houseAmount(fieldArr, buildField, playerArr, i);
                            Logic_propertymanagement.buildHouse(buildField, fieldArr, playerArr, i, houseAmount, guiInstance);
                        }
                    }

                    // 3) The player rolls the dice
                    guiInstance.rollButton(i); // Prompts the user to roll
                    int roll1 = Dice.roll();
                    int roll2 = Dice.roll();
                    guiInstance.dieSetter(roll1, roll2, i); // Sets the die (based on what you roll) in the gui

                    // 4) Checks if the player crosses the start
                    Logic_checkfield.checkStart(playerArr, oldPosition, i, roll1, roll2, gui_playerList);
                    int actualPosition = Logic_checkfield.setNewPosition(playerArr, oldPosition, i, roll1, roll2);
                    guiInstance.movePlayer(i, oldPosition, actualPosition, gui_playerList); // Moves the player in gui
                    Logic_checkfield.checkPosition(playerArr, i, actualPosition, fieldArr, gui_playerList);
                    if (playerArr.get(i).getBalance() < 0) {

                        playerArr.get(i).setBankrupt(true);
                        bankruptedPlayers++;
                        guiInstance.bankruptmessage(i);
                        for (int j = 0; j < fieldArr.length; j++) {
                            if (fieldArr[j].getOwnership() == i) {
                                fieldArr[j].setOwnership(-1);
                                guiInstance.bankruptFieldOwnerShip(j);


                            }
                        }

                    }
                }
            }
        }
    }
}
