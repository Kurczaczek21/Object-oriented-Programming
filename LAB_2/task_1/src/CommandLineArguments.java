public class CommandLineArguments {
    public static void main(String[] arguments) {
        System.out.println("args length= " + arguments.length);
         for(int i = 0; i < arguments.length; i++) {
                System.out.println("number of args = " + (i+1));
         }
    }
}
