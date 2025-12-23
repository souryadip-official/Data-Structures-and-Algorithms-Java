import java.util.Scanner;
public class BinaryStringsProblem {
    static int size;
    public void printBinaryStrings(int n, char last_ch, StringBuilder str) {
        if(n == 0) {
            System.out.println(str);
            return;
        }
        if(last_ch == '0') {
            StringBuilder t1 = new StringBuilder(String.valueOf(str));
            t1.append('0');
            printBinaryStrings(n-1, '0', t1);
            StringBuilder t2 = new StringBuilder(String.valueOf(str));
            t2.append('1');
            printBinaryStrings(n-1, '1', t2);
        } else {
            str.append('0');
            printBinaryStrings(n-1, '0', str);
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter string size (n): ");
        size = sc.nextInt();
        BinaryStringsProblem b = new BinaryStringsProblem();
        b.printBinaryStrings(size, '0', new StringBuilder());
    }
}
/*
String tmp = str;
        if(n == size) {
            System.out.println(tmp);
            return;
        }
        if(tmp.isEmpty() || tmp.charAt(tmp.length()-1)=='0') {
            String tmp1 = tmp + '0';
            printBinaryStrings(n+1, tmp1);
            String tmp2 = tmp + '1';
            printBinaryStrings(n+1, tmp2);
        } else {
            tmp += '0';
            printBinaryStrings(n+1, tmp);
        }
 */