import java.util.*;
public class Zeros_Ones_Pattern {
    public static void printZerosOnesPattern(int n) {
        int i, j;
        for(i=0;i<n;i++) {
            for(j=0;j<=i;j++) {
                if((i+j) % 2 == 0) {
                    System.out.print("1 ");
                } else {
                    System.out.print("0 ");
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
            printZerosOnesPattern(n);
        }
    }
}
