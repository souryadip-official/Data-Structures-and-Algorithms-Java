public class ValidMountainArray {
    public boolean validMountainArray(int[] arr) {
        if (arr.length < 3) return false;
        /* Increasing loop */
        int idx = 0;
        int prev = Integer.MIN_VALUE;
        while(idx < arr.length) {
            if (prev < arr[idx]) {
                prev = arr[idx];
                idx++;
            } else {
                break; /* We need to check the decreasing now */
            }
        }
        if (idx == arr.length || idx == 1) {
            /* All were increasing mountains, which is an invalid case as per the question because there should strictly be present some decreasing sequenced mountains after the increasing sequence */
            return false;
        }
        /* Decreasing loop */
        while (idx < arr.length) {
            if (arr[idx] < prev) {
                prev = arr[idx];
                idx++;
            } else return false;
        }
        return true;
    }
}