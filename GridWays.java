import java.util.Scanner;
public class GridWays {
    public static long getFact(int x) {
        int ans = 1;
        for(int i=1;i<=x;i++) ans *= i;
        return ans;
    }
    public static long findGridWays(int row, int col, int noOfRows, int noOfCols) {
        return getFact(noOfRows+noOfCols-2) / (getFact(noOfRows-1) * getFact(noOfCols-1));
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter grid dimensions (m * n): ");
        int m = sc.nextInt(), n = sc.nextInt();
        if(m == 1 && n == 1) {
            System.out.println("Source and destination cells are same. No moves required!");
            return;
        }
        long res = findGridWays(0,0,m,n);
        if(res == 0) System.out.println("No solution exists!");
        else System.out.println("Total ways: " + res);
        sc.close();
    }
}
/*
public static int printGridWays(int[][] grid, int row, int col, String path) {
    if(row == grid.length || col == grid[0].length)
        return 0;
    else if(row == grid.length-1 && col == grid[0].length-1) {
        System.out.println("Path " + (++count) + ": " + path);
        return 1;
    }
    int downWays = printGridWays(grid,row+1, col, path + "Down ");
    int rightWays = printGridWays(grid, row, col+1, path + "Right ");
    return (downWays + rightWays);
} */