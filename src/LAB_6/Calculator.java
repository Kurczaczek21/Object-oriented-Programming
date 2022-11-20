package LAB_6;

import javax.swing.*;
import java.awt.*;

public class Calculator {

    public static void createAndShowGUI() {


        // DISPLAY PNAEL
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridwidth = GridBagConstraints.REMAINDER;
        JTextField field = new JTextField(12);
        field.setFont(new Font("Calabri",Font.BOLD,24));
//        field.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
        field.setEditable( false );


        // BUTTON PANEL
        JPanel panel = new JPanel();

        panel.setPreferredSize(new Dimension(300,150));
        panel.setBackground(Color.lightGray);
        panel.setLayout(new GridLayout(4,4,6,6));


        // BUTTON SETTINGS

//        for (int index = 1; index < 10; index++) {
//            panel.add(createButton(index));
//            if(i==3)
//        }



        JButton button1 = new JButton(" 1 ");
        button1.addActionListener(evt -> {
            field.setText(field.getText().concat("1"));
        });
        button1.setFocusable(false);

        JButton button2 = new JButton(" 2 ");
        button2.addActionListener(evt -> {
            field.setText(field.getText().concat("2"));
        });
        button2.setFocusable(false);

        JButton button3 = new JButton(" 3 ");
        button3.addActionListener(evt -> {
            field.setText(field.getText().concat("3"));
        });
        button3.setFocusable(false);

        JButton button4 = new JButton(" + ");
        button4.addActionListener(evt -> {
            if(field.getText().length()==0 || field.getText().endsWith("*") || field.getText().endsWith("/") || field.getText().endsWith("-") || field.getText().endsWith("+")) {

            }else {
                field.setText(field.getText().concat("+"));
            }
        });
        button4.setFocusable(false);

        JButton button5 = new JButton(" 4 ");
        button5.addActionListener(evt -> {
            field.setText(field.getText().concat("4"));
        });
        button5.setFocusable(false);

        JButton button6 = new JButton(" 5 ");
        button6.addActionListener(evt -> {
            field.setText(field.getText().concat("5"));
        });
        button6.setFocusable(false);

        JButton button7 = new JButton(" 6 ");
        button7.addActionListener(evt -> {
            field.setText(field.getText().concat("6"));
        });
        button7.setFocusable(false);

        JButton button8 = new JButton(" - ");
        button8.addActionListener(evt -> {
            if(field.getText().endsWith("-")) {
            }else {
                field.setText(field.getText().concat("-"));
            }
        });
        button8.setFocusable(false);

        JButton button9 = new JButton(" 7 ");
        button9.addActionListener(evt -> {
            field.setText(field.getText().concat("7"));
        });
        button9.setFocusable(false);

        JButton button10 = new JButton(" 8 ");
        button10.addActionListener(evt -> {
            field.setText(field.getText().concat("8"));
        });
        button10.setFocusable(false);

        JButton button11 = new JButton(" 9 ");
        button11.addActionListener(evt -> {
            field.setText(field.getText().concat("9"));
        });
        button11.setFocusable(false);

        JButton button12 = new JButton(" * ");
        button12.addActionListener(evt -> {
            if(field.getText().length()==0 || field.getText().endsWith("*") || field.getText().endsWith("/") || field.getText().endsWith("-") || field.getText().endsWith("+")) {
            }else {
                field.setText(field.getText().concat("*"));
            }
        });
        button12.setFocusable(false);

        JButton button13 = new JButton(" 0 ");
        button13.addActionListener(evt -> {
            if(field.getText().length()!=0) {
                field.setText(field.getText().concat("0"));
            }
        });
        button13.setFocusable(false);

        JButton button14 = new JButton(" = ");
        button14.addActionListener(evt -> {
            field.setText("WYNIK");
        });
        button14.setFocusable(false);

        JButton button15 = new JButton(" C ");
        button15.addActionListener(evt -> {
            field.setText("");
        });
        button15.setFocusable(false);

        JButton button16 = new JButton(" / ");
        button16.addActionListener(evt -> {
            if(field.getText().length()==0 || field.getText().endsWith("*") || field.getText().endsWith("/") || field.getText().endsWith("-") || field.getText().endsWith("+")) {
            }else {
                field.setText(field.getText().concat("/"));
            }
        });
        button16.setFocusable(false);

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

//        frame.pack();


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