import java.util.ArrayList;
class Stack04 {
    ArrayList<Integer> arr = new ArrayList<>();
    public boolean isEmpty() {
        return (this.arr.size() == 0);
    }
    public void push(int data) {
        this.arr.add(data);
    }
    public int pop() {
        if(this.isEmpty()) return -1;
        int val = this.arr.get(this.arr.size()-1);
        this.arr.remove(this.arr.size()-1);
        return val;
    }
    /* Way 1: Using another stack to store the reverse
    public void reverse() {
        if(this.isEmpty()) return;
        Stack04 temp = new Stack04();
        while(!this.isEmpty()) temp.push(this.pop());
        this.arr = temp.arr;
    } */
    /* Way 2: Pop elements until the stack is empty and then start pushing it at the bottom  */
    public void pushAtBottom(int data) {
        if(this.isEmpty()) {
            this.arr.add(data);
            return;
        }
        int val = this.pop();
        pushAtBottom(data);
        this.arr.add(val);
    }
    public void reverse() {
        if(this.isEmpty()) return;
        int val = this.pop();
        reverse();
        this.pushAtBottom(val);
    }
    public void display() {
        if(this.isEmpty()) {
            System.out.println("Stack is empty!");
            return;
        }
        System.out.println("Stack looks like:");
        for (int i = this.arr.size() - 1; i >= 0; i--)
            System.out.println(" |\t\t" + this.arr.get(i) + "\t\t| " + ((i == this.arr.size() - 1) ? " <-- TOP" : ""));
        System.out.println(" |______________| ");
    }
}
public class Stack04_Main {
    public static void main(String[] args) {
        Stack04 s = new Stack04();
        for(int i=1; i<=10; i++) s.push(i);
        s.display();
        s.reverse();
        s.display();
    }
}
