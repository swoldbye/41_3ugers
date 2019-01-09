package Controllers;

import Boundary.GUI_Monopoly;
import Entities.PlayerList;

public class C_Initializer {

    public void initialize(){
        GUI_Monopoly guiBoard = new GUI_Monopoly();
        PlayerList playerList = new PlayerList();

        guiBoard.boardSetup();
        String[] playerNames = guiBoard.playerNames();
        playerList.playerListInitializer(playerNames);
        guiBoard.InitializePlayersGUI(playerList.getPlayerArr());
    }

}
