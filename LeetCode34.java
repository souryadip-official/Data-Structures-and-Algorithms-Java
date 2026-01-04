public class LeetCode34 {
    public int[] searchRange(int[] arr, int target) {
        int lidx = -1, ridx = -1, low, high, mid;
        lidx = ridx = -1;
        /* Finding the leftmost occurrence */
        low = 0;
        high = arr.length-1;
        while (low <= high) {
            mid = (low + high)/2;
            if (arr[mid] == target) {
                lidx =  mid; /* store mid as current leftmost candidate */
                high = mid-1; /* to find for existence of further earlier occurrence */
            } else if (arr[mid] < target)
                low = mid+1; /* move right because the target is larger */
            else high = mid-1; /* move left because the target is smaller */
        }
        /* Finding the rightmost occurrence */
        low = 0;
        high = arr.length-1;
        while (low <= high) {
            mid = (low + high)/2;
            if (arr[mid] == target) {
                ridx =  mid; /* store mid as current rightmost candidate */
                low = mid+1; /* to find the existence of further later occurrence */
            } else if (arr[mid] < target)
                low = mid+1; /* move right because the target is larger */
            else high = mid-1; /* move left because the target is smaller */
        }
        int[] res = new int[2];
        res[0] = lidx;
        res[1] = ridx;
        return res;
    }
}
