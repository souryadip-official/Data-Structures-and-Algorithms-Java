/*
Lexicographically smallest string of length N and sum K
We have two integers N and K. The task is to print the lexicographically smallest string of
length N consisting of lower-case English alphabets such that the sum of the characters of
the string equals to K where ‘a’ = 1, ‘b’ = 2, ‘c’ = 3, ... and ‘z’ = 26.
Sample Input 1: N = 5, K = 42
Sample Output 1: aaamz
Sample Input 2: N = 3, K = 25
Sample Output 2: aaw */

public class LexicographicSmallestString {
    public static String lexicographicSmallestString(int n, int k) {
        StringBuilder result = new StringBuilder();
        int currCharCount = 0;
        char charToAppend = '\0';
        while(currCharCount <= n) {
            currCharCount++;
            if(currCharCount <= n) {
                int remainingChars = n - currCharCount;
                if(remainingChars == 0) {
                    // this is the last character
                    charToAppend = (char)(96 + k);
                }
                else if(k <= (remainingChars *  26)) {
                    charToAppend = 'a';
                    k -= 1;
                } else {
                    int excess = k - (remainingChars *  26);
                    charToAppend = (char) (96 + excess);
                    k -= excess;
                }
                System.out.println(charToAppend);
                result.append(charToAppend);
            }
        }
        return result.toString();
    }
    public static void main(String[] args) {
        int n = 5, k = 104;
        String res = lexicographicSmallestString(n, k);
        System.out.println("Result is: " + res);
    }
}
