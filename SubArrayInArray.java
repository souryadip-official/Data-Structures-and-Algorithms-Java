import java.util.*;
public class SubArrayInArray {
    public static void printArray(int arr[]) {
        int i;
        System.out.print("[ ");
        for(i=0;i<arr.length;i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println("]");
    }
//    public static int[] getPrefixArray(int[] arr) {
//        int prefix[] = new int[arr.length], i, j, sum=0, idx=0;
//        for(i=0;i<arr.length;i++) {
//            if(idx == 0) {
//                prefix[idx] = arr[i];
//            } else {
//                prefix[idx] = prefix[idx-1] + arr[i];
//            }
//            idx++;
//        }
//        return prefix;
//    }
//     public static void generateSubArrays(int arr[]) {
//        int i, j, k, n=arr.length, sum=0, prefix[] = getPrefixArray(arr), max = Integer.MIN_VALUE, min = Integer.MAX_VALUE;
//        System.out.println("Prefix array:");
//        printArray(prefix);
//        for(i=0;i<n;i++) {
//            for(j=i;j<n;j++) {
//                sum = i==0? prefix[j] : prefix[j] - prefix[i-1];
//                max = Math.max(max, sum);
//                min = Math.min(min, sum);
//                sum = 0;
//            }
//        }
//        System.out.println("Maximum sub-array sum = " + max);
//        System.out.println("Minimum sub-array sum = " + min);
//    }
    public static void KadanesAlgo(int[] arr) {
        int i, currSum = 0, maxSum = Integer.MIN_VALUE, largest = Integer.MIN_VALUE;
        for(i=0;i<arr.length;i++) {
            currSum += arr[i];
            largest = Math.max(largest, arr[i]);
            /* largest is calculated in case the array contains all negative numbers */
            if(currSum < 0)
                currSum = 0;
            maxSum = Math.max(maxSum, currSum);
        }
        System.out.println("Maximum sub-array sum = " + ((maxSum > 0)? maxSum : largest));
    }
    public static int[] removeDuplicates(int arr[]) {
        int i, j, uniques = 0, n=arr.length;
        boolean isDuplicateFound = false;
        for(i=0;i<n;i++) {
            for(j=i+1;j<n;j++) {
                if(arr[i] == arr[j]) {
                    isDuplicateFound = true;
                    break;
                }
            }
            if(!isDuplicateFound)
                uniques++;
            isDuplicateFound = false;
        }
        if(uniques == n)
            return arr;
        int newArr[] = new int[uniques], idx=0;
        isDuplicateFound = false;
        for(i=0;i<n;i++) {
            for(j=i+1;j<n;j++) {
                if(arr[i] == arr[j]) {
                    isDuplicateFound = true;
                    break;
                }
            }
            if(!isDuplicateFound)
                newArr[idx++] = arr[i];
            isDuplicateFound = false;
        }
        return newArr;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n, i;
        System.out.print("Enter the size of the array: ");
        n = sc.nextInt();
        if(n <= 0) {
            System.out.println("Invalid size.");
            System.exit(0);
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
        System.out.println();
        KadanesAlgo(newArr);
    }
}
//public static int getArraySum(int arr[]) {
//    int i, sum=0;
//    for(i=0;i<arr.length;i++) {
//        sum += arr[i];
//    }
//    return sum;
//}
//public static int generateArrayAndPrint(int arr[], int size, int begin, int count) {
//    int newArr[] = new int[size], i=begin, idx, sum;
//    for(idx=0;idx<size;idx++) {
//        newArr[idx] = arr[i++];
//    }
//    System.out.print(count+". ");
//    printArray(newArr);
//    sum = getArraySum(newArr);
//    return sum;
//}
//public static void generateSubArrays(int arr[]) {
//    int i, n=arr.length, limit, start, count=1, sum, max = Integer.MIN_VALUE, min = Integer.MAX_VALUE;
//    System.out.println("The sub-arrays are: ");
//    for(i=0;i<n;i++) {
//        limit = n-i;
//        for(start=1;start<=limit;start++) {
//            sum = generateArrayAndPrint(arr, start, i, count++);
//            max = Math.max(sum, max);
//            min = Math.min(sum, min);
//        }
//    }
//    System.out.println("Maximum sub-array sum = " + max);
//    System.out.println("Minimum sub-array sum = " + min);
//}
