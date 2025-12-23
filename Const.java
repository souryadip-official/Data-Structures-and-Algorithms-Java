//public class Const {
//    public static void main(String[] args) {
//        C1 c = new C1();
//        C1.hero = "Hero";
//    }
//}
//class A1 {
//    A1() {
//        System.out.println("Constructor for A called!");
//    }
//}
//class B1 extends A1 {
//    B1() {
//        System.out.println("Constructor for B called!");
//    }
//}
//class C1 extends B1 {
//    static String hero;
//    C1() {
//        System.out.println("Constructor for C called!");
//    }
//}
/* OUTPUT:
Constructor for A called!
Constructor for B called!
Constructor for C called!   */
public class Const {
    Const() {
        System.out.println("Constructor called for Const!");
    }
    public static void main(String[] args) {
        Hero h = new Hero();
        h.action();
    }
}
class Hero extends Const {
    Hero() {
        System.out.println("Constructor called for Hero!");
    }
    public void action() {
        String[] arr = new String[2];
        arr[0] = "Hello";
        arr[1] = "Bye";
        Const.main(arr);
    }
}

/* WTF, LOL */