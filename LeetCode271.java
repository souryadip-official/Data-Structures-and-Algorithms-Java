import java.util.ArrayList;
import java.util.List;
public class LeetCode271 {
    public static String encode(List<String> strs) {
        StringBuilder res = new StringBuilder();
        for (int i=0; i<strs.size(); i++) {
            String curr = strs.get(i);
            res.append(curr).append("~"); /* Using ~ symbol because it is comparatively less used */
        }
        return res.toString();
    }
    public static List<String> decode(String str) {
        List<String> res = new ArrayList<>();
        StringBuilder temp = new StringBuilder();
        for (int i=0; i<str.length(); i++) {
            char ch = str.charAt(i);
            if (ch == '~') {
                res.add(temp.toString());
                temp = new StringBuilder();
            } else {
                temp.append(ch);
            }
        }
        return res;
    }
    public static void main(String[] args) {
        /* Problem Statement: Encode and Decode Strings */
        List<String> ip = new ArrayList<>();
        ip.add("Hello");
        ip.add("World");
        String op = encode(ip);
        System.out.println(op);
        System.out.println(decode(op));
    }
}