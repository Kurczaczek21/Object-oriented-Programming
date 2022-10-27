public class ArithmeticMean {
    public static void main(String[] arguments) {
        System.out.println("args length= " + arguments.length);

        if (arguments.length == 0) {
            System.out.print("Brak argumentow programu.");
        }else{
            int suma = 0;
            System.out.print("Średnia arytetyczna liczb: ");
            for (int i = 0; i < arguments.length; i++) {
                System.out.print(arguments[i]);
                if (i!= (arguments.length-1)){
                    System.out.print(", ");
                }
                suma += Integer.parseInt(arguments[i]);
            }
            int srednia = suma/ arguments.length;
            int reszta = suma % arguments.length;
            System.out.print(" wynosi "+srednia+", reszta: "+reszta);
        }
    }
}

