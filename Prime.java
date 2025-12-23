import java.util.*;
public class Prime {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter any number: ");
        int num = sc.nextInt();
        if(num <= 0) {
            System.out.println("Zero or negative numbers cannot be prime.");
        } else {
            int factors = 0, i;
            // We know, a prime number has only two factors, 1 and itself.
            for(i=2;i<=num/2;i++) {
                if(num % i == 0) {
                    factors++;
                }
            }
            /* num / 2 because we know a number cannot be divided by a number which is greater than half of the number. For example, 32 cannot get divided by a number greater than 16. */
            System.out.println((factors > 0)? "Not a prime number." : "Prime number.");
        }
    }
}
