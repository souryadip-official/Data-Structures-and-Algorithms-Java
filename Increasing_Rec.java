import java.util.Scanner;
public class Increasing_Rec {
    public void print_inc(int n) {
        if(n == 1)
            System.out.print(n + " ");
        else {
            print_inc(n-1);
            System.out.print(n + " ");
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the number: ");
        int n = sc.nextInt();
        Increasing_Rec d = new Increasing_Rec();
        if(n > 0) d.print_inc(n);
        else System.out.println("Invalid input!");
        sc.close();
    }
}
