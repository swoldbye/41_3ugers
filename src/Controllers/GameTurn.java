package Controllers;

import Boundary.GUI_Monopoly;
import Entities.Dice;
import Entities.PlayerArchetype;
import Entities.PlayerList;
import gui_fields.GUI_Player;

import java.util.ArrayList;


public class GameTurn{
    // This method checks if the game is still eligible to play. You need to be at least 2 players
    public void checkTurn(ArrayList<PlayerArchetype> playerArr, GUI_Player[] gui_playerList, GUI_Monopoly guiInstance){
       while (playerArr.size()>=2){
           // Calls the playerTurn method
           playerTurn(playerArr, gui_playerList, guiInstance);
       }
       // The while loop ends when there is only 1 player left, the winner. Then we prompt the winMessage
        guiInstance.winMessage(); // Is displayed when there is only 1 player left (the winner :D)
    }
    // T
    public void playerTurn(ArrayList<PlayerArchetype> playerArr,GUI_Player[] gui_playerList,GUI_Monopoly guiInstance){
        for (int i=0;i<PlayerList.playerArr.size();i++) {
            // For loop that runs a standard turn for each player.
            int oldPosition = playerArr.get(i).getPosition();
            if (oldPosition == 30) {
                //Call jail method
            }

            guiInstance.rollButton(i); // Prompts the user to roll
            int roll1=Dice.roll();
            int roll2=Dice.roll();
            guiInstance.dieSetter(roll1,roll2,i); // Displays the dice rolls in the gui
            if(((playerArr.get(i).getPosition())+roll1+roll2)>=40){
                playerArr.get(i).setBalance(playerArr.get(i).getBalance()+4000);
                System.out.println(playerArr.get(i).getBalance());
            }
            playerArr.get(i).setPosition(((playerArr.get(i).getPosition())+roll1+roll2)%40);
            int newPosition = playerArr.get(i).getPosition();
            guiInstance.movePlayer(i,oldPosition,newPosition, gui_playerList);

        }

    }
}

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
