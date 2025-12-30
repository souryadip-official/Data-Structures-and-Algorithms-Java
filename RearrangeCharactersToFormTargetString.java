import java.util.HashMap;
public class RearrangeCharactersToFormTargetString {
    public int rearrangeCharacters(String s, String target) {
        /* Lowercasing both the strings */
        s = s.toLowerCase();
        target = target.toLowerCase();
        /* Counting the frequency and the unique characters of the target string */
        int[] freq = new int[26];
        int uq = 0;
        for (int i=0; i<target.length(); i++)
            freq[target.charAt(i)-'a']++;
        for(int cell: freq)
            if(cell != 0)
                uq++;
        /* Now finding the occurrence count of the characters to find the target string */
        HashMap<Character, Integer> map = new HashMap<>();
        for (int i=0; i<s.length(); i++) {
            char ch = s.charAt(i);
            if (freq[ch-'a'] > 0) /* this ensures that this character is a part of the target because the frequency of it in the freq array for the target string is greater than 0 */
                map.put(ch, map.getOrDefault(ch, 0) + 1);
        }
        if (map.size() == uq) {
            int res = Integer.MAX_VALUE;
            for (char k : map.keySet())
                res = Math.min(res, map.get(k) / freq[k-'a']);
            return res;
        }
        else return 0;
    }
}