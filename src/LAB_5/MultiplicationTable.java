package LAB_5;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Properties;

public class MultiplicationTable {
    public static void main(String[] args) throws IOException {
        boolean doesFileExists;
        try {
            File file = new File("setup.properties");
            if (file.exists()){
                FileReader reader=new FileReader("db.properties");
                Properties p=new Properties();
                p.load(reader);

                System.out.println(p.getProperty("user"));
                System.out.println(p.getProperty("password"));
            }else {
                Properties p=new Properties();
                p.setProperty("wartosc_minimum","1");
                p.setProperty("wartosc_maximum","10");
                p.setProperty("procent","70");
                p.setProperty("powtorzen_minimum","10");
                p.setProperty("powtorzen_maximum","25");
                p.store(new FileWriter("setup.properties"),"Multiplication Table settings");
            }

        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }
}
