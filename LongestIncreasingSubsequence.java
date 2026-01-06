import java.util.Arrays;
public class LongestIncreasingSubsequence {
    /* Recursive Approach */
    public static int lisUtilRecursive(int[] nums, int curr, int prev) {
        if (curr == nums.length) return 0;
        if (prev == -1) { /* This is the first element on which this function is called */
            /* Consider including */
            int include = 1 + lisUtilRecursive(nums, curr+1, curr);
            /* Considering excluding */
            int exclude = lisUtilRecursive(nums, curr+1, prev);
            return Math.max(include, exclude);
        } else {
            if (nums[curr] > nums[prev]) {
                /* This can be included as well as excluded */
                int include = 1 + lisUtilRecursive(nums, curr+1, curr);
                int exclude = lisUtilRecursive(nums, curr+1, prev);
                return Math.max(include, exclude);
            } else {
                /* Exclude is the only option */
                int exclude = lisUtilRecursive(nums, curr+1, prev);
                return exclude;
            }
        }
    }
    public int lengthOfLISRecursive(int[] nums) {
        int res = lisUtilRecursive(nums, 0, -1);
        return res;
    }
    /* Memoization Approach */
    public static int lisUtilMemo(int[] nums, int curr, int prev, int[][] dp) {
        if (curr == nums.length) return 0;
        if (dp[curr][prev+1] != Integer.MIN_VALUE)
            return dp[curr][prev+1];
        if (prev == -1) {
            /* Consider including */
            int include = 1 + lisUtilMemo(nums, curr+1, curr, dp);
            /* Exclude */
            int exclude = lisUtilMemo(nums, curr+1, prev, dp);
            return dp[curr][prev+1] = Math.max(include, exclude);
        } else {
            if (nums[curr] > nums[prev]) {
                /* This can be included as well as excluded */
                int include = 1 + lisUtilMemo(nums, curr+1, curr, dp);
                int exclude = lisUtilMemo(nums, curr+1, prev, dp);
                return dp[curr][prev+1] = Math.max(include, exclude);
            } else {
                /* Exclude is the only option */
                int exclude = lisUtilMemo(nums, curr+1, prev, dp);
                return dp[curr][prev+1] = exclude;
            }
        }
    }
    public int lengthOfLISMemo(int[] nums) {
        int[][] dp = new int[nums.length+1][nums.length+1];
        for(int[] arr : dp)
            Arrays.fill(arr, Integer.MIN_VALUE);

        /* dp[i][0] denotes the cases where the prev index is -1 because the column index in the dp is denoting the prev index which can be -1 hence it is shifted by an offset of 1 */
        for(int j=0; j<dp[0].length; j++)
            dp[dp.length-1][j] = 0; /* When we cross the total size of nums, the longest increasing subsequence is 0 */

        int res = lisUtilMemo(nums, 0, -1, dp);
        return res;
    }
    public int lengthOfLISTabulation(int[] nums) {
        int[][] dp = new int[nums.length+1][nums.length+1];
        for(int[] arr : dp)
            Arrays.fill(arr, Integer.MIN_VALUE);

        /* dp[i][0] means the cases where the prev index is -1 because the column index in the dp is denoting the prev index which can be -1 hence shifted by an offset of 1 */
        for(int j=0; j<dp[0].length; j++)
            dp[dp.length-1][j] = 0; /* When we cross the total size of nums, the longest increasing subsequence is 0 */

        for (int curr=dp.length-2; curr>=0; curr--) {
            for (int prev=curr-1; prev>=-1; prev--) {
                if (prev == -1 || nums[curr] > nums[prev]) {
                    /* In both this cases, we can include and exclude */
                    int include = 1 + dp[curr+1][curr+1]; /* When we are including the number, the prev should be curr but since the curr is in the correct ordering but prev is shifted by an offset 1 to the right, we add +1 to curr to balance the corrdinate shift */
                    int exclude = dp[curr+1][prev+1];
                    dp[curr][prev+1] = Math.max(include, exclude);
                } else {
                    /* Exclude is the only option */
                    int exclude = dp[curr+1][prev+1];
                    dp[curr][prev+1] = exclude;
                }
            }
        }
        return dp[0][0];
    }
}