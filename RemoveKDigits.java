import java.util.Stack;
public class RemoveKDigits {
    public String removeKdigits(String num, int k) {
        Stack<Integer> stack = new Stack<>(); /* stack keeps track of digits forming the smallest number so far */
        int maxRemoveAllowed = k; /* this tracks how many digits we can still remove */
        for(int i=0; i<num.length(); i++) {
            int curr_num = num.charAt(i) - '0';
            /* if the current digit is smaller than stack top, and we can still remove digits, pop bigger digits to minimize number */
            while(maxRemoveAllowed > 0 && !stack.isEmpty() && stack.peek() > curr_num) {
                stack.pop();
                maxRemoveAllowed--;
            }
            stack.push(curr_num); /* push the current digit after removing larger ones from top */
        }
        /* if we still have digits to remove after traversing the string, remove from the end (stack top) */
        while (maxRemoveAllowed > 0) {
            stack.pop();
            maxRemoveAllowed--;
        }
        StringBuilder str = new StringBuilder();
        int start = 0; /* flag to skip leading zeros */
        for(int val: stack) {
            if (start == 0 && val == 0) {
                continue; /* skip leading zeros */
            } else if (val > 0)
                start = 1; /* first non-zero digit encountered, start appending */
            str.append(val); /* append surviving digits */
        }
        return (!str.isEmpty()? str.toString() : "0"); /* if nothing left, return "0" */
    }
}