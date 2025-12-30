import java.util.Arrays;
import java.util.Collections;
import java.util.PriorityQueue;
public class MaximumSumWithAtmostKElements {
    public static long maxSum(int[][] grid, int[] limits, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        for (int i=0; i<grid.length; i++) {
            Integer[] currRow = new Integer[grid[i].length];
            for(int j=0; j<grid[i].length; j++)
                currRow[j] = grid[i][j];
            Arrays.sort(currRow, Collections.reverseOrder()); /* To sort the current row in the decreasing order */

            for(int j=0; j<limits[i]; j++)
                pq.add(currRow[j]);
        }
        long sum = 0;
        for(int i=1; i<=k; i++)
            sum += pq.remove();
        return sum;
    }
}