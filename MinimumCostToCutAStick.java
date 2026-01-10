import java.util.Arrays;
public class MinimumCostToCutAStick {
    public static int minCostUtil(int n, int[] cuts, int[][] dp, int i, int j, int lastLeftCutPos, int lastRightCutPos) {
        if (i > j) return 0; /* No more cuts left */
        if (dp[i][j] != -1) return dp[i][j];
        int minCost = Integer.MAX_VALUE;
        for (int k=i; k<=j; k++) {
            int leftPartition = minCostUtil(n, cuts, dp, i, k-1, lastLeftCutPos, cuts[k]);
            int rightPartition = minCostUtil(n, cuts, dp, k+1, j, cuts[k], lastRightCutPos);
            int currCost = lastRightCutPos - lastLeftCutPos;
            int totalCost = currCost + leftPartition + rightPartition;
            minCost = Math.min(minCost, totalCost);
        }
        return dp[i][j] = minCost;
    }
    public int minCost(int n, int[] cuts) {
        int[][] dp = new int[cuts.length][cuts.length];
        Arrays.sort(cuts);
        for (int[] arr: dp)
            Arrays.fill(arr, -1);
        return minCostUtil(n, cuts, dp, 0, cuts.length-1, 0, n);
    }
}