import java.util.Arrays;
public class MatrixChainMultiplication {
    public static int minCostUtilRecursive(int[] dimension, int i, int j) {
        if (i == j) return 0; /* For a single matrix, no multiplication operation is needed */
        int min_cost = Integer.MAX_VALUE;
        for (int k=i; k<=j-1; k++) {
            int partition1_cost = minCostUtilRecursive(dimension, i, k);
            int partition2_cost = minCostUtilRecursive(dimension, k+1, j);
            int curr_cost = dimension[i-1] * dimension[k] * dimension[j] + partition1_cost + partition2_cost;
            min_cost = Math.min(curr_cost, min_cost);
        }
        return min_cost;
    }
    public static long minCostRecursive(int[] dimension) {
        return minCostUtilRecursive(dimension, 1, dimension.length-1);
    }
    public static int minCostUtilMemo(int[] dimension, int i, int j, int[][] dp) {
        if (i == j) return 0;
        if (dp[i][j] != -1) return dp[i][j];
        int min_cost = Integer.MAX_VALUE;
        for (int k=i; k<=j-1; k++) {
            int partition1_cost = minCostUtilMemo(dimension, i, k, dp);
            int partition2_cost = minCostUtilMemo(dimension, k+1, j, dp);
            int curr_cost = dimension[i-1] * dimension[k] * dimension[j] + partition1_cost + partition2_cost;
            min_cost = Math.min(curr_cost, min_cost);
        }
        return dp[i][j] = min_cost;
    }
    public static long minCostMemo(int[] dimension) {
        int[][] dp = new int[dimension.length][dimension.length];
        /* dp[i][j] represents the minimum number of scalar multiplications required
            to multiply the chain of matrices from Mi to Mj (both inclusive), that is, Mi * Mi+1 * ... * Mj.
            Although the dp array is 0-based in Java, the indices i and j are treated conceptually as 1-based,
            corresponding to the matrix chain defined by the dimension array. */
        for (int [] arr: dp)
            Arrays.fill(arr, -1);
        for (int i=0; i<dp.length; i++)
            dp[i][0] = 0;
        for (int j=0; j<dp[0].length; j++)
            dp[0][j] = 0;
        return minCostUtilMemo(dimension, 1, dimension.length-1, dp);
    }
    public static long minCostTab(int[] dimension) {
        int[][] dp = new int[dimension.length][dimension.length];
        for (int i=dimension.length-1; i>=1; i--) {
            for (int j=i+1; j<dimension.length; j++) {
                if (i == j) dp[i][j] = 0;
                else {
                    int min_cost = Integer.MAX_VALUE;
                    for (int k=i; k<=j-1; k++) {
                        int partition1_cost = dp[i][k];
                        int partition2_cost = dp[k+1][j];
                        int curr_cost = dimension[i-1] * dimension[k] * dimension[j] + partition1_cost + partition2_cost;
                        min_cost = Math.min(curr_cost, min_cost);
                    }
                    dp[i][j] = min_cost;
                }
            }
        }
        return dp[1][dp[0].length-1];
        /*
        We are running 'i' backwards because, assume the dimension array has length 5, so we are multiplying 4 matrices:
        M1, M2, M3, M4. The dp table entries we care about are dp[i][j] where 1 ≤ i < j ≤ 4.

        Suppose we want to compute dp[1][4]. According to the formula, dp[1][4]
        depends on:
        dp[1][1], dp[2][4]
        dp[1][2], dp[3][4]
        dp[1][3], dp[4][4]

        So before dp[1][4] can be computed, dp[2][4] and dp[3][4] must already exist.
        Now look at dp[2][4]. It depends on:
        dp[2][2], dp[3][4]
        dp[2][3], dp[4][4]

        This shows a clear pattern: dp[i][j] depends on dp[i+1][j], dp[i+2][j], etc.
        That means states with a larger starting index i must be computed first because of this clear dependency.

        If we run i forward (1 to n), then when we are at i = 1 and j = 4,
        dp[2][4] and dp[3][4] are not computed yet, so dp[1][4] would use
        incorrect or default values.

        By running i backward (n to 1), dp[4][4] is computed first, then dp[3][4],
        then dp[2][4], and finally dp[1][4]. This guarantees that whenever dp[i][j]
        is being calculated, all required dp[i+1][j], dp[i+2][j], and dp[k+1][j]
        states already exist.

        So running 'i' backwards ensures that dependencies move from already-filled
        cells to the current cell, which is exactly what bottom-up dynamic
        programming requires.
        */
    }
    public static void main(String[] args) {
        int[] dimension = {1, 2, 3, 4, 3};
        System.out.println(minCostRecursive(dimension));
        System.out.println(minCostMemo(dimension));
        System.out.println(minCostTab(dimension));
    }
}
