import java.util.ArrayDeque;
import java.util.Queue;
public class QueueUsingJCF {
    public static void main(String[] args) {
        Queue<Integer> q = new ArrayDeque<>();
        q.add(5);
        System.out.println("Peek result: " + q.peek());
        System.out.println("Queue is: " + q);
        q.remove();
        System.out.println("Queue is: " + q);
    }
}
