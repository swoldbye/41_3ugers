package Boundary;
import Entities.PlayerArchetype;
import gui_fields.GUI_Field;
import gui_fields.GUI_Player;
import gui_main.GUI;

import java.awt.*;
import java.util.ArrayList;

public class GUI_Monopoly extends GUI_PlayerList{
    GUI_PlayerList gui_PlayerList = new GUI_PlayerList();
    public static GUI_Field[] fields;
    public static String[] playerNames;
    public static GUI gui;
    public GUI_Player[] GUIPlayerList;
    public static int numberOfPlayers;

    public  void boardSetup() {
        fields = GUI_FieldFactory.fieldInitializer();
        gui = new GUI(fields, Color.WHITE);
    }

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
        fields[0].setCar(GUIPlayerList[i],true);
        }
        return GUIPlayerList;
    }

    public void rollButton(int playerID){
        String rollButton = gui.getUserButtonPressed("It is player " + (playerID+1)+"'s turn","Roll");
        return;
    }

    public void dieSetter(int roll1, int roll2,int playerID){
        gui.setDice(roll1,roll2);
        gui.showMessage("Player "+(playerID+1)+" Rolled: "+roll1+" and "+roll2);
        return;
    }

    public void winMessage(){
        gui.showMessage("Congratulations! You have won the game");
    }

    public void movePlayer(int playerID, int oldPosition,int newPosition, GUI_Player[] GUIPlayerList){
        fields[newPosition].setCar(GUIPlayerList[playerID],true);
        fields[oldPosition].removeAllCars();
        return;
    }
}