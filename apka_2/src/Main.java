import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        boolean shouldContinue = true;

        Party party = new Party();

        while(shouldContinue){
            System.out.println("Wybierz opcję");
            System.out.println("1. Wyświetl gości");
            System.out.println("2. Dodaj gościa");
            System.out.println("3 .Wyświetl potrawy");
            System.out.println("4. Znajdź po numebrze telefonów");
            System.out.println("5. Wyjście");

            int userChoice = scanner.nextInt();

            switch (userChoice) {
                case 1 -> System.out.println(party.getGuests());
                case 2 -> party.addGuest();
                case 3 -> System.out.println("Wybrano 3.");
                case 4 -> System.out.println("Wybrano 4.");
                case 5 -> shouldContinue=false;
            }
        }

    }
}