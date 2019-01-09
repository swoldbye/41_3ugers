package Controllers;

import Entities.Dice;
import Entities.PlayerArchetype;
import Entities.PlayerList;
import Boundary.GUI_Monopoly;
import gui_main.GUI;
import javafx.geometry.Pos;

import java.util.ArrayList;


public class GameTurn{
    public static GUI gui;
    GUI_Monopoly instance = new GUI_Monopoly();


    // This controller checks if the game is still eligible to play
    public void checkTurn(){
       while (PlayerList.playerArr.size()>=2){
           // Start turn for every player sequentially
           playerTurn();
       }
       instance.winMessage(); // Is displayed when there is only 1 player left (the winner :D)
    }

    public void playerTurn(){
        int [] PositionArray = new int [PlayerList.playerArr.size()];

        for (int i=0;i<PlayerList.playerArr.size();i++){
            // For loop that runs a standard turn for each player.
            instance.rollButton(i); // Prompts the user to roll
            int roll1=Dice.roll();
            int roll2=Dice.roll();
            instance.dieSetter(roll1,roll2,i); // Displays the dice rolls in the gui

            PositionArray[i]+=(roll1+roll2);
            // 1) Lands on ownable
            //    -> Pay rent or Buy or don't buy ownable
            // 2) Lands on chance card
            //    -> Effect of chance card
            // 3) Lands on passive (includes start)
            //    -> Nothing happens
            // 4) Lands on "Go to prison"
            //    -> Goes to prison

          //  PlayerList.playerArr[i].position += Dice.roll();
        }
        return;
    }
}
