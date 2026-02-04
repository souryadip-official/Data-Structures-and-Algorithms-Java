import java.util.ArrayList;
import java.util.List;
public class LeetCode46_Permuations {
    public static void getpermute(int[] nums, boolean[] taken, List<List<Integer>> res, List<Integer> temp, int size) {
        if (size == nums.length) {
            List<Integer> newp = new ArrayList<>();
            for (int ele: temp)
                newp.add(ele);
            res.add(newp);
            return;
        }

        for (int i=0; i<nums.length; i++) {
            if (!taken[i]) {
                temp.add(nums[i]);
                taken[i] = true;
                getpermute(nums, taken, res, temp, size+1);
                temp.remove(temp.size()-1);
                taken[i] = false; /* backtrack for future cases */
            }
        }
    }
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        boolean[] taken = new boolean[nums.length];
        getpermute(nums, taken, res, new ArrayList<>(), 0);
        return res;
    }
}
