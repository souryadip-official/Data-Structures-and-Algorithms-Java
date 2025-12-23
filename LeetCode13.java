import java.util.Scanner;
class LeetCode13 {
    public static int equ(char x) {
        if(x == 'I') return 1;
        if(x == 'V') return 5;
        if(x == 'X') return 10;
        if(x == 'L') return 50;
        if(x == 'C') return 100;
        if(x == 'D') return 500;
        if(x == 'M') return 1000;
        else return -1;
    }
    public static int romanToInt(String s) {
        int ans = 0;
        if(s.length() == 1) return equ(s.charAt(0));
        for(int i=0;i<=s.length()-1;i++) {
            char ch = s.charAt(i);
            if(i+1 != s.length()) {
                char e = s.charAt(i+1);
                if(ch == 'I') {
                    if(e == 'V') {
                        ans += equ(e) - equ(ch);
                        i++;
                        continue;
                    } else if( e == 'X') {
                        ans += equ(e) - equ(ch);
                        i++;
                        continue;
                    }
                } else if(ch == 'X') {
                    if(e == 'L') {
                        ans += equ(e) - equ(ch);
                        i++;
                        continue;
                    } else if( e == 'C') {
                        ans += equ(e) - equ(ch);
                        i++;
                        continue;
                    }
                } else if(ch == 'C') {
                    if(e == 'D') {
                        ans += equ(e) - equ(ch);
                        i++;
                        continue;
                    } else if( e == 'M') {
                        ans += equ(e) - equ(ch);
                        i++;
                        continue;
                    }
                }
            }
            ans += equ(ch);
        }
        return ans;
    }

    public static void main(String[] args) {
        /* Assuming valid roman number will be entered */
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the roman number: ");
        String rNum = sc.next().toUpperCase();
        System.out.println("Equivalent integer: " + romanToInt(rNum));
        sc.close();
    }
}