import java.util.Arrays;
class WildcardMatching {
    public static boolean isMatchUtil(String s, String p, int si, int pi, int[][] dp) {
        /* This recursive function represents the state where we are trying to match the prefix s[0..si] with the prefix p[0..pi] */
        if (si < 0 && pi >= 0) {
            /* The string is exhausted. But the pattern is not fully matched. So we need to check if only * is left in the pattern because this is the only case where this can be true. If it contains characters other than *, then there were other characters which were supposed to be matched but the matching was not done, so its not a valid match case */
            for (int k=0; k<=pi; k++) {
                if (p.charAt(k) != '*') {
                    /* Valid character which was supposed to be matched */
                    return false;
                }
            }
            return true; /* all the characters were '*' only */
        } else if (pi < 0 && si >= 0) {
            /* If the pattern is exhausted but the string is not, there is no way to match further, so returning false here */
            return false;
        } else if (si < 0 && pi < 0) {
            /* Both strings are matched successfully */
            return true;
        }

        /* dp[i][j] stores whether the substring s[0..i] matches the pattern p[0..j] considering all wildcard rules, so dp[i][j] directly represents the answer to the subproblem (i, j) and memoizes it to avoid recomputation due to '*' branching; the dp array is sized (s.length()+1) x (p.length()+1) because we need to represent the case where the substring or pattern is empty (i=-1 or j=-1), and using +1 offset allows valid indexing of these empty prefixes in the array without going negative */
        if (dp[si][pi] != -1) return (dp[si][pi] == 1? true : false);

        char chs = s.charAt(si);
        char chp = p.charAt(pi);

        if (chs == chp) {
            /* Character matched. Both pointers moved */
            dp[si][pi] = (isMatchUtil(s, p, si-1, pi-1, dp)? 1 : 0);
            return (dp[si][pi] == 1? true : false);
        } else if (chp == '?') {
            /* We ignore whatever be the character on the string because ? matches any character */
            dp[si][pi] = (isMatchUtil(s, p, si-1, pi-1, dp)? 1 : 0);
            return (dp[si][pi] == 1? true : false);
        } else if (chp == '*') {
            /* Here we need to try all possible combinations of length. If at least one is true, we return true */
            int temp = 0;
            while (temp <= si+1) {
                /* Matching temp up to si, matches only the valid indices that are up to 0th character. But we need to handle the cases where the '*' consumes all the remaining characters. For example, if we are 'c' of the string "abcd" and at the '*'' of the pattern "*d", then we match * with going beyond '*' always gives false because of the scenario that the pattern is exhausted but the string is not. So, in this case, if we go only upto the valid, we will come to a situation where the string is also exhausted, therefore, we get a false even if this is a valid match. So, we go one step beyond the possible index just to see the case whether '*' consumes all the initial characters by exhausting the string */

                /* temp represents how many characters '*' is assumed to consume from the string before matching the remaining pattern */
                dp[si][pi] = (isMatchUtil(s, p, si-temp, pi-1, dp)? 1 : 0);
                if (dp[si][pi] == 1)
                    return true;
                temp++;
            }
            dp[si][pi] = 0;
            return false;
        } else {
            /* The characters do not match. We immediately return false */
            dp[si][pi] = 0;
            return false;
        }
    }
    public boolean isMatch(String s, String p) {
        /* dp table is used to store results of all smaller prefix matching states so that overlapping recursive calls are avoided and dp[i][j] specifically represents whether the substring s[0..i-1] matches the pattern p[0..j-1] considering all wildcard rules; the array is sized (s.length()+1) x (p.length()+1) because the +1 allows us to handle empty prefixes safely without negative indexing */
        int[][] dp = new int[s.length()+1][p.length()+1];
        for (int[] arr: dp)
            Arrays.fill(arr, -1);
        /* -1 for not computed state; 0 for false state; 1 for true state */
        return isMatchUtil(s, p, s.length()-1, p.length()-1, dp);
    }
}