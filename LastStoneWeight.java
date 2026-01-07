import java.util.Collections;
import java.util.PriorityQueue;
public class LastStoneWeight {
    public int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder()); /* max heap */
        for(int wt: stones) pq.add(wt);

        while(pq.size() > 0) {
            if (pq.size() == 1) break;
            int s1 = pq.poll();
            int s2 = pq.poll();
            if (s2 < s1)
                pq.add(s1-s2);
        }
        if (pq.size() == 0) return 0; /* no stones are left, we return 0 */
        else return pq.poll(); /* otherwise, we return the last stone weight */
    }
}