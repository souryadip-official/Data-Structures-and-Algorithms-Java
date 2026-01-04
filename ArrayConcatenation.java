public class ArrayConcatenation {
    public int[] getConcatenation(int[] nums) {
        int[] ans = new int[nums.length * 2];
        for(int i=0; i<nums.length; i++) {
            int currnum = nums[i];
            ans[i] = currnum;
            ans[i + nums.length] = currnum;
        }
        return ans;
    }
}