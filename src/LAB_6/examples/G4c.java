package LAB_6.examples;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.*;

public class G4c {

    public static void createAndShowGUI() {
        JFrame jf = new JFrame("My First Frame");
        jf.setLayout(new GridLayout(4,4));

        JPanel jp = new JPanel();
        JPanel jp2 = new JPanel();
        jf.getContentPane().add(jp);
        jf.getContentPane().add(jp2);

        JButton jb = new JButton("Hello!");
        jf.getContentPane().add(jb, BorderLayout.PAGE_END);
        jp.add(jb);

        JButton jb2 = new JButton("How are you?");
        jp2.add(jb2);

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