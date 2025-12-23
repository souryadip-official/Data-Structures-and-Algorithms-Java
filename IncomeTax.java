import java.util.*;
public class IncomeTax {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the income: ");
        int income = sc.nextInt();
        float tax = 0.0f;
        if(income < 500000) {
            tax = 0.0f;
        } else if(income >= 500000 && income <= 1000000) {
            tax = (float) (20.0/100) * income;
        } else {
            tax = (float) (30.0/100) * income;
        }
        System.out.println("Net tax payable: Rs. "+ tax);
    }
}
