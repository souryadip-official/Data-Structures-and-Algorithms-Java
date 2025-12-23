import java.util.Stack;
public class Stack03 {
    public static void main(String[] args) {
        Stack<Integer> s = new Stack<>();
        s.push(5);
        System.out.println("Search result: " + s.search(5));
        System.out.println(s);
        s.peek();
        System.out.println(s.pop());
    }
}
