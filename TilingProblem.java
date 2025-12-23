import java.util.Scanner;
public class TilingProblem {
    public int getWays(int n, String path) {
        if(n == 0) {
            if(path.isEmpty())
                /* isEmpty() is a string function that checks whether a string is empty or not */
                System.out.println("No tile placed horizontally or vertically\n");
            else
                System.out.println(path + "\n");
            return 1;
        } else if(n == 1) {
            System.out.println(path + "1 tile placed vertically\n");
            return 1;
        }
        String temp = path;
        int a,b;
        {
            temp += ("1 tile placed vertically\n");
            a = getWays(n-1, temp);
        }
        /* In each block, a local temp will be created */
        {
            temp += ("2 tiles placed horizontally one over another\n");
            b = getWays(n-2, temp);
        }
        return (a + b);
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the value of 'n' for 2*n floor: ");
        int n = sc.nextInt();
        TilingProblem t = new TilingProblem();
        System.out.println("Following are the ways adopted from left to right: ");
        System.out.println("Total ways: " + t.getWays(n, ""));
    }
}
