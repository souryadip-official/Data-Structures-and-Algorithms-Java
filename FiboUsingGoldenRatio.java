import java.util.Scanner;
public class FiboUsingGoldenRatio {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the value of n (Indexing starts from 0): ");
        int n = sc.nextInt();
        /* Applying Binet's Formula */
        System.out.println("Fibonacci number at index " + n + " is: " + Math.round(Math.pow(1.618,n) / Math.sqrt(5)));
        sc.close();
    }
}
