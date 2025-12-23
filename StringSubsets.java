import java.util.Scanner;
public class StringSubsets {
    /**
     * This function takes a string, a starting index and an empty string as arguments and prints all the subsets of a given string.
     * @param str: The original string.
     * @param i: The starting index.
     * @param res: The empty string.
     */
    public static void printSubsets(String str, int i, String res) {
        if(i == str.length()) {
            if(res.isEmpty()) {
                System.out.println("\"\" (Empty string)");
                return;
            }
            System.out.print("\"" + res + "\"" + ", ");
            return;
        }

        /* taking the character as a part of the substring */
        printSubsets(str, i+1, res+str.charAt(i));
        /* not taking the character as a part of the substring */
        printSubsets(str, i+1, res);
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the string: ");
        String str = sc.next();
        System.out.print("The subsets are: ");
        printSubsets(str, 0, "");
        sc.close();
    }
}
