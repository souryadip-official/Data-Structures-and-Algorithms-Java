import java.util.Scanner;
public class LeetCode67 {
    public static String addBinary(String a, String b) {
        StringBuilder res = new StringBuilder();
        int m = a.length(), n = b.length(), i=m-1, j=n-1, ic=0, sum=0, n1, n2;
        while(i >= 0 && j >= 0) {
            n1 = (int)a.charAt(i) - 48;
            n2 = (int)b.charAt(j) - 48;
            sum = (n1 ^ n2) ^ ic;
            ic = (n1 & n2) | (n2 & ic) | (ic & n1);
            res.append(sum);
            i--; j--;
        }
        while(i >= 0) {
            n1 = (int)a.charAt(i) - 48;
            sum = n1 ^ ic;
            ic = n1 & ic;
            res.append(sum);
            i--;
        }
        while(j >= 0) {
            n2 = (int)b.charAt(j) - 48;
            sum = n2 ^ ic;
            ic = n2 & ic;
            res.append(sum);
            j--;
        }
        if(ic == 1) {
            res.append("1");
        }
        return res.reverse().toString();
    }

    public static void main(String[] args) {
        /* Assuming that a valid binary number will be entered */
        /* We can also handle this condition using exception handling */
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the first number: ");
        String a = sc.next();
        System.out.print("Enter the second number: ");
        String b = sc.next();
        System.out.println("Binary addition result: " + addBinary(a,b));
        sc.close();
    }
}
