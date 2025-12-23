import java.util.Scanner;
public class KeypadCombinations {
    static int count = 0;
    public static void printCombinations(char[][] cmbns, String str, int idx, String res) {
        if(idx == str.length()) {
            System.out.println("Combination #" + (++count) + ": " + res);
            return;
        }
        char ch = str.charAt(idx);
        int dg = ch - '2';
        for(int j=0;j<cmbns[dg].length;j++)
            printCombinations(cmbns, str,idx+1,res+cmbns[dg][j]);
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the string sequence: ");
        String str = sc.next();
        if(str.indexOf('0') != -1 || str.indexOf('1') != -1) {
            System.out.println("Given string contains 0 or 1 which has no mapping!");
            return;
        } else if(str.isEmpty()) {
            System.out.println("\"\"");
            return;
        }
        /* If we want to completely ignore 0 and 1 */
        char[][] cmbns = {{'a','b','c'}, {'d','e','f'}, {'g','h','i'}, {'j','k','l'},
                {'m','n','o'}, {'p','q','r','s'}, {'t','u','v'}, {'w','x','y','z'}};
        printCombinations(cmbns, str,0, "");
        sc.close();
    }
}
