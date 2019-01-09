package Entities;

import java.util.ArrayList;

public class PlayerList {
    public static ArrayList<PlayerArchetype> playerArr = new ArrayList<PlayerArchetype>();

    public PlayerList() {
    }

    public static void playerListInitializer(String[] playerNames){
        for(int i = 0; i < playerNames.length; i++){
            playerArr.add(new PlayerArchetype(playerNames[i], 0,30000));
        }


    }

    public ArrayList<PlayerArchetype> getPlayerArr() {
        return playerArr;
    }
}

