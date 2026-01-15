import java.util.Stack;
public class MyQueue {
    Stack<Integer> stack1;
    Stack<Integer> stack2;
    public MyQueue() {
        this.stack1 = new Stack<>();
        this.stack2 = new Stack<>();
    }

    public void push(int x) {
        if (this.stack1.isEmpty()) {
            while (!this.stack2.isEmpty())
                this.stack1.push(this.stack2.pop());
            this.stack1.add(x);
        }
        else
            this.stack1.push(x);
    }

    public int pop() {
        if (this.stack1.isEmpty()) {
            return this.stack2.pop();
        } else {
            while (this.stack1.size() > 1)
                this.stack2.push(this.stack1.pop());
            return this.stack1.pop();
        }
    }

    public int peek() {
        if (this.stack1.isEmpty()) {
            return this.stack2.peek();
        } else {
            while (this.stack1.size() > 1)
                this.stack2.push(this.stack1.pop());
            int ele = this.stack1.pop();
            this.stack2.push(ele);
            return ele;
        }
    }

    public boolean empty() {
        return this.stack1.isEmpty() && this.stack2.isEmpty();
    }
}