import java.util.*;
public class BinarySearch {
    public static int binarySearch(int arr[], int ele) {
        int low = 0, high = arr.length-1, mid;
        while(low <= high) {
            mid = (low+high)/2;
            if(arr[mid] ==  ele) {
                return mid;
            } else if(arr[mid] < ele) {
                low = mid+1;
            } else {
                high = mid-1;
            }
        }
        return -1;
    }
    public static void sortArray(int arr[]) {
        int i, j, temp;
        for(i=0;i<arr.length-1;i++) {
            for(j=0;j<arr.length-i-1;j++) {
                if(arr[j] > arr[j+1]) {
                    temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                }
            }
        }
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
        for (i = 0; i < n; i++) {
            System.out.print("Enter element " + (i + 1) + ": ");
            arr[i] = sc.nextInt();
        }
        System.out.println("Given array: ");
        printArray(arr);

        sortArray(arr);
        System.out.println("Sorted array: ");
        printArray(arr);

        System.out.print("Enter the element you want to search: ");
        ele = sc.nextInt();

        int searchStatus = binarySearch(arr, ele);
        if (searchStatus == -1) {
            System.out.println("Element is not found in the array.");
        } else {
            System.out.println("Element found at index " + searchStatus);
        }
    }
}
