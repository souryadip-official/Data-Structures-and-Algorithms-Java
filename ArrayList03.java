import java.util.Scanner;
import java.util.ArrayList;
public class ArrayList03 {
    /* using functions */
    public static void swap(ArrayList<Integer> list, int i1, int i2) {
        int temp = list.get(i2);
        list.set(i2, list.get(i1));
        list.set(i1, temp);
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<Integer> list = new ArrayList<>();
        System.out.print("Enter size of list (n): ");
        int n = sc.nextInt();
        System.out.print("Enter the " + n + " elements: ");
        for(int i=1; i<=n; i++) list.add(sc.nextInt());
        System.out.print("Enter the two indices to swap: ");
        int idx1 = sc.nextInt(), idx2 = sc.nextInt();
        System.out.println("Before swap, List: " + list);
        /* Swapping the value at two indices */
        swap(list, idx1, idx2);
        System.out.println("After swap, List: " + list);
        sc.close();
    }
}