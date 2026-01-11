public class StringToInteger {
    public int myAtoi(String s) {
        boolean sign = true; /* true (positive), false (negative) */
        boolean digitsStarted = false;
        boolean signSeen = false;
        StringBuilder num = new StringBuilder();
        s = s.trim();
        for (int i=0; i<s.length(); i++) {
            char ch = s.charAt(i);
            if (ch == '-' && !signSeen && !digitsStarted) {
                signSeen = true; /* So that no further sign can appear */
                digitsStarted = true;
                sign = false;
            } else if (ch == '+' && !signSeen && !digitsStarted) {
                signSeen = true;
                digitsStarted = true;
                sign = true;
            }
            else if (ch == '.' || ch == ' ' || Character.isLetter(ch) || ch == '-' || ch == '+') /* we break as soon as we get a character or a sign after the number started or a space in between */
                break;
            else if (Character.isDigit(ch)) {
                digitsStarted = true;
                num.append(ch);
            }
        }
        if (num.length() == 0) return 0;
        long value = 0;
        for (int i = 0; i < num.length(); i++) {
            value = value * 10 + (num.charAt(i) - '0');
            if (sign && value > Integer.MAX_VALUE)
                return Integer.MAX_VALUE;
            if (!sign && -value < Integer.MIN_VALUE)
                return Integer.MIN_VALUE;
        }
        return sign ? (int) value : (int) -value;
    }
}