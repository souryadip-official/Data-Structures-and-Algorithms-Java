import java.util.*;
public class Factorial {
    public static long getFactorial(int n) {
        long fact = 1;
        int i = 1;
        for(i=1;i<=n;i++) {
            fact *= i;
        }
        return fact;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the number: ");
        int n = sc.nextInt();
        long fact = getFactorial(n);
        System.out.println("Factorial is = " + fact);
    }
}
