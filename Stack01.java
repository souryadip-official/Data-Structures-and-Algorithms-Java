import java.util.ArrayList;
class Stack {
    ArrayList<Integer> arr = new ArrayList<>();
}
public class Stack01 {
    public static boolean isEmpty(Stack04 s) {
        return (s.arr.size() == 0);
    }
    public static void push(Stack04 s, int data) {
        s.arr.add(data);
    }

    public static int pop(Stack04 s) {
        if (s.arr.isEmpty()) {
            System.out.println("Stack underflow!");
            return -1;
        }
        int res = s.arr.get(s.arr.size() - 1);
        s.arr.remove(s.arr.size() - 1);
        return res;
    }

    public static void pushAtBottom(Stack04 s, int data) {
        if(isEmpty(s)) {
            s.arr.add(data);
            return;
        }
        int res = pop(s);
        pushAtBottom(s, data);
        push(s, res);
    }
    /* Top to bottom:
    3 2 1 (Initial stack)
    2 1 -> 3 (Recent to older pops)
    1 -> 2 3
    _ -> 1 2 3
    4 -> 1 2 3
    1 4 -> 2 3
    2 1 4 -> 3
    3 2 1 4 */



    public static void peek(Stack04 s) {
        if (isEmpty(s)) {
            System.out.println("Stack is empty!");
            return;
        }
        int element = s.arr.get(s.arr.size() - 1);
        System.out.println("Topmost element is: " + element);
    }
    public static void display(Stack04 s) {
        if (isEmpty(s)) {
            System.out.println("Stack is empty!");
            return;
        }
        System.out.println("Stack looks like:");
        for (int i = s.arr.size() - 1; i >= 0; i--)
            System.out.println(" |\t" + s.arr.get(i) + "\t| " + ((i == s.arr.size() - 1) ? " <-- TOP" : ""));
        System.out.println(" -------- ");
    }
    public static void main(String[] args) {
        Stack04 s = new Stack04();
        pushAtBottom(s, 6);
        push(s, 5);
        pushAtBottom(s, 6);
        peek(s);
        display(s);
        pop(s);
    }
}
