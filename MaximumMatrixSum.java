public class MaximumMatrixSum {
    public long maxMatrixSum(int[][] matrix) {
        int negCount = 0; /* count of negative elements */
        long absum = 0; /* sum of absolute values of all elements */
        int smallestAbs = Integer.MAX_VALUE; /* track the smallest absolute value */
        for (int i=0; i<matrix.length; i++) {
            for (int j=0; j<matrix[0].length; j++) {
                int val = matrix[i][j]; /* current element */
                if (val < 0) negCount++; /* increment if negative */
                int abs = Math.abs(val); /* absolute value of current element */
                absum += abs; /* add to the total absolute sum */
                smallestAbs = Math.min(smallestAbs, abs); /* update smallest absolute value */
            }
        }
        return (negCount % 2 == 0)? absum : absum - 2L * smallestAbs; /* if odd negatives, subtract double smallest absolute value */
    }
}