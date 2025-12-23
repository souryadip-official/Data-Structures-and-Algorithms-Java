import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
public class SlidingWindowMaximum {
    public static ArrayList<Integer> slidingWindow_BruteForce(int[] nums, int k) {
        ArrayList<Integer> result = new ArrayList<>();
        int max;
        for(int i=0; i<= nums.length-k; i++) {
            max = Integer.MIN_VALUE;
            for(int j=i; j<i+k; j++)
                max = Math.max(max, nums[j]);
            result.add(max);
        }
        return result;
    }
    public static ArrayList<Integer> slidingWindow_Optimised(int[] nums, int k) {
        ArrayList<Integer> result = new ArrayList<>();
        Deque<Integer> deque = new LinkedList<>();
        /* storing the first window result */
        for(int i=0; i<k; i++) {
            while(!deque.isEmpty() && nums[deque.getLast()] <= nums[i])
                deque.removeLast();
            deque.addLast(i);
        }
        /* after that checking the remaining elements one by one */
        for(int i=k; i<nums.length; i++) {
            result.add(nums[deque.getFirst()]);
            int startIndex = i-k+1;
            /* now, we should remove all those elements from the deque which are not a part of the current window */
            while(!deque.isEmpty() && deque.getFirst() < startIndex)
                deque.removeFirst();
            /* now storing the maximum for this new window */
            while(!deque.isEmpty() && nums[deque.getLast()] <= nums[i])
                deque.removeLast();
            deque.addLast(i);
        }
        result.add(nums[deque.getFirst()]);
        return result;
    }
    public static void main(String[] args) {
        int nums[] = {1, 3, -1, -3, 5, 3, 6, 7}, k = 3;
        ArrayList<Integer> result = new ArrayList<>(slidingWindow_BruteForce(nums, k));
        System.out.println("Result: " + result);
        result = new ArrayList<>(slidingWindow_Optimised(nums, k));
        System.out.println("Result: " + result);
    }
}
