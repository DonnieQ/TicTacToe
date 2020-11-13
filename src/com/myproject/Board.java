package com.myproject;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.util.*;
import java.util.List;


public class Board {
    private final JFrame board;
    private final JButton[] tile = new JButton[10];
    private final JPanel cellPanel;
    private final JPanel titlePanel;
    private final JLabel titleText;
    private boolean isComputer;
    Human human = new Human();
    ComputerBrain brain = new ComputerBrain();
    List<JButton> tiles = new ArrayList<>();

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

        cellPanel = new JPanel();

        cellPanel.setLayout(new GridLayout(3, 3));
        cellPanel.setBackground(Color.BLACK);
    }

    public void actionPerformed(ActionEvent e) {
        JButton selected = (JButton) e.getSource();
        if (isComputer) {

            selected.setIcon(new ImageIcon("halloween_pennywise-512.png"));
            selected.setText("");
            tiles.add(selected);

            brain.getSelections().add(Integer.valueOf(selected.getActionCommand()));
            isComputer = false;
            selected.setEnabled(false);
            checkWinner();
            selected.setEnabled(false);

        } else {

            selected.setIcon(new ImageIcon("yellowRaincoat.png"));
            selected.setText("");
            tiles.add(selected);

            human.getSelections().add(Integer.valueOf(selected.getActionCommand()));
            isComputer = true;
            selected.setEnabled(false);
            checkWinner();
            computerTurn(brain.think());
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
            tile[i].setActionCommand(String.valueOf(i));
            tile[i].addActionListener(this::actionPerformed);
            tile[i].setText(String.valueOf(i));
        }
    }

    public void computerTurn(int num) {
        JButton select = tile[num];
        if (isComputer && tiles.size() < 9) {

            if (!tiles.contains(tile[5])) {
                tile[5].doClick();
            } else if (!tiles.contains(tile[3])) {
                tile[3].doClick();
            } else if (!tiles.contains(tile[7])) {
                tile[7].doClick();
            } else if (!tiles.contains(tile[9])) {
                tile[9].doClick();
            } else if (!tiles.contains(tile[8])) {
                tile[8].doClick();
            } else if (!tiles.contains(tile[4])) {
                tile[4].doClick();
            } else if (!tiles.contains(tile[6])) {
                tile[6].doClick();
            } else if (!tiles.contains(select)) {
                select.doClick();
            } else if(!tiles.contains(tile[1])){
                tile[1].doClick();
            } else if (!tiles.contains(tile[num])){
                tile[brain.think()].doClick();
            }
        }
    }

    public void checkWinner() {
        if (WinningMoves.evaluateWin(brain)) {
            JOptionPane.showMessageDialog(board, new ImageIcon("halloween_pennywise-512.png"), "Game over, winner is:", 1);
            System.exit(0);
        } else if (WinningMoves.evaluateWin(human)) {
            JOptionPane.showMessageDialog(board, new ImageIcon("yellowRaincoat.png"), "Game over, winner is:", 1);
            System.exit(0);
        } else if (tiles.size() == 9) {
            JOptionPane.showMessageDialog(board, new ImageIcon("drawFloat.png"));
            System.exit(0);
        }
    }
}


















