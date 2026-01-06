import java.util.Arrays;
public class LongestCommonSubstring {
    public int longestCommonSubstr(String s1, String s2) {
        int[][] dp = new int[s1.length()+1][s2.length()+1]; /* dp[i][j] represents the length of the longest common substring ending exactly at s1[i-1] and s2[j-1], so continuity is mandatory */
        for(int[] arr: dp)
            Arrays.fill(arr, Integer.MIN_VALUE); /* initialize all states to a dummy value to clearly separate uncomputed states from valid substring lengths */

        for(int i=0; i<dp.length; i++)
            dp[i][0] = 0; /* if the second string is empty, no common substring can exist, so length is zero */

        for(int j=0; j<dp[0].length; j++)
            dp[0][j] = 0; /* if the first string is empty, no common substring can exist, so length is zero */

        int max = 0; /* stores the maximum length of any common substring found so far across all dp states */
        for(int i1=1; i1<dp.length; i1++) {
            for(int i2=1; i2<dp[0].length; i2++) {
                char ch1 = s1.charAt(i1-1); /* mapping dp index to actual character index in the first string */
                char ch2 = s2.charAt(i2-1); /* mapping dp index to actual character index in the second string */
                if (ch1 == ch2) { /* when characters match, we can extend the previous common substring diagonally */
                    dp[i1][i2] = 1 + dp[i1-1][i2-1]; /* substring continuity is preserved only by moving diagonally */
                    max = Math.max(max, dp[i1][i2]); /* update global maximum because longest substring can end anywhere */
                } else {
                    dp[i1][i2] = 0; /* mismatch breaks substring continuity, so length must reset to zero */
                }
            }
        }
        return max; /* returns the length of the longest common contiguous substring */
    }
}