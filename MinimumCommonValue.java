public class MinimumCommonValue {
    public int getCommon(int[] nums1, int[] nums2) {
        for (int i=0, j=0; i<nums1.length && j<nums2.length; ) {
            if(nums1[i] == nums2[j]) /* If the current elements of both arrays are equal, we found the smallest common value, so return it immediately */
                return nums1[i];
            else if(nums1[i] < nums2[j]) i++; /* If nums1[i] is smaller, increment i to move to a larger value in nums1, since arrays are sorted and smaller values cannot match any future nums2[j] */
            else j++; /* Otherwise, nums2[j] is smaller, so increment j to move to a larger value in nums2 for a possible match */
        }
        return -1; /* If we reach the end of either array without finding a match, return -1 indicating no common value exists */
    }
}
