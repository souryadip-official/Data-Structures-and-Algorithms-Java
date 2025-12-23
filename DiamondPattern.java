import java.util.*;
public class DiamondPattern {
    public static void printSpacesAndStars(int i, int n) {
        int j, spaces;
        for(spaces=0;spaces<n-i-1;spaces++) {
            System.out.print("  ");
        }
        for(j=0;j<(2*i)+1;j++) {
            System.out.print("* ");
        }
    }
    public static void printDiamondPattern(int n) {
        int i;
        /* For the upper half */
        for(i=0;i<n;i++) {
            printSpacesAndStars(i, n);
            System.out.println();
        }
        /* For the lower half */
        for(i=n-1;i>=0;i--) {
            printSpacesAndStars(i, n);
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
            printDiamondPattern(n);
        }
    }
}
