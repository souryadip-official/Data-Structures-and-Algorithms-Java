import java.util.Scanner;
public class PowerUsingBits {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter base: ");
        int a = sc.nextInt();
        System.out.print("Enter power: ");
        int n = sc.nextInt();
        int temp = n, ans = 1;
        while(temp > 0){
            if((temp & 1) == 1)
                ans = ans * a;
            a *= a;
            temp >>= 1;
        }
        System.out.println("Result: " + ans);
        sc.close();
    }
}
