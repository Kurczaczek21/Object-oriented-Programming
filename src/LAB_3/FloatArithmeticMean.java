public class FloatArithmeticMean {
    public static void main(String[] arguments) {
        if (arguments.length == 0) {
            System.out.print("Brak argumentow programu.");
            System.exit(0);
        }
        float suma = 0;
        for (int i = 0; i < arguments.length; i++) {
            float x = Float.parseFloat(arguments[i]);
//            System.out.println(x);
            System.out.printf("%10s %n", (String.format("%.3f", x )));
            suma += Float.parseFloat(arguments[i]);
        }
        System.out.println("----------");
        System.out.printf("%10s %n", (String.format("%.3f", suma)));

        float srednia = suma / arguments.length;
        System.out.print("Średnia arytmetyczna: " + String.format("%.4f", srednia));
    }
}

