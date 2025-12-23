import java.util.LinkedList;
import java.util.Scanner;
import java.util.Queue;
public class FirstNonRepeatingCharacter {
    public static String firstNonRepeatingChar(String str) {
        Queue<Character> q = new LinkedList<>();
        StringBuilder result = new StringBuilder();
        int[] charFreq = new int[26];
        for(int i=0; i<str.length(); i++) {
            q.add(str.charAt(i));
            charFreq[str.charAt(i)-'a']++;
            while(!q.isEmpty() && charFreq[q.peek()-'a'] != 1)
                q.remove();
            if(!q.isEmpty()) result.append(q.peek()).append(" ");
            else result.append("-1").append(" ");
        }
        return result.toString();
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the stream of characters: ");
        String str = sc.next();
        System.out.println("First non repeating character/letter in the given stream of characters: " + firstNonRepeatingChar(str));
        sc.close();
    }
}
