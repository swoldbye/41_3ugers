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
        numberOfPlayers = gui.getUserInteger("Hvor mange spillere? (mellem 3 og 6)");
        for (int i = 0; i < 1; i = 0) {
            if (numberOfPlayers >= 3 && numberOfPlayers <= 6) {
                i = 1;
                return numberOfPlayers;
            } else {
                numberOfPlayers = gui.getUserInteger("Hvor mange spillere? (mellem 3 og 6)");
            }
        }
        return numberOfPlayers;
    }

    public String[] playerNames(int amountOfPlayers) {
        playerNames = new String[6];
        for (int i = 0; i < amountOfPlayers; i++) {
            String name = gui.getUserString("Navngiv Player " + (i+1) + ": ");
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
        String rollButton = gui.getUserButtonPressed("Det er player " + (playerID+1)+"'s tur","Rul");
        return;
    }

    // This method sets the die in the gui depending on what the player rolls
    public void dieSetter(int roll1, int roll2,int playerID){
        gui.setDice(roll1,roll2);
        gui.showMessage("Player "+(playerID+1)+" Rullede: "+roll1+" og "+roll2);
        return;
    }

    public void winMessage(){
        gui.showMessage("Tilykke! Du har vundet spillet");
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
        String answer = gui.getUserSelection("Vil du købe denne felt?","Ja","Nej");
        if(answer.equals("Ja")){
            int currentBalance = gui_playerList[playerID].getBalance();
            gui_playerList[playerID].setBalance(currentBalance-price);
            fields[actualPosition].setDescription(fields[actualPosition].getTitle()+" er ejet af: Player "+(playerID+1));
        }
        return answer;
    }

    // The balance of the player and owner of a given field will be updated in the gui in this method
    public String GUI_payRent(int owner,int rent,GUI_Player[] gui_playerList,int playerID){
        String rentMessage = gui.getUserSelection("Denne felt af ejet af Player "+(owner+1)+". Betal "+rent,"Betal "+rent);
        // Defining the balance of the player and owner
        int playerBalance = gui_playerList[playerID].getBalance();
        int ownerBalance = gui_playerList[owner].getBalance();
        // Setting their new respective balances after paying and receiving rent.
        gui_playerList[playerID].setBalance(playerBalance-rent);
        gui_playerList[owner].setBalance(ownerBalance+rent);

    return rentMessage;
    }
    public String GUI_payTax(int balance,int playerID, int tax,GUI_Player[] gui_playerList){
        String taxMessage = gui.getUserSelection("Player "+(playerID+1)+" landede på et skattefelt","betal "+tax);
        gui_playerList[playerID].setBalance(balance-tax);
        return taxMessage;

    }
    public void goToJail(int playerID,GUI_Player[] gui_playerList){
        gui.showMessage("Du kom i fængsel.");
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
                gui.showMessage("Du har hverken penge eller en chance kort. Du skal rulle dobbelt for at komme ud af fængsel.");
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

    public boolean buildBooleanMessage(int playerID){
        boolean build = false;
        String answer = gui.getUserSelection("Player "+(playerID+1)+" skal spille. Vil du bygge?","Ja", "Nej");
        if(answer.equals("Ja")){
            build = true;
        } return build;
    }


    public int buildMessage(){
        int group = 0;
        String answer = gui.getUserSelection("Hvilken gruppe vil du bygge på?", "Blå", "Orange", "Grøn", "Grå", "Rød", "Hvid", "Gul", "Lilla", "Annuller");
        if(answer.equals("Blå")){
            group = 0;
        }else if(answer.equals("Orange")){
            group = 2;
        }else if(answer.equals("Grøn")){
            group = 3;
        }else if(answer.equals("Grå")){
            group =5;
        }else if(answer.equals("Rød")){
            group =6;
        }else if(answer.equals("Hvid")){
            group =7;
        }else if(answer.equals("Gul")){
            group =8;
        }else if(answer.equals("Lilla")) {
            group = 9;
        }else if(answer.equals("Annuller")){
            group = -1;
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
                answer = gui.getUserSelection("Hvilken ejendom vil du bygge på?", fieldArr[index0].getFieldName(), fieldArr[index1].getFieldName(), fieldArr[index2].getFieldName(), "Annuller");
                if (answer.equals(fieldArr[index0].getFieldName())) {
                    finalFieldIndex = groupIndexes[group][0];
                } else if (answer.equals(fieldArr[index1].getFieldName())) {
                    finalFieldIndex = groupIndexes[group][1];
                } else if (answer.equals(fieldArr[index2].getFieldName())) {
                    finalFieldIndex = groupIndexes[group][2];
                }else if (answer.equals("Annuller")){
                    finalFieldIndex = -1;
                }
                break;
            case 2:
                int index3 = groupIndexes[group][0];
                int index4 = groupIndexes[group][1];
                answer = gui.getUserSelection("Hvilken ejendom vil du bygge på?", fieldArr[index3].getFieldName(), fieldArr[index4].getFieldName(), "Annuller");
                if (answer.equals(fieldArr[index3].getFieldName())) {
                    finalFieldIndex = groupIndexes[group][0];
                } else if (answer.equals(fieldArr[index4].getFieldName())) {
                    finalFieldIndex = groupIndexes[group][1];
                }else if (answer.equals("Annuller")){
                    finalFieldIndex = -1;
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
                    answer = gui.getUserSelection("Hvad vil du bygge?", "1 Hus", "2 Huse", "3 Huse", "4 Huse", "Hotel", "Annuller");
                    if(answer.equals("1 Hus")){value = 1;} else if (answer.equals("2 Huse")){value = 2;} else if(answer.equals("3 Huse")){value = 3;}
                    else if (answer.equals("4 Huse")){value = 4;} else if(answer.equals("Hotel")){value = 5;} else if(answer.equals("Annuller")){value = -1;}

                    if(playerArr.get(playerID).getBalance() < cost){
                        gui.showMessage("Din saldo: "+playerArr.get(playerID).getBalance()+". Pris: "+cost+". Du har ikke nok penge.");
                        i++;
                    }
                    else{
                        cost = value * fieldArr[index].getHousePrice();
                        i++;
                    }
                }
                break;

            case 1:
                while(i == 0){
                    answer = gui.getUserSelection("Hvad vil du bygge?", "1 Hus", "2 Huse", "3 Huse", "Hotel", "Annuller");
                    if(answer.equals("1 Hus")){value = 1;} else if (answer.equals("2 Huse")){value = 2;} else if(answer.equals("3 Huse")){value = 3;}
                    else if(answer.equals("Hotel")){value = 4;} else if(answer.equals("Annuller")){value = -1;}

                    if(playerArr.get(playerID).getBalance() < cost){
                        gui.showMessage("Din saldo: "+playerArr.get(playerID).getBalance()+". Pris: "+cost+". Du har ikke nok penge.");
                    }
                    else{
                        cost = value * fieldArr[index].getHousePrice();
                        i++;
                    }
                }
                break;
            case 2:
                while(i == 0){
                    answer = gui.getUserSelection("Hvad vil du bygge?", "1 Hus", "2 Huse", "Hotel", "Annuller");
                    if(answer.equals("1 Hus")){value = 1;} else if (answer.equals("2 Huse")){value = 2;} else if(answer.equals("Hotel")){value = 3;}
                    else if(answer.equals("Annuller")){value = -1;}

                    if(playerArr.get(playerID).getBalance() < cost){
                        gui.showMessage("Din saldo: "+playerArr.get(playerID).getBalance()+". Pris: "+cost+". Du har ikke nok penge.");
                    }
                    else{
                        cost = value * fieldArr[index].getHousePrice();
                        i++;

                    }
                }
                break;

            case 3:
                while(i == 0){
                    answer = gui.getUserSelection("Hvad vil du bygge?", "1 Hus", "Hotel", "Annuller");
                    if(answer.equals("1 Hus")){value = 1;} else if(answer.equals("Hotel")){value = 2;}else if(answer.equals("Annuller")){value = -1;}

                    if(playerArr.get(playerID).getBalance() < cost){
                        gui.showMessage("Din saldo: "+playerArr.get(playerID).getBalance()+". Pris: "+cost+". Du har ikke nok penge.");
                    }
                    else{
                        cost = value * fieldArr[index].getHousePrice();
                        i++;
                    }
                }
                break;

            case 4:
                while(i == 0){
                    answer = gui.getUserSelection("Vil du bygge en hotel?", "Ja", "Annuller");
                    if(answer.equals("Ja")){value = 1;} else if(answer.equals("Annuller")){value = -1;}

                    if(playerArr.get(playerID).getBalance() < cost){
                        gui.showMessage("Din saldo: "+playerArr.get(playerID).getBalance()+". Pris: "+cost+". Du har ikke nok penge.");
                    }
                    else{
                        cost = value * fieldArr[index].getHousePrice();
                        i++;
                    }
                }
                break;
            case 5:
                gui.showMessage("Du har allerede et hotel på denne ejendom.");
                value = 0;
                break;
        }return value;
    }


    public boolean housePlacement(int playerID,int houseIncrement ,int houseAmount, int fieldIndex,GUI_Player[] guiPlayerList, Field_Abstract[] fieldArr) {
        boolean bought = false;
        int cost = houseIncrement * fieldArr[fieldIndex].getHousePrice();
        String answer = gui.getUserSelection("Denne transaktion vil koste dig: " + cost + ". Vil du fortsætte?", "Ja", "Nej");

        if (answer.equals("Ja")) {
            guiPlayerList[playerID].setBalance(guiPlayerList[playerID].getBalance() - cost);
            if (houseAmount == 5) {
                if (fields[fieldIndex] instanceof GUI_Street) {
                    ((GUI_Street) fields[fieldIndex]).setHotel(true);
                }
            } else if (fields[fieldIndex] instanceof GUI_Street) {
                ((GUI_Street) fields[fieldIndex]).setHouses(houseAmount);
            }
            bought = true;
        }else{

            gui.showMessage("Transaktion annuleret.");
        }return bought;
    }

    public void deleteHouses(int index){
        if(fields[index] instanceof GUI_Street){
            ((GUI_Street) fields[index]).setHotel(false);
            ((GUI_Street) fields[index]).setHouses(0);
        }
    }

    public void doesNotOwnGroup()
    {
        gui.showMessage("Du ejer ikke denne gruppe.");
    }
}