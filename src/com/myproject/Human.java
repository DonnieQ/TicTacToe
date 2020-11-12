package com.myproject;

import java.util.Set;
import java.util.HashSet;


public class Human implements Gamer {
    private String name;
    private String icon;
    private Set<Integer> selections = new HashSet<>();

    public Human() {

    }

    public Human(String name) {
        setName(name);
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {

        return this.name;
    }


    public Set<Integer> getSelections() {
        return selections;
    }

}