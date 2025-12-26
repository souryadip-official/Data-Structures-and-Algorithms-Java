import java.util.Scanner;
public class FibonacciDP {
    private static int fibonacciUtil(int num, int[] fib) {
        if (fib[num] != -1) /* The fibonacci for this num is already calculated */
            return fib[num];
        fib[num] = fibonacciUtil(num-1, fib) + fibonacciUtil(num-2, fib);
        return fib[num];
    }
    public static int fibonacci(int num) {
        if (num == 0 || num == 1) return num;
        int[] fib = new int[num+1]; /* to store the fibonacci of 0...num */
        fib[0] = 0;
        fib[1] = 1;
        for (int i=2; i<fib.length; i++)
            fib[i] = -1; /* fibonacci for this index is still not populated */
        long startTime = System.nanoTime();
        int val = fibonacciUtil(num, fib);
        long endTime = System.nanoTime();
        long durationInNanoseconds = endTime - startTime;
        System.out.println("Execution time: " + durationInNanoseconds + "ns");
        return val;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the number: ");
        int num = sc.nextInt();
        System.out.println(fibonacci(num));
    }
}
