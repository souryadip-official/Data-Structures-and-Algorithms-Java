import java.util.*;
public class ProductUsingFunction {
    public static int getProduct(int a, int b) {
        return (a * b);
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the first number: ");
        int num1 = sc.nextInt();
        System.out.print("Enter the second number: ");
        int num2 = sc.nextInt();
        int product = getProduct(num1, num2);
        System.out.println("The product calculated is: " + product);
    }
}
