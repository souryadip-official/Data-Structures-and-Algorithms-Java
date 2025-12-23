import java.util.Scanner;
public class ClearLastIBits {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the number: ");
        int n = sc.nextInt();

        System.out.print("Enter the number of bits you want to clear: ");
        int b = sc.nextInt();

        int c = (~0) << b;
        int newNum = n & c;
        System.out.println("After updating, result is: " + newNum);
    }
}
