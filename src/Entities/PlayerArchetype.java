package Entities;

import java.util.ArrayList;

public class PlayerArchetype {

    //Attributes
    private String name;
    private int balance;
    private int position;
    private boolean jailed;
    private int jailCounter;
    private int jailCard;
    private boolean bankrupt;
    private int[] ownGroup;

    //Constructor
    public PlayerArchetype(String name, int balance, int position, boolean jailed, int jailCounter, int jailCard, boolean bankrupt, int[] ownGroup) {
        this.name = name;
        this.balance = balance;
        this.position = position;
        this.jailed = jailed;
        this.jailCounter = jailCounter;
        this.jailCard = jailCard;
        this.bankrupt = bankrupt;
        this.ownGroup = ownGroup;
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

    public int getJailCard() {
        return jailCard;
    }

    public void setJailCard(int jailCard) {
        this.jailCard = jailCard;
    }

    public boolean isBankrupt() {return bankrupt;}

    public void setBankrupt(boolean bankrupt) {this.bankrupt = bankrupt;}

    public int[] getOwnGroup() {
        return ownGroup;
    }

    public void setOwnGroup(int[] ownGroup) {
        this.ownGroup = ownGroup;
    }
}

