import java.util.Scanner;
public class LeetCode2016 {
    public static int maximumDifference_bruteForce(int[] nums) {
        if(nums.length == 1) return -1;
        int currDiff = -1;
        for(int i=0;i<nums.length-1;i++) {
            for(int j=i+1; j<nums.length;j++) {
                if(j > i && nums[j] > nums[i] && nums[j]-nums[i] > currDiff)
                    currDiff = nums[j] - nums[i];
            }
        }
        return currDiff;
    }
    public static int maximumDifference_optimised(int[] nums) {
        if(nums.length == 1) return -1;
        int minIdx=0, currDiff=-1;
        for(int i=0;i<nums.length;i++) {
            if(nums[i] < nums[minIdx]) minIdx = i;
            if(nums[i] - nums[minIdx] > currDiff)
                currDiff = nums[i] - nums[minIdx];
        }
        if(currDiff <= 0) return -1;
        return currDiff;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the array size: ");
        int[] nums = new int[sc.nextInt()];
        System.out.print("Enter " + nums.length + " elements: ");
        for(int i=0;i<nums.length;i++) nums[i] = sc.nextInt();
        System.out.println("Maximum difference: " + maximumDifference_optimised(nums));
        sc.close();
    }
}
