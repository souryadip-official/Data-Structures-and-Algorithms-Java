import java.util.Scanner;
public class StringLengthRecursion {
    public int getLength(String str, int i) {
        try {
            char ch = str.charAt(i);
            return 1 + getLength(str, i+1);
        } catch(StringIndexOutOfBoundsException e) {
            return 0;
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the string: ");
        String str = sc.nextLine();
        StringLengthRecursion s = new StringLengthRecursion();
        System.out.println("Length of the string is: " + s.getLength(str, 0));
    }
}
