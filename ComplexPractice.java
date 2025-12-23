import java.util.Scanner;
public class ComplexPractice {
    public static void main(String[] args) {
        Complex1 a = new Complex1();
        Complex1 b = new Complex1();
        a.input();
        a.display();
        b.input();
        b.display();
        Complex1 res = new Complex1();
        res = res.add(a,b);
        res.display();
        res = res.difference(a,b);
        res.display();
        res = res.product(a,b);
        res.display();
    }
}
class Complex1 {
    private int real, imaginary;
    /* These parameters cannot be accessed using any object declared in main()
       Although it can be accessed by an object under the scope of this class (Complex1) */
    Complex1() {
        this.real = this.imaginary = 0;
    }
    void input() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter real and imaginary part of the number: ");
        this.real = sc.nextInt();
        this.imaginary = sc.nextInt();
    }
    Complex1 add(Complex1 a, Complex1 b) {
        Complex1 temp = new Complex1();
        temp.real = a.real + b.real;
        temp.imaginary = a.imaginary + b.imaginary;
        return temp;
    }
    Complex1 difference(Complex1 a, Complex1 b) {
        Complex1 temp = new Complex1();
        temp.real = a.real - b.real;
        temp.imaginary = a.imaginary - b.imaginary;
        return temp;
    }
    Complex1 product(Complex1 a, Complex1 b) {
        Complex1 temp = new Complex1();
        temp.real = (a.real * b.real) - (a.imaginary * b.imaginary);
        temp.imaginary = (a.real * b.imaginary) + (a.imaginary * b.real);
        return temp;
    }
    void display() {
        System.out.println("Number: " + this.real + " + " + this.imaginary + "i");
    }
}