import java.util.HashMap;
public class LargestSubarrayWithSumZero {
    private static class Range {
        int start;
        int end;
        Range(int s, int e) {
            this.start = s;
            this.end = e;
        }
    }
    public static Range largestSubarr(int[] arr) {
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0, -1); /* Because index starts from i+1, i.e, -1+1 = 0 */
        /* To handle subarrays starting from index 0.
           For example, say we have an array {1,2,-3,5}.
           Now, at index 0 we get cumsum = 1, store in hashmap (1,0).
           Now, at index 1, we get cumsum = 3, store in hashmap (3,1).
           Now, at index 2, we get cumsum = 0, but there is no "0" key in the hashmap, so we store (0, 2).
           Now, at index 3, we get cumsum = 5, store in hashmap (5, 3)
           Therefore, even if there was a subarray whose sum was 0 {1, 2, -3}, we still get index as -1, -1.
           Therefore, we are handling the edge case where the subarray starts from index 0 itself. */
        int cumsum = 0, maxlen = 0;
        /* cumsum stores the cumulative sum up to certain index
           maxlen stores the length of the largest subarray with sum 0 */
        Range result = new Range(-1, -1);
        for (int i=0; i<arr.length; i++) {
            cumsum += arr[i];
            if (map.containsKey(cumsum)) {
                /* this is a subarray whose range is 0 */
                int idx = map.get(cumsum);
                int curr_subarray_len = i - idx;
                if (curr_subarray_len > maxlen) {
                    maxlen = curr_subarray_len;
                    result.start = idx+1;
                    result.end = i;
                }
            } else {
                map.put(cumsum, i);
            }
        }
        return result;
    }
    public static void main(String[] args) {
        int[] arr = {15, -2, 2, -8, 1, 7, 10};
        Range res = largestSubarr(arr);
        System.out.println(res.start + " ---> " + res.end);
    }
}
