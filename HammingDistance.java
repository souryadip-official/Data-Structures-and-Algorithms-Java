public class HammingDistance {
    public int hammingDistance(int x, int y) {
        /* If we XOR x amd y, then the bits set to 1 are the bits where two corresponding bits are different because xor of a, b is 1 if a != b else 0. Thereafter, if we check the number of 1 bits in the binary equivalent of that result, we get the hamming distance between them */
        int xor = x ^ y;
        int count = 0;
        while (xor > 0) {
            int currBit = xor & 1;
            if (currBit == 1) count++;
            xor = xor >> 1;
        }
        return count;
    }
}
