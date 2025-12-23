import java.util.Scanner;
public class Permutations {
    static int count = 0;
    public static void getPermutations(String str, int i, String res, String ite) {
        if(i == str.length()) {
            System.out.print(res + " ");
            count++;
            return;
        }
        for(int k=0;k<str.length();k++) {
            if(ite.indexOf(str.charAt(k)) == -1)
                getPermutations(str, i+1, res + str.charAt(k), ite+str.charAt(k));
        }
    }

    public static void getPermutations_optimised(String str, int i, String res, boolean[] visited) {
        if(i == str.length()) {
            System.out.print(res + " ");
            count++;
            return;
        }
        for(int k=0;k<str.length();k++) {
            if(!visited[k]) {
                visited[k] = true;
                getPermutations_optimised(str, i + 1, res + str.charAt(k), visited);
                visited[k] = false;
            }
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the string: ");
        String str = sc.next();
        boolean[] visited = new boolean[str.length()];
        getPermutations_optimised(str, 0, "", visited);
        System.out.println("\nCount = " + count); /* to check the count is n! */
        sc.close();
    }
}
