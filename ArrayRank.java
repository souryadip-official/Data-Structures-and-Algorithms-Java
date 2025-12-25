import java.util.ArrayList;
import java.util.Collections;
public class ArrayRank {
    public static class Distance implements Comparable<Distance> {
        int val;
        int rank;
        int initIdx;
        Distance(int d, int r, int i) {
            this.val = d;
            this.rank = r;
            this.initIdx = i;
        }
        @Override
        public int compareTo(Distance d2) {
            return this.val - d2.val; /* sorts the values in increasing order */
        }
    }
    public static int[] arrayRankTransform(int[] arr) {
        if (arr.length == 0) return new int[0];
        ArrayList<Distance> dist = new ArrayList<>();
        for (int i=0; i<arr.length; i++)
            dist.add(new Distance(arr[i], Integer.MIN_VALUE, i));

        Collections.sort(dist);
        int rank = 1;
        Distance prev = null;
        for (int i=0; i<dist.size(); i++) {
            Distance currObj = dist.get(i);
            if (prev == null) {
                currObj.rank = rank;
                prev = currObj;
            } else if (currObj.val == prev.val) {
                currObj.rank = prev.rank;
            } else {
                currObj.rank = ++rank;
                prev = currObj;
            }
        }
        int[] res = new int[arr.length];
        for (Distance d : dist) {
            int currIdx = d.initIdx;
            res[currIdx] = d.rank;
        }
        return res;
    }
    public static void main(String[] args) {
        int[] arr = {37,12,28,9,100,56,80,5,12};
        for (int rank: arrayRankTransform(arr))
            System.out.print(rank + " ");
    }
}