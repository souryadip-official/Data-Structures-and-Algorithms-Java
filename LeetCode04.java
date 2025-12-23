class LeetCode04 {
    public static int[] merge(int[] arr1, int[] arr2) {
        int m = arr1.length, n = arr2.length;
        int[] finalArr = new int[m + n];
        int i=0, j=0, k=0;
        while(i < m && j < n) {
            if(arr1[i] <= arr2[j])
                finalArr[k++] = arr1[i++];
            else
                finalArr[k++] = arr2[j++];
        }
        while(i < m) finalArr[k++] = arr1[i++];
        while(j < n) finalArr[k++] = arr2[j++];
        return finalArr;
    }
    public static double findMedian(int[] arr) {
        int len = arr.length;
        if(len % 2 != 0) {
            int mid = (0 + (len-1))/2;
            /* 0 denotes the lower index and len-1 denotes the higher index */
            return (double) arr[mid];
        } else {
            int mid1 = (0 + (len-1))/2;
            int mid2 = mid1 + 1;
            return (float)(arr[mid1] + arr[mid2])/2.0;
        }
    }
    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        if(nums1.length == 0 && nums2.length == 0) return 0.0;
        else if(nums1.length == 0) return findMedian(nums2);
        else if(nums2.length == 0) return findMedian(nums1);
        else {
            int[] finalArr = merge(nums1, nums2);
            return findMedian(finalArr);
        }
    }
    public static void main(String[] args) {
        int nums1[] = {1, 2}, nums2[] = {3, 4};
        System.out.println("Median = " + findMedianSortedArrays(nums1, nums2));
    }
}
