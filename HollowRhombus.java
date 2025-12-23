import java.util.*;
public class HollowRhombus {
    public static void printHollowRhombus(int n) {
        int i, j, spaces;
        for (i=0;i<n;i++) {
            for (spaces=0;spaces<n-i-1;spaces++) {
                System.out.print("  ");
            }
            for(j=0;j<n;j++) {
                if(i==0 || i==n-1 || j==0 || j==n-1) {
                    System.out.print("* ");
                } else {
                    System.out.print("  ");
                }
            }
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
            printHollowRhombus(n);
        }
    }
}