import java.util.*;
public class CountingSort {
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
    public static int getMax(int[] arr) {
        int i, n = arr.length, max = Integer.MIN_VALUE;
        for(i=0;i<n;i++)
            max = Math.max(max, arr[i]);
        return max;
    }
    public static void countingSort(int[] arr) {
        int i, n = arr.length, max = getMax(arr), index = 0;
        int[] count = new int[max+1];
        for(i=0;i<n;i++)
            count[arr[i]]++;
        for(i=0;i<count.length;i++) {
            while(count[i] > 0) {
                arr[index++] = i;
                count[i]--;
            }
        }
    }
    public static void main(String[] args) {
        int[] arr = createArray();
        System.out.println("Given array is:");
        printArray(arr);
        countingSort(arr);
        System.out.println("Sorted array is: ");
        printArray(arr);
    }
}
/* store the range of each element
for(i=1;i<count.length;i++)
    count[i] += count[i-1];
int[] output = new int[n];
//we traverse from back to maintain the stability
for(i=n-1;i>=0;i--)
    output[--count[arr[i]]] = arr[i];
copy the output array to the original array
for(i=0;i<n;i++)
    arr[i] = output[i]; */