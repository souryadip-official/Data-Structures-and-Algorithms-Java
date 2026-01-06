import java.util.Stack;
public class BaseballGame {
    public int calPoints(String[] operations) {
        Stack<Integer> stack = new Stack<>();
        for (int i=0; i<operations.length; i++) {
            String curr = operations[i];
            if (curr.equals("+")) {
                int s1 = stack.pop();
                int s2 = stack.pop();
                stack.push(s2);
                stack.push(s1);
                stack.push(s1+s2);
            } else if (curr.equals("D")) {
                int s1 = stack.peek();
                stack.push(2 * s1);
            } else if (curr.equals("C")) {
                stack.pop();
            } else {
                stack.push(Integer.parseInt(curr));
            }
        }
        int ans = 0;
        while(!stack.isEmpty())
            ans += stack.pop();
        return ans;
    }
}