package Controllers;

import Boundary.GUI_Monopoly;
import Entities.PlayerArchetype;
import Entities.PlayerList;
import gui_fields.GUI_Player;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class C_Initializer {

    public void initialize() {
        GUI_Monopoly guiBoard = new GUI_Monopoly();
        PlayerList playerList = new PlayerList();
        //playerList Singleton = c_playerArr
        //GUI_PlayerList Singleton = c_GUIPlayerArr

        guiBoard.boardSetup();
        int playerAmount = guiBoard.playerAmount();
        String[] playerNames = guiBoard.playerNames(playerAmount);

        ArrayList<PlayerArchetype> c_playerArr = playerList.playerListInitializer(playerNames, playerAmount);
        GUI_Player[] c_GUIPlayerArr = guiBoard.InitializePlayersGUI(c_playerArr);


        //----------------------------------------------------------------------
        // Main Controller From here:

        GameTurn gameTurn = new GameTurn();
        int[] playerPositions = new int[2];

        for (int i = 0; i < c_playerArr.size(); i++) {
            if (gameTurn.checkTurn(c_playerArr) == true) {
                guiBoard.winMessage();
            }
            else {
                playerPositions = gameTurn.playerTurn(c_playerArr, i);
                guiBoard.movePlayer(c_GUIPlayerArr,i, playerPositions[0], playerPositions[1]);
                if(i == c_playerArr.size()){i=0;}

            }
        }
    }

}

