package com.myproject;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.PseudoColumnUsage;
import java.util.*;
import java.util.List;
import java.util.stream.Stream;

public class Board {
    private JFrame board;
    private JButton[] tile = new JButton[10];
    private JPanel cellPanel;
    private JPanel titlePanel;
    private JLabel titleText;
    private boolean isComputer;

    List<JButton> tiles = new ArrayList<>();
    Collection<JButton> compSelection = new ArrayList<>();
    Collection<JButton> humanSelection = new ArrayList<>();
    List<String> winningCombo = List.of("1,2,3", "4,5,6");
    Thread thread = new Thread();

    public Board() {
        board = new JFrame("Tic-Tac-Toe");

        board.setVisible(true);
        board.setSize(900, 900);
        board.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        board.setLayout(new BorderLayout(15, 15));
        board.getContentPane();

        titlePanel = new JPanel();

        titlePanel.setLayout(new BorderLayout(15, 15));
        titlePanel.setBounds(0, 0, 0, 0);

        titleText = new JLabel();

        titleText.setHorizontalAlignment(JLabel.RIGHT);
        titleText.setText("Team 3 Project ");
        // titleText.setOpaque(false);

        cellPanel = new JPanel();

        cellPanel.setLayout(new GridLayout(3, 3));
        cellPanel.setBackground(Color.BLACK);
    }

    //TODO Separate ActionListener

    public void actionPerformed(ActionEvent e) {
        JButton selected = (JButton) e.getSource();
        if (isComputer && selected.getText().equals("Click Me!")) {
            selected.setIcon(new ImageIcon("halloween_pennywise-512.png"));
            selected.setText("");
            tiles.add(selected);
            compSelection.add(selected);

            isComputer = false;


            //TODO send to list to count wins?
        } else if ((!isComputer && selected.getText().equals("Click Me!"))) {
            selected.setIcon(new ImageIcon("yellowRaincoat.png"));
            selected.setText("");
            tiles.add(selected);
            humanSelection.add(selected);

            isComputer = true;
            //TODO
            computerTurn();
            checkWinner();
            System.out.println(selected.getActionCommand());
        }
    }

    public void start() {
        titlePanel.add(titleText);
        board.add(cellPanel);
        board.add(titlePanel, BorderLayout.SOUTH);

        for (int i = 1; i < 10; i++) {
            tile[i] = new JButton();
            tile[i].setBackground(Color.BLACK);
            cellPanel.add(tile[i]);
            //    tiles.add(tile[i]);
            tile[i].setActionCommand(String.valueOf(i));
            tile[i].addActionListener(this::actionPerformed);
            tile[i].setText("Click Me!");

        }
    }

    //TODO map?

    public void computerTurn() {

        while (isComputer && tiles.size() <= 9) {
            int rand = ComputerBrain.think();
            JButton select = tile[rand];
            if (tile[5].getText().equals("Click Me!")) {
                tile[5].doClick();
            } else if (tile[3].getText().equals("Click Me!")) {
                tile[3].doClick();
            } else if (tile[7].getText().equals("Click Me!")) {
                tile[7].doClick();
            } else if (tile[9].getText().equals("Click Me!")) {
                tile[9].doClick();
            } else if (tile[1].getText().equals("Click Me!")) {
                tile[1].doClick();
            } else if (tile[4].getText().equals("Click Me!")) {
                tile[4].doClick();
            } else if (tile[6].getText().equals("Click Me!")) {
                tile[6].doClick();
            } else if (select.getText().equals("Click Me!")) {
                select.doClick();
            } else {
                break;
            }

        }

    }


