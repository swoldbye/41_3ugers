package Boundary;
import Entities.PlayerArchetype;
import gui_fields.GUI_Car;
import gui_fields.GUI_Player;
import jdk.nashorn.internal.objects.Global;

import java.awt.*;
import java.util.ArrayList;

public class GUI_PlayerList {
    GUI_PlayerList(){}
    public GUI_Player[] GUI_playerCarIndex;
    public GUI_Player[] createPlayerList(int amountPlayers)
    {
        GUI_Player[] playerList = new GUI_Player[6];
        GUI_Player[] GUI_playerCarIndex = new GUI_Player[amountPlayers];
        int j = 0;
        int var2 = j + 1;


        GUI_Car car1 = new GUI_Car(Color.RED, Color.RED, GUI_Car.Type.UFO, GUI_Car.Pattern.HORIZONTAL_GRADIANT);
        GUI_Player gui_Player1 = new GUI_Player("Player 1: " , 30000, car1);
        playerList[j] = gui_Player1;

        GUI_Car car2 = new GUI_Car(Color.BLUE, Color.BLUE, GUI_Car.Type.RACECAR, GUI_Car.Pattern.HORIZONTAL_GRADIANT);
        GUI_Player gui_Player2 = new GUI_Player("Player 2: ", 30000, car2);
        playerList[var2++] = gui_Player2;

        GUI_Car car3 = new GUI_Car(Color.WHITE, Color.RED, GUI_Car.Type.CAR, GUI_Car.Pattern.HORIZONTAL_GRADIANT);
        GUI_Player gui_Player3 = new GUI_Player("Player 3: ",30000, car3);
        playerList[var2++] = gui_Player3;

        GUI_Car car4 = new GUI_Car(Color.GRAY, Color.GRAY, GUI_Car.Type.TRACTOR, GUI_Car.Pattern.HORIZONTAL_GRADIANT);
        GUI_Player gui_Player4 = new GUI_Player("Player 4: ",30000, car4);
        playerList[var2++] = gui_Player4;

        GUI_Car car5 = new GUI_Car(Color.GRAY, Color.GRAY, GUI_Car.Type.UFO, GUI_Car.Pattern.HORIZONTAL_GRADIANT);
        GUI_Player gui_Player5 = new GUI_Player("Player 5: ",30000, car5);
        playerList[var2++] = gui_Player5;

        GUI_Car car6 = new GUI_Car(Color.GRAY, Color.GREEN, GUI_Car.Type.RACECAR, GUI_Car.Pattern.HORIZONTAL_GRADIANT);
        GUI_Player gui_Player6 = new GUI_Player("Player 6: ",30000, car6);
        playerList[var2++] = gui_Player6;



        for(int i = 0; i < GUI_playerCarIndex.length; i++){
            GUI_playerCarIndex[i] = playerList[i];
            // GUI_playerCarIndex[i].setName(playerArchetypeList.get(i).getName());
            // Setter is defective.
        }

        return GUI_playerCarIndex;
    }
}