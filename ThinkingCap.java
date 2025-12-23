class Thinker {
    String green, red;
    Thinker() {
        this.green = "Green";
        this.red = "Red";
    }
    void slots(String green, String red) {
        this.green = green;
        this.red = red;
    }
    void push_green() {
        System.out.println(green);
    }
    void push_red() {
        System.out.println(red);
    }
}
public class ThinkingCap {
    public static void main(String[] args) {
        Thinker obj = new Thinker();
        obj.slots("Hello", "Bye");
        obj.push_green();
        obj.push_red();
    }
}
