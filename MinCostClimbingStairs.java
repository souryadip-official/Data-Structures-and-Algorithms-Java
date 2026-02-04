import java.util.Arrays;
public class MinCostClimbingStairs {
    public static int mincostUtilMemo(int[] cost, int curr, int[] dp) {
        if (curr >= cost.length) return 0;
        if (dp[curr] != -1) return dp[curr];
        int onestep = mincostUtilMemo(cost, curr+1, dp);
        int twostep = mincostUtilMemo(cost, curr+2, dp);
        return dp[curr] = cost[curr] + Math.min(onestep, twostep);
    }
    public static int mincostUtilTab(int[] cost) {
        int[] dp = new int[cost.length+2]; /* To handle cost.length and cost.length+1 */
        dp[cost.length] = 0;
        dp[cost.length+1] = 0;
        for (int i=cost.length-1; i>=0; i--) {
            int onestep = dp[i+1];
            int twostep = dp[i+2];
            dp[i] = cost[i] + Math.min(onestep, twostep);
        }
        return Math.min(dp[0], dp[1]);
    }
    public int minCostClimbingStairsMemo(int[] cost) {
        int[] dp = new int[cost.length]; /* dp[i] stores the min cost required to reach top of the floor from the ith step */
        Arrays.fill(dp, -1);
        mincostUtilMemo(cost, 0, dp);
        return Math.min(dp[0], dp[1]);
    }
    public int minCostClimbingStairsTab(int[] cost) {
        return mincostUtilTab(cost);
    }
}