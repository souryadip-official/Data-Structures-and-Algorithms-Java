import java.util.ArrayList;
public class ReverseWordsInAString {
    public static void reverseWordsUtil(String s, int i, int j, ArrayList<String> words) {
        StringBuilder temp = new StringBuilder();
        boolean firstBlank = true;
        while (i <= j) {
            char ch = s.charAt(i);
            if (ch == ' ') {
                if (firstBlank) {
                    words.add(temp.toString());
                    temp = new StringBuilder();
                    firstBlank = false;
                }
            }
            else { /* a character */
                firstBlank = true;
                temp.append(ch);
            }
            i++;
        }
        /* Appending the last word */
        words.add(temp.toString());
    }
    public String reverseWords(String s) {
        s = s.trim();
        ArrayList<String> words = new ArrayList<>();
        reverseWordsUtil(s, 0, s.length()-1, words);
        System.out.print(words);

        /* Now swapping from start to end */
        int start = 0, end = words.size()-1;
        while (start <= end) {
            String temp1 = words.get(start);
            String temp2 = words.get(end);
            words.set(end, temp1);
            words.set(start, temp2);
            start++;
            end--;
        }
        StringBuilder res = new StringBuilder();
        for (int i=0; i<words.size(); i++) {
            res.append(words.get(i));
            if (i+1 == words.size())
                break;
            else res.append(" ");
        }
        return res.toString();
    }
}