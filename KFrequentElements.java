import java.util.Collections;
import java.util.HashMap;
import java.util.PriorityQueue;
public class KFrequentElements {
    public static class Info implements Comparable<Info> {
        int val;
        int freq;
        public Info(int val, int freq) {
            this.val = val;
            this.freq = freq;
        }
        @Override
        public int compareTo(Info i) {
            return this.freq - i.freq; /* Ascending order */
        }
    }
    public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>(); /* To store (value, freq) pair */
        PriorityQueue<Info> pq = new PriorityQueue<>(Collections.reverseOrder()); /* Max heap */
        for (int i=0; i<nums.length; i++) {
            int curr = nums[i];
            map.put(curr, map.getOrDefault(curr, 0) + 1);
        }
        for (int key : map.keySet()) {
            int value = map.get(key);
            pq.add(new Info(key, value));
        }
        int[] arr = new int[k];
        for (int i=1; i<=k; i++)
            arr[i-1] = pq.poll().val;
        return arr;
    }
}