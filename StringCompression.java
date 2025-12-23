import java.util.Scanner;
public class StringCompression {
    public static String compress(String str) {
        StringBuilder sb = new StringBuilder();
        int i, j, count, n=str.length();
        boolean isRepeating;
        for(i=0;i<n;) {
            char ch = str.charAt(i);
            j = i+1; count = 1; isRepeating = true;
            while(isRepeating && j < str.length()) {
                if(str.charAt(j) != ch)
                    isRepeating = false;
                else {
                    count++;
                    j++;
                }
            }
            sb.append(ch);
            if(count > 1) {
                sb.append(count);
                i += (j-i);
            } else i++;
        }
        return sb.toString();
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a string: ");
        String str = sc.nextLine();
        System.out.println("Compressed String: " + compress(str));
    }
}
