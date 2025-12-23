import java.util.*;
public class DecimalToBinary {
    public static int power(int a, int b) {
        int pow = 1;
        while(b > 0) {
            pow *= a;
            b--;
        }
        return pow;
    }
    public static int getBinary(int dec) {
        int dg, idx = 0, stBin = 0;
        while(dec > 0) {
            dg = dec % 2;
            stBin = stBin + (dg * power(10, idx++));
            dec = dec / 2;
        }
        return stBin;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int decimal;
        System.out.print("Enter a decimal number: ");
        decimal = sc.nextInt();
        if(decimal < 0) {
            System.out.println("Negative number not accepted.");
        } else {
            int binary = getBinary(decimal);
            System.out.println("Binary equivalent of " + decimal + " is: " + binary);
        }
    }
}
