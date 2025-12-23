import java.util.Scanner;
public class StringComparisons01 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter string: ");
        String str = sc.nextLine();
        System.out.print("Enter starting and ending indices: ");
        int s = sc.nextInt();
        int e = sc.nextInt();
        if((s >= 0 && s <= str.length()-1) && (e >=0 && e <=str.length()-1) && (s <= e))
            System.out.println("Substring: " + str.substring(s, e));
        else
            System.out.println("Invalid indices!");
    }
}
