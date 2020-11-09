package com.myproject;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.PseudoColumnUsage;
import java.util.*;
import java.util.List;

public class Board {
    private JFrame board = new JFrame("Tic-Tac-Toe");
    private JButton[] tile = new JButton[9];
    private JPanel cellPanel = new JPanel();
    private JPanel titlePanel = new JPanel();
    private JLabel titleText = new JLabel();
    private boolean isComputer = true;
    JOptionPane popup = new JOptionPane();
    List<JButton> tiles = new ArrayList<>();

    Collection<JButton> compWins = new ArrayList<>();
    Collection<JButton> humanWins = new ArrayList<>();

    public Board() {

        board.setVisible(true);
        board.setSize(900, 900);
        board.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        board.setLayout(new BorderLayout());
        board.getContentPane();

        titlePanel.setLayout(new BorderLayout());
        titlePanel.setBounds(0, 0, 100, 500);

        titleText.setHorizontalAlignment(JLabel.RIGHT);
        titleText.setText("Team 3 Project");
        titleText.setOpaque(false);

        cellPanel.setLayout(new GridLayout(3, 3));
        cellPanel.setBackground(Color.BLACK);

    }


    public void actionPerformed(ActionEvent e) {
        JButton selected = (JButton) e.getSource();
        if (isComputer && selected.getText().equals("Click Me!")) {
            selected.setIcon(new ImageIcon("halloween_pennywise-512.png"));
            selected.setText("");
            compWins.add(selected);
            isComputer = false;
            System.out.println(selected.getActionCommand());


            //TODO send to list to count wins?
        } else if ((!isComputer && selected.getText().equals("Click Me!"))) {
            selected.setIcon(new ImageIcon("yellowRaincoat.png"));
            selected.setText("");
            humanWins.add(selected);
            isComputer = true;
            System.out.println(selected);

        } else if (!selected.getText().equals("Click Me!")) {
            System.out.println("Spot taken");

            //TODO Figure out how to get a message if spot is taken
        }
    }

    public void start() {
        titlePanel.add(titleText);
        board.add(cellPanel);
        board.add(titlePanel, BorderLayout.SOUTH);

        for (int i = 0; i < 9; i++) {
            tile[i] = new JButton();
            tile[i].setBackground(Color.BLACK);
            cellPanel.add(tile[i]);
            tiles.add(tile[i]);
            tile[i].setActionCommand("this is tile" + i);
            tile[i].addActionListener(this::actionPerformed);
            tile[i].setText("Click Me!");

        }
    }


}


