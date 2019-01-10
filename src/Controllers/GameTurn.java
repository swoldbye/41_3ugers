package Controllers;

import Boundary.GUI_PlayerList;
import Entities.Dice;
import Entities.PlayerArchetype;
import Entities.PlayerList;
import Boundary.GUI_Monopoly;
import gui_main.GUI;
import javafx.geometry.Pos;

import java.util.ArrayList;


public class GameTurn{
GUI_Monopoly instance = new GUI_Monopoly();

    // This controller checks if the game is still eligible to play
    public boolean checkTurn(ArrayList<PlayerArchetype> playerArr){
       if(playerArr.size()>=2){
           // Start turn for every player sequentially
           return false;
       }
       else{
           return true;
       }
    }

    public int[] playerTurn(ArrayList<PlayerArchetype> playerArr, int i){
        int[] playerPos = new int[2];
            // For loop that runs a standard turn for each player.
            instance.rollButton(i); // Prompts the user to roll
            int roll1=Dice.roll();
            int roll2=Dice.roll();
            instance.dieSetter(roll1,roll2,i); // Displays the dice rolls in the gui
            if(((playerArr.get(i).getPosition())+roll1+roll2)>=40){
                playerArr.get(i).setBalance(playerArr.get(i).getBalance()+4000);
            }

            playerPos[0] = playerArr.get(i).getPosition();
            playerArr.get(i).setPosition(((playerArr.get(i).getPosition())+roll1+roll2)%40);
            playerPos[1] = playerArr.get(i).getPosition();




            //if(fieldType[PositionArray[i]=="Ownable"){
                // do something
            //}

            // 1) Lands on ownable
            //    -> Pay rent or Buy or don't buy ownable
            // 2) Lands on chance card
            //    -> Effect of chance card
            // 3) Lands on passive (includes start)
            //    -> Nothing happens
            // 4) Lands on "Go to prison"
            //    -> Goes to prison

          //  PlayerList.playerArr[i].position += Dice.roll();

        return playerPos;

    }
}
