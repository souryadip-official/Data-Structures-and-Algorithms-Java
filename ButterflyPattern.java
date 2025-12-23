import java.util.*;
public class ButterflyPattern {
    public static void printStarsAndSpaces(int i, int n) {
        int j, spaces, nospc, nostr;
        nostr = i;
        nospc = (2*n) - (2*nostr);
        for(j=0;j<nostr;j++) {
            System.out.print("* ");
        }
        for(spaces=0;spaces<nospc;spaces++) {
            System.out.print("  ");
        }
        for(j=0;j<nostr;j++) {
            System.out.print("* ");
        }
    }
    public static void printButterflyPattern(int n) {
        int i;
        // Loop for the upper half
        for(i=1;i<=n;i++) {
            printStarsAndSpaces(i, n);
            System.out.println();
        }
        // Loop for the lower half
        for(i=n;i>=1;i--) {
            printStarsAndSpaces(i,n);
            System.out.println();
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the size of pattern: ");
        int n = sc.nextInt();
        if(n <= 0) {
            System.out.println("Invalid size.");
        } else {
            printButterflyPattern(n);
        }
    }
}
