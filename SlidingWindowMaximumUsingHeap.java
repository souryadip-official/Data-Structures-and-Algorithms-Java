import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.PriorityQueue;
public class SlidingWindowMaximumUsingHeap {
    public static class Info implements Comparable<Info> {
        int value;
        int index;
        public Info(int value, int index) {
            this.value = value;
            this.index = index;
        }
        @Override
        public int compareTo(Info i) {
            return this.value - i.value;
        }
    }
    public static int[] slidingWindowMax(int[] arr, int k) {
        /* Concept: If we have 'n' elements, and we group 'k' elements at a time, then number of groups that will be formed is n-k+1 */
        int[] res = new int[arr.length-k+1];
        PriorityQueue<Info> pq = new PriorityQueue<>(Collections.reverseOrder());
        /* Adding the first window (first k numbers) to the priority queue */
        for (int i=0; i<k; i++)
            pq.add(new Info(arr[i], i));

        /* From here we start sliding window */
        int resIdx = 0; /* Index to track the index at which result will be stored */
        res[resIdx++] = pq.peek().value;
        for (int i=k; i<arr.length; i++) {
            int outOfRangeIdx = i-k; /* Say, our k is 3, and we are current at index 3, then the new window is from [1...3], so 0 is excluded. This is because all the values at indices <= (i-k), in this case, 3-3=0, therefore, all the elements in the front with indices less than or equal to 0 will be removed from the queue */
            while (!pq.isEmpty() && pq.peek().index <= outOfRangeIdx)
                pq.remove();
            pq.add(new Info(arr[i], i));
            res[resIdx++] = pq.peek().value;
        }
        return res;
    }
    public static void main(String[] args) {
        int[] arr = {1,3,-1,-3,5,3,6,7};
        int k = 3;
        System.out.println(Arrays.toString(slidingWindowMax(arr, k)));
    }
}
