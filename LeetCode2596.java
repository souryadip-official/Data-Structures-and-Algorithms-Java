import java.util.Scanner;
public class LeetCode2596 {
    public static boolean check(int[][] grid, int row, int col, int idx) {
        int n = grid.length;
        //base case
        if(idx == (n*n)-1) return true;
        /* First, we will check whether the new position is valid, that is accessible and secondly we will check whether any of the valid 8 moves has the next index contained */
        /* checking 2 up 1 right */
        if(row >= 2 && col < n-1) {
            if(grid[row-2][col+1] == idx+1)
                return check(grid, row-2, col+1, idx+1);
        }
        /* checking 2 up 1 left */
        if(row >= 2 && col > 0) {
            if(grid[row-2][col-1] == idx+1)
                return check(grid, row-2, col-1, idx+1);
        }
        /* checking 2 left 1 up */
        if(col >= 2 && row > 0) {
            if(grid[row-1][col-2] == idx+1)
                return check(grid, row-1, col-2, idx+1);
        }
        /* checking 2 right 1 up */
        if(col <= n-3 && row > 0) {
            if(grid[row-1][col+2] == idx+1)
                return check(grid, row-1, col+2, idx+1);
        }
        /* checking 2 left 1 down */
        if(col >= 2 && row <= n-2) {
            if(grid[row+1][col-2] == idx+1)
                return check(grid, row+1, col-2, idx+1);
        }
        /* checking 2 right 1 down */
        if(col <= n-3 && row <= n-2) {
            if(grid[row+1][col+2] == idx+1)
                return check(grid, row+1, col+2, idx+1);
        }
        /* checking 2 down 1 left */
        if(row <= n-3 && col > 0) {
            if(grid[row+2][col-1] == idx+1)
                return check(grid, row+2, col-1, idx+1);
        }
        /* checking 2 down 1 right */
        if(row <= n-3 && col < n-1) {
            if(grid[row+2][col+1] == idx+1)
                return check(grid, row+2, col+1, idx+1);
        }
        /* else it has no moves possible */
        return false;
    }
    public static boolean checkValidGrid(int[][] grid) {
        if(grid[0][0] != 0) return false;
        return check(grid, 0, 0, 0);
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the size of the board (n): ");
        int n = sc.nextInt();
        int[][] grid = new int[n][n];
        for(int i=0;i<n;i++) {
            for(int j=0;j<n;j++) {
                System.out.print("Enter the integer at grid[" + i + "][" + j + "]: ");
                grid[i][j] = sc.nextInt();
            }
        }
        System.out.println("Valid configuration of the knight's movements? " + checkValidGrid(grid));
        sc.close();
    }
}
