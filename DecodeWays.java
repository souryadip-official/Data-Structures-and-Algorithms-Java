public class DecodeWays {
    public int numDecodings(String s) {
        if (s.charAt(0) == '0') return 0;
        int n = s.length();
        int[] dp = new int[n+1]; /* dp[i] stores the number of ways to decode the current string with first i characters */
        dp[0] = 1; /* if the length of the string is 0, there is only one way to decode it that is by considering nothing into consideration */
        dp[1] = s.charAt(0) == '0'? 0 : 1; /* If the first character is valid, then we have only 1 way to decode it that is by consdering it completely or else we dont have a way to decode it that is 0 */

        for (int i=2; i<dp.length; i++) {
            int oneDigit = Integer.parseInt(s.substring(i-1, i)); /* considering the last character (that is the current string character). Since we are at a plus one offset, 'i' in dp array means 'i-1' in the string */
            int twoDigit = Integer.parseInt(s.substring(i-2, i)); /* considering the last two characters (that is the current string character and the previous one) */

            int oneDigitWays = 0, twoDigitWays = 0;
            if (oneDigit >= 1 && oneDigit <= 9) /* current single digit is valid only if its between 1-9. This is because, beyond this range, no mapping exists */
                oneDigitWays = dp[i-1];
            if (twoDigit >= 10 && twoDigit <= 26) /* current two digit is valid only if its between 10-26. This is because, beyond this range, no mapping exists */
                twoDigitWays = dp[i-2];

            dp[i] += oneDigitWays + twoDigitWays; /* if the current digit is taken into account, the total ways is the sum of ways if its considered as 1 digit or it is considered as 2 digit (current + previous together) */
        }
        return dp[n];
    }
}
