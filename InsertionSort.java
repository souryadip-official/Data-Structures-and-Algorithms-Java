import java.util.*;
public class InsertionSort {
    public static void printArray(int[] arr) {
        int i;
        for(i=0;i<arr.length;i++)
            System.out.print(arr[i]+" ");
        System.out.println();
    }
    public static void getInput(int[] arr) {
        Scanner sc = new Scanner(System.in);
        int i, n = arr.length;
        System.out.print("Enter " + n + " elements: ");
        for(i=0;i<n;i++)
            arr[i] = sc.nextInt();
    }
    public static int[] createArray() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter size: ");
        int n = sc.nextInt();
        int[] arr = new int[n];
        getInput(arr);
        return arr;
    }
    public static void insertionSort(int[] arr) {
        int i, j, n = arr.length, curr_element;
        for(i=1;i<n;i++) {
            curr_element = arr[i];
            j = i-1;
            while(j>=0 && arr[j] > curr_element) {
                arr[j+1] = arr[j];
                j--;
            }
            arr[j+1] = curr_element;
        }
    }
    public static void main(String[] args) {
        int[] arr = createArray();
        System.out.println("Given array is:");
        printArray(arr);
        insertionSort(arr);
        System.out.println("Sorted array is: ");
        printArray(arr);
    }
}
