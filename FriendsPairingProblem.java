import java.util.Scanner;
public class FriendsPairingProblem {
    public int getWays(int n) {
        if(n == 1 || n == 2) return n;
        int a = getWays(n-1);
        /* Ways when a person remains single (no pair) */
        int b = (n-1) * getWays(n-2);
        /* Ways when a person pairs up with one of the n-1 friends */
        /* A person pair up with only one friend but that friend can be anyone in the given group. So, a single person has (n-1) choices or basically has n-1 friends to pair up with. Hence, multiplying the choice as n-1 */
        return (a+b);
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter number of friends (n): ");
        int n = sc.nextInt();
        FriendsPairingProblem f = new FriendsPairingProblem();
        System.out.println("Total arrangement: " + f.getWays(n));
    }
}
