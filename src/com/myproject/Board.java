package com.myproject;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Board implements ActionListener {
    JFrame board = new JFrame("Tic-Tac-Toe");
    JButton [] tile = new JButton[9];
    JPanel cellPanel = new JPanel();
    JPanel titlePanel = new JPanel();
    JLabel titleText = new JLabel();
    boolean isComputer;
    public Board (){
        board.setVisible(true);
        board.setSize(900,900);
        board.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        board.setLayout(new BorderLayout());

        titlePanel.setLayout(new BorderLayout());
        titlePanel.setBounds(0,0,100,500);

        titleText.setHorizontalAlignment(JLabel.RIGHT);
        titleText.setText("Team 3 Project");
        titleText.setOpaque(false);

        cellPanel.setLayout(new GridLayout(3,3));
        cellPanel.setBackground(Color.BLACK);

        tile[0] = new JButton("1");
        tile[1] = new JButton("2");
        tile[2] = new JButton("3");
        tile[3] = new JButton("4");
        tile[4] = new JButton("5");
        tile[5] = new JButton("6");
        tile[6] = new JButton("7");
        tile[7] = new JButton("8");
        tile[8] = new JButton("9");

        tile[0].addActionListener(this::actionPerformed);
        tile[1].addActionListener(this::actionPerformed);
        tile[2].addActionListener(this::actionPerformed);
        tile[3].addActionListener(this::actionPerformed);
        tile[4].addActionListener(this::actionPerformed);
        tile[5].addActionListener(this::actionPerformed);
        tile[6].addActionListener(this::actionPerformed);
        tile[7].addActionListener(this::actionPerformed);
        tile[8].addActionListener(this::actionPerformed);

        cellPanel.add(tile[0]);
        cellPanel.add(tile[1]);
        cellPanel.add(tile[2]);
        cellPanel.add(tile[3]);
        cellPanel.add(tile[4]);
        cellPanel.add(tile[5]);
        cellPanel.add(tile[6]);
        cellPanel.add(tile[7]);
        cellPanel.add(tile[8]);

        titlePanel.add(titleText);
        board.add(cellPanel);
        board.add(titlePanel, BorderLayout.SOUTH);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(isComputer) {
            tile[0].setIcon(new ImageIcon("halloween_pennywise-512.png"));
        }if(isComputer = false);
        tile[0].setIcon(new ImageIcon("halloween_pennywise-512.png"));

    }
}
