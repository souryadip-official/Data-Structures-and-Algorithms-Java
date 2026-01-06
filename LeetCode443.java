public class LeetCode443 {
    public int compress(char[] chars) {
        StringBuilder ans = new StringBuilder();
        char curr = '\0';
        int currLen = 0;
        for(int i=0; i<chars.length; i++) {
            char ch = chars[i];
            if(curr == '\0') {
                curr = ch;
                currLen = 1;
            } else if(curr != ch) {
                ans.append(curr);
                if(currLen > 1)
                    ans.append(currLen); /* only append count if greater than one as mentioned in the problem statement */
                curr = ch;
                currLen = 1;
            } else {
                currLen++;
            }
            if(i == chars.length - 1) { /* handling the last character */
                ans.append(curr);
                if(currLen > 1)
                    ans.append(currLen);
            }
        }
        /* Now copying the result to the minimum length of ans or chars */
        for(int i=0; i<Math.min(ans.length(), chars.length); i++)
            chars[i] = ans.charAt(i);
        return ans.length(); /* return actual compressed length, may be larger than original array */
    }
}