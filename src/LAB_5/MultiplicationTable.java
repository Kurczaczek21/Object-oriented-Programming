package LAB_5;

import java.io.*;
import java.util.InputMismatchException;
import java.util.Properties;
import java.util.Random;
import java.util.Scanner;

public class MultiplicationTable {
    public static void main(String[] args) throws IOException {

        Properties p = new Properties();
        File file = null;
        try {
            file = new File("setup.properties");
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
            System.exit(1);
        }

        if (!file.exists()) {
            p.setProperty("wartosc_minimum", "1");
            p.setProperty("wartosc_maximum", "10");
            p.setProperty("procent", "70");
            p.setProperty("powtorzen_minimum", "10");
            p.setProperty("powtorzen_maximum", "25");
            p.store(new FileWriter("setup.properties"), "Multiplication Table settings");
        }

        FileReader reader = new FileReader(file);
        p.load(reader);

        float currentTry = 1;
        float grade =0;
        float points =0;

        while (currentTry <=Float.parseFloat(p.getProperty("powtorzen_maximum"))) {
            System.out.println("-----------------------");
            System.out.println("points: "+(int)points);
            System.out.println("current attempt: "+(int)currentTry);

            int n1 = randInt(Integer.parseInt(p.getProperty("wartosc_minimum")), Integer.parseInt(p.getProperty("wartosc_maximum")));
            int n2 = randInt(Integer.parseInt(p.getProperty("wartosc_minimum")), Integer.parseInt(p.getProperty("wartosc_maximum")));
            System.out.printf("%d * %d = ", n1, n2);

            Scanner scanner = new Scanner(System.in);
            float answer = 0;
            try{
                answer = scanner.nextInt();
            }catch (InputMismatchException e){
                System.out.println("Błędne wprowadzenie danych");
                System.exit(1);
            }
            if (answer == n1 * n2){
                points+=1;
            }
            grade = points/currentTry;
            System.out.println("current grade: "+String.format("%.0f",grade*100)+"%");

            if (currentTry>=Float.parseFloat(p.getProperty("powtorzen_minimum")) && grade>=(Float.parseFloat(p.getProperty("procent"))/100)){
                break;
            }
            currentTry +=1;
        }
        if(grade>=(Float.parseFloat(p.getProperty("procent"))/100)){
            System.out.println("TEST PASSED");
        }else {
            System.out.println("TEST FAILED");
        }
        System.out.println("Percentage of correct answers: "+ String.format("%.0f",grade*100)+"%");
        System.out.println("Total points: "+ (int)points);
        System.out.println("Total attempts: "+ (int)currentTry);

    }

    private static int randInt(int min, int max) {
        Random rn = new Random();
        return rn.nextInt((max - min) + 1) + min;
    }
}
