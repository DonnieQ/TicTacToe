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
    Collection<String> winCalc = new ArrayList<>();

    Map<String, Collection<String>> humMap = new HashMap<>();




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
        if (isComputer) {

            selected.setIcon(new ImageIcon("halloween_pennywise-512.png"));
            selected.setText(".");
            tiles.add(selected);
            compSelection.add(selected);
            selected.setEnabled(false);
            isComputer = false;
            superCheckWinner();
        }
        else {

            selected.setIcon(new ImageIcon("yellowRaincoat.png"));
            selected.setText("");
            tiles.add(selected);
            humanSelection.add(selected);
            winCalc.add(selected.getActionCommand());
            humMap.put("hum", winCalc);
            selected.setEnabled(false);
            isComputer = true;
            computerTurn(ComputerBrain.think());

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
            tile[i].setText(String.valueOf(i));

        }
    }

    //TODO map?

    public void computerTurn(int num) {
        while (isComputer && tiles.size() <= 9) {
            JButton select = tile[num];
            if (tile[5].isEnabled()) {
                tile[5].doClick();
            } else if (tile[3].isEnabled()) {
                tile[3].doClick();
            } else if (tile[7].isEnabled()) {
                tile[7].doClick();
            } else if (tile[9].isEnabled()) {
                tile[9].doClick();
            } else if (tile[1].isEnabled()) {
                tile[1].doClick();
            } else if (tile[4].isEnabled()) {
                tile[4].doClick();
            } else if (tile[6].isEnabled()) {
                tile[6].doClick();
            } else if (select.isEnabled()) {
                select.doClick();
            } else {
                break;
            }

        }
    }

        public void superCheckWinner () {
            if (tile[1].getText().equals(tile[2].getText()) && tile[1].getText().equals(tile[3].getText())) {
                JOptionPane.showMessageDialog(board, tile[1].getIcon(), "Game Over, winner is:", 1);
            } else if (tile[4].getText().equals(tile[5].getText()) && tile[4].getText().equals(tile[6].getText())) {
                JOptionPane.showMessageDialog(board, tile[4].getIcon(), "Game Over, winner is:", 1);
            } else if (tile[7].getText().equals(tile[8].getText()) && tile[7].getText().equals(tile[9].getText())) {
                JOptionPane.showMessageDialog(board, tile[7].getIcon(), "Game Over, winner is:", 1);
            } else if (tile[1].getText().equals(tile[4].getText()) && tile[1].getText().equals(tile[7].getText())) {
                JOptionPane.showMessageDialog(board, tile[1].getIcon(), "Game Over, winner is:", 1);
            } else if (tile[2].getText().equals(tile[5].getText()) && tile[2].getText().equals(tile[8].getText())) {
                JOptionPane.showMessageDialog(board, tile[2].getIcon(), "Game Over, winner is:", 1);
            } else if (tile[3].getText().equals(tile[6].getText()) && tile[3].getText().equals(tile[9].getText())) {
                JOptionPane.showMessageDialog(board, tile[3].getIcon(), "Game Over, winner is:", 1);
            } else if (tile[1].getText().equals(tile[5].getText()) && tile[1].getText().equals(tile[9].getText())) {
                JOptionPane.showMessageDialog(board, tile[1].getIcon(), "Game Over, winner is:", 1);
            } else if (tile[3].getText().equals(tile[5].getText()) && tile[3].getText().equals(tile[7].getText())) {
                JOptionPane.showMessageDialog(board, tile[3].getIcon(), "Game Over, winner is:", 1);
            }
        }

    public boolean isComputer() {
        return isComputer;
    }

    public void setComputer(boolean computer) {
        isComputer = computer;
    }

    public List<JButton> getTiles() {
        return tiles;
    }

    public void setTiles(List<JButton> tiles) {
        this.tiles = tiles;
    }
}


//       for(int i = 0; i<8; i++){
//          String but = "help";
//          switch (i){
//           case 0:
//               but = tile[1].getActionCommand() + " " + tile[2].getActionCommand();
//               break;
//
//
//          }if (winCalc.contains(but)){
//               System.out.println("player wins");
//          }else{
//               System.out.println(but);
//           }
//       }
//       }


