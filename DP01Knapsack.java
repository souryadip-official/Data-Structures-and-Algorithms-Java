public class DP01Knapsack {
    public static int recursiveApproach(int[] val, int[] wt, int W, int curr, int currProfit) {
        /* Base case */
        if (curr == val.length || W == 0) /* no more items to consider or the knapsack capacity is 0 */
            return currProfit;
        /* General cases */
        if (wt[curr] <= W) {
            /* Option 1: Include the item */
            int inclusionProfit = recursiveApproach(val, wt, W - wt[curr], curr + 1, currProfit + val[curr]);
            /* Option 2: Exclude the item */
            int exclusionProfit = recursiveApproach(val, wt, W, curr + 1, currProfit);
            return Math.max(inclusionProfit, exclusionProfit);
        } else { /* There is no option other than excluding the item because the weight of the item exceeds the knapsack capacity */
            return recursiveApproach(val, wt, W, curr + 1, currProfit);
        }
    }

    public static int memoizationApproachUtil(int[] val, int[] wt, int W, int curr, int[][] dp) {
        /* Base case */
        if(curr == val.length || W == 0)
            return 0; /* Either we are beyond the last item or the remaining knapsack capacity is 0, so no profit can be gained */
        /* General cases */
        if(dp[curr][W] == -1) { /* This state has not been computed yet */
            if (wt[curr] <= W) {
                /* Option 1: Include the current item */
                int inclusionProfit = val[curr] + memoizationApproachUtil(val, wt, W - wt[curr], curr + 1, dp);
                /* Option 2: Exclude the current item */
                int exclusionProfit = memoizationApproachUtil(val, wt, W, curr + 1, dp);
                /* Store the maximum profit for this state */
                return dp[curr][W] = Math.max(inclusionProfit, exclusionProfit);
            } else {
                /* Item cannot be included because it exceeds the remaining capacity, so only exclusion is possible */
                return dp[curr][W] = memoizationApproachUtil(val, wt, W, curr + 1, dp);
            }
        } else {
            return dp[curr][W]; /* State was already computed previously, return stored value */
        }
    }

    public static int memoizationApproachDriver(int[] val, int[] wt, int W) {
        int[][] dp = new int[val.length + 1][W + 1]; /* dp[i][j] stores the maximum-profit achievable starting from item i to the end with capacity j */
        for(int i=0; i<dp.length; i++) {
            for(int j=0; j<dp[0].length; j++)
                dp[i][j] = -1; /* -1 means this state has not been computed yet */
        }
        memoizationApproachUtil(val, wt, W, 0, dp);
        return dp[0][W]; /* Maximum profit starting from the first item (that is the entire set of items) with full capacity is stored in dp[0][W] */
    }

    public static int tabulationApproach(int[] val, int[] wt, int W) {
        int[][] dp = new int[val.length + 1][W + 1]; /* dp[i][j] represents the maximum-profit achievable starting from item index i with remaining knapsack capacity j */
        for (int i=0; i<dp.length; i++)
            dp[i][0] = 0; /* Maximum profit is always 0 when knapsack capacity is 0, irrespective of how many items are available */

        for (int j=0; j<dp[0].length; j++)
            dp[dp.length-1][j] = 0; /* Maximum profit is 0 when no items are left to consider (i.e., we are beyond the last item), irrespective of remaining capacity */

        for (int startItem = val.length-1; startItem>=0; startItem--) { /* Filling the DP table bottom-up starting from the last item towards the first item */
            for (int currCap = 1; currCap<=W; currCap++) { /* Trying all knapsack capacities from 1 to W */
                if (wt[startItem] <= currCap) {
                    int inclusionProfit = val[startItem] + dp[startItem + 1][currCap - wt[startItem]]; /* Profit if the current item is included */
                    int exclusionProfit = dp[startItem + 1][currCap]; /* Profit if the current item is excluded */
                    dp[startItem][currCap] = Math.max(inclusionProfit, exclusionProfit); /* Taking the better of inclusion and exclusion */
                } else
                    dp[startItem][currCap] = dp[startItem + 1][currCap]; /* Current item cannot be included due to weight constraint, so exclusion is the only option */
            }
        }

        for(int[] row : dp) {
            for(int cell : row)
                System.out.print(cell + " ");
            System.out.println();
        }
        System.out.println();
        return dp[0][W]; /* dp[0][W] stores the maximum-profit achievable starting from the first item with full knapsack capacity */
    }

    public static void main(String[] args) {
        int[] val = {15, 14, 10, 45, 30};
        int[] wt = {2, 5, 1, 3, 4};
        int W = 7; /* Maximum weight allowed in the knapsack */
        System.out.println(recursiveApproach(val, wt, W, 0, 0));
        System.out.println(memoizationApproachDriver(val, wt, W));
        System.out.println(tabulationApproach(val, wt, W));
    }
}
