import java.util.Scanner;
public class CheckArraySorted {
    public boolean checkIsSorted_rec(int[] arr, int count) {
        if(count == arr.length-2) {
            if(arr[count] <= arr[count+1])
                return true;
            return false;
        } else {
            if(arr[count] <= arr[count+1])
                return checkIsSorted_rec(arr, count+1);
            return false;
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the size of the array: ");
        int size = sc.nextInt();
        if(size <= 0) {
            System.out.println("Invalid size!");
            return;
        } else if(size == 1) {
            System.out.println("Whatever be the array, it will be sorted.");
            return;
        }
        int[] arr = new int[size];
        System.out.print("Enter " + size + " elements of the array: ");
        for(int i=0;i<size;i++)
            arr[i] = sc.nextInt();
        CheckArraySorted c = new CheckArraySorted();
        System.out.println("Given array is " + (c.checkIsSorted_rec(arr,0)? "sorted." : "not sorted."));
        sc.close();
    }
}