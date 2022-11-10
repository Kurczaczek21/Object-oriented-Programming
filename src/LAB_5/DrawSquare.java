package LAB_5;

import java.io.IOException;
import java.util.Scanner;

public class DrawSquare {
    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        int size = scanner.nextInt();
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

