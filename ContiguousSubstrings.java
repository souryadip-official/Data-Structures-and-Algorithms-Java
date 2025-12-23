import java.util.Scanner;
public class ContiguousSubstrings {
    static int count = 0;
    public void getSubstrings(int start, int end, String str) {
        if (start >= str.length()) return;
        if (end >= str.length()) {
            getSubstrings(start+1, start+1, str);
            return;
        }
        if (str.charAt(start) == str.charAt(end)) {
            System.out.println(str.substring(start, end+1));
            count++;
        }
        getSubstrings(start, end+1, str);
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the string: ");
        ContiguousSubstrings c = new ContiguousSubstrings();
        String str = sc.next();
        c.getSubstrings(0, 0, str);
        System.out.println("Total substrings: " + count);
    }
}
