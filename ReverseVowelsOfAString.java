public class ReverseVowelsOfAString {
    public String reverseVowels(String s) {
        if (s.length() == 0) return "";
        boolean[] isVowel = new boolean[s.length()];
        StringBuilder vowel = new StringBuilder();
        for (int i=0; i<s.length(); i++) {
            char ch = s.charAt(i);
            if (ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u' || ch == 'A' || ch == 'E' || ch == 'I' || ch == 'O' || ch == 'U') {
                vowel.append(ch);
                isVowel[i] = true;
            }
        }

        StringBuilder res = new StringBuilder();
        vowel.reverse();
        int idx = 0;
        for (int i=0; i<s.length(); i++) {
            char ch = s.charAt(i);
            if (isVowel[i]) {
                res.append(vowel.charAt(idx++));
            } else {
                res.append(ch);
            }
        }
        return res.toString();
    }
}