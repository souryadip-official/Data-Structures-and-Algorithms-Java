import java.util.Stack;
public class DuplicateParentheses {
    public static char toLowerCase(char ch) {
        if(ch >= 'A' && ch <= 'Z')
            return (char)((int) ch + 32);
        return ch;
    }
    public static boolean isOperand(char ch) {
        ch = toLowerCase(ch);
        return (ch >= 'a' && ch <= 'z');
    }
    public static boolean isOperator(char ch) {
        return (ch == '+' || ch == '-' || ch == '*' || ch == '/' || ch == '%');
    }
    public static boolean isOpeningBrace(char ch) {
        return (ch == '(' || ch == '{' || ch == '[');
    }
    public static boolean isClosingBrace(char ch) {
        return (ch == ')' || ch == '}' || ch == ']');
    }
    public static boolean isDuplicatePresent(String s) {
        Stack<Character> stack = new Stack<>();
        int idx = 0;
        while(idx != s.length()) {
            char ch = s.charAt(idx);
            if(isOpeningBrace(ch) || isOperator(ch) || isOperand(ch)) stack.push(ch);
            else if(isClosingBrace(ch)) {
                char chToMatch = '\0';
                if(ch == ')') chToMatch = '(';
                else if(ch == '}') chToMatch = '{';
                else chToMatch = '[';
                int noOfNonBraceOperators = 0;
                while(stack.peek() != chToMatch) {
                    noOfNonBraceOperators++;
                    stack.pop();
                }
                if(noOfNonBraceOperators == 0) return true;
                else stack.pop(); /* pop the opening brace */
            }
            idx++;
        }
        /* if no violation is found till now after traversing through the entire expression, this means there is no duplicate parentheses in this expression */
        return false;
    }
    public static void main(String[] args) {
        String str = "a+(b+(c+(d)))+(((e+f)*g)+h)";
        System.out.println("Duplicate parentheses present in expression " + str + "?\nAnswer: " + isDuplicatePresent(str));
    }
}