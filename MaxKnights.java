import java.util.Scanner;
public class MaxKnights {
    static int max_knights = 0;
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
        return true;
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
    public static void placeKnights(char[][] grid, int row, int col, int placed) {
        if(row == grid.length) {
            if(placed > max_knights)
                max_knights = placed;
            return;
        }
        if(col == grid.length) {
            placeKnights(grid, row+1, 0, placed);
            return;
        }
        if(isSafe(grid,row,col)) {
            grid[row][col] = 'K';
            placeKnights(grid,row,col+1,placed+1);
            grid[row][col] = 'x';
        }
        placeKnights(grid,row,col+1,placed);
    }
    public static void printMaxKnightConfig(char[][] grid, int row, int col, int placed) {
        if(row == grid.length) {
            if(placed == max_knights)
                displayBoard(grid);
            return;
        }
        if(col == grid.length) {
            printMaxKnightConfig(grid, row+1, 0, placed);
            return;
        }
        if(isSafe(grid,row,col)) {
            grid[row][col] = 'K';
            printMaxKnightConfig(grid,row,col+1,placed+1);
            grid[row][col] = 'x';
        }
        printMaxKnightConfig(grid,row,col+1,placed);
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the size of the board (n): ");
        int n = sc.nextInt();
        char[][] board = new char[n][n];
        for(int i=0;i<n;i++)
            for(int j=0;j<n;j++) board[i][j] = 'x';
        placeKnights(board, 0, 0, 0);
        /* Optional: To print all the configurations with maximum knights */
        printMaxKnightConfig(board,0,0,0);
        System.out.println("Maximum knights placed: " + max_knights);
        sc.close();
    }
}
