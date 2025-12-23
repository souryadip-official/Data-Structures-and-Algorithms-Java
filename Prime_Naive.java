import java.util.*;
public class Prime_Naive {
    public static boolean checkPrime(int n) {
        boolean isPrime = true;
        int i;
        for(i=2;i<=Math.sqrt(n);i++) {
            if(n % i == 0) {
                isPrime = false;
                return isPrime;
            }
        }
        return isPrime;
    }
    public static void detectPrime(int l, int u) {
        int i;
        System.out.println("The prime numbers are: ");
        for(i=l;i<=u;i++) {
            if(checkPrime(i)) {
                System.out.print(i + " ");
            }
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int l, u;
        System.out.print("Enter the range (Do not include any sign): ");
        l = sc.nextInt();
        u = sc.nextInt();
        if(l >= 2 && u >= 2) {
            detectPrime(l, u);
        } else {
            System.out.println("Invalid range or the range includes 0 or 1 which are neither prime nor composite.");
        }
    }
}
