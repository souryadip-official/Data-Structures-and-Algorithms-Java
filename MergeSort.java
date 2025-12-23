import java.util.Scanner;
class Merge {
    public void merge(int[] arr, int low, int mid, int high) {
        int size = high-low+1;
        int[] newArr = new int[size];
        int i = low, j = mid+1, idx = 0;
        while(i <= mid && j <= high) {
            if(arr[i] <= arr[j]) newArr[idx++] = arr[j++];
            else newArr[idx++] = arr[i++];
        }
        while(i <= mid) newArr[idx++] = arr[i++];
        while(j <= high) newArr[idx++] = arr[j++];
        for(i=low,idx=0;idx<size;i++,idx++)
            arr[i] = newArr[idx];
    }
    public void display(int[] arr) {
        for(int i=0;i<arr.length;i++)
            System.out.print(arr[i] + " ");
        System.out.println();
    }
    public void mergeSort(int[] arr, int low, int high) {
        if(low < high) {
            int mid = low + (high - low)/2;
            mergeSort(arr,low, mid);
            mergeSort(arr, mid +1,high);
            merge(arr,low, mid,high);
        }
    }
}
public class MergeSort {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the size of the array: ");
        int n = sc.nextInt();
        int[] arr = new int[n];
        System.out.print("Enter " + n + " elements of the array: ");
        for(int i=0;i<n;i++)
            arr[i] = sc.nextInt();
        Merge m = new Merge();
        m.mergeSort(arr, 0, arr.length-1);
        System.out.print("Sorted Array: ");
        m.display(arr);
    }
}
