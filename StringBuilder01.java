import java.util.Scanner;
public class StringBuilder01 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();
        for(char c='a';c<='z';c++)
            sb.append(c);
        System.out.println("StringBuilder: " + sb);
    }
}
