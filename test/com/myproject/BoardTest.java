package com.myproject;

import org.junit.Before;
import org.junit.Test;

import javax.swing.*;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import static org.junit.Assert.*;

public class BoardTest implements ActionListener {
    Board board;
    private JButton[] tileTest= new JButton[12];

    @Before
    public void setUp()  {
        board = new Board();
    }

    @Test
    public void computerTurnTest_withNineTiles() {
        JButton select = tileTest[1];
        board.tiles.add(tileTest[1]);
        board.tiles.add(tileTest[2]);
        board.tiles.add(tileTest[3]);
        board.tiles.add(tileTest[4]);
        board.tiles.add(tileTest[5]);
        board.tiles.add(tileTest[6]);
        board.tiles.add(tileTest[7]);
        board.tiles.add(tileTest[8]);
        board.tiles.add(tileTest[9]);
        board.computerTurn(1);
        tileTest[1].addActionListener(this);


    }

    @Test
    public void superCheckWinner() {
    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }
}