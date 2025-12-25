public class ArrayProductExceptSelf {
    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int [] leftProd = new int[n]; /* leftProd[i] = stores the product of all the elements to the left of the element i */
        int [] rightProd = new int[n]; /* rightProd[i] = stores the product of all the elements to the right of the element i */
        int currleftProd = nums[0]; /* the first element */
        int currRightProd = nums[n-1]; /* the last element */
        leftProd[0] = rightProd[n-1] = 1; /* The Leftmost element has no element in its left, and the rightmost element has no elements in its right. So, their corresponding left and right products are 1 (identity) */
        for (int i=1; i<n; i++) {
            leftProd[i] = currleftProd;
            currleftProd = currleftProd * nums[i];
        }
        for (int i=n-2; i>=0; i--) {
            rightProd[i] = currRightProd;
            currRightProd = currRightProd * nums[i];
        }
        int[] ans = new int[n];
        for (int i=0; i<n; i++)
            ans[i] = leftProd[i] * rightProd[i];
        return ans;
    }
}