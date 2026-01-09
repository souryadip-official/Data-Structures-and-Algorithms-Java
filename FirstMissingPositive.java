public class FirstMissingPositive {
    public int firstMissingPositive(int[] nums) {
        /* The approach we are going to take is the in-place piegeonhole principle */
        int n = nums.length;
        /* For an array of size 'n' of positive integers 1,2,3,4,...n, the max positive element it can have is 'n'. So, all the negative numbers and those which are greater than 'n' are of no use to us. We can safely remove them and mark there 'n+1' because that is the potential max answer that can be of the question if all indices have their correct values from 1...n */
        for (int i=0; i<nums.length; i++) {
            if (nums[i] <= 0 || nums[i] > n)
                nums[i] = n+1;
        }
        /* Say for an array of size n, the positive numbers, if and when the array is sorted should appear like 1, 2, 3, 4...n, that is index i should contain i+1 considering 0 based indexing. So performing this sorting using swapping */

        for (int i=0; i<nums.length; i++) {
            /* at this point, our array only contains positive values */
            int element = Math.abs(nums[i]);
            if (element == n+1) continue; /* we need not require to handle the n because after we traverse the array, if all elements are in their correct place, then the only possible answer is n. Else, we negate the number just to show that the seat is reserved or not and we dont need any handling for negative numbers because we are not going to have a negative number at this point because all negative numbers and numbers > n were marked as n+1 */
            int seat = element-1;
            if (nums[seat] > 0) /* If it is already negative, then the seat is already reserved, we dont change it */
                nums[seat] = -1 * nums[seat];
        }
        /* Now after this manipulation, the array should look like 1, 2... max up to n-1. We will find the first unreserved seat */
        for (int i=0; i<nums.length; i++) {
            if (nums[i] > 0)
                return i+1; /* if nums[i] is a positive number, then it is an unreserved seat. Also if index 0, contains element 1. So, index i must contain i+1 */
        }
        return n+1; /* If all were at their correct places, then n+1 is the only possible ans */
    }
}