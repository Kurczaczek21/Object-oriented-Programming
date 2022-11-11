package LAB_5;

import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;

public class DrawSquare {
    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        int size =0;
        try{
            size = scanner.nextInt();
        }catch (InputMismatchException e){
            System.out.println("Błędne wprowadzenie danych");
            System.exit(1);
        }
        if(size<= 0){
            System.out.println("zły rozmiar");
            System.exit(1);
        }
        System.out.println("Dla boku o długości: "+size);
        String repeated = "#".repeat(size);
        System.out.println(repeated);
        for (int i=2;i<=size-1;i++){
            System.out.println("#"+" ".repeat(size-2)+"#");
        }
        System.out.println(repeated);
    }
}

