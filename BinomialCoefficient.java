import java.util.*;
public class BinomialCoefficient {
    public static long getFact(int x) {
        int i;
        long fact = 1;
        for(i=1; i<=x; i++)
            fact *= i;
        return fact;
    }
    public static long getBinomialCoeff(int n, int r) {
        return (getFact(n) / (getFact(r) * getFact(n-r)));
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n, r;
        long bcoeff = 0;
        System.out.print("Enter the value of n: ");
        n = sc.nextInt();
        System.out.print("Enter the value of r: ");
        r = sc.nextInt();
        if(n >= r) {
            bcoeff = getBinomialCoeff(n,r);
            System.out.println("Value of "+n+"C"+r+" is = "+bcoeff);
        } else {
            System.out.println("Value of n should be greater than or equal to r.\nInvalid input.");
        }
    }
}
