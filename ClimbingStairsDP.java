public class ClimbingStairsDP {
    public static int climbStairsUtil(int[] steps, int n) {
        if (n < 0) return 0;
        if (steps[n] != Integer.MIN_VALUE) {
            return steps[n];
        } else {
            steps[n] = climbStairsUtil(steps, n-1) + climbStairsUtil(steps, n-2);
            /* Storing the result, so that in future if a call is made for the same 'n', we do not have to calculate it again */
            return steps[n];
        }
    }
    public static int climbStairs(int n) {
        if (n==0 || n==1 || n==2) {
            return n;
            /* 0 has 0 ways, 1 has 1 way {1 step}, 2 has 2 ways {2, 1+1} */
        }
        int[] steps = new int[n+1];
        steps[0] = 0;
        steps[1] = 1;
        steps[2] = 2;
        for (int i=3; i<(n+1); i++) steps[i] = Integer.MIN_VALUE;
        return climbStairsUtil(steps, n);
    }
    public static void main(String[] args) {
        System.out.println(climbStairs(15));
    }
}