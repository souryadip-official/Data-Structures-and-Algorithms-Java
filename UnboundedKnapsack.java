public class UnboundedKnapsack {
    public static int unboundedKnapsack(int[] val, int[] wt, int W) {
        int[][] dp = new int[val.length + 1][W + 1]; /* dp table where dp[i][j] stores max profit using first i items and capacity j */
        for (int i=0; i<dp.length; i++)
            dp[i][0] = 0; /* if capacity is zero then profit must be zero no matter how many items exist */

        for (int j=0; j<dp[0].length; j++)
            dp[0][j] = 0; /* if no items are allowed, then profit is zero even if capacity is there */

        for (int i=1; i<dp.length; i++) { /* start iterating items one by one */
            for (int j=1; j<dp[0].length; j++) { /* for each item, try all possible capacities */
                int currWt = wt[i-1]; /* actual weight of the current item since dp index is shifted by 1 */
                if (currWt <= j) { /* item can fit inside the bag so decision time */
                    int inclusionProfit = val[i-1] + dp[i][j-currWt]; /* include item and stay in same row because item is reusable */
                    int exclusionProfit = dp[i-1][j]; /* exclude item and move to the previous item set */
                    dp[i][j] = Math.max(inclusionProfit, exclusionProfit); /* take the better option no overthinking */
                } else {
                    int exclusionProfit = dp[i-1][j]; /* item is too heavy, so the only option is to skip it */
                    dp[i][j] = exclusionProfit; /* store the skipped result directly */
                }
            }
        }
        return dp[dp.length-1][dp[0].length-1];
    }
    public static void main(String[] args) {
        int[] val = {15, 14, 10, 45, 30};
        int[] wt = {2, 5, 1, 3, 4};
        int W = 7; /* maximum capacity of the bag */
        System.out.println(unboundedKnapsack(val, wt, W));
    }
}