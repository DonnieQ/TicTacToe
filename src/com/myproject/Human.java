package com.myproject;

import java.util.Set;
import java.util.HashSet;


public class Human implements Gamer {
    private String name;
    private String icon;
    private Set<Integer> selections = new HashSet<>();
    private int pickedTile;

    public Human() {

    }

    public Human(String name) {
        setName(name);
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        System.out.println("Welcome to TicTacToe " + name);
        return this.name;
    }

    public String getIcon() {
        return null;
    }

    public void setIcon(String symbol) {
        this.icon = symbol;
    }

    public Set<Integer> getSelections() {
        return selections;
    }


    public int getPickedTile() {
        return pickedTile;
    }

    public void setPickedTile(int pickedTile) {
        this.pickedTile = pickedTile;
    }
}