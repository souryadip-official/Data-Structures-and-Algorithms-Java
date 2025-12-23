import java.util.*;
public class HollowRectangle {
    public static void printHollowRectangle(int r, int c) {
        int i, j;
        for(i=0;i<r;i++) {
            for(j=0;j<c;j++) {
                if(i == 0 || j == 0 || i == r-1 || j == c-1) {
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
        int rows, cols;
        System.out.print("Enter numbers of rows: ");
        rows = sc.nextInt();
        System.out.print("Enter number of cols: ");
        cols = sc.nextInt();
        if(rows <= 2 || cols <= 2) {
            System.out.println("Hollow rectangle cannot be formed for the given data input.");
        } else {
            printHollowRectangle(rows, cols);
        }
    }
}
