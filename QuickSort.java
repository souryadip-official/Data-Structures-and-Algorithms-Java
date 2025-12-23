import java.util.Scanner;
import java.util.Random;
class Quick_Sort {
    public void display(int[] arr) {
        for(int i=0;i<arr.length;i++)
            System.out.print(arr[i] + " ");
        System.out.println();
    }
    public void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
    public int partition(int[] arr, int low, int high) {
        int pivot = arr[high], i=low-1, j=low;
        for(;j<=high-1;j++) {
            if(arr[j] <= pivot) {
                i++;
                swap(arr,i,j);
            }
        }
        i++;
        arr[high] = arr[i];
        arr[i] = pivot;
        return i;
    }
    public void quickSort(int[] arr, int low, int high) {
        if(low < high) {
            int loc = partition(arr,low,high);
            quickSort(arr,low,loc-1);
            quickSort(arr,loc+1,high);
        }
    }
}
public class QuickSort {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the size of the array: ");
        int n = sc.nextInt();
        int[] arr = new int[n];
        System.out.print("Enter " + n + " elements of the array: ");
        for(int i=0;i<n;i++)
            arr[i] = sc.nextInt();
        Quick_Sort q = new Quick_Sort();
        q.quickSort(arr, 0, arr.length-1);
        System.out.print("Sorted Array: ");
        q.display(arr);
        sc.close();
    }
}
