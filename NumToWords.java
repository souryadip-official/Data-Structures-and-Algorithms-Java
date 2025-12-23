import java.util.InputMismatchException;
import java.util.Scanner;
public class NumToWords {
    public String convertToWords(String n, String[] word, int i, String str) {
        if(i == n.length()) return str;
        int currNum = Integer.parseInt(String.valueOf(n.charAt(i)));
        str += (word[currNum] + " ");
        return convertToWords(n, word, i+1, str);
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the number (Number must not be zero and must not end with zero): ");
        int n;
        try {
            n = sc.nextInt();
        } catch (InputMismatchException e) {
            System.out.println("Invalid argument!");
            return;
        }
        String n_str = Integer.toString(n);
        /* Although this code works fine even when the number entered is 0 or when the last digit is 0, but as it is asked in the question to avoid those number that is 0 or ends with zero, we will take this into account */
        if(n == 0 || (n_str.charAt(n_str.length()-1) == '0')) {
            System.out.println("Either the number is zero or the number ends with 0.");
            return;
        }
        String[] word = {"Zero", "One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine"};
        NumToWords obj = new NumToWords();
        System.out.println("In English: " + obj.convertToWords(Integer.toString(n), word, 0, ""));
        sc.close();
    }
}
