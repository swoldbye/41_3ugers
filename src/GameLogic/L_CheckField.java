package GameLogic;
import Entities.PlayerArchetype;
import java.util.ArrayList;

public class L_CheckField {
    // First checks if user crosses start
    public void checkStart(ArrayList<PlayerArchetype> playerArr, int oldPosition,int i, int roll1, int roll2){
        boolean b = false;
        if((oldPosition+roll1+roll2)>=40){
            playerArr.get(i).setBalance(playerArr.get(i).getBalance()+4000);
        }
        return;
    }

    public int setNewPosition(ArrayList<PlayerArchetype> playerArr,int oldPosition, int i,int roll1, int roll2){
        // Sets the new position before analyzing what field the player landed on
        playerArr.get(i).setPosition((oldPosition+roll1+roll2)%40);
        int newPosition = playerArr.get(i).getPosition();
        return newPosition;
    }

    public void checkPosition(ArrayList<PlayerArchetype> playerArr, int i){
        // Check what field the player lands on
        //
    }
}
