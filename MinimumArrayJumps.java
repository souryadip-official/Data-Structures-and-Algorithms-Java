import java.util.Arrays;
public class MinimumArrayJumps {
    private static int minJumpsUtilRecursion(int[] arr, int curr) {
        if (curr >= arr.length-1) return 0; /* We are either at the destination or out of bounds */
        if (arr[curr] == 0) return Integer.MAX_VALUE; /* We cannot jump further from this step */
        int min = Integer.MAX_VALUE;
        for (int jumpSize = 1; jumpSize <= arr[curr]; jumpSize++) {
            int res = minJumpsUtilRecursion(arr, curr + jumpSize); /* We move to the next index to figure out further jumps */
            if (res == Integer.MAX_VALUE)
                continue; /* The jump we took was not a valid jump i.e., from there, the destination was unreachable */
            /* Otherwise, our jump was valid. We do the minimum check */
            int currCost = 1 + res; /* Current jump added */
            min = Math.min(min, currCost);
        }
        return min;
    }
    public static int minJumpsRecursion(int[] arr) {
        int finalAns = minJumpsUtilRecursion(arr, 0);
        return finalAns;
    }

    private static int minJumpsUtilMemo(int[] arr, int curr, int[] dp) {
        if (curr >= arr.length-1) return 0;
        if (dp[curr] != -1) return dp[curr];
        if (arr[curr] == 0) return Integer.MAX_VALUE;
        int min = Integer.MAX_VALUE;
        for (int jumpSize = 1; jumpSize <= arr[curr]; jumpSize++) {
            int res = minJumpsUtilMemo(arr, curr + jumpSize, dp);
            if (res == Integer.MAX_VALUE)
                continue;
            int currCost = 1 + res;
            min = Math.min(min, currCost);
        }
        return dp[curr] = min;
    }
    public static int minJumpsMemo(int[] arr) {
        int[] dp = new int[arr.length]; /* dp[i] stores the minimum jumps required from the ith cell to last cell */
        Arrays.fill(dp, -1);
        dp[dp.length-1] = 0; /* Jump is not required from the last cell, since we are already at the destination */
        int finalAns = minJumpsUtilMemo(arr, 0, dp);
        return finalAns;
    }
    public static int minJumpsTab(int[] arr) {
        int[] dp = new int[arr.length];
        dp[arr.length-1] = 0; /* We do not need any further jump after we reach the last cell, hence no cost */
        for (int curr = arr.length-2; curr>=0; curr--) { /* Not starting from arr.length-1 because, from the last step, no jump is actually needed */
            if (arr[curr] == 0) dp[curr] = Integer.MAX_VALUE; /* Since no jump is possible from this index, the destination cannot be reached, so we mark it unreachable by returning a big value. */
            int min = Integer.MAX_VALUE;
            for (int jumpSize = 1; jumpSize <= arr[curr]; jumpSize++) {
                if (curr + jumpSize >= arr.length)
                    continue;
                int res = dp[curr + jumpSize];
                if (res == Integer.MAX_VALUE)
                    continue; /* The jump we made, landed on an index from which the destination is unreachable */
                /* That jump was valid, and from there the destination is reachable. So, checking the min jumps */
                int currCost = 1 + res;
                min = Math.min(min, currCost);
            }
            dp[curr] = min;
        }
        return dp[0];
    }
    public static void main(String[] args) {
        int[] arr = {2, 3, 1, 1, 4};
        System.out.println(minJumpsRecursion(arr));
        System.out.println(minJumpsMemo(arr));
        System.out.println(minJumpsTab(arr));
    }
}
