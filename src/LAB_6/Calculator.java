package LAB_6;

import javax.swing.*;
import java.awt.*;

public class Calculator {

    public static void createAndShowGUI() {

        JFrame frame = new JFrame(" Calculator kurczaka");

        ImageIcon image = new ImageIcon("kalkulator.png");
        frame.setIconImage(image.getImage());

        frame.setVisible(true);
        frame.setSize(750,740);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);
        frame.getContentPane().setBackground(Color.DARK_GRAY);

        JTextField jt = new JTextField();

        jt.setEditable(false);
        jt.setFont(new Font("Arial",Font.BOLD,11));
//        jt.setText(Integer);
        jt.setHorizontalAlignment(SwingConstants.RIGHT);

        frame.setLayout(new GridLayout(4,4));

        JPanel jp = new JPanel();

        jp.add(new JButton(" 1 "));
        jp.add(new JButton(" 2 "));
        jp.add(new JButton(" 3 "));
        jp.add(new JButton(" + "));
        jp.add(new JButton(" 4 "));
        jp.add(new JButton(" 5 "));
        jp.add(new JButton(" 6 "));
        jp.add(new JButton(" - "));
        jp.add(new JButton(" 7 "));
        jp.add(new JButton(" 8 "));
        jp.add(new JButton(" 9 "));
        jp.add(new JButton(" * "));
        jp.add(new JButton(" 0 "));
        jp.add(new JButton(" = "));
        jp.add(new JButton(" C "));
        jp.add(new JButton(" / "));

        frame.getContentPane().add(jp, BorderLayout.CENTER);

        frame.pack();

    }


    public static void main(String[] args) {
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() { createAndShowGUI(); }
        });
    }

}