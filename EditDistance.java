import java.util.Arrays;

public class EditDistance {
    public static int minDistanceUtilRecursive(String w1, String w2, int i1, int i2, int[][] dp) {
        /* Base case: When i1 < 0 and i2 >= 0, it means word1 is finished but word2 still has characters left. To convert "" to those remaining characters, you need i2 + 1 insert operations, not 0. Similarly, when i2 < 0 and i1 >= 0, you need i1 + 1 delete operations to remove the remaining characters of word1 */
        if (i1 < 0 && i2 >= 0) {
            /* It means, w1 is exhausted, so the max we can do is inserting all the rest of the characters of w2 which requires i2+1 insert operations (+1 because i2 is 0-based index) */
            return i2 + 1;
        } else if (i1 >= 0 && i2 < 0) {
            /* It means, w2 is exhausted, so the max we can do is deleting all the rest of the characters of w1 which requires i1+1 delete operations (+1 because i1 is 0-based index) */
            return i1+1;
        } else if (i1 < 0 && i2 < 0) {
            /* If both of them are exhausted, we do not need any further operation, so we return a 0 */
            return 0;
        }
        char ch1 = w1.charAt(i1);
        char ch2 = w2.charAt(i2);
        if (ch1 == ch2) {
            /* Including them makes conversion easy because it is already following the sequence */
            return minDistanceUtilRecursive(w1, w2, i1-1, i2-1, dp);
        } else { /* We need to perform all the three different operations which are insert, delete or replace to find the minimum operations */
            /* Option 1: We assume that we insert the current character of w2 at the end of w1 to match the characters. So we increment the operation by 1 and go one step back for w2 because inserting the character of w2 at the end of w1 essentially means that the character matched ago and we are left to shift back the pointer for w2 */
            int insert = 1 + minDistanceUtilRecursive(w1, w2, i1, i2-1, dp);
            /* Option 2: We assume that we delete this current character of w1 (basically, ignore) and check for any other occurrence */
            int delete = 1 + minDistanceUtilRecursive(w1, w2, i1-1, i2, dp);
            /* Optiom 3: We assume that we replace the current character of w1 with the current character of w2 and check for further cases. So assume that we replaced, so the matching is successfully, we move the pointers back for each */
            int replace =  1 + minDistanceUtilRecursive(w1, w2, i1-1, i2-1, dp);
            return Math.min(Math.min(insert, delete), replace); /* The minimum operation among all these three are considered */
        }
    }
    public int minDistanceRecursive(String word1, String word2) {
        int[][] dp = new int[word1.length()+1][word2.length()+1];
        int ans = minDistanceUtilRecursive(word1, word2, word1.length()-1, word2.length()-1, dp);
        return ans;
    }
    class Solution {
        public static int minDistanceUtilMemo(String w1, String w2, int i1, int i2, int[][] dp) {
            if (i1 < 0 && i2 >= 0) { /* dp[i1][i2] represents minimum operations to convert w1[0..i1] to w2[0..i2], both indices inclusive, here w1 exhausted, w2 has i2+1 characters left, so need exactly i2+1 insert operations */
                return i2 + 1;
            } else if (i1 >= 0 && i2 < 0) { /* dp[i1][i2] represents min operations to convert w1[0..i1] to w2[0..i2], here w2 exhausted, w1 has i1+1 characters left, so need exactly i1+1 delete operations */
                return i1+1;
            } else if (i1 < 0 && i2 < 0) { /* dp[i1][i2] represents min operations to convert empty prefixes w1[0..i1] and w2[0..i2], both empty, so cost is 0 */
                return 0;
            }
            if (dp[i1][i2] != Integer.MIN_VALUE) /* dp[i1][i2] already computed, reuse it to avoid recomputation, represents min operations to convert w1[0..i1] to w2[0..i2] inclusive */
                return dp[i1][i2];
            char ch1 = w1.charAt(i1);
            char ch2 = w2.charAt(i2);
            if (ch1 == ch2) { /* last characters of prefixes match, so no operation needed, dp[i1][i2] reduces to dp[i1-1][i2-1] which represents min operations to convert w1[0..i1-1] to w2[0..i2-1] inclusive */
                return dp[i1][i2] = minDistanceUtilMemo(w1, w2, i1-1, i2-1, dp);
            } else {
                int insert = 1 + minDistanceUtilMemo(w1, w2, i1, i2-1, dp); /* simulate inserting w2[i2] into w1, now we solve w1[0..i1] -> w2[0..i2-1], inclusive indices, add 1 operation */
                int delete = 1 + minDistanceUtilMemo(w1, w2, i1-1, i2, dp); /* simulate deleting w1[i1], now solve w1[0..i1-1] -> w2[0..i2] inclusive, add 1 operation */
                int replace =  1 + minDistanceUtilMemo(w1, w2, i1-1, i2-1, dp); /* simulate replacing w1[i1] with w2[i2], now solve w1[0..i1-1] -> w2[0..i2-1] inclusive, add 1 operation */
                return dp[i1][i2] = Math.min(Math.min(insert, delete), replace); /* store and return minimum operations for dp[i1][i2] representing w1[0..i1] -> w2[0..i2] inclusive */
            }
        }
        public int minDistanceMemo(String word1, String word2) {
            int[][] dp = new int[word1.length()][word2.length()]; /* dp table where dp[i][j] represents min operations to convert w1[0..i] to w2[0..j], both inclusive */
            for(int[] arr: dp)
                Arrays.fill(arr, Integer.MIN_VALUE); /* initialize all dp states as unsolved */
            int ans = minDistanceUtilMemo(word1, word2, word1.length()-1, word2.length()-1, dp); /* compute min operations for full strings, inclusive indices */
            return ans; /* final edit distance between word1 and word2 */
        }
        public int minDistanceTab(String word1, String word2) {
            int[][] dp = new int[word1.length()+1][word2.length()+1]; /* dp[i][j] will store the minimum number of operations needed to convert the first i characters of word1 into the first j characters of word2, here we use i and j starting from 1 to make handling the empty string easier */
            for(int j=0; j<dp[0].length; j++)
                dp[0][j] = j; /* when word1 is empty, we need exactly j insertions to build the first j characters of word2, so we fill the first row with 0,1,2,...,j representing this cost */
            for(int i=0; i<dp.length; i++)
                dp[i][0] = i; /* when word2 is empty, we need exactly i deletions to remove all characters from the first i characters of word1, so we fill the first column with 0,1,2,...,i representing this cost */

            for (int i1=1; i1<dp.length; i1++) {
                for(int i2=1; i2<dp[0].length; i2++) {
                    char ch1 = word1.charAt(i1-1); /* get the current character from word1 corresponding to index i1-1 because dp indices start from 1 but string indices start from 0 */
                    char ch2 = word2.charAt(i2-1); /* get the current character from word2 corresponding to index i2-1 for the same reason */
                    if (ch1 == ch2) {
                        dp[i1][i2] = dp[i1-1][i2-1]; /* if the characters are the same, no new operation is needed so we just take the value from the diagonal cell which represents the cost for the previous characters */
                    } else {
                        int insert = 1 + dp[i1][i2-1]; /* if we insert the character from word2, the cost is one plus the cost to match the same prefix of word1 with one less character of word2 */
                        int delete = 1 + dp[i1-1][i2]; /* if we delete the character from word1, the cost is one plus the cost to match one less character of word1 with the same prefix of word2 */
                        int replace = 1 + dp[i1-1][i2-1]; /* if we replace the character from word1 with the character from word2, the cost is one plus the cost to match the previous prefixes without these characters */
                        dp[i1][i2] = Math.min(Math.min(insert, delete), replace); /* we take the minimum of these three options because we want the least number of operations to match the prefixes of word1 and word2 */
                    }
                }
            }
            return dp[dp.length-1][dp[0].length-1]; /* finally, dp[m][n] stores the minimum operations required to convert the entire word1 to word2, which is our answer */
        }
    }
}
