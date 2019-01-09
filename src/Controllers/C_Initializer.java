package Controllers;

import Boundary.GUI_Monopoly;
import Entities.PlayerList;

public class C_Initializer {

    public void initialize(){
        GUI_Monopoly guiBoard = new GUI_Monopoly();
        PlayerList playerList = new PlayerList();

        guiBoard.boardSetup();
        int playerAmount = guiBoard.playerAmount();
        String[] playerNames = guiBoard.playerNames(playerAmount);
        playerList.playerListInitializer(playerNames, playerAmount);
        guiBoard.InitializePlayersGUI(playerList.getPlayerArr());

        GameTurn startGame = new GameTurn();
        startGame.checkTurn();
    }

}
