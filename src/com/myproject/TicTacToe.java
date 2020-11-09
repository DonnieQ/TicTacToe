package com.myproject;

public class TicTacToe {
    //private Gamer player1;


    public void initiateGame() {
        System.out.println("Welcome to Java Team Six Gaming Console.");
        System.out.println("Please enter your name: ");
        new Human().setName(UserInput.getUserInput());
        gameSelection();
    }

    public static void gameSelection() {
        System.out.println("What game would you like to play?\n " +
                "1. TicTacToe\n " +
                "2. Hangman\n " +
                "3. Pac-Man\n " +
                "4. Exit \n" +
                "Please enter a number selection:");
        String gameType = UserInput.getUserInput();
        if (gameType.matches("1")) {
            System.out.println("Welcome to TicTacToe ");
            Board playgame = new Board();
            playgame.start();
        }
    }
}


