import java.util.Arrays;
public class CatalansNumber {
    public static int getCatalan(int x) {
        if (x == 0 || x == 1) return 1;
        int cx = 0; /* catalan of x */
        for (int i=0; i<=x-1; i++) {
            int cf = getCatalan(i); /* catalan for the ith number */
            int cl = getCatalan(x-i-1); /* catalan for the (x-i-1)th number */
            cx += (cf * cl);
        }
        return cx;
    }
    private static int getCatalanMemoUtil(int x, int[] dp) {
        if (x == 0 || x == 1) return 1;
        int ans = 0;
        if (dp[x] != -1) return dp[x];
        for (int i=0; i<=x-1; i++) {
            if (dp[i] == -1)
                dp[i] = getCatalanMemoUtil(i, dp);
            if (dp[x-i-1] == -1)
                dp[x-i-1] = getCatalanMemoUtil(x-i-1, dp);
            ans += (dp[i] * dp[x-i-1]);
        }
        dp[x] = ans;
        return dp[x];
    }
    public static int getCatalanMemo(int x) {
        int[] dp = new int[x+1];
        Arrays.fill(dp, -1);
        return getCatalanMemoUtil(x, dp);
    }
    public static int getCatalanTab(int x) {
        if (x == 0 || x == 1) return 1;
        int[] dp = new int[x +1];
        dp[0] = dp[1] = 1;
        for(int i=2; i<dp.length; i++) {
            int ans = 0;
            for(int j=0; j<=i-1; j++)
                ans += (dp[j] * dp[i-j-1]);
            dp[i] = ans;
        }
        return dp[x];
    }
    public static void main(String[] args) {
        System.out.println(getCatalan(3));
        System.out.println(getCatalanMemo(5));
        System.out.println(getCatalanTab(5));
    }
}
