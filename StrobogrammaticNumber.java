public class StrobogrammaticNumber {
    public static boolean checkStrobogrammatic(int num) {
        String snum = String.valueOf(num);
        StringBuilder res = new StringBuilder();
        for (int i=0; i<snum.length(); i++) {
            char ch = snum.charAt(i);
            if (ch == '6')
                res.append('9');
            else if (ch == '9')
                res.append('6');
            else if (ch == '0' || ch == '8' || ch == '1')
                res.append(ch);
            else return false; /* It is not even a valid digit. If a number contains digits except the handled digits, then it is definitely not a strobogrammatic number */
        }
        return snum.contentEquals(res.reverse()); /* Similar to equals but checks the character sequence ignoring the data type */
    }
    public static void main(String[] args) {
        int num = 986;
        System.out.println(num + " " + checkStrobogrammatic(num));
    }
}
