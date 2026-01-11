import java.util.ArrayList;
import java.util.PriorityQueue;
public class KNearbyCars {
    public static class Distance implements Comparable<Distance> {
        int index;
        double distance;
        public Distance(int index, double distance) {
            this.index = index;
            this.distance = distance;
        }
        @Override
        public int compareTo(Distance other) {
            return Double.compare(this.distance, other.distance);
            /* Compares the distance of the current object with the other object and returns a negative value if this.distance is smaller, zero if both distances are equal, or a positive value if this.distance is larger, which allows the PriorityQueue to order objects based on increasing distance */
        }
    }
    public static double findDistanceFromOrigin(int x, int y) {
        double distance = Math.sqrt(Math.pow(x, 2) + Math.pow(y, 2));
        return distance;
    }
    public static ArrayList<Distance> findKNearbyCars(int[][] coordinates, int k) {
        PriorityQueue<Distance> pq = new PriorityQueue<>(); /* Min-Heap */
        for (int i=0; i<coordinates.length; i++) {
            int[] coordinate = coordinates[i];
            double currDist = findDistanceFromOrigin(coordinate[0], coordinate[1]);
            pq.add(new Distance(i, currDist));
        }
        /* Now we will pop 'K' nearest cars */
        ArrayList<Distance> res = new ArrayList<>();
        if (pq.size() < k) return null;
        for (int i=1; i<=k; i++) {
            Distance curr = pq.poll();
            res.add(new Distance(curr.index, curr.distance));
        }
        return res;
    }
    public static void main(String[] args) {
        int[][] coordinates = {{3,3}, {5,-1}, {-2,4}};
        ArrayList<Distance> res = findKNearbyCars(coordinates, 2);
        for (Distance d: res)
            System.out.printf(d.index + ", %2.5f\n", d.distance); /* %2.5f prints a floating-point value with exactly 5 digits after the decimal point; 2 is the minimum field width and is ignored if the number needs more space */
    }
}
