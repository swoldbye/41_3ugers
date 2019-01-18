package Boundary;
import Entities.Field_Abstract;
import Entities.PlayerArchetype;
import gui_fields.GUI_Field;
import gui_fields.GUI_Player;
import gui_fields.GUI_Street;
import gui_main.GUI;
import java.awt.*;
import java.util.ArrayList;

public class GUI_Monopoly{
    GUI_PlayerList gui_PlayerList = new GUI_PlayerList();
    public static GUI_Field[] fields;
    public static String[] playerNames;
    public static GUI gui;
    public static int numberOfPlayers;

    // This method initializes the gui fields
    public  void boardSetup() {
        fields = GUI_FieldFactory.fieldInitializer();
        gui = new GUI(fields, Color.WHITE);
    }

    // This method creates n amount of players, depending on user input in the gui
    public int playerAmount() {
        numberOfPlayers = gui.getUserInteger("How many players are you? (between 3 and 6)");
        for (int i = 0; i < 1; i = 0) {
            if (numberOfPlayers >= 3 && numberOfPlayers <= 6) {
                i = 1;
                return numberOfPlayers;
            } else {
                numberOfPlayers = gui.getUserInteger("How many players are you? (between 3 and 6)");
            }
        }
        return numberOfPlayers;
    }

    public String[] playerNames(int amountOfPlayers) {
        playerNames = new String[6];
        for (int i = 0; i < amountOfPlayers; i++) {
            String name = gui.getUserString("Name of Player " + (i+1) + ": ");
            playerNames[i] = name;
            }
        return playerNames;
    }

    public GUI_Player[] InitializePlayersGUI(ArrayList<PlayerArchetype> players){
        GUI_Player[] GUIPlayerList = gui_PlayerList.createPlayerList(players.size());
        gui_PlayerList.createPlayerList(numberOfPlayers);

        for(int i=0; i < players.size(); i++){
            gui.addPlayer(GUIPlayerList[i]);
            fields[0].setCar(GUIPlayerList[i],true);
        }
        return GUIPlayerList;
    }

    public void rollButton(int playerID){
        String rollButton = gui.getUserButtonPressed("It is player " + (playerID+1)+"'s turn","Roll");
        return;
    }

    // This method sets the die in the gui depending on what the player rolls
    public void dieSetter(int roll1, int roll2,int playerID){
        gui.setDice(roll1,roll2);
        gui.showMessage("Player "+(playerID+1)+" Rolled: "+roll1+" and "+roll2);
        return;
    }

    public void winMessage(){
        gui.showMessage("Congratulations! You have won the game");
    }

    public void movePlayer(int playerID, int oldPosition, int newPosition, GUI_Player[] GUIPlayerList){
        fields[oldPosition].setCar(GUIPlayerList[playerID],false);
        fields[newPosition].setCar(GUIPlayerList[playerID],true);
        return;
    }

    public void passStart(int playerID,int newBalance, GUI_Player[] gui_playerList){
        gui_playerList[playerID].setBalance(newBalance);
        gui.showMessage("Player "+(playerID+1)+" has passed start and collects 4000kr");
    }

    // Button that adds the choice to buy a property
    public String GUI_buyProperty (int actualPosition, int playerID, int price, GUI_Player[] gui_playerList){
        String answer = gui.getUserSelection("Would you like to purchase this property?","Yes","No");
        if(answer.equals("Yes")){
            int currentBalance = gui_playerList[playerID].getBalance();
            gui_playerList[playerID].setBalance(currentBalance-price);
            fields[actualPosition].setDescription(fields[actualPosition].getTitle()+" is owned by: Player "+(playerID+1));
        }
        return answer;
    }

