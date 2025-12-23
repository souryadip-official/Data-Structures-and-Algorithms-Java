import java.util.Scanner;
public class UpdateIthBit {
    public static int set(int n, int b) {
        int c = 1 << b;
        return (n | c);
    }
    public static int clear(int n, int b) {
        int c = ~(1 << b);
        return (n & c);
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the number: ");
        int n = sc.nextInt();
        System.out.print("Enter the index of the bit you want to manipulate (Indexing starts from 0 from right to left): ");
        int b = sc.nextInt();
        System.out.print("1-> Set the bit\n2-> Clear the bit\nEnter your choice: ");
        int ch = sc.nextInt();
        switch(ch) {
            case 1:
                System.out.println("After updating, result is: " + set(n,b));
                break;
            case 2:
                System.out.println("After updating, result is: " + clear(n,b));
                break;
            default:
                System.out.println("Invalid choice!");
        }
        sc.close();
    }
}