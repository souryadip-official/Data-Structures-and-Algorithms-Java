import java.util.HashMap;
import java.util.ArrayList;
import java.util.List;
public class MajorityElementII {
    public List<Integer> majorityElement(int[] nums) {
        int criteria = nums.length/3;
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i=0; i<nums.length; i++) {
            int key = nums[i];
            if (map.isEmpty() || !map.containsKey(key)) map.put(key, 1);
            else map.put(key, map.get(key)+1);
        }
        List<Integer> res = new ArrayList<>();
        for (int key: map.keySet())
            if (map.get(key) > criteria)
                res.add(key);
        return res;
    }
}
