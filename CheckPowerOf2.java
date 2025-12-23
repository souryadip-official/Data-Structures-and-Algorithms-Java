import java.util.*;
public class CheckPowerOf2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the number: ");
        int n = sc.nextInt();
        /* By the change of base rule:
           log (base a) x = log (base b) x / log (base b) a */
        int n1 = (int) (Math.log(n) / Math.log(2));
        int x = (int) Math.pow(2,n1);
        if((n ^ x) == 0)
            System.out.println(n + " is an exact power of 2.\n[2 ^ " + n1 + " = " + x + "]");
        else
            System.out.println(n + " is not an exact power of 2.");
        sc.close();
    }
}
