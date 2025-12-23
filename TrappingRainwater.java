import java.util.*;
public class TrappingRainwater {
    public static void printArray(int arr[]) {
        int i;
        System.out.print("[ ");
        for(i=0;i<arr.length;i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println("]");
    }
    public static int getMaxLeftBar(int[] arr, int idx, int init) {
        int i, maxLeft = 0;
        for(i=idx-1;i>=0;i--) {
            maxLeft = Math.max(arr[i], maxLeft);
        }
        return (maxLeft < init? -1: maxLeft);
    }
    public static int getMaxRightBar(int[] arr, int idx, int init) {
        int i, maxRight = 0;
        for(i=idx+1;i<arr.length;i++) {
            maxRight = Math.max(arr[i], maxRight);
        }
        return (maxRight < init? -1 : maxRight);
    }
    public static void calculateTrappedRainwater(int[] arr, int width) {
        int i, n = arr.length, leftMax[] = new int[n], rightMax[] = new int[n], waterLevel = 0, trappedWater = 0;
        /* calculating the leftMax array */
        leftMax[0] = arr[0];
        for(i=1;i<n;i++) {
            leftMax[i] = Math.max(leftMax[i-1], arr[i]);
            /* from arr[i] perspective, it can be interpreted as:
               "For my leftMax, am I bigger or my previous bar's leftMax is bigger" */
        }
        /* calculating the rightMax array */
        rightMax[n-1] = arr[n-1];
        for(i=n-2;i>=0;i--) {
            rightMax[i] = Math.max(rightMax[i+1], arr[i]);
            /* from arr[i] perspective, it can be interpreted as:
               "For my rightMax, am I bigger or my next bar's rightMax is bigger" */
        }
        /* calculating the trapped water */
        for(i=0;i<n;i++) {
            waterLevel = Math.min(leftMax[i], rightMax[i]);
            trappedWater += Math.abs(arr[i] - waterLevel) * width;
        }
        System.out.println("Trapped rainwater = " + trappedWater + " units.");
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int bars, width, i;
        System.out.print("Enter number of bars: ");
        bars = sc.nextInt();
        if(bars <= 0) {
            System.out.println("Invalid size.");
            System.exit(0);
        }
        int[] arr = new int[bars];
        for (i=0;i<bars;i++) {
            System.out.print("Enter height of bar " + (i+1) + ": ");
            arr[i] = sc.nextInt();
            if(arr[i] < 0) {
                System.out.println("Value cannot be negative.");
                System.exit(0);
            }
        }
        System.out.print("Enter the width: ");
        width = sc.nextInt();
        if(width <= 0) {
            System.out.println("Width cannot be negative.");
            System.exit(0);
        }
        System.out.println("Given bars:");
        printArray(arr);
        calculateTrappedRainwater(arr, width);
    }
}