    // The balance of the player and owner of a given field will be updated in the gui in this method
    public String GUI_payRent(int owner,int rent,GUI_Player[] gui_playerList,int playerID){
        String rentMessage = gui.getUserSelection("This field is owned by Player "+(owner+1)+". Pay "+rent,"Pay "+rent);
        // Defining the balance of the player and owner
        int playerBalance = gui_playerList[playerID].getBalance();
        int ownerBalance = gui_playerList[owner].getBalance();
        // Setting their new respective balances after paying and receiving rent.
        gui_playerList[playerID].setBalance(playerBalance-rent);
        gui_playerList[owner].setBalance(ownerBalance+rent);

    return rentMessage;
    }
    public String GUI_payTax(int balance,int playerID, int tax,GUI_Player[] gui_playerList){
        String taxMessage = gui.getUserSelection("Player "+(playerID+1)+" landed on a tax field","Pay "+tax);
        gui_playerList[playerID].setBalance(balance-tax);
        return taxMessage;

    }
    public void goToJail(int playerID,GUI_Player[] gui_playerList){
        gui.showMessage("You went to jail.");
        fields[30].setCar(gui_playerList[playerID],false);
        fields[10].setCar(gui_playerList[playerID],true);
    }
    public String jailMessage(int playerID, int playerStatus){
        String answer = null;
        switch(playerStatus){
            case 1:
                answer = gui.getUserSelection("Vil du betale 1000kr for at komme ud?", "Nej", "Ja", "Brug kort");
                break;
            case 2:
                answer = gui.getUserSelection("Vil du betale 1000kr for at komme ud?", "Nej", "Ja");
                break;
            case 3:
                answer = gui.getUserSelection("Du kan bruge dit kort for at komme ud af fængsel.", "Nej",  "Brug kort");
                break;
            case 4:
                gui.showMessage("You can't pay your way out of this one.");
                answer = "Nej";
                break;
        }
        return answer;

    }

    public void payOrReceive(int balance,int playerID, int cardAmount,GUI_Player[] gui_playerList){
        gui_playerList[playerID].setBalance(balance+cardAmount);
    }
    public void chMessage(String message){
        gui.showMessage(message);
    }

    public void bankruptmessage (int playerid) {
        gui.showMessage("Player "+(playerid+1)+" er gået fallit. Alle player "+(playerid+1)+" grunde er givet til banken og kan nu købes");
    }
    public void bankruptFieldOwnerShip(int bankruptOwnedProperties){
        // This method defaults the ownership string in the field descriptions.
        fields[bankruptOwnedProperties].setDescription(" ");
    }

    public boolean buildBooleanMessage(){
        boolean build = false;
        String answer = gui.getUserSelection("Do you want to build house or hotel?","Yes", "No");
        if(answer.equals("Yes")){
            build = true;
        } return build;
    }


    public int buildMessage(){
        int group = 0;
        String answer = gui.getUserSelection("Which group do you want to build on?", "Blue", "Orange", "Green", "Grey", "Red", "White", "Yellow", "Purple");
        if(answer.equals("Blue")){
            group = 0;
        }else if(answer.equals("Orange")){
            group = 2;
        }else if(answer.equals("Green")){
            group = 3;
        }else if(answer.equals("Grey")){
            group =5;
        }else if(answer.equals("Red")){
            group =6;
        }else if(answer.equals("White")){
            group =7;
        }else if(answer.equals("Yellow")){
            group =8;
        }else if(answer.equals("Purple")){
            group =9;
        }return group;
    }

    public int chooseField(int group, Field_Abstract[] fieldArr, int[][] groupIndexes) {
        String answer = null;
        int finalFieldIndex = -1;

        switch (groupIndexes[group].length) {
            case 3:
                int index0 = groupIndexes[group][0];
                int index1 = groupIndexes[group][1];
                int index2 = groupIndexes[group][2];
                answer = gui.getUserSelection("Which field do you want to build on?", fieldArr[index0].getFieldName(), fieldArr[index1].getFieldName(), fieldArr[index2].getFieldName());
                if (answer.equals(fieldArr[index0].getFieldName())) {
                    finalFieldIndex = groupIndexes[group][0];
                } else if (answer.equals(fieldArr[index1].getFieldName())) {
                    finalFieldIndex = groupIndexes[group][1];
                } else if (answer.equals(fieldArr[index2].getFieldName())) {
                    finalFieldIndex = groupIndexes[group][2];
                }
                break;
            case 2:
                int index3 = groupIndexes[group][0];
                int index4 = groupIndexes[group][1];
                answer = gui.getUserSelection("Which field do you want to buiold on?", fieldArr[index3].getFieldName(), fieldArr[index4].getFieldName());
                if (answer.equals(fieldArr[index3].getFieldName())) {
                    finalFieldIndex = groupIndexes[group][0];
                } else if (answer.equals(fieldArr[index4].getFieldName())) {
                    finalFieldIndex = groupIndexes[group][1];
                }
                break;
        }
        return finalFieldIndex;
    }


