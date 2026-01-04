import java.util.HashMap;
public class ContainsDuplicatesII {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>(); /* hashmap to store each number with the last index where it was seen */
        for (int i=0; i<nums.length; i++) {
            int currnum = nums[i];
            if (!map.containsKey(currnum)) /* first time seeing this number, so storing its index */
                map.put(currnum, i);
            else {
                /* this number was already seen before */
                int idx = map.get(currnum);
                if (Math.abs(idx - i) <= k) /* checking if the index difference satisfies the k condition */
                    return true;
                else {
                    /* the current index gap exceeds k, so we update the index with the most recent one so that future comparisons have a smaller gap */
                    map.put(currnum, i);
                }
            }
        }
        return false;
    }
}