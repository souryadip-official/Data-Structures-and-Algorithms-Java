import java.util.Scanner;
public class GetIthBit {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the number: "); // 0000 0111
        int n = sc.nextInt();

        System.out.print("Enter the index of the bit you want(Indexing starts from 0 from right to left): ");
        int b = sc.nextInt();

        int c = n >> b; /* right shift 'n', 'b' times */
        int bit = c & 1;
        System.out.println("Bit at index " + b+" is: " + bit);
    }
}
