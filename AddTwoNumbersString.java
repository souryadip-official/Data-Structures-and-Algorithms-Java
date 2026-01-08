public class AddTwoNumbersString {
    public String addStrings(String num1, String num2) {
        StringBuilder res = new StringBuilder();
        int carry = 0, sum = 0;
        int i1 = num1.length()-1, i2 = num2.length()-1;
        while (i1 >= 0 && i2 >= 0) {
            int n1 = num1.charAt(i1) - '0';
            int n2 = num2.charAt(i2) - '0';
            i1--;
            i2--;
            sum = n1 + n2 + carry;
            if (sum >= 10) {
                sum = sum - 10;
                carry = 1;
            } else carry = 0;
            res.append(sum);
            sum = 0;
        }
        while (i1 >= 0) {
            int n1 = num1.charAt(i1) - '0';
            i1--;
            sum = n1 + carry;
            if (sum >= 10) {
                sum = sum - 10;
                carry = 1;
            } else carry = 0;
            res.append(sum);
            sum = 0;
        }
        while (i2 >= 0) {
            int n2 = num2.charAt(i2) - '0';
            i2--;
            sum = n2 + carry;
            if (sum >= 10) {
                sum = sum - 10;
                carry = 1;
            } else carry = 0;
            res.append(sum);
            sum = 0;
        }
        if (carry == 1) res.append(1);
        return res.reverse().toString();
    }
}