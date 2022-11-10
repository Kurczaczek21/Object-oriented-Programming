package LAB_2;

public class CommandLineArguments {
    public static void main(String[] arguments) {
        System.out.println("args length= " + arguments.length);
         for(int i = 0; i < arguments.length; i++) {
                System.out.println((i+1)+". "+arguments[i]);
         }
    }
}
