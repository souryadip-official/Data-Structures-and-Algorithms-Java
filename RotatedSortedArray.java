import java.util.Scanner;
public class RotatedSortedArray {
    /**
     * Searches for a key in a rotated sorted array using recursive approach.
     * Assumes all elements are distinct.
     *
     * @param arr The rotated sorted array.
     * @param l The lower index of the array.
     * @param h The higher index of the array
     * @param key The element to search for.
     * @return Index of the key if found, otherwise -1.
     */
    public static int rec_search(int[] arr, int l, int h, int key) {
        if(l > h) return -1;
        int mid = l+(h-l)/2;
        if(arr[mid] == key) return mid;
        else if(arr[l] <= arr[mid]) { //checking the left sorted array
            if(arr[l] <= key && key < arr[mid]) //key if exists will be in the left sorted array
                return rec_search(arr,l,mid-1,key);
            return rec_search(arr,mid+1,h,key); //key if exists will be in the right sorted array
        } else { //checking the right sorted array
            if(arr[mid] < key && key <= arr[h]) //key if exists will be in the right sorted array
                return rec_search(arr,mid+1,h,key);
            return rec_search(arr,l,mid-1,key); //key if exists will be in the left sorted array
        }
    }
    /**
     * Searches for a key in a rotated sorted array using iterative binary search.
     * Assumes all elements are distinct.
     *
     * @param arr The rotated sorted array.
     * @param key The element to search for.
     * @return Index of the key if found, otherwise -1.
     */
    public static int itr_search(int[] arr, int key) {
        int l = 0, h = arr.length-1;
        while(l <= h) {
            int mid = l + (h-l)/2;
            if(arr[mid] == key) return mid;
            else if(arr[l] <= arr[mid]) {
                //checking the left sorted array
                if(arr[l] <= key && key < arr[mid]) h = mid-1;
                else l = mid+1;
            } else {
                //checking the right sorted array
                if(arr[mid] < key && key <= arr[h]) l = mid+1;
                else h = mid-1;
            }
        }
        return -1;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the size of the array: ");
        int n = sc.nextInt();
        int[] arr = new int[n];
        System.out.print("Enter " + n + " elements of the array: ");
        for(int i=0;i<n;i++)
            arr[i] = sc.nextInt();
        System.out.print("Enter the element you want to search: ");
        int key = sc.nextInt();
        int res = itr_search(arr, key);
        System.out.println(key + (res != -1? (" exists in the array at index " + res) : (" does not exist in the array.")));
        sc.close();
    }
}