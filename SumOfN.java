import java.util.Scanner;
public class SumOfN {
    public int rec_sum(int n) {
        if(n == 0 || n == 1) return n;
        else return (n + rec_sum(n-1));
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter n: ");
        int n = sc.nextInt();
        SumOfN s = new SumOfN();
        System.out.println("Result: " + s.rec_sum(n));
        sc.close();
    }
}