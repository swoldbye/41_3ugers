package Entities;

import java.util.ArrayList;

public class PlayerList {

    public PlayerList() {
    }

    public void playerListInitializer(String[] playerNames){
        PlayerArchetype[] playersArr = new PlayerArchetype[playerNames.length];
        for(int i = 0; i < playerNames.length; i++){
            playersArr[i] = new PlayerArchetype(playerNames[i], 0, 30000);
        }
    }



}

