import java.util.Arrays;
public class JumpGameII {
    public int jumpUtil(int[] nums, int curr, int[] dp) {
        if (curr >= nums.length-1) return 0;
        if (dp[curr] == -1) {
            for(int j=1; j<=nums[curr]; j++) { /* j starts from 1 to avoid zero-length jump */
                if(curr+j < nums.length) {
                    int futureJumps = jumpUtil(nums, curr + j, dp);
                    if (futureJumps != -1) /* only considering valid future paths, that is, number of paths != -1 as -1 means not computed or unreachable paths */
                        dp[curr] = Math.min((dp[curr] == -1? Integer.MAX_VALUE : dp[curr]), 1 + futureJumps); // 1 for current jump + future jumps
                    /* (dp[curr] == -1? Integer.MAX_VALUE ---> dp[curr]) ensures that if the current steps is still -1 (not computed or unreachable) and future jumps > -1, then Math.min would normally take -1 which is going to make the code working in a wrong fashion. That is why if the dp[curr] is -1 we consider it to be Integer.MAX_VALUE, so that the future jumps are considered as the dp[curr] and if it is not -1, then the min operation occurs between dp[curr] and future jumps */
                }
            }
            return dp[curr];
        } else return dp[curr];
    }
    public int jump(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n]; /* dp[i] represents the minimum steps to reach n-1th step from ith step */
        Arrays.fill(dp, -1); /* -1 represents "not computed / unreachable" cell */
        dp[n-1] = 0; /* the number of jumps to reach the n-1th step from n-1th step is zero */
        return jumpUtil(nums, 0, dp);
    }
}