    public int houseAmount(Field_Abstract[] fieldArr, int index, ArrayList<PlayerArchetype> playerArr, int playerID){
        String answer = null;
        int value = 0;
        int i = 0;
        int cost = 0;

        switch (fieldArr[index].getHouses()){
            case 0:
                while(i == 0){
                    answer = gui.getUserSelection("How many houses would you like to build", "1 House", "2 Houses", "3 Houses", "4 Houses", "Hotel");
                    if(answer.equals("1 House")){value = 1;} else if (answer.equals("2 Houses")){value = 2;} else if(answer.equals("3 Houses")){value = 3;}
                    else if (answer.equals("4 Houses")){value = 4;} else if(answer.equals("Hotel")){value = 5;}

                    cost = value * fieldArr[index].getHousePrice();
                    if(playerArr.get(playerID).getBalance() < cost){
                        gui.showMessage("Your Balance: "+playerArr.get(playerID).getBalance()+". Cost: "+cost+". You don't have sufficient funds.");
                    }
                    else{
                        i++;
                        gui.showMessage("Transaction Complete.");
                    }
                }
                break;

            case 1:
                while(i == 0){
                    answer = gui.getUserSelection("How many houses would you like to build", "1 House", "2 Houses", "3 Houses", "Hotel");
                    if(answer.equals("1 House")){value = 1;} else if (answer.equals("2 Houses")){value = 2;} else if(answer.equals("3 Houses")){value = 3;}
                    else if(answer.equals("Hotel")){value = 4;}

                    cost = value * fieldArr[index].getHousePrice();
                    if(playerArr.get(playerID).getBalance() < cost){
                        gui.showMessage("Your Balance: "+playerArr.get(playerID).getBalance()+". Cost: "+cost+". You don't have sufficient funds.");
                    }
                    else{
                        i++;
                        gui.showMessage("Transaction Complete.");
                    }
                }
                break;
            case 2:
                while(i == 0){
                    answer = gui.getUserSelection("How many houses would you like to build", "1 House", "2 Houses", "Hotel");
                    if(answer.equals("1 House")){value = 1;} else if (answer.equals("2 Houses")){value = 2;} else if(answer.equals("Hotel")){value = 3;}

                    cost = value * fieldArr[index].getHousePrice();
                    if(playerArr.get(playerID).getBalance() < cost){
                        gui.showMessage("Your Balance: "+playerArr.get(playerID).getBalance()+". Cost: "+cost+". You don't have sufficient funds.");
                    }
                    else{
                        i++;
                        gui.showMessage("Transaction Complete.");
                    }
                }
                break;

            case 3:
                while(i == 0){
                    answer = gui.getUserSelection("How many houses would you like to build", "1 House", "Hotel");
                    if(answer.equals("1 House")){value = 1;} else if(answer.equals("Hotel")){value = 2;}

                    cost = value * fieldArr[index].getHousePrice();
                    if(playerArr.get(playerID).getBalance() < cost){
                        gui.showMessage("Your Balance: "+playerArr.get(playerID).getBalance()+". Cost: "+cost+". You don't have sufficient funds.");
                    }
                    else{
                        i++;
                        gui.showMessage("Transaction Complete.");
                    }
                }
                break;

            case 4:
                while(i == 0){
                    answer = gui.getUserSelection("Would you like to build a hotel?", "Yes", "Cancel");
                    if(answer.equals("Yes")){value = 1;} else if(answer.equals("Cancel")){value = 0;}

                    cost = value * fieldArr[index].getHousePrice();
                    if(playerArr.get(playerID).getBalance() < cost){
                        gui.showMessage("Your Balance: "+playerArr.get(playerID).getBalance()+". Cost: "+cost+". You don't have sufficient funds.");
                    }
                    else{
                        i++;
                        gui.showMessage("Transaction Complete.");
                    }
                }
                break;
            case 5:
                gui.showMessage("You already have a hotel on this property.");
                value = 0;
                break;
        }return value;
    }


    public void housePlacement(int houseAmount, int fieldIndex){
        if(houseAmount == 5) {
            if (fields[fieldIndex] instanceof GUI_Street) {
                ((GUI_Street) fields[fieldIndex]).setHotel(true);
            }
        }
        else if(fields[fieldIndex] instanceof GUI_Street){
            ((GUI_Street)fields[fieldIndex]).setHouses(houseAmount);
        }
    }
}