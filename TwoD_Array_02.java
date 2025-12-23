import java.util.*;
public class TwoD_Array_02 {
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
    public static void search(int[][] arr, int element) {
        int i, j, rows = arr.length, cols = arr[0].length;
        boolean isFound = false;
        for(i=0;i<rows;i++) {
            for(j=0;j<cols;j++) {
                if(arr[i][j] == element) {
                    isFound = true;
                    System.out.println("(" + i + ", " + j + ")");
                }
            }
        }
        System.out.print(!isFound? "Element not found!\n" : "");
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[][] arr = createArray();
        int element;
        dataInput(arr);
        System.out.println("Given array:");
        printArray(arr);
        System.out.print("Enter the element you want to search: ");
        element = sc.nextInt();
        search(arr, element);
    }
}
