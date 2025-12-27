import java.util.HashSet;
import java.util.Iterator;
public class HashSet01 {
    public static void main(String[] args) {
        HashSet<Integer> set = new HashSet<>();
        System.out.println(set.add(5)); /* add operation in a set */
        System.out.println(set.add(6));
        System.out.println(set.add(6)); /* set will ignore duplicates */
        System.out.println(set);
        System.out.println(set.contains(5));
        System.out.println(set.contains(9));
        System.out.println(set.remove(6));
        System.out.println(set);

        System.out.println(set.add(20));
        System.out.println(set.add(30));
        System.out.println(set.add(50));
        /* Iteration on a hashset */
        /* Method 1 */
        Iterator<Integer> itr = set.iterator();
        while (itr.hasNext())
            System.out.print(itr.next() + " ");
        System.out.println();
        /* Method 2 */
        for(int val : set)
            System.out.print(val + " ");
    }
}
