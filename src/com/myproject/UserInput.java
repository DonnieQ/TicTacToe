package com.myproject;

import java.util.Scanner;

public class UserInput {
    String name;
    String gameType;
    Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        UserInput user = new UserInput();
        user.acceptUserName();
    }

    public void acceptUserName() {
        System.out.print("Please enter your name: ");
        setName(scanner.nextLine());
        System.out.println("Hello " + name);
        gameSelection();
    }

    public void gameSelection() {
        System.out.println("What game would you like to play?\n " +
                "1. TicTacToe\n " +
                "2. Hangman\n " +
                "3. Pac-Man " +
                "Please enter a number selection");
        setGameType(scanner.nextLine());
        if (gameType.equals("1")) {
            System.out.println("Welcome to TicTacToe " + name);
        }
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGameType() {
        return gameType;
    }

    public void setGameType(String gameType) {
        this.gameType = gameType;
    }
}

