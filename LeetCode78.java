import java.util.ArrayList;
import java.util.List;
public class LeetCode78 {
    class Solution {
        public static void subsetsUtil(int[] nums, List<List<Integer>> ans, int curr, List<Integer> temp) {
            if (curr == nums.length) {
                List<Integer> lst = new ArrayList<>();
                for(int num : temp) lst.add(num);
                ans.add(lst);
                return;
            } else {
                /* Include the number */
                temp.add(nums[curr]);
                subsetsUtil(nums, ans, curr+1, temp);
                /* Exclude the number */
                temp.remove(temp.size()-1);
                subsetsUtil(nums, ans, curr+1, temp);
            }
        }
        public List<List<Integer>> subsets(int[] nums) {
            List<List<Integer>> ans = new ArrayList<>();
            subsetsUtil(nums, ans, 0, new ArrayList<>());
            return ans;
        }
    }
}
