public class FourDivisors {
    public static int getDivisor(int num) {
        int sum = 0;
        int divCount = 0;
        for(int i=1; i<=(int)Math.sqrt(num); i++) {
            if(num % i == 0) {
                /* Now if the result of num/i is a valid integer and say is 'x', then num/x = i, which is also a valid integer and hence a whole divisor */
                int pair = num / i;
                if (i == pair) { /* perfect square case (for example, num=16, i=4, then num/i=4 again, hence, we count it only once) */
                    sum += i; /* add only i once */
                    divCount++; /* increment divisor count by 1 */
                } else { /* normal case where i and num/i are different */
                    sum += (i + pair); /* add both divisors */
                    divCount += 2; /* count both */
                }
            }
            if (divCount > 4) return 0; /* if more than 4 divisors, we can stop early and return 0 */
        }
        return (divCount == 4? sum : 0); /* if exactly 4 divisors, return their sum, else 0 */
    }
    public int sumFourDivisors(int[] nums) {
        int finalAns = 0;
        for(int i=0; i<nums.length; i++)
            finalAns += getDivisor(nums[i]); /* sum up the divisors for each number */
        return finalAns; /* return final answer */
    }
}