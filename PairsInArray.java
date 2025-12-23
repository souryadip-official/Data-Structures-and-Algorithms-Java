import java.util.*;
public class PairsInArray {
    public static void generatePairs(int arr[]) {
        int i, j, idx = 1;
        System.out.println("Generated pairs: ");
        for(i=0;i<arr.length;i++) {
            for(j=i+1;j<arr.length;j++) {
                System.out.println((idx++) + ". ("+arr[i]+", "+arr[j]+")");
            }
        }
        if(idx == 1) {
            System.out.println("No pairs can be formed.");
        }
        /* this function works for an array of distinct elements */
    }
    public static int[] removeDuplicates(int arr[]) {
        int i, j, uniques = 0, n=arr.length;
        boolean isDuplicateFound = false;
        for(i=0;i<n;i++) {
            for(j=i+1;j<n;j++) {
                if(arr[i] == arr[j]) {
                    isDuplicateFound = true;
                    break; /* prevents extra computation when a repeated element is already found */
                }
            }
            /* by the end of this loop, we will know if the arr[i] element is unique or not */
            if(!isDuplicateFound) {
                uniques++;
            }
            isDuplicateFound = false;
        }
        /* for repeated elements, say we have an array of size 5 containing 1 1 1 1 1,
        then for the first four 1s, no uniques will be calculated, but for the last 1,
        as there are no other 1s, hence that will be counted as unique */
        if(uniques == n) {
            return arr;
        }
        int newArr[] = new int[uniques], idx=0;
        isDuplicateFound = false;
        for(i=0;i<n;i++) {
            for(j=i+1;j<n;j++) {
                if(arr[i] == arr[j]) {
                    isDuplicateFound = true;
                    break;
                }
            }
            if(!isDuplicateFound) {
                newArr[idx++] = arr[i];
            }
            isDuplicateFound = false;
        }
        return newArr;
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
        if(n == 1) {
            System.out.println("Array should have at least 2 elements for pairing.");
            System.exit(0);
            /* System.exit(0) is a command/method which terminates the current program and stops its execution with a status 0 meaning a successful termination. */
        }
        int arr[] = new int[n];
        for (i=0;i<n;i++) {
            System.out.print("Enter element " + (i + 1) + ": ");
            arr[i] = sc.nextInt();
        }
        System.out.println("Given array:");
        printArray(arr);

        int newArr[] = removeDuplicates(arr);
        System.out.println("Array without duplicates: ");
        printArray(newArr);

        generatePairs(newArr);
    }
}
