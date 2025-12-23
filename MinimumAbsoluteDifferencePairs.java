import java.util.Arrays;
import java.util.Scanner;
public class MinimumAbsoluteDifferencePairs {
    public static int getMinAbsoluteDifference(int[] nums1, int[] nums2) {
        int minDiff = 0;
        for(int i=0; i<nums1.length; i++)
            minDiff += Math.abs(nums1[i] - nums2[i]);
        return minDiff;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter number of elements: ");
        int n = sc.nextInt();
        int[] nums1 = new int[n];
        int[] nums2 = new int[n];
        System.out.print("Enter " + n + " elements for the first array: ");
        for(int i=0; i<n; i++) nums1[i] = sc.nextInt();
        System.out.print("Enter " + n + " elements for the second array: ");
        for(int i=0; i<n; i++) nums2[i] = sc.nextInt();
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        int minAbsDiff = getMinAbsoluteDifference(nums1 , nums2);
        System.out.println("The minimum absolute difference is " + minAbsDiff);
        sc.close();
    }
}
