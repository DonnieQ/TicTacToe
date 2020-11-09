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
    private JButton[] tile = new JButton[10];
    private JPanel cellPanel = new JPanel();
    private JPanel titlePanel = new JPanel();
    private JLabel titleText = new JLabel();
    private boolean isComputer;
    JOptionPane popup = new JOptionPane();
    List<JButton> tiles = new ArrayList<>();
    Map<String, String>coolMap = new HashMap<>();

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
            tiles.add(selected);

            isComputer = false;



            //TODO send to list to count wins?
        } else if ((!isComputer && selected.getText().equals("Click Me!"))) {
            selected.setIcon(new ImageIcon("yellowRaincoat.png"));
            selected.setText("");
            tiles.add(selected);
            isComputer = true;
            computerTurn();

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
            tile[i].setActionCommand("" + i);
            tile[i].addActionListener(this::actionPerformed);
            tile[i].setText("Click Me!");

        }
    }

    public void computerTurn() {
        ComputerBrain brain = new ComputerBrain();
        int rand = brain.think();
        JButton select = (JButton) tile[rand];
        if (select.getText().equals("Click Me!")) {
            select.doClick();
        } else if (tiles.size() == 9){
            System.out.println("You win!");
        }else {
            computerTurn();
        }

        }

    }








