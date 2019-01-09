package Boundary;
import Entities.PlayerArchetype;
import gui_fields.GUI_Field;
import gui_fields.GUI_Player;
import gui_main.GUI;

import java.awt.*;
import java.util.ArrayList;

public class GUI_Monopoly {

    GUI_PlayerList GUI_PlayerList = new GUI_PlayerList();
    public static GUI_Field[] fields;
    public static String[] playerNames;

    public static GUI gui;

    public void boardSetup() {
        fields = GUI_FieldFactory.fieldInitializer();
        gui = new GUI(fields, Color.WHITE);
    }

    public String[] playerNames() {
        int numberOfPlayers = gui.getUserInteger("How many players are you? ");
        playerNames = new String[numberOfPlayers];
        if (numberOfPlayers >= 3 && numberOfPlayers <= 6) {
            for (int i = 0; i < numberOfPlayers; i++) {
                String name = gui.getUserString("Name of Player " + (i+1) + ": ");
                playerNames[i] = name;
            }
        }
        return playerNames;
    }


    public void InitializePlayersGUI(ArrayList<PlayerArchetype> players){
        GUI_Player[] GUIPlayerList = GUI_PlayerList.createPlayerList(players.size());


        for(int i=0; i < players.size(); i++){
        gui.addPlayer(GUIPlayerList[i]);
        fields[0].setCar(GUIPlayerList[i],true);
        }
    }

    public static void rollButton(int playerID){
        String rollButton = gui.getUserButtonPressed("It is player " + (playerID)+"'s turn","Roll");
        return;
    }
}