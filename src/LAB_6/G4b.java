package LAB_6;

import java.awt.*;

import javax.swing.JButton;
import javax.swing.JFrame;

public class G4b {

    public static void createAndShowGUI() {
        JFrame jf = new JFrame("My First Frame");
        jf.setLayout(new GridLayout(4,4)); //tworze obiekt klasy flowLayout ktory ospowaida za pozycje

        JButton jb = new JButton("Hello!");
        jf.getContentPane().add(jb);

        JButton jb2 = new JButton("How are you?");
        jf.getContentPane().add(jb2);

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

