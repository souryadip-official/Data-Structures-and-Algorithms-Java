import java.util.Scanner;
public class MergeSort_OnStringArray {
    public static void display(String[] arr) {
        for(int i=0;i<arr.length;i++)
            System.out.print(arr[i] + " ");
        System.out.println();
    }
    public static void mergeString_array(String[] arr, int low, int mid, int high) {
        int size = high-low+1;
        String[] t = new String[size];
        int i=low, j=mid+1, idx=0;
        while(i <= mid && j <= high) {
            if(arr[i].compareTo(arr[j]) < 0) t[idx++] = arr[i++];
            /* compareTo compares two strings lexicographically (ASCII comparison)
               Suppose we have car and cat, c and c will match, a and a will match but
               ascii value of t > ascii value of r, hence cat > car and the value returned
               by the function will be ascii(r) - ascii(t) < 0, meaning car < cat */
            else t[idx++] = arr[j++];
        }
        while(i <= mid) t[idx++] = arr[i++];
        while(j <= high) t[idx++] = arr[j++];
        for(i=0;i<size;i++) arr[i+low] = t[i];
    }
    public static void mergeSort_String(String[] arr, int low, int high) {
        if(low < high) {
            int mid = low + (high-low)/2;
            mergeSort_String(arr,low,mid);
            mergeSort_String(arr,mid+1,high);
            mergeString_array(arr,low,mid,high);
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the size of the array: ");
        int n = sc.nextInt();
        String[] arr = new String[n];
        for(int i=0;i<n;i++) {
            System.out.print("Enter element " + (i+1) + ": ");
            arr[i] = sc.next().toLowerCase();
        }
        mergeSort_String(arr, 0, arr.length-1);
        System.out.print("After sorting: "); display(arr);
        sc.close();
    }
}
