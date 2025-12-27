import java.util.HashSet;
public class UnionAndIntersection {
    private static HashSet<Integer> construct(int[] a) {
        HashSet<Integer> set = new HashSet<>();
        for (int val : a)
            set.add(val);
        return set;
    }
    public static HashSet<Integer> union(int[] arr1, int[] arr2) {
        HashSet<Integer> set1 = construct(arr1);
        HashSet<Integer> set2 = construct(arr2);
        set1.addAll(set2); /* duplicates gets ignored automatically */
        /* we can also do set2.addAll(set1) */
        return set1;
    }
    public static HashSet<Integer> intersection(int[] arr1, int[] arr2) {
        HashSet<Integer> set1 = construct(arr1);
        HashSet<Integer> set2 = construct(arr2);
        HashSet<Integer> res = new HashSet<>();
        /* We can add either set1 to set2 or set2 to set1 */
        for (int ele: set1) {
            if (set2.contains(ele))
                res.add(ele);
        }
        return res;
    }
    public static void main(String[] args) {
        int[] arr1 = {7, 3, 9};
        int[] arr2 = {6, 3, 9, 2, 9, 4};
        System.out.println("Union of arr1 and arr2: " + union(arr1, arr2) + "\nNumber of elements = " + union(arr1, arr2).size());
        System.out.println("\nIntersection of arr1 and arr2: " + intersection(arr1, arr2) + "\nNumber of elements = " + intersection(arr1, arr2).size());
    }
}
