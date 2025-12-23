import java.util.*;
public class Spiral_Matrix {
    public static int[][] createArray() {
        int rows, cols;
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter rows and cols: ");
        rows = sc.nextInt(); cols = sc.nextInt();
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
                System.out.print(arr[i][j] + "\t");
            System.out.println();
        }
    }
    public static void printForwardRow(int[][] arr, int rowInd, int start, int end) {
        for(int j=start;j<=end;j++)
            System.out.print(arr[rowInd][j] + " ");
    }
    public static void printBackwardRow(int[][] arr, int rowInd, int start, int end) {
        for(int j=start;j>=end;j--)
            System.out.print(arr[rowInd][j] + " ");
    }
    public static void printForwardColumn(int[][] arr, int colInd, int start, int end) {
        for(int i=start;i<=end;i++)
            System.out.print(arr[i][colInd] + " ");
    }
    public static void printBackwardColumn(int[][] arr, int colInd, int start, int end) {
        for(int i=start;i>=end;i--)
            System.out.print(arr[i][colInd] + " ");
    }
    public static void printSpiral(int[][] arr) {
        int rows, cols, turns, start, end, rowInd, colInd, rowStart, rowEnd, colStart, colEnd;
        rows = arr.length; cols = arr[0].length;
        rowStart = 0; rowEnd = rows-1; colStart = 0; colEnd = cols-1;
        rowInd = rowStart; colInd = colEnd;
        if(rows == 1 || cols == 1) {
            if(rows == 1) printForwardRow(arr, rowInd, colStart, colEnd);
            else printForwardColumn(arr, colInd, rowStart, rowEnd);
            return;
        }
        turns = (int) Math.ceil((double)Math.min(rows, cols) / 2);
        while(turns > 0) {
            printForwardRow(arr, rowInd, colStart, colEnd); rowInd = rowEnd;
            printForwardColumn(arr, colInd, rowStart+1, rowEnd); colInd = colStart;
            if(rowStart < rowEnd) printBackwardRow(arr, rowInd, colEnd-1, colStart);
            /* when rowStart and rowEnd becomes same, the same row is printed twice, so to prevent that, we wrote if rowStart < rowEnd then only print backwards */
            if(colStart < colEnd) printBackwardColumn(arr, colInd, rowEnd-1, rowStart+1);
            /* same reason as previous */
            rowStart++; colStart++; rowEnd--; colEnd--; rowInd = rowStart; colInd = colEnd;
            turns--;
        }
    }
    public static void main(String[] args) {
        int[][] arr = createArray();
        dataInput(arr);
        System.out.println("Given array:");
        printArray(arr);
        System.out.println("Spiral Matrix: ");
        printSpiral(arr);
    }
}