import java.util.Scanner;
public class Capitalise {
    public static String capitaliseWords(String str) {
        StringBuilder sb = new StringBuilder();
        sb.append(Character.toUpperCase(str.charAt(0)));
        for(int i=1;i<str.length();i++) {
            if(str.charAt(i) == ' ' && i+1 < str.length()) {
                sb.append(' ');
                sb.append(Character.toUpperCase(str.charAt(i+1)));
                i++; /* since we have dealt with two characters */
            } else
                sb.append(str.charAt(i));
        }
        return sb.toString();
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a string: ");
        String str = (sc.nextLine()).trim();
        /* trim is a function which removes all leading and trailing spaces and returns a new string */
        System.out.println("String is: " + capitaliseWords(str));
    }
}
