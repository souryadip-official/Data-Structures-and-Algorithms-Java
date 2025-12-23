import java.util.Scanner;
import java.util.ArrayList;
public class ArrayList05 {
    public static boolean isMonotonic(ArrayList<Integer> list) {
        if(list.size() == 1) return true;
        int n = list.size();
        if(list.getFirst() < list.getLast()) {
            /* if true, list has a chance to be monotone increasing */
            for(int i=0; i<n-1; i++)
                if(list.get(i) > list.get(i+1)) return false;
        } else {
            /* list has a chance to be monotone decreasing */
            for(int i=0; i<n-1; i++)
                if(list.get(i) < list.get(i+1)) return false;
        }
        return true;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<Integer> list = new ArrayList<>();
        System.out.print("Enter size of list (n): ");
        int n = sc.nextInt();
        System.out.print("Enter the " + n + " elements: ");
        for(int i=1; i<=n; i++) list.add(sc.nextInt());
        System.out.println(isMonotonic(list)? "Yes, monotonic." : "No, not monotonic");

        sc.close();
    }
}
