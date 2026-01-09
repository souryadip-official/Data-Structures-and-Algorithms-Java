public class TrailingZeroes {
    public boolean hasTrailingZeros(int[] nums) {
        /* Bitwise OR of any number with an odd number will have a trailing 1 whereas bitwise OR of two even numbers will always have a trailing 0. So, our problem reduces to check if the array has at least two even elements */
        int countEven = 0; /* to check if two or more even elements are found */
        for (int i=0; i<nums.length; i++) {
            if (nums[i] % 2 == 0)
                countEven++;
        }
        return countEven >= 2;
    }
}