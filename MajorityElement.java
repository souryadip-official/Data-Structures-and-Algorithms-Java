import java.util.Scanner;
class OptimisedMajorityFind {
    public void display(int[] arr) {
        for(int i=0;i<arr.length;i++)
            System.out.print(arr[i] + " ");
        System.out.println();
    }
    public void merge(int[] arr, int low, int mid, int high) {
        int size = high-low+1;
        int[] newArr = new int[size];
        int i=low, j=mid+1, idx=0;
        while(i <= mid && j <= high) {
            if(arr[i] <= arr[j]) newArr[idx++] = arr[i++];
            else newArr[idx++] = arr[j++];
        }
        while(i <= mid) newArr[idx++] = arr[i++];
        while(j <= high) newArr[idx++] = arr[j++];
        for(i=0;i<size;i++) arr[i+low] = newArr[i];
    }
    public void mergeSort(int[] arr, int low, int high) {
        if(low < high) {
            int mid = low + (high-low)/2;
            mergeSort(arr,low,mid);
            mergeSort(arr,mid+1,high);
            merge(arr,low,mid,high);
        }
    }
    public int majority(int[] arr) {
        /* majority() assumes a sorted array and finds the majority element in it */
        if(arr.length == 1) return arr[0];
        int majority_criteria = arr.length/2;
        int prev = arr[0];
        int count = 1;
        for(int i=1;i<=arr.length-1;i++) {
            if(prev == arr[i]) {
                count++;
                if(i == arr.length-1 && count >= majority_criteria)
                    return prev;
            }
            else {
                if(count > majority_criteria)
                    return prev;
                prev = arr[i];
                count = 1;
            }
        }
        return -1;
    }
}
public class MajorityElement {
    public static int bruteForce_find(int[] arr) {
        int max = arr.length/2;
        int count = 0;
        for(int i = 0; i< arr.length; i++) {
            for(int j = i+1; j< arr.length; j++) {
                if(arr[i] == arr[j])
                    count++;
            }
            if(count >= max)
                return arr[i];
            count = 0;
        }
        return -1;
    }
    public static int optimised_find(int[] arr) {
        OptimisedMajorityFind o = new OptimisedMajorityFind();
        o.mergeSort(arr,0,arr.length-1);
        return o.majority(arr);
    }
    public static int moores_voting_algorithm(int[] arr) {
        int freq=0, ans=0;
        for(int i=0;i<arr.length;i++) {
            if(freq == 0) ans = arr[i];
            if(arr[i] == ans) freq++;
            else freq--;
        }
        return ans;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the size of the array: ");
        int n = sc.nextInt(), res;
        int[] arr = new int[n];
        System.out.print("Enter " + n + " elements of the array: ");
        for(int i=0;i<n;i++)
            arr[i] = sc.nextInt();
        //res = bruteForce_find(arr); -> Using Brute Force Approach O(n2)
        //res = optimised_find(arr); -> Using Optimised Approach O(nlogn) for Merge Sort and O(n) for searching, hence a total of O(nlogn + n) = O(nlogn)
        res = moores_voting_algorithm(arr); // Most optimised approach
        System.out.println(res < 0? "Majority element does not exist in the array!" : ("Majority element: " + res));
        sc.close();
    }
}
