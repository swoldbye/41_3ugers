package Controllers;

import Boundary.GUI_Monopoly;
import Entities.*;
import gui_fields.GUI_Player;

import java.util.ArrayList;

public class C_GameTurn {
    SC_ChanceCardEffect Logic_chancecard = new SC_ChanceCardEffect();
    SC_CheckField Logic_checkfield = new SC_CheckField();
    SC_Jail Logic_jail = new SC_Jail();
    SC_PropertyManagement Logic_propertymanagement = new SC_PropertyManagement();
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
                    boolean ownsGroup = false;
                    // Check the current position of the player before he rolls the dice
                    int oldPosition = playerArr.get(i).getPosition();
                    // check groupsOwnedAmounted[] and increment groupsOwned[] if you have all in the group
                    Logic_propertymanagement.ownsGroupIncrement(playerArr, i, groupIndexes);
                    // 2) If the player owns all properties within one group, ask if he wants to buy houses

                    // If the player owns all properties within one group
                    ownsGroup = Logic_propertymanagement.ownsGroup(playerArr, fieldArr, i);
                    if (ownsGroup == true) {
                        int j = 0;
                        while (j == 0) {
                            boolean buy = guiInstance.buildBooleanMessage(i);
                            if (buy == true) {
                                int buildField = Logic_propertymanagement.specifyGroup(playerArr, guiInstance, i, groupIndexes, fieldArr);

                                if (buildField > 0) {
                                    int houseAmount = guiInstance.houseAmount(fieldArr, buildField, playerArr, i);
                                    if (houseAmount > 0) {
                                        Logic_propertymanagement.buildHouse(buildField, fieldArr, playerArr, i, houseAmount, guiInstance, gui_playerList);
                                    }
                                }
                            }else{j++;}
                        }
                    }

                    // 3) The player rolls the dice
                    guiInstance.rollButton(i); // Prompts the user to roll
                    int roll1 = Dice.roll();
                    int roll2 = Dice.roll();
                    guiInstance.dieSetter(roll1, roll2, i); // Sets the die (based on what you roll) in the gui

                    // 4) Checks if the player crosses the start
                    Logic_checkfield.checkStart(playerArr, oldPosition, i, roll1, roll2, gui_playerList);
                    int actualPosition = Logic_checkfield.setNewPosition(playerArr, oldPosition, i, roll1, roll2,gui_playerList);
                    Logic_checkfield.checkPosition(playerArr, i, actualPosition, fieldArr, gui_playerList);
                    if (playerArr.get(i).getBalance() < 0) {

                        playerArr.get(i).setBankrupt(true);
                        bankruptedPlayers++;
                        guiInstance.bankruptmessage(i);

                        for (int j = 0; j < fieldArr.length; j++) {
                            if (fieldArr[j] instanceof Field_Ownable)
                            {
                                if (fieldArr[j].getOwnership() == i) {
                                    fieldArr[j].setOwnership(-1);
                                    fieldArr[j].setHouses(0);
                                    guiInstance.deleteHouses(j);
                                    guiInstance.bankruptFieldOwnerShip(j);
                                }

                            }
                        }
                    }
                }
            }
        }
    }
}
