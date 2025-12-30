import java.util.ArrayList;
import java.util.List;
public class TargetIndexAfterSorting {
    public List<Integer> targetIndices(int[] nums, int target) {
        List<Integer> res = new ArrayList<>();
        /* We will track the number of items less than target and the number of times the target appears */
        int less = 0, count = 0;
        for (int num: nums) {
            if (num < target) less++;
            else if(num == target) count++;
        }
        for(int i=0; i<count; i++)
            res.add(less+i);
        return res;
    }
}