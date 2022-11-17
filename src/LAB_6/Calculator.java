package LAB_6;

import javax.swing.*;
import java.awt.*;

public class Calculator {

    public static void createAndShowGUI() {
        JFrame jf = new JFrame("My First Frame");

        jf.setResizable(false);
        jf.setLocationRelativeTo(null);

        JTextField jt = new JTextField();

        jt.setEditable(false);
        jt.setFont(new Font("Arial",Font.BOLD,11));
//        jt.setText(Integer);
        jt.setHorizontalAlignment(SwingConstants.RIGHT);
        jf.getContentPane().add(jt,BorderLayout.NORTH);

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

        jf.getContentPane().add(jp, BorderLayout.CENTER);

        jf.pack();
        jf.setVisible(true);
        jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }


    public static void main(String[] args) {
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() { createAndShowGUI(); }
        });
    }

}