    public void checkWinner() {

        if (humanSelection.contains(tile[1]) &&
                humanSelection.contains(tile[2]) &&
                humanSelection.contains(tile[3])) {
            System.out.println("checkWinner 123");
        } else if (humanSelection.contains(tile[4]) &&
                humanSelection.contains(tile[5]) &&
                humanSelection.contains(tile[6])) {
            System.out.println("checkWinner456");
        } else if (humanSelection.contains(tile[7]) &&
                humanSelection.contains(tile[8]) &&
                humanSelection.contains(tile[9])) {
            System.out.println("checkWinner789");
        } else if (humanSelection.contains(tile[1]) &&
                humanSelection.contains(tile[4]) &&
                humanSelection.contains(tile[7])) {
            System.out.println("checkWinner147");
        } else if (humanSelection.contains(tile[2]) &&
                humanSelection.contains(tile[5]) &&
                humanSelection.contains(tile[8])) {
            System.out.println("checkWinner258");
        } else if (humanSelection.contains(tile[3]) &&
                humanSelection.contains(tile[6]) &&
                humanSelection.contains(tile[9])) {
            System.out.println("checkWinner 369");
        } else if (humanSelection.contains(tile[3]) &&
                humanSelection.contains(tile[5]) &&
                humanSelection.contains(tile[7])) {
            System.out.println("checkWinner 357");
        } else if (humanSelection.contains(tile[1]) &&
                humanSelection.contains(tile[5]) &&
                humanSelection.contains(tile[9])) {
            System.out.println("checkWinner 159");
        } else if (compSelection.contains(tile[1]) &&
                compSelection.contains(tile[2]) &&
                compSelection.contains(tile[3])) {
            System.out.println("checkWinner 123");
        } else if (compSelection.contains(tile[4]) &&
                compSelection.contains(tile[5]) &&
                compSelection.contains(tile[6])) {
            System.out.println("checkWinner456");
        } else if (compSelection.contains(tile[7]) &&
                compSelection.contains(tile[8]) &&
                compSelection.contains(tile[9])) {
            System.out.println("checkWinner789");
        } else if (compSelection.contains(tile[1]) &&
                compSelection.contains(tile[4]) &&
                compSelection.contains(tile[7])) {
            System.out.println("checkWinner147");
        } else if (compSelection.contains(tile[2]) &&
                compSelection.contains(tile[5]) &&
                compSelection.contains(tile[8])) {
            System.out.println("checkWinner258");
        } else if (compSelection.contains(tile[3]) &&
                compSelection.contains(tile[6]) &&
                compSelection.contains(tile[9])) {
            System.out.println("checkWinner 369");
        } else if (compSelection.contains(tile[3]) &&
                compSelection.contains(tile[5]) &&
                compSelection.contains(tile[7])) {
            System.out.println("checkWinner 357");
        } else if (compSelection.contains(tile[1]) &&
                compSelection.contains(tile[5]) &&
                compSelection.contains(tile[9])) {
            System.out.println("checkWinner 159");
        }
    }

//    public void superCheckWinner(){
//        String[] boxes = winningCombo.get(0).split(",");
//        for(String box : boxes){
//            if(Stream.of(humanSelection).findAny());
//            System.out.println("win");
//        }
//    }
}

//    public void hardMode() {
//        JButton select = new JButton();
//        ComputerBrain brain = new ComputerBrain();
//        int rand = brain.think();
//        JButton selectRand = (JButton) tile[rand];
//
//        try {
//            thread.sleep(800);
//            if (humanSelection.contains(tile[1]) &&
//                    humanSelection.contains(tile[2])) {
//                select = tile[3];
//
//                select.doClick(5);
//            }
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
//        try {
//            thread.sleep(800);
//            if (humanSelection.contains(tile[2]) &&
//                    humanSelection.contains(tile[3])) {
//                select = tile[1];
//
//                select.doClick(5);
//            }
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
//        try {
//            thread.sleep(800);
//            if (humanSelection.contains(tile[3]) &&
//                    humanSelection.contains(tile[1])) {
//                select = tile[2];
//
//                select.doClick(5);
//            }
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
//        try {
//            thread.sleep(800);
//            if (humanSelection.contains(tile[4]) &&
//                    humanSelection.contains(tile[5])) {
//                select = tile[6];
//
//                select.doClick(5);
//            }
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
//        try {
//            thread.sleep(800);
//            if (humanSelection.contains(tile[6]) &&
//                    humanSelection.contains(tile[4])) {
//                select = tile[5];
//
//                select.doClick(5);
//            }
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
//        try {
//            thread.sleep(800);
//            if (humanSelection.contains(tile[5]) &&
//                    humanSelection.contains(tile[6])) {
//                select = tile[4];
//
//                select.doClick(5);
//            }
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
//        try {
//            thread.sleep(800);
//            if (humanSelection.contains(tile[7]) &&
//                    humanSelection.contains(tile[8])) {
//                select = tile[9];
//
//                select.doClick(5);
//            }
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
//        try {
//            thread.sleep(800);
//            if (humanSelection.contains(tile[9]) &&
//                    humanSelection.contains(tile[7])) {
//                select = tile[8];
//
//                select.doClick(5);
//            }
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
//        try {
//            if (humanSelection.contains(tile[8]) &&
//                    humanSelection.contains(tile[9])) {
//                select = tile[7];
//                thread.sleep(800);
//                select.doClick(5);
//            }
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }






















