import java.util.Arrays;
public class LongestPalindromicSubsequence {
    public static int lps(String s, int head, int tail, int[][] dp) {
        /* Since the tail parameter is at an offset of 1 from the zero-based indexing of the string,
           we must be careful when accessing s.charAt(tail-1); this ensures we are actually referring
           to the last character in the current substring [head, tail). This offset helps simplify
           handling empty and single-character substrings in the recursion. */
        if (head >= tail) return 0; /* Base case: if head has crossed or reached tail, the substring is empty,
                                        so the length of the longest palindromic subsequence is 0. */
        if (head == tail-1) return 1; /* Base case: if there is exactly one character (substring length 1),
                                         then that character itself forms a palindromic subsequence of length 1. */
        char start = s.charAt(head);  /* Current character at the start of the substring */
        char end = s.charAt(tail-1);  /* Current character at the end of the substring */
        if (dp[head][tail] != Integer.MIN_VALUE) /* Memoization check: if we have already computed the
                                                     longest palindromic subsequence for the substring
                                                     [head, tail), we directly return it to avoid
                                                     redundant computation and save time. */
            return dp[head][tail];

        /* Recursive computation */
        if (start == end) {
            /* Case when characters at both ends are equal: including both these characters in the
               palindromic subsequence is always beneficial because it increases the length by 2,
               and we then recursively compute the LPS of the substring inside these two characters
               (head+1 to tail-1). This ensures we build the palindrome from the outside in. */
            return dp[head][tail] = 2 + lps(s, head+1, tail-1, dp); /* Store the result in dp table
                                                                        and return it */
        } else {
            /* Case when characters at both ends are not equal: we cannot include both characters simultaneously in a palindrome. Therefore, we have two options: either exclude the start character and compute the LPS of the remaining substring (head+1 to tail), or exclude the end character and compute the LPS of (head to tail-1). The maximum of these two options gives the LPS for the current substring. This ensures that all possible palindromic subsequences are considered. */
            int exclude1 = lps(s, head+1, tail, dp); /* Excluding start character */
            int exclude2 = lps(s, head, tail-1, dp); /* Excluding end character */
            return dp[head][tail] = Math.max(exclude1, exclude2); /* Store and return the maximum */
        }
    }

    public int longestPalindromeSubseq(String s) {
        int[][] dp = new int[s.length()+1][s.length()+1]; /* DP table where dp[i][j] stores the LPS  length for substring starting at index i and ending before index j (exclusive) */
        for (int[] arr: dp)
            Arrays.fill(arr, Integer.MIN_VALUE); /* Initialize all states as uncomputed so that memoization can work properly */
        for (int j=0; j<dp[0].length; j++)
            dp[dp.length-1][j] = 0; /* Base case for memoization: empty substring starting from index s.length() has length 0 */
        for (int i=0; i<dp.length; i++)
            dp[i][0] = 0; /* Base case for memoization: substring ending at index 0 has length 0 */

        return lps(s, 0, s.length(), dp); /* Start recursion from the full string [0, s.length()) */
    }
}