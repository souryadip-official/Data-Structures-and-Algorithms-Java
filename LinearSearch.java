import java.util.*;
public class LinearSearch {
    public static int linearSearch(int arr[], int ele) {
        int i;
        for(i=0;i<arr.length;i++) {
            if(arr[i] == ele) {
                return i;
            }
        }
        return -1;
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
        int n, i, ele;
        System.out.print("Enter the size of the array: ");
        n = sc.nextInt();
        int arr[] = new int[n];
        for(i=0;i<n;i++) {
            System.out.print("Enter element "+(i+1)+": ");
            arr[i] = sc.nextInt();
        }
        System.out.println("Given array: ");
        printArray(arr);

        System.out.print("Enter the element you want to search: ");
        ele = sc.nextInt();

        int searchStatus = linearSearch(arr, ele);
        if(searchStatus == -1) {
            System.out.println("Element is not found in the array.");
        } else {
            System.out.println("Element found at index "+searchStatus);
        }
    }
}
