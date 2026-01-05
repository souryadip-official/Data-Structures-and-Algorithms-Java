import java.util.Arrays;

public class LongestCommonSubsequence {
    /* Basic Recursive Approach */
    public static int lcsUtilRecursive(String t1, String t2, int i1, int i2) {
        if (i1 < 0 || i2 < 0) return 0; /* out of bounds */
        char ct1 = t1.charAt(i1);
        char ct2 = t2.charAt(i2);
        if (ct1 == ct2)
            return 1 + lcsUtilRecursive(t1, t2, i1-1, i2-1);
        else {
            int mvi1 = lcsUtilRecursive(t1, t2, i1-1, i2);
            int mvi2 = lcsUtilRecursive(t1, t2, i1, i2-1);
            return Math.max(mvi1, mvi2);
        }
    }
    public static int longestCommonSubsequenceRecursive(String text1, String text2) {
        int ans = lcsUtilRecursive(text1, text2, text1.length()-1, text2.length()-1);
        return ans;
    }

    /* Top-Down Memoization Dynamic Programming Approach */
    public static int lcsUtilMemo(String t1, String t2, int i1, int i2, int[][] dp) {
        if (i1 < 0 || i2 < 0) return 0; /* base case: if either string index goes out of bounds, the LCS length is zero */
        if (dp[i1+1][i2+1] != Integer.MIN_VALUE) return dp[i1+1][i2+1]; /* dp[i1+1][i2+1] stores the LCS length of prefixes t1[0..i1] and t2[0..i2], reuse it to avoid recomputation */
        char ct1 = t1.charAt(i1);
        char ct2 = t2.charAt(i2);
        if (ct1 == ct2)
            return dp[i1+1][i2+1] = 1 + lcsUtilMemo(t1, t2, i1-1, i2-1, dp); /* when characters match, include this character in LCS and move diagonally */
        else {
            int mvi1 = lcsUtilMemo(t1, t2, i1-1, i2, dp); /* option 1: ignore current character of first string */
            int mvi2 = lcsUtilMemo(t1, t2, i1, i2-1, dp); /* option 2: ignore current character of second string */
            return dp[i1+1][i2+1] = Math.max(mvi1, mvi2); /* store and return the maximum LCS length from both possibilities */
        }
    }
    public static int longestCommonSubsequenceMemo(String text1, String text2) {
        int[][] dp = new int[text1.length()+1][text2.length()+1]; /* dp[i][j] represents the LCS length between text1[0..i-1] and text2[0..j-1] */
        for(int k=0; k<dp.length; k++) Arrays.fill(dp[k], Integer.MIN_VALUE); /* initialize all states as uncomputed */
        for(int j=0; j<dp[0].length; j++) dp[0][j] = 0; /* when first string prefix is empty, LCS length is zero */
        for(int i=0; i<dp.length; i++) dp[i][0] = 0; /* when second string prefix is empty, LCS length is zero */
        return lcsUtilMemo(text1, text2, text1.length()-1, text2.length()-1, dp); /* start solving for full strings */
    }

    /* Bottom-Up Tabulation Approach */
    public static int longestCommonSubsequenceTab(String text1, String text2) {
        int[][] dp = new int[text1.length()+1][text2.length()+1]; /* dp[i][j] stores the LCS length of prefixes text1[0..i-1] and text2[0..j-1] */
        for(int k=0; k<dp.length; k++) Arrays.fill(dp[k], Integer.MIN_VALUE);
        for(int j=0; j<dp[0].length; j++) dp[0][j] = 0; /* base case: empty prefix of first string gives LCS length 0 */
        for(int i=0; i<dp.length; i++) dp[i][0] = 0; /* base case: empty prefix of second string gives LCS length 0 */

        for(int i1 = 1; i1 < dp.length; i1++) {
            for(int i2 = 1; i2 <dp[0].length; i2++) {
                if (text1.charAt(i1 -1) == text2.charAt(i2 -1)) { /* matching characters extend LCS diagonally */
                    dp[i1][i2] = 1 + dp[i1 -1][i2 -1];
                } else {
                    int mvi1 = dp[i1 -1][i2]; /* skip character from first string */
                    int mvi2 = dp[i1][i2 - 1]; /* skip character from second string */
                    dp[i1][i2] = Math.max(mvi1, mvi2); /* take the best possible subsequence */
                }
            }
        }
        return dp[dp.length-1][dp[0].length-1]; /* the final cell represents LCS of full strings */
    }
    public static void main(String[] args) {
        String s1 = "ace", s2 = "abcde";
        System.out.println(longestCommonSubsequenceRecursive(s1, s2));
        System.out.println(longestCommonSubsequenceMemo(s1, s2));
        System.out.println(longestCommonSubsequenceTab(s1, s2));
    }
}
