import java.util.Deque;
import java.util.LinkedList;
public class DequeUsingJCF {
    public static void main(String[] args) {
        Deque<Integer> d = new LinkedList<>();
        for(int i=1; i<=5; i++) d.addFirst(i);
        System.out.println(d);
        for(int i=-5; i<=-1; i++) d.addLast(i);
        System.out.println(d);
        d.removeFirst();
        d.removeLast();
        System.out.println(d);
    }
}
