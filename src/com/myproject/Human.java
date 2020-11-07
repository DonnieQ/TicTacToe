package com.myproject;

public class Human implements Gamer {
    private String name;

    @Override
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String getName() {
        System.out.println("Welcome to TicTacToe " + name);
        return null;
    }



}