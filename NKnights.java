import java.util.Scanner;
public class NKnights {
    static int knightsToPlace;
    static int count = 0;
    public static void displayBoard(char[][] board) {
        System.out.println("*-----Chessboard-----*");
        for (char[] chars : board) {
            for (int j = 0; j < board[0].length; j++)
                System.out.print(chars[j] + " ");
            System.out.println();
        }
    }
    public static boolean checkUpRight(char[][] grid, int row, int col) {
        if(row >= 2 && col < grid[0].length-1)
            return grid[row - 2][col + 1] != 'K';
        return true; /* in case the cell is inaccessible */
    }
    public static boolean checkUpLeft(char[][] grid, int row, int col) {
        if(row >= 2 && col > 0)
            return grid[row-2][col-1] != 'K';
        return true;
    }
    public static boolean checkLeftUp(char[][] grid, int row, int col) {
        if(col >= 2 && row > 0)
            return grid[row - 1][col - 2] != 'K';
        return true;
    }
    public static boolean checkRightUp(char[][] grid, int row, int col) {
        if(col <= grid[0].length-3 && row > 0)
            return grid[row - 1][col + 2] != 'K';
        return true;
    }
    public static boolean isSafe(char[][] grid, int row, int col) {
        return checkUpRight(grid,row,col) && checkUpLeft(grid,row,col) && checkLeftUp(grid,row,col) && checkRightUp(grid,row,col);
    }
    public static void place_K_Knights(char[][] grid, int row, int col, int num) {
        if(row == grid.length) {
            if(num == knightsToPlace) {
                count++;
                displayBoard(grid);
            }
            return;
        }
        if(isSafe(grid, row, col)) {
            grid[row][col] = 'K';
            if(col != grid[0].length-1)
                place_K_Knights(grid, row, col+1, num+1);
            else
                place_K_Knights(grid, row+1, 0, num+1);
            grid[row][col] = 'x';
        }
        if(col != grid[0].length-1)
            place_K_Knights(grid,row,col+1,num);
        else
            place_K_Knights(grid,row+1,0,num);
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the size of the board (n): ");
        int n = sc.nextInt();
        char[][] board = new char[n][n];
        for(int i=0;i<n;i++)
            for(int j=0;j<n;j++) board[i][j] = 'x';
        System.out.print("Enter number of knights to place: ");
        knightsToPlace = sc.nextInt();
        place_K_Knights(board, 0, 0, 0);
        if(count == 0) System.out.println(knightsToPlace + " knights cannot be placed in a " + n + " * " + n + " chessboard!");
        else
            System.out.println("Total solutions found: " + count);
        sc.close();
    }
}
