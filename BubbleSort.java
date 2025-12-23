import java.util.*;
public class BubbleSort {
    public static void bubbleSort(int[] arr) {
        int n = arr.length;
        boolean isSwapped;
        for(int i=0;i<n-1;i++) {
            isSwapped = false;
            for(int j=0;j<n-i-1;j++) {
                if(arr[j] > arr[j+1]) {
                    int temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                    isSwapped = true;
                }
            }
            if(!isSwapped)  return;
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the size of the array: ");
        int n = sc.nextInt();
        int[] arr = new int[n];
        System.out.print("Enter " + n + " elements: ");
        for(int i=0;i<n;i++)
            arr[i] = sc.nextInt();
        bubbleSort(arr);
        System.out.println("Sorted array is: ");
        for(int i=0;i<n;i++)
            System.out.print(arr[i]+" ");
    }
}
