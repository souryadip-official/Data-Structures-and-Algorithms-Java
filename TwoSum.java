import java.util.Arrays;
import java.util.HashMap;
public class TwoSum {
    public static class Info implements Comparable<Info>{
        int val;
        int idx;
        public Info(int val, int idx) {
            this.val = val;
            this.idx = idx;
        }
        @Override
        public int compareTo(Info i) {
            return this.val - i.val; /* defining natural ordering so that Info objects get sorted based on values, which enables two pointer technique after sorting */
        }
    }
    /* HashMap Approach */
    public static int[] twoSum1(int[] nums, int target) {
        if (nums.length == 1) return new int[] {}; /* single element can never form a valid pair */
        HashMap<Integer, Integer> map = new HashMap<>(); /* map stores previously seen number as key and its index as value to allow O(1) complement lookup */
        for(int i=0; i<nums.length; i++) {
            int curr = nums[i];
            int gap = target - curr; /* required complement that must exist among already processed elements */
            if (map.containsKey(gap)) /* ensures we do not reuse the same element and guarantees two distinct indices */
                return new int[] {map.get(gap), i}; /* returning indices of the complement and current element */
            else map.put(curr, i); /* store current element only after checking to avoid pairing element with itself */
        }
        return new int[] {}; /* fallback return when no valid pair is found */
    }
    /* Approach 2: Two Pointer Approach */
    public static int[] twoSum2(int[] nums, int target) {
        if (nums.length == 1) return new int[] {}; /* edge case handling */
        Info[] arr = new Info[nums.length];
        for (int i=0; i<nums.length; i++)
            arr[i] = new Info(nums[i], i); /* wrapping values with original indices so index information is preserved even after sorting */

        Arrays.sort(arr); /* sorting enables two pointer strategy by arranging values in ascending order */
        int lp = 0, rp = arr.length-1;
        while(lp <= rp) { /* moving pointers inward to explore all possible pairs in sorted order */
            int sum = arr[lp].val + arr[rp].val;
            if(sum == target)
                return new int[] {arr[lp].idx, arr[rp].idx}; /* returning original indices corresponding to the found pair */
            else if (sum < target) lp++; /* increasing sum by moving left pointer forward */
            else rp--; /* decreasing sum by moving right pointer backward */
        }
        return new int[] {}; /* fallback return if no valid pair exists */
    }
}