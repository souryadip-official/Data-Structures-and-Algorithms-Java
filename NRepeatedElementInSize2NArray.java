import java.util.HashSet;
public class NRepeatedElementInSize2NArray {
    public int repeatedNTimes(int[] nums) {
        HashSet<Integer> set = new HashSet<>(); /* used to track elements already seen */
        int repeated = -1;
        for (int i=0; i<nums.length; i++) {
            if (!set.contains(nums[i]))
                set.add(nums[i]); /* first time seeing this element */
            else {
                repeated = nums[i]; /* duplicate found, this is the element repeated n times */
                break;
            }
        }
        return repeated; /* problem guarantees such an element exists */
    }
}