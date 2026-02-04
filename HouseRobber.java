import java.util.Arrays;
public class HouseRobber {
    public static int robUtilMemo(int[] nums, int curr, int[] dp) {
        if (curr >= nums.length) return 0;
        if (dp[curr] != -1) return dp[curr];
        /* get included and move twice */
        int include = nums[curr] + robUtilMemo(nums, curr+2, dp);
        /* Get excluded and move next */
        int exclude = robUtilMemo(nums, curr+1, dp);
        return dp[curr] = Math.max(include, exclude);
    }
    public static int robUtilTab(int[] nums) {
        int[] dp = new int[nums.length+2]; /* dp size n+2 to handle base cases dp[n] and dp[n+1] = 0 for i+2 transitions */
        dp[nums.length] = 0;
        dp[nums.length+1] = 0;
        for (int i=nums.length-1; i>=0; i--) {
            int include = Integer.MIN_VALUE, exclude = Integer.MIN_VALUE;
            include = nums[i] + dp[i+2];
            exclude = dp[i+1];
            dp[i] = Math.max(include, exclude);
        }
        return dp[0];
    }
    public int robMemo(int[] nums) {
        int[] dp = new int[nums.length]; /* dp[i] stores the max profit achievable from the ith house either including that house or excluding it */
        Arrays.fill(dp, -1);
        return robUtilMemo(nums, 0, dp);
    }
    public int robTab(int[] nums) {
        return robUtilTab(nums);
    }
}