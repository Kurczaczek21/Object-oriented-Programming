package LAB_6;

import javax.swing.*;

public class G0 {
    public static void createAndShowGUI() {
        JFrame jf = new JFrame("My First Frame");
        jf.pack();
        jf.setVisible(true);
    }

    public static void main(String[] args) {
        System.out.println("Before");

        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() { createAndShowGUI(); }
        });
        System.out.println("After");
   }

}
/*
Uwagi:

        Proszę sprawdzić co zrobić aby:

        - Aplikacja wyświetlała się na środku ekranu.

        - Cyfra 0 (oraz inne w polu z wynikiem) były pogrubione, czcionką Arial i z dosunięciem do prawej strony.

        - Pole z wynikiem nie powinno być edytowalne.

        - Zaś cała aplikacja ma mieć stały rozmiar i użytkownik nie może go zmieniać.

 */