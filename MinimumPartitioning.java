public class MinimumPartitioning {
    public static int minimumDifference(int[] numbers) {
        int totalSum = 0;
        for (int num: numbers)
            totalSum += num;

        int W = totalSum/2; /* Knapsack capacity */
        System.out.println(totalSum);
        int[][] dp = new int[numbers.length+1][W+1]; /* dp[i][j] stores the maximum profit that can be made for given first 'i' items with a knapsack capacity of 'j' */

        for (int i=0; i<dp.length; i++) /* Maximum profit is always 0 when knapsack capacity is 0, irrespective of how many items are available */
            dp[i][0] = 0;
        for (int j=0; j<dp[0].length; j++)
            dp[dp.length-1][j] = 0; /* Maximum profit is 0 when no items are left to consider (i.e., we are beyond the last item), irrespective of remaining capacity */

        for (int startItem = numbers.length-1; startItem >= 0; startItem--) {
            for (int currCap = 1; currCap <= W; currCap++) {
                /* Here, the weight and the value array both are the numbers array */
                if (numbers[startItem] <= currCap) {
                    /* Option 1: Include the item */
                    int inclusionCost = numbers[startItem] + dp[startItem + 1][currCap - numbers[startItem]]; /* This means, the current item is included, check for the later items */
                    /* Option 2: Exclude the item */
                    int exclusionCost = dp[startItem + 1][currCap]; /* This means, the current item is excluded, check for the later items */
                    dp[startItem][currCap] = Math.max(inclusionCost, exclusionCost);
                } else {
                    /* The current item cannot be accommodated in the knapsack */
                    int exclusionCost = dp[startItem + 1][currCap];
                    dp[startItem][currCap] = exclusionCost;
                }
            }
        }
        int totalProfitMadeForSet1 = dp[0][W];
        int totalProfitForSet2 = totalSum - totalProfitMadeForSet1;
        System.out.println("Current = " + totalProfitMadeForSet1);
        System.out.println("Remaining = " + totalProfitForSet2);
        return Math.abs(totalProfitMadeForSet1 - totalProfitForSet2);
    }
    public static void main(String[] args) {
        int[] numbers = {1, 6, 11, 15};
        System.out.println("Minimum difference = " + minimumDifference(numbers));
    }
}
