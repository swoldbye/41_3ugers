package Entities;

import java.util.ArrayList;

public class PlayerList {
    ArrayList<PlayerArchetype> playerArr = new ArrayList<PlayerArchetype>();

    public PlayerList() {
    }

    public void playerListInitializer(String[] playerNames){
        for(int i = 0; i < playerNames.length; i++){
            playerArr.add(new PlayerArchetype(playerNames[i], 0,30000));
        }
    }

    public ArrayList<PlayerArchetype> getPlayerArr() {
        return playerArr;
    }
}

