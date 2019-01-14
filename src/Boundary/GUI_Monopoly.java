package Boundary;
import Entities.Field_Abstract;
import Entities.PlayerArchetype;
import gui_fields.GUI_Field;
import gui_fields.GUI_Player;
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
    public String jailMessage(int playerID){
        String answer = gui.getUserSelection("Vil du betale 1000kr for at komme ud?", "Nej", "Ja", "Brug kort");
        return answer;
    }
}