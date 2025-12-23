public class SwapUsingFunction {
    public static void swap(int a, int b) {
        System.out.println("Inside swap() function: ");
        System.out.println("Before swapping:\na = "+a+" & b = "+b);
        int temp = a;
        a = b;
        b = temp;
        System.out.println("After swapping:\na = "+a+" & b = "+b);
    }
    public static void main(String[] args) {
        int a = 5, b = 10;
        System.out.println("Before swapping:\na = "+a+" & b = "+b);
        swap(a, b);
        System.out.println("After swapping:\na = "+a+" & b = "+b);
        /* Here we can see that even after swapping the variables, the variables values remained unchanged. This is because, here we made "call by value". Go through theory notes to understand the same. */
    }
}
