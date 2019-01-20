package Entities;

import java.util.ArrayList;

public class PlayerList {
    public static ArrayList<PlayerArchetype> playerArr = new ArrayList<PlayerArchetype>();

    public PlayerList() {

    }

    //public static void setPlayerArr(ArrayList<PlayerArchetype> playerArr) {
    //    PlayerList.playerArr = playerArr;
    //}

    public ArrayList<PlayerArchetype> playerListInitializer(String[] playerNames, int amountOfPlayers){
//        int[] ownGroupInitializer = {0,0,0,0,0,0,0,0,0,0};
//        int[] groupsOwnedInitializer = {0,0,0,0,0,0,0,0,0,0};
        PlayerArchetype[] reservedPlayerList = new PlayerArchetype[6];
        int j = 0;
        int var2 = j + 1;

        PlayerArchetype gui_Player1 = new PlayerArchetype(playerNames[0], 30000, 0, false, 0, 0, false, new int[]{0,0,0,0,0,0,0,0,0,0}, new int[]{0,0,0,0,0,0,0,0,0,0});
        reservedPlayerList[j] = gui_Player1;

        PlayerArchetype gui_Player2 = new PlayerArchetype(playerNames[1], 30000, 0, false, 0, 0, false, new int[]{0,0,0,0,0,0,0,0,0,0}, new int[]{0,0,0,0,0,0,0,0,0,0});
        reservedPlayerList[var2++] = gui_Player2;

        PlayerArchetype gui_Player3 = new PlayerArchetype(playerNames[2], 30000, 0, false, 0, 0, false, new int[]{0,0,0,0,0,0,0,0,0,0}, new int[]{0,0,0,0,0,0,0,0,0,0});
        reservedPlayerList[var2++] = gui_Player3;

        PlayerArchetype gui_Player4 = new PlayerArchetype(playerNames[3], 30000, 0, false, 0, 0, false, new int[]{0,0,0,0,0,0,0,0,0,0}, new int[]{0,0,0,0,0,0,0,0,0,0});
        reservedPlayerList[var2++] = gui_Player4;

        PlayerArchetype gui_Player5 = new PlayerArchetype(playerNames[4], 30000, 0, false, 0, 0, false, new int[]{0,0,0,0,0,0,0,0,0,0}, new int[]{0,0,0,0,0,0,0,0,0,0});
        reservedPlayerList[var2++] = gui_Player5;

        PlayerArchetype gui_Player6 = new PlayerArchetype(playerNames[5], 30000, 0, false, 0, 0, false, new int[]{0,0,0,0,0,0,0,0,0,0}, new int[]{0,0,0,0,0,0,0,0,0,0});
        reservedPlayerList[var2++] = gui_Player6;


        for(int i = 0; i < amountOfPlayers; i++) {
            playerArr.add(reservedPlayerList[i]);
        }
    return playerArr;
    }

}

// felter [-1,-2,-1,-1,-1] eksempel på at et felt ikke har en ejer

// felter [0,-2,2,3,0]