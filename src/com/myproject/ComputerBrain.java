package com.myproject;

import java.util.Random;

public class ComputerBrain {
    public void think() {
        int min =1;
        int max =9;
        int random_int = (int)(Math.random() * (max-min+1) + min);  //generate random values from 1 to 9
        System.out.println(random_int);
    }
}