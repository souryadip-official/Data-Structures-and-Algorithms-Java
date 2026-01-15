import java.util.LinkedList;
import java.util.Queue;
public class MyStack {
    Queue<Integer> queue1;
    Queue<Integer> queue2;
    public MyStack() {
        this.queue1 = new LinkedList<>();
        this.queue2 = new LinkedList<>();
    }

    public void push(int x) {
        if (this.queue1.isEmpty())
            this.queue2.add(x);
        else
            this.queue1.add(x);
    }

    public int pop() {
        if (this.queue1.isEmpty()) {
            while (this.queue2.size() > 1)
                this.queue1.add(this.queue2.poll());
            return this.queue2.poll();
        } else {
            while (this.queue1.size() > 1)
                this.queue2.add(this.queue1.poll());
            return this.queue1.poll();
        }
    }

    public int top() {
        if (this.queue1.isEmpty()) {
            while (this.queue2.size() > 1)
                this.queue1.add(this.queue2.poll());
            int ele = this.queue2.poll();
            this.queue1.add(ele);
            return ele;
        }
        else {
            while (this.queue1.size() > 1)
                this.queue2.add(this.queue1.poll());
            int ele = this.queue1.poll();
            this.queue2.add(ele);
            return ele;
        }
    }

    public boolean empty() {
        return this.queue1.isEmpty() && this.queue2.isEmpty();
    }
}