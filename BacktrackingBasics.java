import java.util.Scanner;
public class BacktrackingBasics {
    public static void backtrack(int[] arr, int i) {
        if(i == arr.length) {
            for (int j : arr) System.out.print(j + " ");
            System.out.println();
            return;
        }
        arr[i] = i+1;
        backtrack(arr, i+1);
        arr[i] -= 2;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the size of the array: ");
        int[] arr = new int[sc.nextInt()];
        backtrack(arr, 0);
        for (int j : arr) System.out.print(j + " ");
        System.out.println();
        sc.close();
    }
}
