package LAB_6;

import javax.swing.*;
import java.awt.*;
import java.util.HashMap;
import java.util.Objects;

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

//        HashMap<Integer, JButton> numButtons = new HashMap<Integer, JButton>();
//        for (int i=1;i<10;i++){
//            numButtons.put(i,createButton(i, field));
//        }

        JButton button1 = new JButton("1");
        numKeyAction(field, button1);

        JButton button2 = new JButton("2");
        numKeyAction(field, button2);

        JButton button3 = new JButton("3");
        numKeyAction(field, button3);

        JButton button4 = new JButton("4");
        numKeyAction(field, button4);

        JButton button5 = new JButton("5");
        numKeyAction(field, button5);

        JButton button6 = new JButton("6");
        numKeyAction(field, button6);


        JButton button7 = new JButton("7");
        numKeyAction(field, button7);

        JButton button8 = new JButton("8");
        numKeyAction(field, button8);

        JButton button9 = new JButton("9");
        numKeyAction(field, button9);

        JButton buttonZero = new JButton("0");
        buttonZero.addActionListener(e -> {
            if(lastInputWasAction){
                field.setText("");
            }
            if(lastInputWasEqual){
                field.setText("");
                int_1 = Double.NaN;
                int_2 = Double.NaN;
                action = "none";
                hasBeenSolved = true;
            }
            if(!field.getText().startsWith("0")) {
                field.setText(field.getText().concat(buttonZero.getText()));
            }
            lastInputWasAction = false;
            lastInputWasEqual = false;
        });
        buttonZero.setFocusable(false);

        // EQUATION BUTTON

        JButton buttonEquals = new JButton("=");
        buttonEquals.addActionListener(e -> {
            if (lastInputWasEqual) {
                int_1 = Double.parseDouble(field.getText());
            } else {
                int_2 = Double.parseDouble(field.getText());
            }

            switch (action) {
                case "+" -> total = int_1 + int_2;
                case "-" -> total = int_1 - int_2;
                case "*" -> total = int_1 * int_2;
                case "/" -> {
                    if (int_2 != 0) {
                        total = int_1 / int_2;
                    } else {
                        dividingByZero = true;
                    }
                }
                case "none" -> total = Double.parseDouble(field.getText());
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
            lastInputWasAction = false;
            hasBeenSolved = true;
        });
        buttonEquals.setFocusable(false);

        JButton buttonClear = new JButton("C");
        buttonClear.addActionListener(e -> {
            int_1 = Double.NaN;
            int_2 = Double.NaN;
            field.setText("0");
            action = "none";
            hasBeenSolved = true;
        });
        buttonClear.setFocusable(false);

        // MATH OPERATION BUTTONS

        JButton buttonAdd = new JButton("+");
        mathKeyAction(field, buttonEquals, buttonAdd);

        JButton buttonSubtract = new JButton("-");
        mathKeyAction(field, buttonEquals, buttonSubtract);

        JButton buttonMultiplicative = new JButton("*");
        mathKeyAction(field, buttonEquals, buttonMultiplicative);

        JButton buttonDivision = new JButton("/");
        mathKeyAction(field, buttonEquals, buttonDivision);


//        for (int index = 1; index <= 16; index++) {
//            panel.add(button(index));
//        }

        buttonToPanel(panel, button1, button2, button3, button4, button5, button6, buttonAdd, buttonSubtract);
        buttonToPanel(panel, button7, button8, button9, buttonZero, buttonEquals, buttonClear, buttonMultiplicative, buttonDivision);


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

    private static void buttonToPanel(JPanel panel, JButton button1, JButton button2, JButton button3, JButton button4, JButton button5, JButton button6, JButton buttonAdd, JButton buttonSubtract) {
        panel.add(button1);
        panel.add(button2);
        panel.add(button3);
        panel.add(buttonAdd);
        panel.add(button4);
        panel.add(button5);
        panel.add(button6);
        panel.add(buttonSubtract);
    }

    private static void mathKeyAction(JTextField field, JButton buttonEquals, JButton buttonAdd) {
        buttonAdd.addActionListener(e -> {
            if(Objects.equals(action, buttonAdd.getText()) && lastInputWasAction){
                return;
            }
            if (!hasBeenSolved && !lastInputWasAction) {
                buttonEquals.doClick();
                hasBeenSolved = true;
            }
            int_1 = Double.parseDouble(field.getText());
            action = buttonAdd.getText();
            if(!lastInputWasAction) {
                hasBeenSolved = false;
            }
            lastInputWasEqual = false;
            lastInputWasAction = true;
        });
        buttonAdd.setFocusable(false);
    }

    private static void numKeyAction(JTextField field, JButton button) {
        button.addActionListener(evt -> {
            if(lastInputWasAction){
                field.setText("");
            }
            if(lastInputWasEqual){
                field.setText("");
                int_1 = Double.NaN;
                int_2 = Double.NaN;
                action = "none";
                hasBeenSolved = true;
            }
            if(field.getText().equals("0")){
                field.setText("");
            }
            field.setText(field.getText().concat(button.getText()));
            lastInputWasAction = false;
            lastInputWasEqual = false;
        });
        button.setFocusable(false);
    }


    public static void main(String[] args) {
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() { createAndShowGUI(); }
        });
    }

//    protected static JButton createButton(int index, JTextField txtField) {
//        JButton btn = new JButton(String.valueOf(index));
//        numKeyAction(txtField, btn);
//        return btn;
//    }
}