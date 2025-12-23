import java.util.Scanner;
public class StringComparison02 {
    public static String[] createArray() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter number of strings: ");
        return new String[sc.nextInt()];
    }
    public static void inputArray(String[] str) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter " + str.length + " words: ");
        for(int i=0;i<str.length;i++)
            str[i] = sc.next();
    }
    public static String printLargest(String[] str) {
        int i, k, n = str.length;
        boolean isChecking;
        String largest = str[0];
        for(i=1;i<n;i++) {
            k = 0;
            isChecking = true;
            int minLength = Math.min(str[i].length(), largest.length());
            while(isChecking) {
                System.out.println("First: " + str[i] + " Second: " + largest);
                int diff = (int) str[i].charAt(k) - (int) largest.charAt(k);
                if(diff == 0) {
                    if(k == str[i].length()-1 && k == largest.length()-1)
                        isChecking = false;
                    else {
                        k++;
                        if(k == minLength) {
                            if(str[i].length() != minLength) largest = str[i];
                            isChecking = false;
                        }
                    }
                }
                else if(diff > 0) {
                    largest = str[i];
                    isChecking = false;
                } else isChecking = false;
            }
        }
        return largest;
    }
    public static String printLargest1(String[] str) {
        String largest = str[0];
        for(int i=1;i<str.length;i++) {
            if(str[i].compareToIgnoreCase(largest) > 0)
                largest = str[i];
        }
        return largest;
    }
    public static void main(String[] args) {
        String[] str = createArray();
        inputArray(str);
        System.out.println("Largest: " + printLargest1(str));
        Integer a =  new Integer(10);
        System.out.println(a);
        Character ch = new Character('a');
    }
}
