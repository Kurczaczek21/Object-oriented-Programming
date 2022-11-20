package LAB_6;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.sql.SQLOutput;

public class Calculator {

    public static void createAndShowGUI() {

        // BUTTON SETTINGS
        JButton button1 = new JButton(" 1 ");
        button1.addActionListener(e -> System.out.println("1"));
        button1.setFocusable(false);

        JButton button2 = new JButton(" 2 ");
        button2.addActionListener(e -> System.out.println("2"));
        button2.setFocusable(false);

        JButton button3 = new JButton(" 3 ");
        button3.addActionListener(e -> System.out.println("3"));
        button3.setFocusable(false);

        JButton button4 = new JButton(" + ");
        button4.addActionListener(e -> System.out.println("+"));
        button4.setFocusable(false);

        JButton button5 = new JButton(" 4 ");
        button5.addActionListener(e -> System.out.println("4"));
        button5.setFocusable(false);

        JButton button6 = new JButton(" 5 ");
        button6.addActionListener(e -> System.out.println("5"));
        button6.setFocusable(false);

        JButton button7 = new JButton(" 6 ");
        button7.addActionListener(e -> System.out.println("6"));
        button7.setFocusable(false);

        JButton button8 = new JButton(" - ");
        button8.addActionListener(e -> System.out.println("-"));
        button8.setFocusable(false);

        JButton button9 = new JButton(" 7 ");
        button9.addActionListener(e -> System.out.println("7"));
        button9.setFocusable(false);

        JButton button10 = new JButton(" 8 ");
        button10.addActionListener(e -> System.out.println("8"));
        button10.setFocusable(false);

        JButton button11 = new JButton(" 9 ");
        button11.addActionListener(e -> System.out.println("9"));
        button11.setFocusable(false);

        JButton button12 = new JButton(" * ");
        button12.addActionListener(e -> System.out.println("*"));
        button12.setFocusable(false);

        JButton button13 = new JButton(" 0 ");
        button13.addActionListener(e -> System.out.println("0"));
        button13.setFocusable(false);

        JButton button14 = new JButton(" = ");
        button14.addActionListener(e -> System.out.println("="));
        button14.setFocusable(false);

        JButton button15 = new JButton(" C ");
        button15.addActionListener(e -> System.out.println("C"));
        button15.setFocusable(false);

        JButton button16 = new JButton(" / ");
        button16.addActionListener(e -> System.out.println("/"));
        button16.setFocusable(false);

        // BUTTON PANEL
        JPanel panel = new JPanel();

        panel.setPreferredSize(new Dimension(300,150));
        panel.setBackground(Color.lightGray);
        panel.setLayout(new GridLayout(4,4,6,6));
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

        // DISPLAY PNAEL
        JPanel panel2 = new JPanel();
        panel2.setBackground(Color.WHITE);
        panel2.setPreferredSize(new Dimension(300,40));

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
        frame.add(panel2);
        frame.add(panel);

//        frame.pack();


    }


    public static void main(String[] args) {
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() { createAndShowGUI(); }
        });
    }

}