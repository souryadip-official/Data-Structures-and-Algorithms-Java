import java.util.HashSet;
public class HashSet01 {
    public static void main(String[] args) {
        HashSet<Integer> set = new HashSet<>();
        System.out.println(set.add(5)); // add operation in a set
        System.out.println(set.add(6));
        System.out.println(set.add(6)); // set will ignore duplicates
        System.out.println(set);
        System.out.println(set.contains(5));
        System.out.println(set.contains(9));
        System.out.println(set.remove(6));
        System.out.println(set);
    }
}
