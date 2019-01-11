package Controllers;

import Boundary.GUI_Monopoly;
import Entities.Field_Abstract;
import Entities.PlayerArchetype;
import Entities.PlayerList;
import gui_fields.GUI_Player;
import Entities.FieldList;
import GameLogic.*;
import java.lang.reflect.Array;
import java.util.ArrayList;

public class C_Initializer {

    public void initialize(){
        GUI_Monopoly guiBoard = new GUI_Monopoly();
        PlayerList playerList = new PlayerList();
        //playerList Singleton = c_playerArr
        //GUI_PlayerList Singleton = c_GUIPlayerArr

        guiBoard.boardSetup();
        int playerAmount = guiBoard.playerAmount();
        // #2 Creating list of Players
        String[] playerNames = guiBoard.playerNames(playerAmount);
        ArrayList<PlayerArchetype> c_playerArr = playerList.playerListInitializer(playerNames, playerAmount);
        // #3 Inserts these players into the GUI
        GUI_Player[] c_GUIPlayerArr = guiBoard.InitializePlayersGUI(c_playerArr);

        // Handing over responsibility to the GameTurn controller. The game has begun :D
        GameTurn startGame = new GameTurn();
        // Note that the checkTurn method accepts the following parameters
        startGame.checkTurn(c_playerArr, c_GUIPlayerArr,guiBoard);
    }

}
