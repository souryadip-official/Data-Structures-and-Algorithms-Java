import java.util.HashMap;
public class SubarrayCountWithSumK {
    public static int subarraySum(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>(); /* to store the sum and the count */
        int count = 0, cumsum = 0; /* to count the number of subarrays and the cumulative sum*/
        map.put(0, 1); /* sum 0 has occurred once */
        for(int i=0; i<nums.length; i++) {
            cumsum += nums[i];
            if (map.containsKey(cumsum-k))
                count += map.get(cumsum-k);
            map.put(cumsum, map.getOrDefault(cumsum, 0) + 1);
        }
        return count;
    }
    public static void main(String[] args) {
        int[] arr = {15, -2, 2, -8, 1, 7, 10};
        System.out.println(subarraySum(arr, 0));
    }
}
