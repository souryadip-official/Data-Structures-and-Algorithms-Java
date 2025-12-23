import java.util.Scanner;
public class ClearIthBit {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the number: ");
        int n = sc.nextInt();
        System.out.print("Enter the index of the bit you want to clear (Indexing starts from 0 from right to left): ");
        int b = sc.nextInt();
        int c = ~(1 << b);
        int newNum = n & c;
        System.out.println("New number after clearing the bit at index " + b+" is: " + newNum);
    }
}
