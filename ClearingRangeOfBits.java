import java.util.Scanner;
public class ClearingRangeOfBits {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the number: ");
        int n = sc.nextInt();

        System.out.print("Enter the range (from right to left): ");
        int i = sc.nextInt();
        int j = sc.nextInt();

        int n1 = (~0) << (j+1);
        int n2 = (1 << i) - 1;
        int n3 = n1 | n2;

        int newNum = n & n3;
        System.out.println("After updating, result is: " + newNum);
    }
}
