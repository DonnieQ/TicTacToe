package com.myproject;

import java.util.HashSet;
import java.util.Random;
import java.util.Set;

public class ComputerBrain implements Gamer{
    private String name;
    private String icon;
    private Set<Integer> selections = new HashSet<>();
    private int pickedTile;

    public ComputerBrain(String icon) {
        this.icon = icon;
        this.name = "Computer";
    }

    public int think() {
        int min =1;
        int max =9;
        int random_int = (int)(Math.random() * (max-min+1) + min);  //generate random values from 1 to 9
        return random_int;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public Set<Integer> getSelections() {
        return selections;
    }

    public void setSelections(Set<Integer> selections) {
        this.selections = selections;
    }

    public int getPickedTile() {
        return pickedTile;
    }

    public void setPickedTile(int pickedTile) {
        this.pickedTile = pickedTile;
    }

}