import java.util.Scanner;
import java.util.ArrayList;
public class ArrayList02 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<Integer> list = new ArrayList<>();
        System.out.print("Enter size of list (n): ");
        int n = sc.nextInt(), max = Integer.MIN_VALUE;
        System.out.print("Enter the " + n + " elements: ");
        for(int i=1; i<=n; i++) list.add(sc.nextInt());
        /* Finding the maximum in this list */
        for(Integer i : list) max = Math.max(max, i);
        System.out.println("List: " + list);
        System.out.println("Maximum element: " + max);
        sc.close();
    }
}
