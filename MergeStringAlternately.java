public class MergeStringAlternately {
    public String mergeAlternately(String word1, String word2) {
        StringBuilder res = new StringBuilder();
        int i1=0, i2=0;
        while(i1 < word1.length() && i2 < word2.length()) {
            res.append(word1.charAt(i1));
            res.append(word2.charAt(i2));
            i1++;
            i2++;
        }
        /* After that, we copy the left-overs */
        while (i1 < word1.length()) {
            res.append(word1.charAt(i1));
            i1++;
        }
        while(i2 < word2.length()) {
            res.append(word2.charAt(i2));
            i2++;
        }
        return res.toString();
    }
}