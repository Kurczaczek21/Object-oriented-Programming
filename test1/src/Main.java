import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Random random = new Random();
        int numberToGuess = random.nextInt(100) + 1;
        Scanner scanner = new Scanner(System.in);
        boolean wasNumberGuessed = false;

        while(!wasNumberGuessed){
            System.out.println("podaj liczbe: ");
            int number = scanner.nextInt();

            if(number < numberToGuess){
                System.out.println("Liczba jest za mala");
            } else if (number> numberToGuess) {
                System.out.println("Liczba jest za duza");
            }else {
                System.out.println("brawo, winek");
                wasNumberGuessed=true;
            }
        }
    }
}