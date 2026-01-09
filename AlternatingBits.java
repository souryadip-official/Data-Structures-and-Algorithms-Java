public class AlternatingBits {
    public static String binary(int n) {
        StringBuilder res = new StringBuilder();
        while(n > 0) {
            int rem = n % 2;
            res.append(rem);
            n = n/2;
        }
        return res.reverse().toString();
    }
    public boolean hasAlternatingBits(int n) {
        String bin = binary(n);
        int prev = bin.charAt(0) - '0', curr;
        for (int i=1; i<bin.length(); i++) {
            curr = bin.charAt(i) - '0';
            if ((curr == 1 && prev == 1) || (curr == 0 && prev == 0))
                return false;
            else {
                /* it was a valid case, we update the prev to curr */
                prev = curr;
            }
        }
        return true;
    }
    public boolean hasAlternatingBits2(int n) {
        int lastBit = -1, currBit = 0;
        while (n > 0) {
            currBit = n & 1;
            n = n >> 1;
            if (lastBit == currBit) return false;
            else lastBit = currBit;
        }
        return true;
    }
}