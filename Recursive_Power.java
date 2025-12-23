import java.util.Scanner;
public class Recursive_Power {
    public int rec_pow(int b, int p) {
        if(p == 0) return 1;
        return b * rec_pow(b,p-1);
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter base: ");
        int b = sc.nextInt();
        System.out.print("Enter +ve power: ");
        int p = sc.nextInt();
        if(p < 0) {
            System.out.println("Invalid +ve power!");
            return;
        }
        Recursive_Power obj = new Recursive_Power();
        System.out.println("Result: " + b + " ^ " + p + " = " + obj.rec_pow(b,p));
    }
}