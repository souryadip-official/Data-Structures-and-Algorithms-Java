import java.util.*;
public class Inverted_Half_Pyramid_With_Numbers {
    public static void printInvertedHPNum(int n) {
        int i, j;
        for(i=0;i<n;i++) {
            for(j=0;j<n-i;j++) {
                System.out.print((j+1) + " ");
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
            printInvertedHPNum(n);
        }
    }
}
