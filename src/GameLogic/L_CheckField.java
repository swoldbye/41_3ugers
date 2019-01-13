package GameLogic;
import Boundary.GUI_Monopoly;
import Boundary.GUI_PlayerList;
import Entities.Field_Abstract;
import Entities.PlayerArchetype;
import gui_fields.GUI_Player;

import java.util.ArrayList;

public class L_CheckField {
    GUI_Monopoly message = new GUI_Monopoly();
    // First checks if user crosses start
    public void checkStart(ArrayList<PlayerArchetype> playerArr, int oldPosition,int i, int roll1, int roll2,GUI_Player[] gui_playerList){
        if((oldPosition+roll1+roll2)>=40){
            playerArr.get(i).setBalance(playerArr.get(i).getBalance()+4000);
            int balance = playerArr.get(i).getBalance();
            message.passStart(i,balance,gui_playerList);
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
            case 0:
                // Lands on start
                break;
            case 2: case 7: case 17: case 22: case 33: case 36:
                // If player lands on chance card
                Logic_chancecard.chanceCardDeck(actualPosition,playerBalance);
                break;
            case 4: case 38:
                // If player lands on tax field
                landsOnTax(playerArr,playerBalance,i,actualPosition,fieldArr,gui_playerList);
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
        int currentBalance = playerArr.get(i).getBalance();
        if(fieldArr[actualPosition].getOwnership()==-1){
            int price = fieldArr[actualPosition].getPrice();
            String answer = message.GUI_buyProperty(actualPosition,i,price,gui_playerList);
            if(answer.equals("Yes")){
                // player pays for property
                playerArr.get(i).setBalance(currentBalance-price);
                // ownership is set in fieldlist
                fieldArr[actualPosition].setOwnership(i);
                System.out.println("Player "+(i+1)+"'s balance is now: "+playerArr.get(i).getBalance());
            }
        }
        else{
            // find rent
            int rent = fieldArr[actualPosition].getRent();
            // find owner with getOwnership
            int owner = fieldArr[actualPosition].getOwnership();
            // display pay rent button in gui
            message.GUI_payRent(owner,rent,gui_playerList,i);
            // player pays rent
            playerArr.get(i).setBalance(currentBalance-rent);
            int ownerBalance = playerArr.get(owner).getBalance();
            // pay owner
            playerArr.get(owner).setBalance(ownerBalance+rent);
        }

    }
    public void landsOnTax(ArrayList<PlayerArchetype> playerArr,int playerBalance, int i,int actualPosition,Field_Abstract[] fieldArr,GUI_Player[] gui_playerList){
        // If player lands on tax field 1 or 2, reduce balance by either 4000 or 8000.
        if(actualPosition==4){
            int tax = 4000;
            playerArr.get(i).setBalance(playerBalance-tax);
            message.GUI_payTax(playerBalance,i,tax,gui_playerList);
        }
        else if(playerArr.get(i).getPosition()==38){
            int tax = 2000;
            playerArr.get(i).setBalance(playerBalance-tax);
            message.GUI_payTax(playerBalance,i,tax,gui_playerList);
        }
    }
    public void landsOnFerry(ArrayList<PlayerArchetype> playerArr, int i,int actualPosition){

    }
    public void landsOnEmpty(ArrayList<PlayerArchetype> playerArr, int i,int actualPosition){

    }
}
