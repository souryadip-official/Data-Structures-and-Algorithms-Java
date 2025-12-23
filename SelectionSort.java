import java.util.*;
public class SelectionSort {
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
    public static void selectionSort(int[] arr) {
        int i, j, n = arr.length, minloc;
        for(i=0;i<n-1;i++) {
            minloc = i;
            for(j=i+1;j<n;j++) {
                if(arr[j] < arr[minloc])
                    minloc = j;
            }
            if(minloc != i) {
                int temp = arr[i];
                arr[i] = arr[minloc];
                arr[minloc] = temp;
            }
        }
    }
    public static void main(String[] args) {
        int[] arr = createArray();
        System.out.println("Given array is:");
        printArray(arr);
        selectionSort(arr);
        System.out.println("Sorted array is: ");
        printArray(arr);
    }
}
