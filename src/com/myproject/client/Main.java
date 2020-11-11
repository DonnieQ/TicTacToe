package com.myproject.client;

import com.myproject.*;

public class Main {
    private static TicTacToe game;
    private static Gamer gamer;

    public static void main(String[] args) {
        System.out.println("Welcome to Java Team Six Gaming Console.");
        System.out.println("Please enter your name: ");
        String name = UserInput.getUserInput();
        gameSelection(name);
    }

    public static void gameSelection(String name) {
        System.out.println("What game would you like to play?\n " +
                "1. TicTacToe\n " +
                "2. Hangman\n " +
                "3. Pac-Man\n " +
                "4. Exit \n" +
                "Please enter a number selection:");
        String gameType = UserInput.getUserInput();
        if (gameType.matches("1")) {
            System.out.println("Ok " + name + " Let's play TicTacToe");
            Board playGame = new Board();
            playGame.start();
        }
    }
}
