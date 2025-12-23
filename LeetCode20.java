import java.util.EmptyStackException;
import java.util.Stack;
// or, directly do import java.util.*;
class LeetCode20 {
    public static boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        int idx = 0;
        while(idx != s.length()) {
            char ch = s.charAt(idx);
            if(ch == '(' || ch == '{' || ch == '[')
                stack.push(ch);
            else if(ch == ')' || ch == '}' || ch == ']') {
                char chToMatch = '\0';
                if(ch == ')') chToMatch = '(';
                else if(ch == '}') chToMatch = '{';
                else chToMatch = '[';
                try {
                    if(chToMatch == stack.peek()) stack.pop();
                    else return false;
                } catch(EmptyStackException e) {
                    return false;
                }
            } else return false;
            idx++;
        }
        return stack.isEmpty();
    }
    public static void main(String[] args) {
        String str = "{[]()}";
        System.out.println(str + " = " + isValid(str));
    }
}
