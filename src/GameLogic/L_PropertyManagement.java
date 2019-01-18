package GameLogic;
import Boundary.GUI_Monopoly;
import Boundary.GUI_PlayerList;
import Entities.Field_Abstract;
import Entities.PlayerArchetype;
import gui_fields.GUI_Player;

import java.util.ArrayList;

public class L_PropertyManagement {

    public void ownsGroupIncrement(ArrayList<PlayerArchetype> playerArr, Field_Abstract[] fieldArr, int playerID) {
        for (int i = 0; i <= 9; i++) {
            if (playerArr.get(playerID).getGroupOwnedAmount()[i] == fieldArr[i].getGroupSize()) {
                playerArr.get(playerID).setGroupsOwned(i, true);
            }
        }
    }

    public boolean ownsGroup(ArrayList<PlayerArchetype> playerArr, Field_Abstract[] fieldArr, int playerID) {
        boolean ownsGroup = false;
        //if(playerArr.get(playerID).getOwnGroup()[fieldArr[actualPosition].getGroup()] == fieldArr[actualPosition].getGroupSize()){
        for (int i = 0; i <= 9; i++){
             if (playerArr.get(playerID).getGroupsOwned()[i] == 1) {
                ownsGroup = true;
            }else{ownsGroup = false;}
        }
        return ownsGroup;
    }

    public int wantToBuy(ArrayList<PlayerArchetype> playerArr, GUI_Monopoly guiMonopoly, int playerID, int[][] groupIndexes, Field_Abstract[] fieldArr){
        int buildField = -1;
        boolean buy = false;
        int group = -1;

        buy = guiMonopoly.buildBooleanMessage(playerID);
        if(buy == true){
            group = guiMonopoly.buildMessage();
            if(group == -1){
                buildField = -1;
            }
            else if(playerArr.get(playerID).getGroupsOwned()[group] == 1){
                buildField = guiMonopoly.chooseField(group, fieldArr, groupIndexes);
            }
        } return buildField;
    }

    public void buildHouse (int buildField, Field_Abstract[] fieldArr, ArrayList<PlayerArchetype> playerArr, int playerID, int amount, GUI_Monopoly guiMonopoly, GUI_Player[] guiPlayerList){
        //gui method to change what happens on the gui. Then done.
        boolean bought = guiMonopoly.housePlacement(playerID, amount, fieldArr[buildField].getHouses(), buildField, guiPlayerList, fieldArr);
        if(bought == true){
            //set the new amount of houses.
            fieldArr[buildField].setHouses(fieldArr[buildField].getHouses() + amount);
            //changes the players balance based on the house price and the amount of houses bought.
            playerArr.get(playerID).setBalance(playerArr.get(playerID).getBalance() - fieldArr[buildField].getHousePrice() * amount);
        }
    }
}


