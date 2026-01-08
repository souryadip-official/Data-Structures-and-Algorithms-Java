import java.util.Arrays;
public class MinimumPathSum {
    public static int minPathSumUtil(int[][] grid, int[][] dp, int r, int c) {
        if (r < 0 || r >= grid.length || c < 0 || c >= grid[0].length)
            return Integer.MAX_VALUE-200; /* Invalid cell, so returning a very large value so it is never chosen as the minimum. Since, after the value is returned, the grid value at that cell is added to this returned value, so it can create an overflow issue. So to handle that, since we are mentioned that the maximum value of a grid cell can be 200, so we return the maximum integer value by subtracting 200 from it so that even after addition it does not cause an overflow issue */
        else if (r == grid.length-1 && c == grid[0].length-1)
            /* We are at the destination */
            return grid[r][c];

        if (dp[r][c] != -1) return dp[r][c];
        int rightSum = grid[r][c] + minPathSumUtil(grid, dp, r, c+1);
        int downSum = grid[r][c] + minPathSumUtil(grid, dp, r+1, c);
        return dp[r][c] = Math.min(rightSum, downSum);
    }
    public int minPathSum(int[][] grid) {
        if (grid.length == 1 && grid[0].length   == 1)
            /* Source and the destination both are same */
            return grid[0][0];
        int[][] dp = new int[grid.length][grid[0].length];
        for (int[] arr: dp)
            Arrays.fill(arr, -1);
        int res = minPathSumUtil(grid, dp, 0, 0); /* Called for dp[0][0] */
        return res;
    }
}