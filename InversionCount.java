import java.util.Scanner;
class MergeSort_Modified {
    public int merge(int[] arr, int low, int mid, int high) {
        int size = high-low+1;
        int[] newArr = new int[size];
        int i=low, j=mid+1, idx=0;
        int inv_count = 0;
        while(i <= mid && j <= high) {
            if(arr[i] <= arr[j])
                newArr[idx++] = arr[i++];
            else {
                newArr[idx++] = arr[j++];
                inv_count += (mid-i+1);
            }
        }
        while(i <= mid) newArr[idx++] = arr[i++];
        while(j <= high) newArr[idx++] = arr[j++];
        for(i=0;i<size;i++) arr[i+low] = newArr[i];
        return inv_count;
    }
    public int mergeSort(int[] arr, int low, int high) {
        if(low < high) {
            int mid = low + (high-low)/2;
            int leftInversionCount = mergeSort(arr,low,mid);
            int rightInversionCount = mergeSort(arr,mid+1,high);
            int mergeInversionCount = merge(arr,low,mid,high);
            return (leftInversionCount + rightInversionCount + mergeInversionCount);
        }
        return 0;
    }
}
public class InversionCount {
    public static int brute_force_count(int[] arr) {
        int inv_count = 0;
        for(int i=0;i<arr.length;i++) {
            for(int j=i+1;j<arr.length;j++) {
                if(i<j && arr[i] > arr[j])
                    inv_count++;
            }
        }
        return inv_count;
    }
    public static int optimal_count(int[] arr) {
        int[] copy = arr.clone();
        /* Creating a copy of the original array so that changes are not reflected in the original file because this is not a sorting problem instead an inversion counting problem */
        MergeSort_Modified m = new MergeSort_Modified();
        return m.mergeSort(copy,0,copy.length-1);
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the size of the array: ");
        int n = sc.nextInt();
        int[] arr = new int[n];
        System.out.print("Enter " + n + " elements of the array: ");
        for(int i=0;i<n;i++)
            arr[i] = sc.nextInt();
        System.out.println("Inversions (Brute Force): " + brute_force_count(arr));
        System.out.println("Inversions (Optimal): " + optimal_count(arr));
        sc.close();
    }
}
