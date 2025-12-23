import java.util.Scanner;
public class Recursive_Power_Optimised {
    public int rec_pow(int b, int p) {
        if(p == 0)
            return 1;
        int half_pow = rec_pow(b, p/2);
        if(p % 2 == 0)
            return half_pow * half_pow;
        else
            return b * half_pow * half_pow;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter base: ");
        int b = sc.nextInt();
        System.out.print("Enter +ve power: ");
        int p = sc.nextInt();
        if(p < 0) {
            System.out.println("Invalid +ve power!");
            return;
        }
        Recursive_Power_Optimised obj = new Recursive_Power_Optimised();
        System.out.println("Result: " + b + " ^ " + p + " = " + obj.rec_pow(b,p));
    }
}