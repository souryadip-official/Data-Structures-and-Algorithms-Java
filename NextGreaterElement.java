import java.util.Scanner;
import java.util.Stack;
public class NextGreaterElement {
    public static void display(int[] arr) {
        for(int i=0; i<arr.length; i++)
            System.out.print(arr[i] + " ");
        System.out.println();
    }
    public static int[] nextGreater_BruteForce(int[] arr) {
        int[] nextGreater = new int[arr.length];
        for(int i=0; i<arr.length; i++) {
            int currNum = arr[i];
            for(int j=i+1; j<=arr.length; j++) {
                if(j == arr.length) nextGreater[i] = -1;
                else {
                    if(arr[j] > currNum) {
                        nextGreater[i] = arr[j];
                        break;
                    }
                }
            }
        }
        return nextGreater;
    }
    public static int[] nextGreater_Optimised(int[] arr) {
        Stack<Integer> stack = new Stack<>();
        int[] nextGreater = new int[arr.length];
        for(int i=arr.length-1; i>=0; i--) {
            /* checking from the right hand side because next greater element is the one greater than a particular element and present right to it */
            while(!stack.isEmpty() && stack.peek() <= arr[i]) stack.pop();
            if(stack.isEmpty()) nextGreater[i] = -1;
            else nextGreater[i] = stack.peek();
            stack.push(arr[i]);
        }
        return nextGreater;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter number of elements: ");
        int n = sc.nextInt();
        int[] arr = new int[n];
        int[] nextGreater = new int[n];
        System.out.print("Enter the " + n + " numbers: ");
        for(int i=0; i<n; i++) arr[i] = sc.nextInt();
        // nextGreater = nextGreater_BruteForce(arr);
        nextGreater = nextGreater_Optimised(arr);
        display(nextGreater);

        sc.close();
    }
}
