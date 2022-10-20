import java.util.Scanner;

public class ArithmeticMean {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);

        int numberOfArgs = scanner.nextInt();
        int sum=0;

        for (int i=0;i<numberOfArgs;i++){
            int userNumber = scanner.nextInt();
            sum+=userNumber;
        }
        float arith=sum/numberOfArgs;
        System.out.println(arith);
    }
}
