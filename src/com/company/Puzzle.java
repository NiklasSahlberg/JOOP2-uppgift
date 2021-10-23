package com.company;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

public class Puzzle implements ActionListener {

    JButton myResetButton,clearButton;
    JPanel puzzle;
    JLabel test;
    JButton b[] = new JButton[16];


    Puzzle(){

        JFrame main = new JFrame();
        main.setSize(500,500);
        main.setLocationRelativeTo(null);
        main.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        main.setLayout(new BorderLayout());

         puzzle = new JPanel(new GridLayout(4,4,4,4));
         test = new JLabel("");

        ArrayList<Integer> numbers = new ArrayList<Integer>();
        for (int i=0; i<=14; i++) {
            numbers.add(i+1);
        }
        Collections.shuffle(numbers);
        System.out.println(numbers);
        puzzle.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);

        for (int i = 0; i < 15; i++){
                b[i] = new JButton(String.valueOf(numbers.get(i)));
                b[i].addActionListener(this);
                puzzle.add(b[i]);
    }


        puzzle.add(test);
        JPanel resetPanel = new JPanel();
        myResetButton = new JButton("Reset");
        clearButton = new JButton("clear");
        myResetButton.addActionListener(this);
        resetPanel.add(myResetButton);
        main.add(resetPanel,BorderLayout.NORTH);
        main.add(puzzle);
        main.setVisible(true);



    }

    @Override
    public void actionPerformed(ActionEvent e) {


        ArrayList<Integer> numbers = new ArrayList<Integer>();
        for (int i=0; i<=14; i++) {
            numbers.add(i+1);
        }
        Collections.shuffle(numbers);
        if(e.getSource()==myResetButton){
            puzzle.removeAll();
            puzzle.repaint();
            puzzle.revalidate();
            for (int i = 0; i < 15; i++){
                b[i] = new JButton(String.valueOf(numbers.get(i)));
                b[i].addActionListener(this);
                puzzle.add(b[i]);
            }
        }
    }

    public void resetButton(ArrayList <Integer> list){

    }


}
