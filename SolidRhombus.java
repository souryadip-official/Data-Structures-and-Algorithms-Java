import java.util.*;
public class SolidRhombus {
    public static void printSolidRhombus(int n) {
        int i, j, spaces;
        for(i=0;i<n;i++) {
            for(spaces=0;spaces<n-i-1;spaces++) {
                System.out.print("  ");
            }
            for(j=0;j<n;j++) {
                System.out.print("* ");
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
            printSolidRhombus(n);
        }
    }
}