//        if (humMap.containsKey("hum")) {
//            humMap.put("hum", humanSelection);
//            System.out.println(humMap.values());
//        }else if (humMap.values().equals("[3, 2, 1]")){
//            System.out.println("winner");
//        }
//
//        else {
//            Collection<String> values = new ArrayList<>();
//            values.add("0");
//            humMap.put("hum", values);
//
//        }


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
//public void checkWinner() {
//
//    if (humanSelection.contains(tile[1]) &&
//            humanSelection.contains(tile[2]) &&
//            humanSelection.contains(tile[3])) {
//        JOptionPane.showMessageDialog(board,"You Win!");
//    } else if (humanSelection.contains(tile[4]) &&
//            humanSelection.contains(tile[5]) &&
//            humanSelection.contains(tile[6])) {
//        JOptionPane.showMessageDialog(board,"You Win!");
//    } else if (humanSelection.contains(tile[7]) &&
//            humanSelection.contains(tile[8]) &&
//            humanSelection.contains(tile[9])) {
//        JOptionPane.showMessageDialog(board,"You Win!");
//    } else if (humanSelection.contains(tile[1]) &&
//            humanSelection.contains(tile[4]) &&
//            humanSelection.contains(tile[7])) {
//        JOptionPane.showMessageDialog(board,"You Win!");
//    } else if (humanSelection.contains(tile[2]) &&
//            humanSelection.contains(tile[5]) &&
//            humanSelection.contains(tile[8])) {
//        JOptionPane.showMessageDialog(board,"You Win!");
//    } else if (humanSelection.contains(tile[3]) &&
//            humanSelection.contains(tile[6]) &&
//            humanSelection.contains(tile[9])) {
//        JOptionPane.showMessageDialog(board,"You Win!");
//    } else if (humanSelection.contains(tile[3]) &&
//            humanSelection.contains(tile[5]) &&
//            humanSelection.contains(tile[7])) {
//        JOptionPane.showMessageDialog(board,"You Win!");
//    } else if (humanSelection.contains(tile[1]) &&
//            humanSelection.contains(tile[5]) &&
//            humanSelection.contains(tile[9])) {
//        JOptionPane.showMessageDialog(board,"Pennywise Won :(");
//    } else if (compSelection.contains(tile[1]) &&
//            compSelection.contains(tile[2]) &&
//            compSelection.contains(tile[3])) {
//        JOptionPane.showMessageDialog(board,"Pennywise Won :(");
//    } else if (compSelection.contains(tile[4]) &&
//            compSelection.contains(tile[5]) &&
//            compSelection.contains(tile[6])) {
//        JOptionPane.showMessageDialog(board,"Pennywise Won :(");
//    } else if (compSelection.contains(tile[7]) &&
//            compSelection.contains(tile[8]) &&
//            compSelection.contains(tile[9])) {
//        JOptionPane.showMessageDialog(board,"Pennywise Won :(");
//    } else if (compSelection.contains(tile[1]) &&
//            compSelection.contains(tile[4]) &&
//            compSelection.contains(tile[7])) {
//        JOptionPane.showMessageDialog(board,"Pennywise Won :(");
//    } else if (compSelection.contains(tile[2]) &&
//            compSelection.contains(tile[5]) &&
//            compSelection.contains(tile[8])) {
//        JOptionPane.showMessageDialog(board,"Pennywise Won :(");
//    } else if (compSelection.contains(tile[3]) &&
//            compSelection.contains(tile[6]) &&
//            compSelection.contains(tile[9])) {
//        JOptionPane.showMessageDialog(board,"Pennywise Won :(");
//    } else if (compSelection.contains(tile[3]) &&
//            compSelection.contains(tile[5]) &&
//            compSelection.contains(tile[7])) {
//        JOptionPane.showMessageDialog(board,"Pennywise Won :(");
//    } else if (compSelection.contains(tile[1]) &&
//            compSelection.contains(tile[5]) &&
//            compSelection.contains(tile[9])) {
//        JOptionPane.showMessageDialog(board,"Pennywise Won :(");
//    }else if (tiles.size() == 9){
//        JOptionPane.showMessageDialog(board,"Draw!");
//    }
//}


//while (isComputer && tiles.size() <= 9) {
//        if (tile[num].isEnabled()) {
//        switch (num) {
//        case 1:
//        case 3:
//        case 4:
//        tile[5].doClick();
//        break;
//        case 2:
//        case 5:
//        tile[3].doClick();
//        break;
//default:
//        tile[num].doClick();
//        break;
//        }
//        }else if (!tile[num].isEnabled()){
//        tile[ComputerBrain.think()].doClick();
//        }else {break;}
//        }



















