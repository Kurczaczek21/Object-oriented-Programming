package LAB_6;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.sql.SQLOutput;

public class Calculator {

    public static void createAndShowGUI() {


        JButton button = new JButton();

        button.setBounds(100, 100,250 ,100);
        button.setText(" 1 ");
        button.addActionListener(e -> System.out.println("1"));
        button.setFocusable(false);
        button.setBorder(new RoundedBorder(20));

        JPanel jp = new JPanel();

        jp.add(button);


        JFrame frame = new JFrame(" Calculator kurczaka");

        ImageIcon image = new ImageIcon("kalkulator.png");
        frame.setIconImage(image.getImage());

        frame.setVisible(true);
        frame.setSize(750,7500);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);
        frame.getContentPane().setBackground(Color.DARK_GRAY);
        frame.getContentPane().add(jp);
        frame.pack();


    }


    public static void main(String[] args) {
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() { createAndShowGUI(); }
        });
    }

}