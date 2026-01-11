import java.util.Collections;
import java.util.PriorityQueue;
public class AbsoluteDifferenceBetweenMaxAndMinKElements {
    public int absDifference(int[] nums, int k) {
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        for (int num: nums) {
            maxHeap.add(num);
            minHeap.add(num);
        }
        int maxsum = 0, minsum = 0;
        for (int i=1; i<=k; i++) {
            maxsum += maxHeap.poll();
            minsum += minHeap.poll();
        }
        return maxsum - minsum;
    }
}