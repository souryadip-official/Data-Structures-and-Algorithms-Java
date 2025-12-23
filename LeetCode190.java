import java.util.Scanner;
public class LeetCode190 {
    public static int reverseBits(int n) {
        int rev = 0;
        /* Running the loop 32 times because we are working with 32 bits unsigned integers */
        for(int i=1; i<=32; i++) {
            rev = rev << 1;
            /* Making a place of 1 bit for inserting the extracted bit of the number there */
            rev = rev | (n & 1);
            /* Extracting a bit from the number and OR-ing with rev to insert the bit */
            n = n >> 1;
            /* Removing the bit extracted from the number */
        }
        return rev;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the number: ");
        int n = sc.nextInt();
        System.out.println("After bit reverse: " + reverseBits(n));
        sc.close();
    }
}
