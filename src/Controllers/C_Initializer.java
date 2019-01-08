package Controllers;

import Boundary.GUI_Monopoly;

public class C_Initializer {

    public void initialize(){
        GUI_Monopoly guiTest = new GUI_Monopoly();
        guiTest.boardSetup();

        // Now the board has been initialized, and the players created.
        FirstController startGame = new FirstController();
        startGame.gameTurn();
    }

}
