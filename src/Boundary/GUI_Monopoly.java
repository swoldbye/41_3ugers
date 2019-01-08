package Boundary;
import gui_fields.GUI_Field;
import gui_fields.GUI_Player;
import gui_main.GUI;

import java.awt.*;
public class GUI_Monopoly {

        public static GUI_Player[] gui_Names;
        public static GUI_Field[] fields;
        public static GUI gui;

        public void boardSetup() //forsøg på at bruge GUI. opsætning af bræt.
        {
            fields = GUI_FieldFactory.createFields();

            gui = new GUI(fields, Color.WHITE);
            int numberOfPlayers = gui.getUserInteger("How many players are you? ");

            if (numberOfPlayers >= 3 && numberOfPlayers<=6){
                gui_Names = GUI_PlayerList.createPlayerList(numberOfPlayers);
                for (int i = 1; i <= numberOfPlayers; i++) {
                    gui.addPlayer(gui_Names[i - 1]);
                    String name = gui.getUserString("Name of Player" + i + ": ");
                    gui_Names[i - 1].setName(name);
                    fields[0].setCar(gui_Names[i-1],true);
                    gui_Names[i-1].setBalance(30000);
                }

                return; // Returns back to Main, and starts the game
            }
            else{
                String restart = gui.getUserString("Please choose between 3 and 6 players...Restart by pressing OK");
                boardSetup();
            }
        }

        public void guiGameText(){

            return;
        }
    }
