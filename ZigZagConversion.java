import java.util.ArrayList;
public class ZigZagConversion {
    public String convert(String s, int numRows) {
        if (numRows == 1) return s; /* Edge case for the situation where we have only one row */
        ArrayList<Character>[] arr = new ArrayList[numRows];
        for(int i=0; i<numRows; i++)
            arr[i] = new ArrayList<>();

        int idx = 0, dir = 0; /* dir=0 for down, dir=1 for up */
        for(int i=0; i<s.length(); i++) {
            char ch = s.charAt(i);
            arr[idx].add(ch);
            if (idx == 0 && idx+1 < numRows) {
                /* We are at the first barrier */
                dir = 0;
                idx++;
            } else if (idx == numRows-1 && idx-1 >= 0) {
                /* We are at the last barrier */
                dir = 1;
                idx--;
            } else {
                if (dir == 0) idx++;
                else idx--;
            }
        }
        StringBuilder res = new StringBuilder();
        for(int i=0; i<numRows; i++)
            for(char ch: arr[i])
                res.append(ch);
        return res.toString();
    }
}