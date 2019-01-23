package Controllers;
import Boundary.GUI_Monopoly;
import Entities.Field_Abstract;
import Entities.Field_Ownable;
import Entities.PlayerArchetype;
import gui_fields.GUI_Player;

import java.util.ArrayList;

public class SC_CheckField {
    public static int roll;
    public static int playerBalance;
    public static int ownerBalance;
    public static int sodaMultiplier;
    GUI_Monopoly message = new GUI_Monopoly();
    SC_ChCardController chController = new SC_ChCardController();

    // First checks if user crosses start
    public void checkStart(ArrayList<PlayerArchetype> playerArr, int oldPosition,int i, int roll1, int roll2,GUI_Player[] gui_playerList){
        roll=roll1+roll2;
        if((oldPosition+roll1+roll2)>=40){
            playerArr.get(i).setBalance(playerArr.get(i).getBalance()+4000);
            int balance = playerArr.get(i).getBalance();
            message.passStart(i,balance,gui_playerList);
        }
        return;
    }

    public int setNewPosition(ArrayList<PlayerArchetype> playerArr,int oldPosition, int i,int roll1, int roll2,GUI_Player[] gui_playerList){
        // Sets the new position before analyzing what field the player landed on
        playerArr.get(i).setPosition((oldPosition+roll1+roll2)%40);
        int newPosition = playerArr.get(i).getPosition();
        message.movePlayer(i, oldPosition, newPosition, gui_playerList); // Moves the player in gui

        return newPosition;
    }

    // Check what field the player lands on and branches out
    public void checkPosition(ArrayList<PlayerArchetype> playerArr, int i, int actualPosition, Field_Abstract[] fieldArr, GUI_Player[] gui_playerList){
        SC_ChanceCardEffect Logic_chancecard = new SC_ChanceCardEffect();
        playerBalance = playerArr.get(i).getBalance();
        switch (actualPosition){
            case 0:
                // Lands on start
                break;
            case 2: case 7: case 17: case 22: case 33: case 36:
                // If player lands on chance card
                chController.cardController(actualPosition , playerBalance, message , playerArr , i , gui_playerList);
                if (actualPosition != playerArr.get(i).getPosition()) {
                    checkPosition(playerArr, i, playerArr.get(i).getPosition(), fieldArr, gui_playerList);
                }
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
                playerArr.get(i).setPosition(10);
                message.goToJail(i,gui_playerList);
                playerArr.get(i).setJailed(true);
                break;
            case 12: case 28:
                landsOnSoda(playerArr,i,actualPosition,fieldArr,gui_playerList);
                // Player lands on ownable field.
                break;
            default:landsOnProperty(playerArr,i,actualPosition,fieldArr,gui_playerList);
        }
        // Second case : if the player lands on an empty ownable field
    }

    public void landsOnProperty(ArrayList<PlayerArchetype> playerArr, int i,int actualPosition,Field_Abstract[] fieldArr,GUI_Player[] gui_playerList) {
        int currentBalance = playerArr.get(i).getBalance();
        // If player lands on a property that nobody owns
        if (fieldArr[actualPosition].getOwnership() == -1) {
            int price = fieldArr[actualPosition].getPrice();
            if (currentBalance > price) {
                String answer = message.GUI_buyProperty(actualPosition, i, price, gui_playerList);
                if (answer.equals("Ja")) {
                    // player pays for property
                    playerArr.get(i).setBalance(currentBalance - price);
                    playerArr.get(i).incrementOwnedGroupAmount(fieldArr[actualPosition].getGroup());
                    // ownership is set in fieldlist
                    fieldArr[actualPosition].setOwnership(i);
                    System.out.println("Spiller " + (i + 1) + " saldo er nu " + playerArr.get(i).getBalance());
                }
            }
        }
        // Else, pay rent to whomever owns the property
        else {

            // find rent
            int rent = fieldArr[actualPosition].getRent();
            int owner = fieldArr[actualPosition].getOwnership();
            if (fieldArr[actualPosition].getOwnership() != i) {
                if (fieldArr[actualPosition] instanceof Field_Ownable) {
                    if (playerArr.get(owner).getGroupsOwned()[fieldArr[actualPosition].getGroup()] == 1) {
                        int houseAmount = fieldArr[actualPosition].getHouses();
                        if (houseAmount == 0) {
                            rent = rent * 2;
                        } else if (houseAmount > 0) {
                            rent = (int) (rent * 2 * Math.pow(2, houseAmount));
                        }
                    }


                    // player pays rent
                    if (playerArr.get(i).getBalance() < rent) {
                        message.GUI_payRent(owner, playerArr.get(i).getBalance(), gui_playerList, i);
                        playerArr.get(owner).setBalance((ownerBalance + playerArr.get(i).getBalance()));
                        playerArr.get(i).setBalance(0);
                    } else {
                        playerArr.get(i).setBalance(currentBalance - rent);
                        int ownerBalance = playerArr.get(owner).getBalance();
                        // pay owner
                        playerArr.get(owner).setBalance(ownerBalance + rent);
                        // display pay rent button in gui
                        message.GUI_payRent(owner, rent, gui_playerList, i);
                    }

                }
            }
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
    public void landsOnSoda(ArrayList<PlayerArchetype> playerArr, int i,int actualPosition,Field_Abstract[] fieldArr,GUI_Player[] gui_playerList) {
        int sodaRent = roll * sodaMultiplier;
        int price = fieldArr[actualPosition].getPrice();

        if (fieldArr[actualPosition].getOwnership() == -1) {
            String answer = message.GUI_buyProperty(actualPosition, i, price, gui_playerList);
            if (answer == "Ja") {
                // player pays for property
                playerArr.get(i).setBalance(playerBalance - price);
                // ownership is set in fieldlist
                fieldArr[actualPosition].setOwnership(i);

                if (fieldArr[12].getOwnership() == fieldArr[28].getOwnership()) {
                    sodaMultiplier = 200;
                } else {
                    sodaMultiplier = 100;
                }
            }
        } else {
            if (fieldArr[actualPosition].getOwnership() != i) {
                ownerBalance = playerArr.get(fieldArr[actualPosition].getOwnership()).getBalance();
                int owner = fieldArr[actualPosition].getOwnership();

                if (playerArr.get(i).getBalance() < sodaRent) {
                    message.GUI_payRent(owner, playerArr.get(i).getBalance(), gui_playerList, i);
                    playerArr.get(owner).setBalance((ownerBalance + playerArr.get(i).getBalance()));
                    playerArr.get(i).setBalance(0);
                } else {
                    playerArr.get(i).setBalance(playerBalance - sodaRent);
                    playerArr.get(owner).setBalance(ownerBalance + sodaRent);
                    // display pay rent button in gui
                    message.GUI_payRent(owner, sodaRent, gui_playerList, i);
                }
            }
        }
    }

    public void landsOnEmpty(ArrayList<PlayerArchetype> playerArr, int i,int actualPosition){

    }
}
