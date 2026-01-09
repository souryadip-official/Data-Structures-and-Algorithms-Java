public class MoveZeroes {
    public void moveZeroes(int[] nums) {
        /* We know that at the last we have to add 0 only. So, traversing the array and whenever we find a non-zero element, we bring it to the front. Afterward, fill all the indices with 0 */
        int idx = 0;
        for (int num: nums) {
            if (num != 0) {
                nums[idx++] = num;
            }
        }
        while (idx < nums.length)
            nums[idx++] = 0;
    }
}