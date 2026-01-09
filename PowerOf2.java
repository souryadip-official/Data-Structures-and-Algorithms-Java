public class PowerOf2 {
    public boolean isPowerOfTwo(int n) {
        int oneCount = 0;
        /* Any power of 2, contains only a single 1 in its binary equivalent. Like, for 8 it is 1000, for 16 it is 10000 but for say 6, it is 110 */
        while (n > 0) {
            int lastBit = n & 1;
            if (lastBit == 1) oneCount++;
            n = n >> 1;
        }
        return oneCount == 1;
    }
    public boolean isPowerOfTwo2(int n) {
        /* For example, 16 and 15, 10000 & 01111 is 00000. Similarly, this property holds for all 2^n */
        return ((n > 0) && ((n & (n-1)) == 0));
    }
}
