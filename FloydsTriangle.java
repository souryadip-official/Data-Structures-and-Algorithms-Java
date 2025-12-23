import java.util.*;
public class FloydsTriangle {
    public static void printFloydsTriangle(int n) {
        int i, j, value = 1;
        for(i=0;i<n;i++) {
            for(j=0;j<=i;j++) {
                System.out.print((value++) + " ");
            }
            System.out.println();
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the size of pyramid: ");
        int n = sc.nextInt();
        if(n <= 0) {
            System.out.println("Invalid size.");
        } else {
            printFloydsTriangle(n);
        }
    }
}
