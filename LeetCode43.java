import java.util.Scanner;
class LeetCode43 {
    public static String multiply(String num1, String num2) {
        if(num1.equals("0") || num2.equals("0")) return "0";
        StringBuilder fin_res = new StringBuilder();
        int mlen = Math.max(num1.length(), num2.length());
        String mxstr = "", mnstr = "";
        if(num1.length() == mlen) {
            mxstr = num1;
            mnstr = num2;
        }
        else {
            mxstr = num2;
            mnstr = num1;
        }
        int n1, n2, cy = 0, ip=0, i, j;
        StringBuilder res = new StringBuilder();
        for(i=mnstr.length()-1;i>=0;i--) {
            res = new StringBuilder();
            cy = 0;
            for(j=mxstr.length()-1;j>=0;j--) {
                n1 = mxstr.charAt(j) - '0';
                n2 = mnstr.charAt(i) - '0';
                ip = (n1 * n2) + cy;
                res.append(ip % 10);
                cy = ip / 10;
            }
            if(cy != 0) res.append(cy);
            res.reverse();
            if(i == mnstr.length()-1) {
                fin_res = new StringBuilder();
                fin_res.append(res);
            } else {
                StringBuilder adder = new StringBuilder();
                for(int k=0;k<mnstr.length()-1-i;k++) res.append("0");
                int lc = 0, ridx=res.length()-1, k;
                for(k=fin_res.length()-1;k >=0 ;k--) {
                    int c1 = fin_res.charAt(k) - '0';
                    int c2 = res.charAt(ridx--) - '0';
                    int add = (c1 + c2) + lc;
                    adder.append(add % 10);
                    lc = add / 10;
                }
                for(;ridx>=0;ridx--) {
                    int c = res.charAt(ridx) - '0';
                    int add = c + lc;
                    adder.append(add % 10);
                    lc = add/10;
                }
                if(lc != 0) adder.append(lc);
                fin_res = new StringBuilder();
                fin_res.append(adder.reverse());
            }
        }
        return fin_res.toString();
    }

    public static void main(String[] args) {
        /* Assuming, valid number (in form of strings) will be entered */
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the first number: ");
        String s1 = sc.next();
        System.out.print("Enter the second number: ");
        String s2 = sc.next();
        System.out.println("Multiplication Result: " + multiply(s1, s2));
        sc.close();
    }
}
