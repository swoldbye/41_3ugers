package Entities;

import java.util.ArrayList;

public class PlayerList {
    public PlayerArchetype[] playerArr;

    public PlayerList() {
    }

    public void playerListInitializer(String[] playerNames){
        for(int i = 0; i < playerNames.length; i++){
            playerArr[i] = new PlayerArchetype(playerNames[i], 0, 30000);
        }
    }

    public PlayerArchetype[] getPlayerArr() {
        return playerArr;
    }
}

