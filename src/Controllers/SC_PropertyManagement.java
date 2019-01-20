package Controllers;
import Boundary.GUI_Monopoly;
import Boundary.GUI_PlayerList;
import Entities.Field_Abstract;
import Entities.Field_Ownable;
import Entities.PlayerArchetype;
import gui_fields.GUI_Player;

import java.util.ArrayList;

public class SC_PropertyManagement {

    public void ownsGroupIncrement(ArrayList<PlayerArchetype> playerArr, int playerID, int[][] groupIndexes) {
        for (int i = 0; i <= 9; i++) {
            if (playerArr.get(playerID).getGroupOwnedAmount()[i] == groupIndexes[i].length) {
                playerArr.get(playerID).setGroupOwned(i, true);
            }
        }
    }

    public boolean ownsGroup(ArrayList<PlayerArchetype> playerArr, Field_Abstract[] fieldArr, int playerID) {
        boolean ownsGroup = false;
        for (int i = 0; i <= 9; i++){
            if(i == 1 || i == 4){
                i++;
            }
            if (playerArr.get(playerID).getGroupsOwned()[i] == 1) {
                ownsGroup = true;
            }
        }
        return ownsGroup;
    }


    public int specifyGroup(ArrayList<PlayerArchetype> playerArr, GUI_Monopoly guiMonopoly, int playerID, int[][] groupIndexes, Field_Abstract[] fieldArr) {
        int buildField = -1;
        int group = -1;

        group = guiMonopoly.buildMessage();
        if (group == -1) {
            buildField = -1;
        } else if (playerArr.get(playerID).getGroupsOwned()[group] == 1) {
            buildField = guiMonopoly.chooseField(group, fieldArr, groupIndexes);
        } else if (playerArr.get(playerID).getGroupsOwned()[group] == 0){
            buildField = -1;
            guiMonopoly.doesNotOwnGroup();
        }
        return buildField;
    }


    public void buildHouse (int buildField, Field_Abstract[] fieldArr, ArrayList<PlayerArchetype> playerArr, int playerID, int amount, GUI_Monopoly guiMonopoly, GUI_Player[] guiPlayerList){
        //gui method to change what happens on the gui. Then done.
        int tempIncrease = fieldArr[buildField].getHouses() + amount;
        boolean bought = guiMonopoly.housePlacement(playerID, amount, tempIncrease, buildField, guiPlayerList, fieldArr);
        if(bought == true){
            //set the new amount of houses.
            fieldArr[buildField].setHouses(fieldArr[buildField].getHouses() + amount);
            //changes the players balance based on the house price and the amount of houses bought.
            playerArr.get(playerID).setBalance(playerArr.get(playerID).getBalance() - fieldArr[buildField].getHousePrice() * amount);
        }
    }
}


