import java.util.*;
public class LargestArrayElement {
    public static void largestAndSmallest(int arr[]) {
        int i, max = arr[0], min = arr[0];
        for(i=0;i<arr.length;i++) {
            if(arr[i] > max) {
                max = arr[i];
            }
        }
        for(i=0;i<arr.length;i++) {
            if(arr[i] < min) {
                min = arr[i];
            }
        }
        System.out.println("Largest element: " + max);
        System.out.println("Smallest element: " + min);
    }
    public static void printArray(int arr[]) {
        int i;
        System.out.print("[ ");
        for(i=0;i<arr.length;i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println("]");
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n, i, max = 0;
        System.out.print("Enter the size of the array: ");
        n = sc.nextInt();
        int arr[] = new int[n];
        for(i=0;i<n;i++) {
            System.out.print("Enter element "+(i+1)+": ");
            arr[i] = sc.nextInt();
        }
        System.out.println("Given array: ");
        printArray(arr);
        largestAndSmallest(arr);
    }
}
