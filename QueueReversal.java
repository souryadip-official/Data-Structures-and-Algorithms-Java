import java.util.LinkedList;
import java.util.Queue;
public class QueueReversal {
    public static void reverse(Queue<Integer> q) {
        if(q.isEmpty()) return;
        int data = q.remove();
        reverse(q);
        q.add(data);
    }
    public static void main(String[] args) {
        Queue<Integer> q = new LinkedList<>();
        for(int i=1; i<=10; i++) q.add(i);
        System.out.println("Before reverse: " + q);
        reverse(q);
        System.out.println("After reverse: " + q);
    }
}
