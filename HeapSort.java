import java.util.Arrays;
public class HeapSort {
    public static void heapify(int[] arr, int idx, int size) {
        int left = 2 * idx + 1;
        int right = 2 * idx + 2;
        int maxIdx = idx;

        if (left < size && arr[left] > arr[maxIdx])
            maxIdx = left;

        if (right < size && arr[right] > arr[maxIdx])
            maxIdx = right;

        if (maxIdx != idx) {
            /* A new maximum index is found. So, we perform swapping and recursively apply heapify over it as well */
            int temp = arr[idx];
            arr[idx] = arr[maxIdx];
            arr[maxIdx] = temp;
            heapify(arr, maxIdx, size);
        }
    }
    public static void heapSort(int[] arr) {
        /* Building the max-heap (ascending order) */
        int n = arr.length;
        for (int i=n/2; i>=0; i--)
            heapify(arr, i, n);

        /* Swapping the first element with the last and perform heapify recursively on the root */
        for (int i=n-1; i>=1; i--) {
            int temp = arr[0];
            arr[0] = arr[i];
            arr[i] = temp;
            /* By doing the above, the largest element is now at its correct position. We need not consider it further. So, the heap size becomes equal to i (as i decreases, the heap size also decreases */
            heapify(arr, 0, i);
        }
    }
    public static void main(String[] args) {
        /* Number of internal nodes in a heap is floor of n/2 and number of leaf nodes is ceil of n/2. Since a heap is a complete binary tree (CBT), hence all the internal nodes will be at the beginning half of [0, n/2) */
        int[] arr = {1, 4, 2, 5, 3};
        heapSort(arr);
        System.out.println(Arrays.toString(arr));
    }
}
