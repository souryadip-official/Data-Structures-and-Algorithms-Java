import java.util.*;
public class DiagonalSum {
    public static int[][] createArray() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter dimension of matrix: ");
        int dimension = sc.nextInt();
        return (new int[dimension][dimension]);
    }
    public static void dataInput(int[][] arr) {
        int i, j, rows = arr.length, cols = arr[0].length;
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter " + rows * cols + " elements: ");
        for(i=0;i<rows;i++)
            for(j=0;j<cols;j++)
                arr[i][j] = sc.nextInt();
    }
    public static void printArray(int[][] arr) {
        int i, j, rows = arr.length, cols = arr[0].length;
        for(i=0;i<rows;i++) {
            for(j=0;j<cols;j++)
                System.out.print(arr[i][j] + "\t");
            System.out.println();
        }
    }
    public static void calculateDiagonalSum(int[][] arr) {
        int i, size = arr.length, totalDiagonalSum = 0;
        for(i=0;i<size;i++) {
            totalDiagonalSum += arr[i][i];
            if(i != (size-i-1))
                totalDiagonalSum += arr[i][size-i-1];
        }
        System.out.println("Total Diagonal Sum = " + totalDiagonalSum);
    }
    public static void main(String[] args) {
        int[][] arr = createArray();
        dataInput(arr);
        System.out.println("Given array:");
        printArray(arr);
        calculateDiagonalSum(arr);
    }
}