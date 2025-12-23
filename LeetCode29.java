public class LeetCode29 {
    public static int divide(int dividend, int divisor) {
        if(divisor == 0 || dividend == 0) return 0;
        if(dividend == Integer.MAX_VALUE  && Math.abs(divisor) == 1) {
            if(divisor < 0) return Integer.MIN_VALUE;
            else return Integer.MAX_VALUE;
        } else if(dividend == Integer.MIN_VALUE && Math.abs(divisor) == 1) {
            if(divisor < 0) return Integer.MAX_VALUE;
            else return Integer.MIN_VALUE;
        }
        int a = dividend, b = divisor;
        if(a < 0) a = -a;
        if(b < 0) b = -b;
        int count = 0;
        for(int i=b; i<=a; i += b) count++;
        if(dividend < 0 && divisor < 0) count = count;
        else if(dividend < 0 || divisor < 0) count = -count;
        return count;
    }

    public static void main(String[] args) {
        System.out.println(divide(Integer.MAX_VALUE, 2));
    }
}