import java.util.Scanner;
class LeetCode12 {
    public static String intToRoman(int num) {
        StringBuilder res = new StringBuilder();
        while(num > 0) {
            if(num / 1000 > 0) {
                res.append('M');
                num -= 1000;
            } else if(num / 500 > 0) {
                if(num / 900 > 0) {
                    res.append("CM");
                    num -= 900;
                } else {
                    res.append('D');
                    num -= 500;
                }
            } else if(num / 100 > 0) {
                if(num / 400 > 0) {
                    res.append("CD");
                    num -= 400;
                } else {
                    res.append('C');
                    num -= 100;
                }
            } else if(num / 50 > 0) {
                if(num / 90 > 0) {
                    res.append("XC");
                    num -= 90;
                } else {
                    res.append('L');
                    num -= 50;
                }
            } else if(num / 10 > 0) {
                if(num / 40 > 0) {
                    res.append("XL");
                    num -= 40;
                } else {
                    res.append('X');
                    num -= 10;
                }
            } else if(num / 5 > 0) {
                if(num / 9 > 0) {
                    res.append("IX");
                    num -= 9;
                } else {
                    res.append('V');
                    num -= 5;
                }
            } else {
                if(num / 4 > 0) {
                    res.append("IV");
                    num -= 4;
                } else {
                    res.append('I');
                    num -= 1;
                }
            }
        }
        return res.toString();
    }

    public static void main(String[] args) {
        /* Assuming valid integer will be entered */
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the integer: ");
        int n = sc.nextInt();
        System.out.println("Equivalent roman: " + intToRoman(n));
        sc.close();
    }
} 