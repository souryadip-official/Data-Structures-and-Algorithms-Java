import java.util.*;
class Complex {
    int real, imag;
    Complex() {
        this.real = this.imag = 0;
    }
    void input() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the real part: ");
        this.real = sc.nextInt();
        System.out.print("Enter the imaginary part: ");
        this.imag = sc.nextInt();
    }
    void display() {
        System.out.println("Complex number is: " + real + " + " + imag + "i\n");
    }
    void add(Complex c) {
        this.real += c.real;
        this.imag += c.imag;
    }
}
public class ComplexMain {
    public static void main(String[] args) {
        Complex c1 = new Complex();
        Complex c2 = new Complex();
        c1.input(); c1.display();
        c2.input(); c2.display();
        c1.add(c2);
        System.out.println("After addition:");c1.display();
    }
}
