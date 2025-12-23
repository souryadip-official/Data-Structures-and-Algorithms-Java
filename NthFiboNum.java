import java.util.Scanner;
public class NthFiboNum {
    public int getNFibo(int n) {
        if(n == 0 || n == 1) return n;
        return getNFibo(n-1) + getNFibo(n-2);
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter n (Indexing starts from 0): ");
        int n = sc.nextInt();
        NthFiboNum obj = new NthFiboNum();
        System.out.println(n + "-th Fibonacci number is: " + obj.getNFibo(n));
        sc.close();
    }
}
