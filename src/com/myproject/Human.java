package com.myproject;

import java.util.HashSet;
import java.util.Set;

public class Human implements Gamer{
    private String name;
    private String icon;
    private Set<Integer> selections = new HashSet<>();
    private int pickedTile;
    
    public Human(){}

    public Human(String name, String icon) {
        setName(name);
        setIcon(icon);
        setSelections(selections);
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