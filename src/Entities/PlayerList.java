package Entities;

import java.util.ArrayList;

public class PlayerList {
    public static ArrayList<PlayerArchetype> playerArr = new ArrayList<PlayerArchetype>();

    public PlayerList() {
    }

    //public static void setPlayerArr(ArrayList<PlayerArchetype> playerArr) {
    //    PlayerList.playerArr = playerArr;
    //}

    public static void playerListInitializer(String[] playerNames){

        PlayerArchetype[] reservedPlayerList = new PlayerArchetype[6];
        int j = 0;
        int var2 = j + 1;

        PlayerArchetype gui_Player1 = new PlayerArchetype(playerNames[1], 0, 30000, "car1");
        reservedPlayerList[j] = gui_Player1;

        PlayerArchetype gui_Player2 = new PlayerArchetype(playerNames[2], 0, 30000, "car2");
        reservedPlayerList[var2++] = gui_Player2;

        PlayerArchetype gui_Player3 = new PlayerArchetype(playerNames[3], 0, 30000, "car3");
        reservedPlayerList[var2++] = gui_Player3;

        PlayerArchetype gui_Player4 = new PlayerArchetype(playerNames[4], 0, 30000, "car4");
        reservedPlayerList[var2++] = gui_Player4;

        PlayerArchetype gui_Player5 = new PlayerArchetype(playerNames[5], 0, 30000, "car5");
        reservedPlayerList[var2++] = gui_Player5;

        PlayerArchetype gui_Player6 = new PlayerArchetype(playerNames[6], 0, 30000, "car6");
        reservedPlayerList[var2++] = gui_Player6;


        for(int i = 0; i < playerNames.length; ++i) {
            playerArr.add(reservedPlayerList[i]);
        }


    }

    public ArrayList<PlayerArchetype> getPlayerArr() {
        return playerArr;
    }
}

