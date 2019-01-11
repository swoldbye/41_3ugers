package Entities;

import java.util.ArrayList;

public class PlayerArchetype {

    //Attributes
    private String name;
    private int balance;
    private int position;
    private boolean jailed;
    private int jailCounter;


    //Constructor
    public PlayerArchetype(String name, int balance, int position, boolean jailed, int jailCounter) {
        this.name = name;
        this.balance = balance;
        this.position = position;
        this.jailed = jailed;
        this.jailCounter = jailCounter;
    }

    //Getter & Setter methods
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getBalance() {
        return balance;
    }

    public void setBalance(int balance) {
        this.balance = balance;
    }

    public int getPosition() {
        return position;
    }

    public void setPosition(int position) {
        this.position = position;
    }

    public boolean isJailed() { return jailed; }

    public void setJailed(boolean jailed) { this.jailed = jailed; }

    public int getJailCounter() { return jailCounter; }

    public void setJailCounter(int jailCounter) { this.jailCounter = jailCounter; }
}
