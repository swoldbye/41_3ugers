package Entities;
import java.util.Random;

public class Dice{

    //Constructor of player-object
    private int sides;
    /**
     * Dice is initiated with a Sides Attribute
     *
     * @see sides                   Sides of the dice, "how many different values can it show"
     *
     * @param sides                 Sides of the dice, "how many different values can it show"
     *
     * @return void
     * @author Hans P Byager , Tristan
     * @date   08.11.2018
     */
    public Dice(int sides){
        this.sides = this.sides;
    }

    /**
     * Dice needs to recieve an Integer Array after being initiated, such that it knows what values are on what sides of the dice object
     *
     * @see sidesNum                  different values on different sides of the dice
     *
     * @param SidesNum                different values on different sides of the dice
     *
     * @return void
     * @author Hans P Byager , Tristan
     * @date   08.11.2018
     */
    private int[] SidesNum = new int[sides];
    public void DiceSidesNumDecider(int[] SidesNum){
        this.SidesNum = SidesNum;
    }

    /**
     * A roll funktion that rolls the dice, using a random funktion, to decide what side it lands on, and then reads that sides value to
     * return the value of the rolled side.
     *
     * @return int
     * @author Hans P Byager , Tristan
     * @date   08.11.2018
     */
    public int roll(){
        Random rand = new Random(); //Make an instance of Random
        int roll = rand.nextInt(6)+1; //Random int between [0;max[ +1 ... therefore [1;max]

        //int equalDiceValue = SidesNum[roll-1];
        return roll;
    }

    //get & set Sides
    /**
     * GetSides returns an Integer of the number of Sides on the Dice
     *
     * @return int
     * @author Tristan
     * @date   08.11.2018
     */
    public int getSides()
    {
        return sides;
    }
    /**
     * setSides gives the Dice a new Sides Value
     *
     * @param Sides         an integer that indicates the number of sides on the dice.
     * @return Void
     * @author Tristan
     * @date   08.11.2018
     */
    public void setSides(int Sides)
    {
        this.sides = Sides;
    }


}
