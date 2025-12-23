import java.util.Scanner;
public class Decreasing_Rec {
    public void print_dec(int n) {
        if(n == 1)
            System.out.println(n);
        else {
            System.out.print(n + " ");
            print_dec(n-1);
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the number: ");
        int n = sc.nextInt();
        Decreasing_Rec d = new Decreasing_Rec();
        if(n > 0) d.print_dec(n);
        else System.out.println("Invalid input!");
        sc.close();
    }
}
