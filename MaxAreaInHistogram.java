import java.util.Scanner;
import java.util.Stack;
public class MaxAreaInHistogram {
    public static void display(int[] arr) {
        for(int ele : arr) System.out.print(ele + " ");
        System.out.println();
    }
    public static int maxArea_BruteForce(int[] heights) {
        int max = Integer.MIN_VALUE;
        for(int i=0; i<heights.length; i++) {
            int currHeight = heights[i];
            int leftArea = 0, rightArea = 0;
            for(int left=i; left>=0; left--) {
                if(heights[left] >= currHeight)
                    leftArea += currHeight;
                else break;
            }
            for(int right=i+1; right<heights.length; right++) {
                if(heights[right] >= currHeight)
                    rightArea += currHeight;
                else break;
            }
            if(leftArea + rightArea > max)
                max = leftArea + rightArea;
        }
        return max;
    }
    public static int maxArea_Optimised(int[] heights) {
        Stack<Integer> stack = new Stack<>();
        int[] leftSmaller = new int[heights.length];
        int[] rightSmaller = new int[heights.length];

        /* finding the next smaller at left */
        /* Definition of next smaller: First element in the left with respect to a particular element whose value is less than that element */
        for(int i=0; i<heights.length; i++) {
            while(!stack.isEmpty() && heights[stack.peek()] >= heights[i]) stack.pop();
            if(!stack.isEmpty()) leftSmaller[i] = stack.peek();
            else leftSmaller[i] = -1;
            stack.push(i);
        }

        /* emptying the stack */
        while(!stack.isEmpty()) stack.pop();

        /* finding the next smaller element at right */
        /* Definition of next smaller: First element in the right with respect to a particular element whose value is less than that element */
        for(int i=heights.length-1; i>=0; i--) {
            while(!stack.isEmpty() && heights[stack.peek()] >= heights[i]) stack.pop();
            if(!stack.isEmpty()) rightSmaller[i] = stack.peek();
            else rightSmaller[i] = heights.length;
            stack.push(i);
        }

        display(leftSmaller);
        display(rightSmaller);
        /* finding out the area of the maximum rectangle */
        int max = Integer.MIN_VALUE;
        for(int i=0; i<heights.length; i++) {
            int left = leftSmaller[i];
            int right = rightSmaller[i];
            int width = right - left - 1;
            int area = heights[i] * width;
            max = Math.max(max, area);
        }
        return max;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter number of bars: ");
        int n = sc.nextInt();
        int[] heights = new int[n];
        System.out.print("Enter " + n + " heights: ");
        for(int i=0; i<n; i++) heights[i] = sc.nextInt();
        System.out.println("Result: " + maxArea_Optimised(heights));
    }
}
