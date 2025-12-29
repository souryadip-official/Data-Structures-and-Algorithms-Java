import java.util.Arrays;
public class FrogJump {
    public static int minimumEnergy(int[] heights, int curr, int[] dp) {
        if (curr == heights.length-1) /* Base case */
            return 0; /* Energy lost in reaching the last stair from the last stair is zero */

        int oneStepCost = Integer.MAX_VALUE, twoStepCost = Integer.MAX_VALUE;
        if (dp[curr] == -1) {
            if (curr+1 < heights.length) {
                int currJumpCost = Math.abs(heights[curr] - heights[curr+1]); /* to store the cost of the current one-step jump, that is, the immediate energy lost when the frog jumps from the current stair to the next stair */
                int futureCost = minimumEnergy(heights, curr+1, dp); /* to store the future cost after taking this one-step jump, that is, the minimum energy required to reach the last stair starting from the next stair */
                oneStepCost = currJumpCost + futureCost;
            }
            if (curr+2 < heights.length) {
                int currJumpCost = Math.abs(heights[curr] - heights[curr+2]); /* to store the cost of the current two-step jump */
                int futureCost = minimumEnergy(heights, curr+2, dp); /* to store the future cost after taking this two-step jump */
                twoStepCost = currJumpCost + futureCost;
            }
            return dp[curr] = Math.min(oneStepCost, twoStepCost); /* Considering only the minimum jump cost */
        } else
            return dp[curr];
    }
    public static void main(String[] args) {
        int[] heights = {10, 20, 30, 10}; /* heights[i] represents the height of the (i+1)th stair */
        int[] dp = new int[heights.length];
        Arrays.fill(dp, -1);
        dp[heights.length-1] = 0; /* Energy lost in reaching the last stair from the last stair is zero */
        System.out.println(minimumEnergy(heights, 0, dp));
    }
}