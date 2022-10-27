public class ArithmeticMean {
    public static void main(String[] arguments) {
        if (arguments.length == 0) {
            System.out.print("Brak argumentow programu.");
            System.exit(0);
        }
        int suma = 0;
        int k=0;
        System.out.print("Średnia arytetyczna liczb: ");
        for (int i = 0; i < (arguments.length-1); i++) {
            System.out.print(arguments[i] + ", ");
            suma += Integer.parseInt(arguments[i]);
            k=i-1;
        }
        System.out.print(arguments[k]);
        suma += Integer.parseInt(arguments[k]);

        int srednia = suma / arguments.length;
        int reszta = suma % arguments.length;
        System.out.print(" wynosi " + srednia + ", reszta: " + reszta);
    }
}


