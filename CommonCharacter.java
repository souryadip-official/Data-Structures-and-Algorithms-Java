import java.util.ArrayList;
import java.util.List;
public class CommonCharacter {
    public List<String> commonChars(String[] words) {
        int[] minCharCount = new int[26]; /* minCharCount[i] stores the minimum count of character 'a'+i across all words */
        for(int i=0; i<26; i++)
            minCharCount[i] = Integer.MAX_VALUE;

        for (int i=0; i<words.length; i++) {
            words[i] = words[i].toLowerCase();
            int[] localCharCount = new int[26];
            for(int j=0; j<words[i].length(); j++) {
                char currCh = words[i].charAt(j);
                localCharCount[currCh-'a']++;
            }
            for(int k=0; k<26; k++)
                minCharCount[k] = Math.min(minCharCount[k], localCharCount[k]); /* update minimum frequency across words */
        }
        List<String> res = new ArrayList<>();
        for(int i=0; i<26; i++) {
            for(int j=0; j<minCharCount[i]; j++) /* add character minCharCount[i] times */
                res.add((char)(i+'a') + "");
        }
        return res;
    }
}
