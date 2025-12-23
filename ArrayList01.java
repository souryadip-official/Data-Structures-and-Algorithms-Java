import java.util.Scanner;
import java.util.ArrayList;
import java.util.Stack;

//public class ArrayList01 {
//    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
//        ArrayList<Integer> list = new ArrayList<>();
//        do {
//            System.out.print("Enter element: ");
//            list.add(sc.nextInt());
//            System.out.print("Enter 1 to add one more or -1 to exit: ");
//        } while (sc.nextInt() != -1);
//        /* Printing the list in reverse order */
//        System.out.print("Elements are (in Reverse Order): ");
//        for(int i=list.size()-1; i>=0; i--)
//            System.out.print(list.get(i) + " ");
//        System.out.println();
//        sc.close();
//    }
//}
/*
Kth largest odd number in a given range
We have two variables L and R, indicating a range of integers from L to R inclusive, and a
number K, the task is to find Kth largest odd number. If K > number of odd numbers in the range
L to R then return 0.
Sample Input 1: L = -3, R = 3, K = 1
Sample Output 1: 3 */
class KthLargestOdd {
    public static int getKthLargestOdd(int L, int R, int k) {
        int oddCount = 0;
        Stack<Integer> stack = new Stack<>();
        while(L <= R) {
            if(Math.abs(L) % 2 == 1) {
                oddCount++;
                stack.push(L);
            }
            L++;
        }
        System.out.println(stack);
        if(k > oddCount) return 0;
        else {
            int ans = 0;
            for(int i=1; i<=k; i++)
                ans = stack.pop();
            return ans;
        }
    }
    public static void main(String[] args) {
        int L = -10, R = 10, k = 8;
        System.out.println("Kth largest odd number is: " + getKthLargestOdd(L, R, k));
    }
}