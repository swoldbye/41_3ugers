package Entities;

import java.util.ArrayList;

public class PlayerArchetype {

    private String name;
    private int balance;
    private int position;
    private String icon;

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public PlayerArchetype(String name, int position, int balance, String icon){
        this.name = name;
        this.position = position;
        this.balance = balance;
        this.icon = icon;
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
}
