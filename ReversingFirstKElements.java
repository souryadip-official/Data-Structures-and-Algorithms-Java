import java.util.Deque;
import java.util.Queue;
import java.util.LinkedList;
public class ReversingFirstKElements {
    public static void reverseQueue(Queue<Integer> queue) {
        if(queue.isEmpty()) return;
        int data = queue.remove();
        reverseQueue(queue);
        queue.add(data);
    }
    public static void reverseFirstKELements(Queue<Integer> queue, int k) {
        Queue<Integer> helper = new LinkedList<>();
        /* Transfer all the elements of the queue to a deque, this is because we can only remove elements from the front and remove from the back */
        while(!queue.isEmpty()) helper.add(queue.remove());
        int temp = k;
        /* Transfer the first k elements from the deque to the original queue */
        while(temp > 0) {
            queue.add(helper.remove());
            temp--;
        }
        /* now reverse the original queue */
        reverseQueue(queue);
        while(!helper.isEmpty()) queue.add(helper.remove());
    }
    public static void main(String[] args) {
        Queue<Integer> queue = new LinkedList<>();
        for(int i=1; i<=10; i++) queue.add(i);
        int k = 7;
        if(k > queue.size()) {
            System.out.println("Size out of range!");
            return;
        }
        System.out.println("Before reversal: " + queue);
        reverseFirstKELements(queue, k);
        System.out.println("After reversal: " + queue);
    }
}
