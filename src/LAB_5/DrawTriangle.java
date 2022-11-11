package LAB_5;

import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;

public class DrawTriangle {
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
        System.out.println("Dla wysokości: "+size);

        for (int i=1;i<size+1;i++){
            System.out.println(" ".repeat(size-i)+"#".repeat(((2*i)-1)));
        }
    }
}
