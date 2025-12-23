import java.sql.SQLOutput;
import java.util.Scanner;
public class OddEvenBit {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n;
        System.out.print("Enter number to check for odd or even: ");
        n = sc.nextInt();
        if((n & 1) == 1)
            System.out.println("Odd number");
        else
            System.out.println("Even number");
        sc.close();
    }
}
