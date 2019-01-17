package GameLogic;
import Boundary.GUI_Monopoly;
import Entities.Field_Abstract;
import Entities.PlayerArchetype;
import java.util.ArrayList;

public class L_PropertyManagement {

    public boolean ownsGroup(ArrayList<PlayerArchetype> playerArr, Field_Abstract[] fieldArr, int playerID) {
        boolean ownsGroup = false;
        //if(playerArr.get(playerID).getOwnGroup()[fieldArr[actualPosition].getGroup()] == fieldArr[actualPosition].getGroupSize()){
        for (int i = 0; i <= 9; i++){
             if (playerArr.get(playerID).getGroupOwnedAmount()[i] == fieldArr[i].getGroupSize()) {
                playerArr.get(playerID).getGroupsOwned()[i] = 1;
                ownsGroup = true;
            }
        }
        return ownsGroup;
    }

    public int wantToBuy(ArrayList<PlayerArchetype> playerArr,boolean ownsGroup, GUI_Monopoly guiMonopoly, int playerID){
        boolean buy = false;
        int group = -1;

        //
        if(ownsGroup == true){
            buy = guiMonopoly.buildBooleanMessage();
        }
        if(buy = true){
            group = guiMonopoly.buildMessage();
            if(playerArr.get(playerID).getGroupsOwned()[group] == 1){
                guiMonopoly.chooseField;
            }
        } return group;
    }


    public void buildHouse
}


/*
1. check if the player has all fields in a group __
2. check if the player wants to build __
3. check what field the player wants to build on
4. check what type of building the player wants to build
5. check how many of them the player wants to build
 */