import java.util.*;
public class SkipMultiplesOf10 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n;
        while(true) {
            System.out.print("Enter a number: ");
            n = sc.nextInt();
            if(n % 10 == 0) {
                continue;
            }
            System.out.println("You have entered: " + n);
        }
    }
}
