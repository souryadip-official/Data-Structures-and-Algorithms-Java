import java.util.*;
public class TwoD_Array_03 {
    public static int[][] createArray() {
        int rows, cols, row, col;
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter rows and columns: ");
        rows = sc.nextInt();
        cols = sc.nextInt();
        return (new int[rows][cols]);
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
                System.out.print(arr[i][j] + " ");
            System.out.println();
        }
    }
    public static void min_max(int[][] arr) {
        int i, j, rows = arr.length, cols = arr[0].length, min = Integer.MAX_VALUE, max = Integer.MIN_VALUE;
        for(i=0;i<rows;i++) {
            for(j=0;j<cols;j++) {
                max = Math.max(max, arr[i][j]);
                min = Math.min(min, arr[i][j]);
            }
        }
        System.out.println("Maximum element: " + max + "\nMinimum element: " + min);
    }
    public static void main(String[] args) {
        int[][] arr = createArray();
        dataInput(arr);
        System.out.println("Given array:");
        printArray(arr);
        min_max(arr);
    }
}

