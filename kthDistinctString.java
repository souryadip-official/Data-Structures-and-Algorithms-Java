import java.util.LinkedHashSet;
public class kthDistinctString {
    public String kthDistinct(String[] arr, int k) {
        LinkedHashSet<String> distinct = new LinkedHashSet<>();
        LinkedHashSet<String> nondistinct = new LinkedHashSet<>();
        for(String str: arr) {
            if (distinct.contains(str)) {
                distinct.remove(str);
                nondistinct.add(str);
            } else if (!nondistinct.contains(str)) {
                distinct.add(str);
            }
        }
        int count = 1;
        for (String val: distinct) {
            if (count == k) return val;
            count++;
        }
        return "";
    }
}