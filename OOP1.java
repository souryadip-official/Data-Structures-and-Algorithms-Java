class A {
    A() {
        System.out.println("Constructor called!");
    }
    @Override
    protected void finalize() {
        System.out.println("Destructor...Finalize executed");
    }
}
public class OOP1 {
    public static void main(String[] args) {
        for(int i=1;i<=100;i++) {
            A a1 = new A();
            System.gc(); /* explicitly demanding for a garbage collection without any surety that will it be satisfied or not */
        }
    }
}

