import java.util.*;
public class String01 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter word: ");
        String word = sc.next();
        System.out.println("Last character: " + word.charAt(word.length() - 1));
        for(int i=0; i<word.length();i++)
            System.out.println(word.charAt(i));
    }
}
