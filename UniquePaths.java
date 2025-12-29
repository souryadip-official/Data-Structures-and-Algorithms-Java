public class UniquePaths {
    public int uniquePathsUtil(int cr, int cc, int m, int n, int[][] dp) {
        if(cr >= m || cr < 0 || cc >= n || cc < 0) return 0; /* We have crossed the boundary of the grid */
        else if(cr == m-1 && cc == n-1) return dp[m-1][n-1]; /* We are at the destination */

        if(cr != m-1) { /* Ensuring we are not at the last row from where the down movement is not possible */
            if (dp[cr+1][cc] == -1)
                dp[cr+1][cc] = uniquePathsUtil(cr+1, cc, m, n, dp); /* down movement */
        }

        if (cc != n-1) { /* Ensuring we are not at the last column from where the right movement is not possible */
            if (dp[cr][cc+1] == -1)
                dp[cr][cc+1] = uniquePathsUtil(cr, cc+1, m, n, dp); /* up movement */
        }

        if (cr == m-1) return dp[cr][cc+1]; /* Ensuring if we are at the last row, we return only the right movement result */
        if (cc == n-1) return dp[cr+1][cc]; /* Ensuring if we are at the last column, we return only the down movement result */
        else return dp[cr+1][cc] + dp[cr][cc+1]; /* Else we return the result of both the movements */
    }
    public int uniquePaths(int m, int n) {
        int[][] dp = new int[m][n]; /* dp[i][j] stores the number of valid paths to the destination dp[m-1][n-1] */
        for (int i=0; i<m; i++)
            for(int j=0; j<n; j++)
                dp[i][j] = -1;
        dp[m-1][n-1] = 1; /* We are already at the destination. So it in itself is a valid path. Hence, counted as 1 */
        return uniquePathsUtil(0,0, m, n, dp);
    }
}
