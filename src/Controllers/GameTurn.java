package Controllers;

import Entities.Dice;
import Entities.PlayerArchetype;
import Entities.PlayerList;
import Boundary.GUI_Monopoly;
import gui_fields.GUI_Player;

import java.util.ArrayList;


public class GameTurn{
    GUI_Monopoly instance = new GUI_Monopoly();


    // This controller checks if the game is still eligible to play
    public void checkTurn(ArrayList<PlayerArchetype> playerArr, GUI_Player[] gui_playerList){
       while (playerArr.size()>=2){
           // Start turn for every player sequentially
           playerTurn(playerArr, gui_playerList);
       }
       instance.winMessage(); // Is displayed when there is only 1 player left (the winner :D)
    }

    public void playerTurn(ArrayList<PlayerArchetype> playerArr,GUI_Player[] gui_playerList){
        for (int i=0;i<PlayerList.playerArr.size();i++){
            // For loop that runs a standard turn for each player.
            instance.rollButton(i); // Prompts the user to roll
            int roll1=Dice.roll();
            int roll2=Dice.roll();
            instance.dieSetter(roll1,roll2,i); // Displays the dice rolls in the gui
            if(((playerArr.get(i).getPosition())+roll1+roll2)>=40){
                playerArr.get(i).setBalance(playerArr.get(i).getBalance()+4000);
                System.out.println(playerArr.get(i).getBalance());
            }

            int oldPosition = playerArr.get(i).getPosition();
            playerArr.get(i).setPosition(((playerArr.get(i).getPosition())+roll1+roll2)%40);
            int newPosition = playerArr.get(i).getPosition();

            instance.movePlayer(i,oldPosition,newPosition, gui_playerList);



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
        }
        return;
    }
}
