import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class InbuiltSort {
    public static void printArray(Integer[] arr) {
        int i;
        for(i=0;i<arr.length;i++)
            System.out.print(arr[i]+" ");
        System.out.println();
    }
    public static void getInput(Integer[] arr) {
        Scanner sc = new Scanner(System.in);
        int i, n = arr.length;
        System.out.print("Enter " + n + " elements: ");
        for(i=0;i<n;i++)
            arr[i] = sc.nextInt();
    }
    public static Integer[] createArray() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter size: ");
        int n = sc.nextInt();
        Integer[] arr = new Integer[n];
        getInput(arr);
        return arr;
    }
    public static void main(String[] args) {
        Integer[] arr = createArray();
        /* arr is an array object of type 'Integer' */
        System.out.println("Given array is:");
        printArray(arr);
        Arrays.sort(arr, Collections.reverseOrder());
        System.out.println("Sorted array is: ");
        printArray(arr);

        arr = createArray();
        System.out.println("Given array is:");
        printArray(arr);
        Arrays.sort(arr, 0, 3, Collections.reverseOrder());
        System.out.println("Sorted array is: ");
        printArray(arr);
    }
}
