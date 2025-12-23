import java.util.Scanner;
class LeetCode74 {
    public static boolean search_1d(int[] arr, int key) {
        int low=0, high=arr.length;
        while(low <= high) {
            int mid = low + (high-low)/2;
            if(arr[mid] == key) return true;
            else if(key < arr[mid]) high=mid-1;
            else low=mid+1;
        }
        return false;
    }
    public static boolean search(int[][] arr, int low, int high, int key) {
        while(low <= high) {
            int mid = low + (high-low)/2;
            int cols = arr[0].length;
            if(arr[mid][0] <= key && key <= arr[mid][cols-1])
                return search_1d(arr[mid],key);
            else if(key < arr[mid][0]) high = mid-1;
            else low = mid+1;
        }
        return false;
    }
    public static boolean searchMatrix(int[][] matrix, int target) {
        return search(matrix, 0, matrix.length-1, target);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the rows and cols of the array: ");
        int r = sc.nextInt(), c = sc.nextInt();
        int[][] matrix = new int[r][c];
        System.out.println("Enter " + (r*c) + " elements of the array row-wise:");
        for(int i=0;i<r;i++) for(int j=0;j<c;j++) matrix[i][j] = sc.nextInt();
        System.out.print("Enter the element to find: ");
        int target = sc.nextInt();
        System.out.println(searchMatrix(matrix,target)? "Element present in the array." : "Element not present in the array.");
        sc.close();
    }
}
