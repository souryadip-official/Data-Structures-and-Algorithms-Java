import java.util.*;
public class BinaryToDecimal {
    public static int power(int a, int b) {
        /* Although we have a Math.pow function, still let's build one from scratch */
        int pow = 1;
        while(b > 0) {
            pow *= a;
            b--;
        }
        return pow;
    }
    public static int getDecimal(int bin) {
        int stDec = 0, dg, idx = 0;
        while(bin > 0) {
            dg = bin % 10;
            if(dg == 0 || dg == 1) {
                stDec = stDec + (dg * power(2, idx++));
            } else {
                return -9999;
            }
            bin = bin / 10;
        }
        return stDec;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int binary;
        System.out.print("Enter a binary number: ");
        binary = sc.nextInt();
        if(binary < 0) {
            System.out.println("Negative number not accepted.");
        } else {
            int decimal = getDecimal(binary);
            if(decimal != -9999) {
                System.out.println("Decimal equivalent of " + binary + " is: " + decimal);
            } else {
                System.out.println("Invalid Binary Number");
            }
        }
    }
}
