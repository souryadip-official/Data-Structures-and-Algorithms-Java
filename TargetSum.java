public class TargetSum {
    public static boolean doesExistSubset(int[] numbers, int targetSum) {
        boolean[][] dp = new boolean[numbers.length+1][targetSum+1]; /* dp table where dp[i][j] answers this question: using only the first i elements of the array, is it possible to form an exact sum of j or not */
        for(int i=0; i<dp.length; i++)
            dp[i][0] = true; /* This entire column is true because forming sum 0 never requires any element, irrespective of how many elements are available */
        for(int j=1; j<dp[0].length; j++)
            dp[0][j] = false; /* This entire row (except j=0) is false because with 0 elements, we simply cannot construct any positive target sum */
        for(int i=1; i<dp.length; i++) {
            for(int j=1; j<dp[0].length; j++) {
                int currVal = numbers[i-1]; /* Since dp is 1-indexed in terms of elements, the actual array value corresponds to numbers[i-1] */
                if (currVal <= j) { /* If current element value is less than or equal to current target sum, we have a real choice to make */
                    boolean inclusionExistence = dp[i - 1][j - currVal]; /* Inclusion means we pick this element, so we now ask: was the remaining sum (j - currVal) achievable using previous elements? */
                    boolean exclusionExistence = dp[i - 1][j]; /* Exclusion means we ignore this element and check whether sum j was already achievable without it */
                    dp[i][j] =  inclusionExistence || exclusionExistence; /* If at least one of these decisions leads to a valid state, then sum j is achievable using first i elements */
                } else { /* If current element is larger than the target sum j, inclusion is impossible due to overflow */
                    dp[i][j] = dp[i-1][j]; /* Only logical option left is to skip the element and inherit the previous result */
                }
            }
        }
        return dp[dp.length-1][dp[0].length-1]; /* This cell represents whether targetSum is achievable using all available elements */
    }
    public static void main(String[] args) {
        int[] numbers = {4, 2, 7, 1, 3};
        int targetSum = 10;
        System.out.println(doesExistSubset(numbers, targetSum)); /* Prints true if any subset sums exactly to 10, otherwise false */
    }
}