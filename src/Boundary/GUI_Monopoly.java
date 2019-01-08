package Boundary;
import gui_fields.GUI_Field;
import gui_fields.GUI_Player;
import gui_main.GUI;

import java.awt.*;
public class GUI_Monopoly {

    public static GUI gui;

    public void boardSetup() {
        gui = new GUI(GUI_FieldFactory.fieldInitializer(), Color.WHITE);
    }

    public String[] playerNames() {
        int numberOfPlayers = gui.getUserInteger("How many players are you? ");
        String[] playerNames = new String[numberOfPlayers];
        if (numberOfPlayers >= 3 && numberOfPlayers <= 6) {
            for (int i = 0; i < numberOfPlayers; i++) {
                String name = gui.getUserString("Name of Player" + i + ": ");
                playerNames[i] = name;
            }
        }
        return playerNames;
    }


    public
}

            /*int numberOfPlayers = gui.getUserInteger("How many players are you? ");

            if (numberOfPlayers >= 3 && numberOfPlayers<=6){
                playerList = GUI_PlayerList.createPlayerList(numberOfPlayers);
                for (int i = 1; i <= numberOfPlayers; i++) {
                    gui.addPlayer(playerList[i - 1]);
                    String name = gui.getUserString("Name of Player" + i + ": ");
                    playerList[i - 1].setName(name);
                    fields[0].setCar(playerList[i-1],true);
                    playerList[i-1].setBalance(30000);
                }

                return; // Returns back to Main, and starts the game
            }
            else{
                String restart = gui.getUserString("Please choose between 3 and 6 players...Restart by pressing OK");
                boardSetup();
            }


