public class LeetCode1299 {
    public int[] replaceElements(int[] arr) {
        int max = Integer.MIN_VALUE;
        int[] res = new int[arr.length];
        for(int i=arr.length-1; i>=0; i--) { /* traverse from right to left to keep track of the max on the right */
            if (i == arr.length-1) { /* last element always becomes -1 */
                res[i] = -1;
                max = arr[i];
            }
            else { /* replace current element with the max seen so far on the right and update max */
                res[i] = max;
                max = Math.max(max, arr[i]);
            }
        }
        return res;
    }
}