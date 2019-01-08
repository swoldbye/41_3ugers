package Controllers;

import Boundary.GUI_Monopoly;
import Entities.PlayerList;

public class C_Initializer {

    public void initialize(){
        GUI_Monopoly guiTest = new GUI_Monopoly();
        guiTest.boardSetup();

        // Now the board has been initialized, and the players created.
        FirstController startGame = new FirstController();
        startGame.gameTurn();
        GUI_Monopoly guiBoard = new GUI_Monopoly();
        PlayerList playerList = new PlayerList();

        guiBoard.boardSetup();
        String[] playerNames = guiBoard.playerNames();
        playerList.playerListInitializer(playerNames);
    }

}
