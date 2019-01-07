package Entities;

import java.util.ArrayList;

public class PlayerArchetype {

    private String name;
    private int balance;
    private int position;
    ArrayList<Integer> ownedProperties = new ArrayList<Integer>();


    public PlayerArchetype(String name, int position, int balance,ArrayList<Integer> ownedProperties){
        this.name = name;
        this.position = position;
        this.balance = balance;
        this.ownedProperties = ownedProperties;
    }


}
