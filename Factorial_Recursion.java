import java.util.Scanner;
public class Factorial_Recursion {
    public long rec_fact(int n) {
        if(n == 0 || n == 1)
            return 1;
        else return n * rec_fact(n-1);
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the number: ");
        int n = sc.nextInt();
        Factorial_Recursion f = new Factorial_Recursion();
        System.out.println("Factorial of " + n + " = " + f.rec_fact(n));
    }
}