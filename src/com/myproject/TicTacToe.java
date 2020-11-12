package com.myproject;

public class TicTacToe {

Human human = new Human();

    public void initiateGame() {
        System.out.println("Welcome to Java Team Six Gaming Console.");
        System.out.println("Please enter your name: ");
        human.setName(UserInput.getUserInput());
        gameSelection();
    }

    public void gameSelection() {
        System.out.println("What game would you like to play?\n " +
                "1. TicTacToe\n " +
                "2. Hangman**Coming soon**\n " +
                "3. Pac-Man**Coming soon**\n " +
                "Please enter a number selection:");
        String gameType = UserInput.getUserInput();
        if (gameType.matches("1")) {
            System.out.println("Welcome to TicTacToe " + human.getName() );
            Board playgame = new Board();

            playgame.start();

        }else{
            System.out.println("invalid selection " + human.getName() + ", please choose 1.");
            gameSelection();
        }
    }
}


