public class SortColors {
    public void sortColorsApproach1(int[] nums) {
        int c0, c1, c2; /* counters to store how many 0s, 1s, and 2s are present */
        c0 = c1 = c2 = 0; /* initialize all counters to zero */
        for (int num: nums) { /* first pass: just count occurrences */
            if (num == 0) c0++; /* count reds */
            else if (num == 1) c1++; /* count whites */
            else c2++; /* count blues */
        }
        int idx = 0; /* index used to overwrite array in sorted order */
        for (; c0 > 0; idx++) { /* place all 0s first */
            nums[idx] = 0;
            c0--;
        }
        for (; c1 > 0; idx++) { /* then place all 1s */
            nums[idx] = 1;
            c1--;
        }
        for (; c2 > 0; idx++) { /* finally place all 2s */
            nums[idx] = 2;
            c2--;
        }
    }
    public static void swap(int[] nums, int i, int j) { /* utility to swap two elements in array */
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
    public void sortColorsDNF(int[] nums) {
        int low = 0, mid = 0, high = nums.length-1; /* three pointers for Dutch National Flag */
        while(mid <= high) { /* process elements until mid crosses high */
            if(nums[mid] == 0) { /* current element is 0, send it to left */
                swap(nums, low, mid);
                low++;
                mid++;
            } else if(nums[mid] == 1) { /* current element is 1, already in correct middle zone */
                mid++;
            } else { /* current element is 2, send it to right */
                swap(nums, mid, high);
                high--;
            }
        }
    }
}