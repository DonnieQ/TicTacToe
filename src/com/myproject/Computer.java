package com.myproject;

public class Computer implements Gamer{
    String name;


    @Override
    public void setName(String name) {
    this.name = "Pennywise";
    }

    @Override
    public String getName() {
    return name;
    }

}
