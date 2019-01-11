package GameLogic;
import Boundary.GUI_Monopoly;
import Boundary.GUI_PlayerList;
import Entities.Field_Abstract;
import Entities.PlayerArchetype;
import gui_fields.GUI_Player;

import java.util.ArrayList;

public class L_CheckField {
    // First checks if user crosses start
    public void checkStart(ArrayList<PlayerArchetype> playerArr, int oldPosition,int i, int roll1, int roll2){
        boolean b = false;
        if((oldPosition+roll1+roll2)>=40){
            playerArr.get(i).setBalance(playerArr.get(i).getBalance()+4000);
        }
        return;
    }

    public int setNewPosition(ArrayList<PlayerArchetype> playerArr,int oldPosition, int i,int roll1, int roll2){
        // Sets the new position before analyzing what field the player landed on
        playerArr.get(i).setPosition((oldPosition+roll1+roll2)%40);
        int newPosition = playerArr.get(i).getPosition();
        return newPosition;
    }
    // Check what field the player lands on and branches out
    public void checkPosition(ArrayList<PlayerArchetype> playerArr, int i, int actualPosition, Field_Abstract[] fieldArr, GUI_Player[] gui_playerList){
        L_ChanceCard Logic_chancecard = new L_ChanceCard();
        int playerBalance = playerArr.get(i).getBalance();
        switch (actualPosition){
            case 2: case 7: case 17: case 22: case 33: case 36:
                // If player lands on chance card
                Logic_chancecard.chanceCardDeck(actualPosition,playerBalance);
                break;
            case 4: case 38:
                // If player lands on tax field
                break;
            case 10: case 20:
                // Player lands on prison/parking
                landsOnEmpty(playerArr,i,actualPosition);
                break;
            case 30:
                // Player lands on go to prison
                break;
                // Player lands on ownable field.
            default:landsOnOwnable(playerArr,i,actualPosition,fieldArr,gui_playerList);
        }
        // Second case : if the player lands on an empty ownable field

    }

    public void landsOnOwnable(ArrayList<PlayerArchetype> playerArr, int i,int actualPosition,Field_Abstract[] fieldArr,GUI_Player[] gui_playerList){
        GUI_Monopoly message = new GUI_Monopoly();
        int currentBalance = playerArr.get(i).getBalance();
        if(fieldArr[actualPosition].getOwnership()<0){
            int price = fieldArr[actualPosition].getPrice();
            String answer = message.GUI_buyProperty(i,price,gui_playerList);
            if(answer.equals("Yes")){
                // player pays for property
                playerArr.get(i).setBalance(currentBalance-price);
                // ownership is set in fieldlist
                fieldArr[i].setOwnership(i);
            }
        }
        else{
            // find rent
            int rent = fieldArr[i].getRent();
            // find owner
            int owner = fieldArr[i].getOwnership();
            // display pay rent button in gui
            message.GUI_payRent(owner,rent);
            // player pays rent
            playerArr.get(i).setBalance(currentBalance-rent);
            int ownerBalance = playerArr.get(owner).getBalance();
            // pay owner
            playerArr.get(owner).setBalance(ownerBalance+rent);
        }

    }
    public void landsOnFerry(ArrayList<PlayerArchetype> playerArr, int i,int actualPosition){

    }
    public void landsOnEmpty(ArrayList<PlayerArchetype> playerArr, int i,int actualPosition){

    }
}
