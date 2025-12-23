import java.util.*;
public class Pattern2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter number of lines: ");
        int lines = sc.nextInt(), i, j;
        char character = 'A';
        // charPrint will help print the characters
        if(lines <= 6) {
            for(i=1;i<=lines;i++) {
                for(j=1;j<=i;j++) {
                    System.out.print((character++) + " ");
                }
                System.out.println();
            }
        } else {
            System.out.println("Invalid number or insufficient characters to generate the pattern.");
        }
    }
}
