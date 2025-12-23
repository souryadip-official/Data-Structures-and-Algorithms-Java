import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;
public class PairSum {
    public static boolean bruteForce_find(ArrayList<Integer> nums, int sum) {
        if(sum > nums.getFirst() + nums.getLast()) return false;
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
    public static boolean optimised_find(ArrayList<Integer> nums, int sum) {
        if(sum > nums.getFirst() + nums.getLast()) return false;
        boolean isFound = false;
        int leftPointer = 0, rightPointer = nums.size()-1;
        while(leftPointer < rightPointer) {
            int pairSum = nums.get(leftPointer) + nums.get(rightPointer);
            if(pairSum == sum) {
                System.out.println(nums.get(leftPointer) + " + " + nums.get(rightPointer) + " gives sum of " + sum);
                isFound = true;
                leftPointer++;
                rightPointer--;
                continue;
                /* this is because, if a match is found, if we decrease the rightPointer, then the new element pointed by rightPointer will be either less than the previous one or will be the same. Hence, the new pairSum will either be equal to the sum or less than it if we move only the rightPointer. So, there is no chance that we can find a sum equal to 'sum' afterward in case the element is not repeated. So, we move both. On the other hand, if we move only the leftPointer, then the next element will be either greater than or equal to the previous one. Hence, the new pairSum will either be equal to the sum or greater than it if we move only the leftPointer. So, there is no chance that we will get a sum equal to 'sum' afterward. So, we move both */
            }
            if(pairSum >= sum) rightPointer--;
            else leftPointer++;
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
        /* The problem statement assumes a sorted array, but in case the array is not sorted, we may like to sort it
        Collections.sort(nums); */
        System.out.print("Enter the target sum: ");
        int sum = sc.nextInt();
        if(!bruteForce_find(nums,sum)) System.out.println("No pair sum exists!");
        System.out.println();
        if(!optimised_find(nums,sum)) System.out.println("No pair sum exists!");
        sc.close();
    }
}
