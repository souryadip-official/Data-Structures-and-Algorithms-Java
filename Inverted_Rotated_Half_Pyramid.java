import java.util.*;
public class Inverted_Rotated_Half_Pyramid {
    public static void printInvertedRotatedHP(int n) {
        int i, j, spaces;
        for(i=0;i<n;i++) {
            for(spaces=0;spaces<n-i-1;spaces++) {
                System.out.print("  ");
            }
            for(j=0;j<i+1;j++) {
                System.out.print("* ");
            }
            System.out.println();
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n;
        System.out.print("Enter the size of pyramid: ");
        n = sc.nextInt();
        if(n <= 0) {
            System.out.println("Invalid size.");
        } else {
            printInvertedRotatedHP(n);
        }
    }
}
