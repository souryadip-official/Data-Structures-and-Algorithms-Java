public class CoinChange {
    public static int getMinimumCoins(int[] coins, int amount) {
        int[][] dp = new int[coins.length + 1][amount + 1]; /* dp table where dp[i][j] stores the minimum number of coins needed to make amount j using the first i coins */
        for(int j=0; j<dp[0].length; j++) dp[0][j] = -1; /* when no coins are available, forming any positive amount is not possible */
        for (int i=0; i<dp.length; i++) dp[i][0] = 0; /* amount zero can always be formed by choosing no coins */

        for(int i=1; i<dp.length; i++) {
            int currCoin = coins[i - 1]; /* the coin value currently being considered */

            for(int j=1; j<dp[0].length; j++) {
                if (currCoin <= j) { /* the current coin can be used for this amount */

                    /* try including the current coin in the solution */
                    int inclusionCount = -1;
                    if (dp[i][j - currCoin] != -1) /* include only if the remaining amount was already achievable */
                        inclusionCount = 1 + dp[i][j - currCoin];

                    /* try excluding the current coin from the solution */
                    int exclusionCount = dp[i - 1][j];

                    /* choose the valid option that uses fewer coins */
                    if (inclusionCount == -1 && exclusionCount != -1) dp[i][j] = exclusionCount;
                    else if (exclusionCount == -1 && inclusionCount != -1) dp[i][j] = inclusionCount;
                    else if (inclusionCount != -1 && exclusionCount != -1) {
                        if (inclusionCount < exclusionCount) dp[i][j] = inclusionCount;
                        else dp[i][j] = exclusionCount;
                    } else dp[i][j] = -1; /* neither inclusion nor exclusion can form this amount */
                } else {
                    dp[i][j] = dp[i - 1][j]; /* the current coin is too large, so it cannot be used */
                }
            }
        }

        for (int []row : dp) { /* printing the dp table to observe intermediate results */
            for(int val : row)
                System.out.print(val + "\t");
            System.out.println();
        }
        return dp[dp.length-1][dp[0].length-1]; /* final answer for the full amount using all coins */
    }
    public static void main(String[] args) {
        int[] coins = {1, 2, 5};
        int amount = 11;
        System.out.println("Minimum number of coins required = " + getMinimumCoins(coins, amount));
    }
}
