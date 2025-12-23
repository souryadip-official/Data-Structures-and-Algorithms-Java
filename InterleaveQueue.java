import java.util.LinkedList;
import java.util.Queue;
public class InterleaveQueue {
    public static void interleave(Queue<Integer> q) {
        Queue<Integer> firstHalf = new LinkedList<>();
        int size = q.size();
        boolean isOdd = size % 2 != 0;
        for(int i=1; i<=size/2; i++) firstHalf.add(q.remove());
        while(!firstHalf.isEmpty()) {
            q.add(firstHalf.remove());
            q.add(q.remove());
        }
        if(isOdd) q.add(q.remove());
    }
    public static void main(String[] args) {
        Queue<Integer> q = new LinkedList<>();
        for(int i=1; i<=9; i++) q.add(i);
        System.out.println("Before interleave: " + q);
        interleave(q);
        System.out.println("After interleave: " + q);
    }
}
