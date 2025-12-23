import java.util.Stack;
import java.util.Scanner;
public class StringReverseUsingStack {
    public static String reverse(String str) {
        Stack<Character> s = new Stack<>();
        for(int i=0; i<str.length(); i++) s.push(str.charAt(i));
        StringBuilder rev = new StringBuilder();
        while(!s.isEmpty()) rev.append(s.pop());
        System.out.println(Character.toLowerCase('0'));
        return rev.toString();
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the string you want to reverse: ");
        String str = sc.nextLine();
        System.out.println("Reverse of " + str + " is: " + reverse(str));
        sc.close();
    }
}
