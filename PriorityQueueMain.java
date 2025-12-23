import java.util.Comparator;
import java.util.PriorityQueue;
public class PriorityQueueMain {
    static class Student implements Comparable<Student> {
        String name;
        int rank;
        Student(String name, int rank) {
            this.name = name;
            this.rank = rank;
        }
        @Override
        public int compareTo(Student s) {
            return this.rank - s.rank; // To compare objects of a class
        }
    }
    public static void main(String[] args) {
        /* PriorityQueue<Integer> pq = new PriorityQueue<>();
        pq.add(5); pq.add(1); pq.add(4); pq.add(3); pq.add(2);
        while(!pq.isEmpty()) System.out.println(pq.remove());
        // add: O(log n), peek: O(1), remove: O(log n)
        PriorityQueue<Integer> pq2 = new PriorityQueue<>(Comparator.reverseOrder());
        // Now larger elements will get higher priority
        pq2.add(5); pq2.add(1); pq2.add(4); pq2.add(3); pq2.add(2);
        while(!pq2.isEmpty()) System.out.println(pq2.remove()); */

        PriorityQueue<Student> pq = new PriorityQueue<>();
        pq.add(new Student("Souryadip", 1767));
        pq.add(new Student("Ritankar", 17350));
        pq.add(new Student("Ishan", 13000));

        while(!pq.isEmpty()) {
            System.out.print(pq.peek().name + " ");
            pq.remove();
        }
    }
}
