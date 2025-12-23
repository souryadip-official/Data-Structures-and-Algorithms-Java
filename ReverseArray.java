import java.util.*;
public class ReverseArray {
    public static void reverseArray(int arr[]) {
        int start=0, end=arr.length-1, temp;
        while(start < end) {
            temp = arr[start];
            arr[start] = arr[end];
            arr[end] = temp;
            start++;
            end--;
        }
    }

    public static void printArray(int arr[]) {
        int i;
        System.out.print("[ ");
        for(i=0;i<arr.length;i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println("]");
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n, i;
        System.out.print("Enter the size of the array: ");
        n = sc.nextInt();
        int arr[] = new int[n];
        for (i=0;i<n;i++) {
            System.out.print("Enter element " + (i + 1) + ": ");
            arr[i] = sc.nextInt();
        }
        System.out.println("Given array:");
        printArray(arr);
        reverseArray(arr);
        System.out.println("Reversed array:");
        printArray(arr);
    }
}
/*
int i, limit = (arr.length/2)-1, temp;
for(i=0;i<=limit;i++) {
     temp = arr[i];
     arr[i] = arr[arr.length-i-1];
     arr[arr.length-i-1] = temp;
}   */
