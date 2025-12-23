import java.util.Scanner;
import java.util.ArrayList;
public class PairSum02 {
    public static boolean bruteForce_find(ArrayList<Integer> nums, int sum) {
        boolean isFound = false;
        for(int i=0; i<nums.size(); i++) {
            for(int j=i+1; j<nums.size(); j++) {
                if(nums.get(i) + nums.get(j) == sum) {
                    isFound = true;
                    System.out.println(nums.get(i) + " + " + nums.get(j) + " gives sum of " + sum);
                }
            }
        }
        return isFound;
    }
    public static int findPeak(ArrayList<Integer> nums) {
        for(int i=0; i<nums.size()-1; i++) {
            if(nums.get(i+1) < nums.get(i))
                return i;
        }
        return 0;
    }
    public static int modifyLeftPointer(ArrayList<Integer> nums, int val) {
        if(val == nums.size()-1)
            return 0;
        return (val+1);
        /* or we can also use Modular arithmetic:
        return (val + 1) % nums.size(); */
    }
    public static int modifyRightPointer(ArrayList<Integer> nums, int val) {
        if(val == 0)
            return nums.size()-1;
        return (val-1);
        /* or we can also Modular arithmetic:
        return (nums.size() + val - 1) % nums.size(); */
    }
    public static boolean optimised_find(ArrayList<Integer> nums, int sum) {
        int peak = findPeak(nums);
        int leftPointer, rightPointer = peak;
        int initialRightPointer = peak;
        if(peak != nums.size()-1) leftPointer = peak+1;
        else leftPointer = 0;
        int initialLeftPointer = leftPointer;
        boolean isFound = false;
        /* Concept: leftPointer always moves towards the largest element whereas the rightPointer always moves towards the smallest element */
        while(leftPointer != rightPointer) {
            /* Here, we cannot use leftPointer < rightPointer condition because it is not guaranteed. For example, in array 11,15,6,8,7,9,10, 15 will be the rightPointer and 6 will be the leftPointer. Basically, what we mean is, our leftPointer points to the smallest element and the rightPointer points to the largest element */
            int pairSum = nums.get(leftPointer) + nums.get(rightPointer);
            if(pairSum == sum) {
                isFound = true;
                /* To print only the unique pairs, that is only (a,b) and not (b,a) again, we can print either the increasing matches or the decreasing matches. It's preferable to use the increasing match choice because the array was initially assumed as an increasing one */
                if(nums.get(leftPointer) < nums.get(rightPointer))
                    System.out.println(nums.get(leftPointer) + " + " + nums.get(rightPointer) + " gives sum of " + sum);
                leftPointer = modifyLeftPointer(nums, leftPointer);
                rightPointer = modifyRightPointer(nums, rightPointer);
            }
            else if(pairSum > sum)
                /* we need to handle the rightPointer */
                rightPointer = modifyRightPointer(nums, rightPointer);
            else
                /* we need to handle the left pointer */
                leftPointer = modifyLeftPointer(nums, leftPointer);
            if(rightPointer == initialRightPointer && leftPointer == initialLeftPointer) break;
        }
        return isFound;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter number of lines (n): ");
        int n = sc.nextInt();
        if(n == 1) {
            System.out.println("Pair sum cannot be formed out of one number.");
            return;
        }
        ArrayList<Integer> nums = new ArrayList<>();
        System.out.print("Enter the numbers: ");
        for(int i=1; i<=n; i++) nums.add(sc.nextInt());
        System.out.print("Enter the target sum: ");
        int sum = sc.nextInt();
        if(!bruteForce_find(nums,sum)) System.out.println("No pair sum exists!");
        System.out.println();
        if(!optimised_find(nums,sum)) System.out.println("No pair sum exists!");
        sc.close();
    }
}
