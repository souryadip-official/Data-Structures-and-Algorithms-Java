import java.util.Scanner;
public class FibonacciDPTabulation {
    public static int fibonacciTab(int n) {
        if (n == 0 || n == 1) return n;
        int[] dp = new int[n+1];
        dp[0] = 0;
        dp[1] = 1;
        for (int i=2; i<(n+1); i++)
            dp[i] = dp[i-1] + dp[i-2];
        return dp[n];
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the number: ");
        int num = sc.nextInt();
        System.out.println(fibonacciTab(num));
    }
}
