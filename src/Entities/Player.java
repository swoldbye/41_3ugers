package Entities;

public class Player {
    private String name;
    private int Points;
    private int Position;

    public Player(String name, int PlayerStartPosition, int Points) //Constructor of player-object
    {
        this.name = name;
        this.Points = Points;
        this.Position = PlayerStartPosition;
    }


//get & set methods
    //get & set name

    public String getName()
    {
        return name;
    }


    public void setName(String name)
    {
        this.name = name;
    }

    //get & set Position

    public int getPosition()
    {
        return Position;
    }

    public void setPosition(int Position)
    {
        this.Position = Position;
    }

    //get & set score

    public int getPoints()
    {
        return Points;
    }

    public void setPoints(int Points)
    {
        this.Points = Points;
    }

}
