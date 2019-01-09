package Controllers;

import Boundary.GUI_Monopoly;
import Entities.PlayerArchetype;
import Entities.PlayerList;

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
        guiBoard.InitializePlayersGUI(c_playerArr);


        GameTurn startGame = new GameTurn();
        startGame.checkTurn(c_playerArr);
    }

}
