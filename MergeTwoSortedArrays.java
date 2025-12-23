import java.util.Scanner;
public class MergeTwoSortedArrays {
    public static void display(int[] arr) {
        for(int i=0;i<arr.length;i++)
            System.out.print(arr[i] + " ");
        System.out.println();
    }
    public static void merge(int[] nums1, int m, int[] nums2, int n) {
        int[] t = new int[m+n];
        int i=0, j=0, idx=0;
        while(i<m && j<n) {
            if(nums1[i] <= nums2[j])
                t[idx++] = nums1[i++];
            else
                t[idx++] = nums2[j++];
        }
        while(i<m) t[idx++] = nums1[i++];
        while(j<n) t[idx++] = nums2[j++];
        for(i=0;i<m+n;i++)
            nums1[i] = t[i];
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the size of first and second array: ");
        int m = sc.nextInt(), n = sc.nextInt();
        int[] nums1 = new int[m+n];
        int[] nums2 = new int[n];
        System.out.print("Enter " + m + " elements of the first array: ");
        for(int i=0;i<m+n;i++) {
            if(i < m) nums1[i] = sc.nextInt();
            else nums1[i] = 0;
        }
        System.out.print("Enter " + n + " elements of the second array: ");
        for(int i=0;i<n;i++) nums2[i] = sc.nextInt();
        merge(nums1,m,nums2,n);
        System.out.print("Sorted array: ");
        display(nums1);
        sc.close();
    }
}
