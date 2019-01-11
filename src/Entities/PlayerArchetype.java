package Entities;

import java.util.ArrayList;

public class PlayerArchetype {

    //Attributes
    private String name;
    private int balance;
    private int position;
    private int jailStatus;


    //Constructor
    public PlayerArchetype(String name, int balance, int position, int jailStatus) {
        this.name = name;
        this.balance = balance;
        this.position = position;
        this.jailStatus = jailStatus;
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

    public int getJailStatus() { return jailStatus; }

    public void setJailStatus(int jailStatus) { this.jailStatus = jailStatus; }
}
