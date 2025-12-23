import java.util.*;
public class Search_In_Sorted_2D_Array {
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
        for (i = 0; i < rows; i++)
            for (j = 0; j < cols; j++)
                arr[i][j] = sc.nextInt();
    }

    public static void printArray(int[][] arr) {
        int i, j, rows = arr.length, cols = arr[0].length;
        for (i = 0; i < rows; i++) {
            for (j = 0; j < cols; j++)
                System.out.print(arr[i][j] + "\t");
            System.out.println();
        }
    }
    public static int binarySearch(int[] arr, int element) {
        int start = 0, end = arr.length-1, mid;
        while(start <= end) {
            mid = (start+end)/2;
            if(arr[mid] == element)
                return mid;
            else if(arr[mid] < element)
                start = mid+1;
            else end = mid-1;
        }
        return -1;
    }
    public static void staircaseSearch(int[][] arr, int element) {
        int row = arr.length-1, col = 0;
        while(row >= 0 && col < arr[0].length) {
            if(arr[row][col] == element) {
                System.out.println("(" + row + ", " + col + ")");
                return;
            }
            else if(element < arr[row][col]) row--;
            else col++;
        }
        System.out.println("Element not found!");
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[][] arr = createArray();
        int element, checks;
        dataInput(arr);
        System.out.println("Given array:");
        printArray(arr);
        System.out.print("Enter the element you want to search: ");
        element = sc.nextInt();
        staircaseSearch(arr, element);
    }
}