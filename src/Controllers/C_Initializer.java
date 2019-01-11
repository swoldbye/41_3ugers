package Controllers;

import Boundary.GUI_Monopoly;
import Entities.Field_Abstract;
import Entities.PlayerArchetype;
import Entities.PlayerList;
import gui_fields.GUI_Player;
import Entities.FieldList;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class C_Initializer {

    public void initialize(){
        GUI_Monopoly guiBoard = new GUI_Monopoly();
        PlayerList playerList = new PlayerList();


        guiBoard.boardSetup();
        int playerAmount = guiBoard.playerAmount();
        String[] playerNames = guiBoard.playerNames(playerAmount);

        ArrayList<PlayerArchetype> c_playerArr = playerList.playerListInitializer(playerNames, playerAmount);
        GUI_Player[] c_GUIPlayerArr = guiBoard.InitializePlayersGUI(c_playerArr);


        GameTurn startGame = new GameTurn();
        startGame.checkTurn(c_playerArr, c_GUIPlayerArr);

        //FieldList initialization
        Field_Abstract[] fieldList =  FieldList.createFieldList();
    }

}
