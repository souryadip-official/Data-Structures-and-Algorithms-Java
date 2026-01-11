import java.util.PriorityQueue;
public class ConnectNRopes {
    public static int findMinCostToConnectRopes(int[] ropes) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        /* Initially all ropes are added */
        for (int rope: ropes)
            pq.add(rope);
        if (pq.size() == 1) return pq.poll(); /* For given only one rope */
        int cost = 0;
        while (pq.size() > 1) {
            int firstRope = pq.poll();
            int secondRope = pq.poll();
            int newRope = firstRope + secondRope;
            cost += newRope;
            pq.add(newRope);
        }
        return cost;
    }
    public static void main(String[] args) {
        int[] ropes = {4, 3, 2, 6};
        System.out.println(findMinCostToConnectRopes(ropes));
    }
}
