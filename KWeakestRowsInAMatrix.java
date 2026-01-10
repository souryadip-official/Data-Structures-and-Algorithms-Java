import java.util.PriorityQueue;

public class KWeakestRowsInAMatrix {
    public static class Info implements Comparable<Info> {
        int idx;
        int soldiers;
        public Info(int idx, int soldiers) {
            this.idx = idx;
            this.soldiers = soldiers;
        }
        @Override
        public int compareTo(Info i) {
            if (this.soldiers == i.soldiers)
                return this.idx - i.idx;
            else
                return this.soldiers - i.soldiers;
        }
    }
    public int[] kWeakestRows(int[][] mat, int k) {
        PriorityQueue<Info> pq = new PriorityQueue<>();
        for (int i=0; i<mat.length; i++) {
            int nos = 0;
            for (int j=0; j<mat[i].length; j++) {
                if (mat[i][j] == 0) break;
                else nos++;
            }
            pq.add(new Info(i, nos));
        }
        int[] res = new int[k];
        for (int i=1; i<=k; i++)
            res[i-1] = pq.poll().idx;
        return res;
    }
}