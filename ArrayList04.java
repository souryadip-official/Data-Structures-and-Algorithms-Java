import java.util.Scanner;
import java.util.ArrayList;
public class ArrayList04 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<ArrayList<Integer>> mainList = new ArrayList<>();
        System.out.print("Number of internal list: ");
        int intLists = sc.nextInt();
        for(int i=1; i<=intLists; i++) {
            ArrayList<Integer> t = new ArrayList<>();
            mainList.add(t);
        }
        do {
            System.out.print("Enter an element: ");
            int ele = sc.nextInt();
            System.out.print("Enter index of the internal list in which you want to add this element (Indexing starts from 0): ");
            int idx = sc.nextInt();
            mainList.get(idx).add(ele);
            System.out.print("Would you like to enter more elements? (1 for Yes, -1 for No): ");
        } while(sc.nextInt() != -1);
        /* Printing the mainList */
        for(int i=0; i<mainList.size(); i++) {
            for(int j=0; j<mainList.get(i).size(); j++) {
                System.out.print(mainList.get(i).get(j) + " ");
            }
            System.out.println();
        }
        /* or we may also do like this */
        for(int i=0; i<mainList.size(); i++) {
            ArrayList<Integer> curr = mainList.get(i);
            for(int j=0; j<curr.size(); j++)
                System.out.print(curr.get(j) + " ");
            System.out.println();
        }
    }
}
