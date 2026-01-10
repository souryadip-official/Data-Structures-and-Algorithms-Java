import java.util.Arrays;
public class SegmentTree01 {
    public static int buildSegmentTree(int[] nums, int[] segmentTree, int start, int end, int curr) {
        if (start == end) { /* Single node condition. So, we can directly store the value and return it without any further calls */
            segmentTree[curr] = nums[start];
            return nums[start];
        }
        int mid = start + (end - start)/2;
        int leftSum = buildSegmentTree(nums, segmentTree, start, mid, 2*curr+1); /* Building the left subtree */
        int rightSum = buildSegmentTree(nums, segmentTree, mid+1, end, 2*curr+2); /* Building the right subtree */
        segmentTree[curr] = leftSum + rightSum;
        return segmentTree[curr];
    }
    public static int getSumUtil(int[] segmentTree, int queryStart, int queryEnd, int segmentStart, int segmentEnd, int curr) {
        /* The given segment makes no overlapping with the given query range */
        if (queryStart > segmentEnd || queryEnd < segmentStart)
            return 0;
        /* The given segment makes complete overlapping with the given query range */
        if (queryStart <= segmentStart && segmentEnd <= queryEnd)
            return segmentTree[curr]; /* We include the sum completely because the total sum contains the range sum */
        /* The given segment makes partial overlapping with the given query range */
        int mid = segmentStart + (segmentEnd - segmentStart)/2;
        int leftResult = getSumUtil(segmentTree, queryStart, queryEnd, segmentStart, mid, 2*curr+1);
        int rightResult = getSumUtil(segmentTree, queryStart, queryEnd, mid+1, segmentEnd, 2*curr+2);
        return leftResult + rightResult;
    }
    public static int getSum(int[] nums, int[] segmentTree, int queryStart, int queryEnd) {
        return getSumUtil(segmentTree, queryStart, queryEnd, 0, nums.length-1, 0);
    }
    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4, 5, 6, 7, 8};
        int[] segmentTree = new int[4 * nums.length];
        buildSegmentTree(nums, segmentTree, 0, nums.length-1, 0);
        System.out.println(Arrays.toString(segmentTree));
        System.out.println(getSum(nums, segmentTree, 2, 5));
    }
}
