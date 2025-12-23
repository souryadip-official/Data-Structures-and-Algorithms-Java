import java.util.*;
public class PalindromeWord {
    public static boolean checkPalindrome(String str) {
        int i, n = str.length();
        for(i=0;i<n/2;i++)
            if(Character.toLowerCase(str.charAt(i)) != Character.toLowerCase(str.charAt(n-1-i)))
                return false;
        return true;
        /* Character.toLowrCase(#character) converts a character to lower case. We could have also converted each to upper case. The main motive is that, characters are compared logically and not by case */
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter word: ");
        String str = sc.next();
        boolean checkResult = checkPalindrome(str);
        System.out.println(checkResult? "Palindrome" : "Not Palindrome");
    }
}
