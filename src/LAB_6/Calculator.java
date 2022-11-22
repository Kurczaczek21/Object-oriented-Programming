package LAB_6;

import javax.swing.*;
import java.awt.*;

public class Calculator {

    static double int_1 = Double.NaN;
    static double int_2 = Double.NaN;
    static double total = Double.NaN;

    static boolean lastInputWasEqual = false;
    static boolean lastInputWasAction = true;
    static boolean dividingByZero = false;
    static boolean hasBeenSolved = true;

    static String action = "none";
    static String answer;
    public static void createAndShowGUI() {

        /*
            to do:
            - nadpisywanie znaku
            - 0 na start
            - nie clearowanie po nacisnieciu znaku
            - dzialanie przy wprowadzeniu 1 liczby i znaku np 2 * = daje nam 4 bo 2 zostala i jest nowym arg 2
            - optymalizacja bo za duzo linijek :(
         */


        // DISPLAY PNAEL
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridwidth = GridBagConstraints.REMAINDER;
        JTextField field = new JTextField(12);
        field.setFont(new Font("Calabri",Font.BOLD,24));
        field.setHorizontalAlignment(JTextField.RIGHT);
        field.setEditable( false );
        field.setText("0");


        // BUTTON PANEL
        JPanel panel = new JPanel();

        panel.setPreferredSize(new Dimension(300,150));
        panel.setBackground(Color.lightGray);
        panel.setLayout(new GridLayout(4,4,6,6));


        // BUTTON SETTINGS


        JButton button1 = new JButton(" 1 ");
        button1.addActionListener(evt -> {
            if(lastInputWasAction){
                field.setText("");
            }
            if(field.getText().equals("0")){
                field.setText("");
            }
            field.setText(field.getText().concat("1"));
            lastInputWasAction = false;
        });
        button1.setFocusable(false);

        JButton button2 = new JButton(" 2 ");
        button2.addActionListener(evt -> {
            if(lastInputWasAction){
                field.setText("");
            }
            if(field.getText().equals("0")){
                field.setText("");
            }
            field.setText(field.getText().concat("2"));
            lastInputWasAction = false;
        });
        button2.setFocusable(false);

        JButton button3 = new JButton(" 3 ");
        button3.addActionListener(evt -> {
            if(lastInputWasAction){
                field.setText("");
            }
            if(field.getText().equals("0")){
                field.setText("");
            }
            field.setText(field.getText().concat("3"));
            lastInputWasAction = false;
        });
        button3.setFocusable(false);

        JButton button5 = new JButton(" 4 ");
        button5.addActionListener(evt -> {
            if(lastInputWasAction){
                field.setText("");
            }
            if(field.getText().equals("0")){
                field.setText("");
            }
            field.setText(field.getText().concat("4"));
            lastInputWasAction = false;
        });
        button5.setFocusable(false);

        JButton button6 = new JButton(" 5 ");
        button6.addActionListener(evt -> {
            if(lastInputWasAction){
                field.setText("");
            }
            if(field.getText().equals("0")){
                field.setText("");
            }
            field.setText(field.getText().concat("5"));
            lastInputWasAction = false;
        });
        button6.setFocusable(false);

        JButton button7 = new JButton(" 6 ");
        button7.addActionListener(evt -> {
            if(lastInputWasAction){
                field.setText("");
            }
            if(field.getText().equals("0")){
                field.setText("");
            }
            field.setText(field.getText().concat("6"));
            lastInputWasAction = false;
        });
        button7.setFocusable(false);


        JButton button9 = new JButton(" 7 ");
        button9.addActionListener(evt -> {
            if(lastInputWasAction){
                field.setText("");
            }
            if(field.getText().equals("0")){
                field.setText("");
            }
            field.setText(field.getText().concat("7"));
            lastInputWasAction = false;
        });
        button9.setFocusable(false);

        JButton button10 = new JButton(" 8 ");
        button10.addActionListener(evt -> {
            if(lastInputWasAction){
                field.setText("");
            }
            if(field.getText().equals("0")){
                field.setText("");
            }
            field.setText(field.getText().concat("8"));
            lastInputWasAction = false;
        });
        button10.setFocusable(false);

        JButton button11 = new JButton(" 9 ");
        button11.addActionListener(evt -> {
            if(lastInputWasAction){
                field.setText("");
            }
            if(field.getText().equals("0")){
                field.setText("");
            }
            field.setText(field.getText().concat("9"));
            lastInputWasAction = false;
        });
        button11.setFocusable(false);

        JButton button13 = new JButton(" 0 ");
        button13.addActionListener(evt -> {
            if(lastInputWasAction){
                field.setText("");
            }
            if(!field.getText().startsWith("0")) {
                field.setText(field.getText().concat("0"));
            }
            lastInputWasAction = false;
        });
        button13.setFocusable(false);

        // EQUATION BUTTON

        JButton button14 = new JButton(" = ");
        button14.addActionListener(e -> {
            if (lastInputWasEqual) {
                int_1 = Double.parseDouble(field.getText());
            } else {
                int_2 = Double.parseDouble(field.getText());
            }

            switch (action) {
                case "+":
                    total = int_1 + int_2;
                    break;
                case "-":
                    total = int_1 - int_2;
                    break;
                case "*":
                    total = int_1 * int_2;
                    break;
                case "/":
                    if (int_2 != 0) {
                        total = int_1 / int_2;
                    } else {
                        dividingByZero = true;
                    }
                case "none":
                    total = Double.parseDouble(field.getText());
                    break;
            }
            if ((total % 1) == 0) {
                answer = String.valueOf((int) total);
            } else {
                answer = String.valueOf(total);
            }
            if (!dividingByZero) {
                field.setText(answer);
            } else {
                field.setText("ERROR");
                dividingByZero = false;
            }
            lastInputWasEqual = true;
            lastInputWasAction = true;
            hasBeenSolved = true;
        });
        button14.setFocusable(false);

        JButton button15 = new JButton(" C ");
        button15.addActionListener(evt -> {
            int_1 = Double.NaN;
            int_2 = Double.NaN;
            field.setText("0");
            action = "none";
            hasBeenSolved = true;
        });
        button15.setFocusable(false);

        // MATH OPERATION BUTTONS

        JButton button4 = new JButton(" + ");
        button4.addActionListener(e -> {
            if (!hasBeenSolved) {
                button14.doClick();
                hasBeenSolved = true;
            }
            int_1 = Double.parseDouble(field.getText());
            action = "+";
            if(!lastInputWasAction) {
                hasBeenSolved = false;
            }
            lastInputWasEqual = false;
            lastInputWasAction = true;
        });
        button4.setFocusable(false);


        JButton button8 = new JButton(" - ");
        button8.addActionListener(e -> {
            if (!hasBeenSolved) {
                button14.doClick();
                hasBeenSolved = true;
            }

            int_1 = Double.parseDouble(field.getText());
            action = "-";

            if(!lastInputWasAction) {
                hasBeenSolved = false;
            }
            lastInputWasEqual = false;
            lastInputWasAction = true;
        });
        button8.setFocusable(false);

        JButton button12 = new JButton(" * ");
        button12.addActionListener(e -> {
            if (!hasBeenSolved) {
                button14.doClick();
                hasBeenSolved = true;
            }
            int_1 = Double.parseDouble(field.getText());
            action="*";
            if(!lastInputWasAction) {
                hasBeenSolved = false;
            }
            lastInputWasEqual = false;
            lastInputWasAction = true;

        });
        button12.setFocusable(false);

        JButton button16 = new JButton(" / ");
        button16.addActionListener(e -> {
            if (!hasBeenSolved) {
                button14.doClick();
                hasBeenSolved = true;
            }
            int_1 = Double.parseDouble(field.getText());
            action="/";
            if(!lastInputWasAction) {
                hasBeenSolved = false;
            }
            lastInputWasEqual = false;
            lastInputWasAction = true;
        });
        button16.setFocusable(false);




//        for (int index = 1; index <= 16; index++) {
//            panel.add(button(index));
//        }

        panel.add(button1);
        panel.add(button2);
        panel.add(button3);
        panel.add(button4);
        panel.add(button5);
        panel.add(button6);
        panel.add(button7);
        panel.add(button8);
        panel.add(button9);
        panel.add(button10);
        panel.add(button11);
        panel.add(button12);
        panel.add(button13);
        panel.add(button14);
        panel.add(button15);
        panel.add(button16);


        // MAIN FRAME
        JFrame frame = new JFrame(" Calculator kurczaka");

        ImageIcon image = new ImageIcon("kalkulator.png");
        frame.setIconImage(image.getImage());

        frame.setVisible(true);
        frame.setSize(350,255);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);
        frame.getContentPane().setBackground(Color.DARK_GRAY);
        frame.setLayout(new FlowLayout());
        frame.setLocationRelativeTo(null);
        frame.add(field, gbc);
        frame.add(panel);
    }


    public static void main(String[] args) {
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() { createAndShowGUI(); }
        });
    }

    protected static JButton createButton(int index) {
        JButton btn = new JButton(" "+String.valueOf(index)+" ");
        btn.setFocusable(false);
//        btn.addActionListener(buttonActionHandler);
        return btn;
    }
}