import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;
public class ChocolaProblem {
    public static void minimumCost(int rows, int cols, Integer[] horizontalCosts, Integer[] verticalCosts) {
        Arrays.sort(horizontalCosts, Collections.reverseOrder()); // sorted the horizontal costs in reverse order
        Arrays.sort(verticalCosts, Collections.reverseOrder()); // sorted the vertical costs in reverse order
        int hPointer = 0, vPointer = 0; // hPointer is the horizontal pointer and vPointer is the vertical pointer
        int hPieces = 1, vPieces = 1; // hPieces and vPieces are the initial horizontal and vertical pieces for the given chocolate
        int finalCost = 0; // cost to break the entire chocolate into single pieces
        while(hPointer < horizontalCosts.length && vPointer < verticalCosts.length) {
            if(horizontalCosts[hPointer] > verticalCosts[vPointer]) {
                // this means the horizontal cut is expensive, so we make a horizontal cut
                finalCost += (horizontalCosts[hPointer] * vPieces);
                hPieces++; // since we made a horizontal cut, horizontal pieces will increase by one
                hPointer++; // for the next iteration
            } else {
                // this means the vertical cut is expensive, so we make a vertical cut
                finalCost += (verticalCosts[vPointer] * hPieces);
                vPieces++;  // since we made a vertical cut, vertical pieces will increase by one
                vPointer++; // for the next iteration
            }
        }
        // if more horizontal cuts are yet to be performed
        while(hPointer < horizontalCosts.length) {
            finalCost += (horizontalCosts[hPointer] * vPieces);
            hPieces++;
            hPointer++;
        }
        // if more vertical cuts are yet to be performed
        while(vPointer < verticalCosts.length) {
            finalCost += (verticalCosts[vPointer] * hPieces);
            vPieces++;
            vPointer++;
        }
        System.out.println("The minimum cost for breaking a chocolate of " + rows + " * " + cols + " is " + finalCost);
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter n (rows) and m (cols): ");
        int n = sc.nextInt(); //rows
        int m = sc.nextInt(); //cols
        Integer[] horizontalCosts = new Integer[n-1];
        System.out.print("Enter the " + (n-1) + " costs for horizontal cuts: ");
        for(int i=0; i<n-1; i++) horizontalCosts[i] = sc.nextInt();
        Integer[] verticalCosts = new Integer[m-1];
        System.out.print("Enter the " + (m-1) + " costs for vertical cuts: ");
        for(int i=0; i<m-1; i++) verticalCosts[i] = sc.nextInt();
        minimumCost(n, m, horizontalCosts, verticalCosts);
        sc.close();
    }
}
