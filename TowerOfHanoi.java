import java.util.Scanner;
public class TowerOfHanoi {
    public void printSolution(int n, String s, String a, String d) {
        if(n == 1) {
            System.out.println(s + " -> " + d);
            return;
        }
        printSolution(n-1, s, d, a);
        System.out.println(s + " -> " + d);
        printSolution(n-1, a, s, d);
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter number of disks (n): ");
        int n = sc.nextInt();
        TowerOfHanoi t = new TowerOfHanoi();
        t.printSolution(n, "Source", "Auxiliary", "Destination");
        sc.close();
    }
}
