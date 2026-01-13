import java.util.HashMap;
public class FindSumPairs {
    int[] n1;
    int[] n2 = null;
    HashMap<Integer, Integer> map1; /* To store, sum, count pair for nums1 */
    HashMap<Integer, Integer> map2;
    public FindSumPairs(int[] nums1, int[] nums2) {
        this.n1 = new int[nums1.length];
        this.n2 = new int[nums2.length];
        this.map1 = new HashMap<>();
        this.map2 = new HashMap<>();

        for (int i=0; i<nums1.length; i++)
            this.n1[i] = nums1[i];

        for (int j=0; j<nums2.length; j++)
            this.n2[j] = nums2[j];

        /* Since, the first array is fixed and never changed, so we can store the sums of nums1 in the hashmap so that we don't have to do the O(n) operation of adding the elements multiple times. In the same way in nums2 array where we face unnecessary duplicates too due to which the practical time increases. For that, we can maintain another map as well. */
        for (int num: this.n1)
            map1.put(num, map1.getOrDefault(num, 0) + 1);

        for (int num: this.n2)
            map2.put(num, map2.getOrDefault(num, 0) + 1);
    }

    public void add(int index, int val) {
        int oldVal = this.n2[index];
        int freq = this.map2.get(oldVal);
        if (freq == 1)
            /* this value came only once, and we are updating that now. So, we need to delete this */
            this.map2.remove(oldVal);
        else
            this.map2.put(oldVal, freq-1);

        this.n2[index] += val;
        int newVal = this.n2[index];
        this.map2.put(newVal, this.map2.getOrDefault(newVal, 0) + 1);
    }

    public int count(int tot) {
        int count = 0;
        for (int key1 : map1.keySet()) {
            int need = tot - key1;
            if (this.map2.containsKey(need)) {
                count += this.map1.get(key1) * this.map2.get(need);
            }
        }
        return count;
    }
}