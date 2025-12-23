import java.util.Scanner;
import java.util.Stack;
class DecodeString {
    /* Approach 1: Using a single stack */
    public static String decodeString_Approach1(String s) {
        Stack<Character> stack = new Stack<>();
        StringBuilder temp = new StringBuilder();
        StringBuilder res = new StringBuilder();
        StringBuilder num = new StringBuilder();
        for(int i=0; i<s.length(); i++) {
            char ch = s.charAt(i);
            if(Character.isDigit(ch) || Character.isLetter(ch) || ch == '[')
                stack.push(ch);
            else if(ch == ']') {
                while(!stack.isEmpty() && !Character.isDigit(stack.peek())) {
                    char chr = stack.pop();
                    if(chr != '[') temp.append(chr);
                    else break;
                }
                temp.reverse();

                while(!stack.isEmpty() && Character.isDigit(stack.peek())) {
                    num.append(stack.pop());
                }

                num.reverse();
                int digit = Integer.parseInt(num.toString());


                StringBuilder curr = new StringBuilder();

                /* appending the string that many times */
                for(int j=0; j<digit;j++) curr.append(temp);

                if(!stack.isEmpty()) {
                    for(int k=0; k<curr.length(); k++)
                        stack.push(curr.charAt(k));
                } else res.append(curr);

                temp = new StringBuilder();
                num = new StringBuilder();
            }
            if(i+1 == s.length() && s.charAt(i) != ']') {
                while(!stack.isEmpty()) temp.append(stack.pop());
                temp.reverse();
                res.append(temp);
                break;
            }
        }
        StringBuilder remainingChars = new StringBuilder();
        while(!stack.isEmpty())
            remainingChars.append(stack.pop());

        return res.append(remainingChars.reverse()).toString();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the string: ");
        String str = sc.next();
        System.out.println("Decoded string: " + decodeString_Approach1(str));
        sc.close();
    }
}