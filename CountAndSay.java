public class CountAndSay {
    public void countAndSayUtil(int curr, int n, StringBuilder str) {
        if (curr == 0) return;
        if (curr == 1) str.append("1"); /* base case */
        if (curr == n) return;
        else {
            char prev = str.charAt(0);
            int count = 1;
            StringBuilder tempstr = new StringBuilder();
            for(int i = 1; i< str.length(); i++) {
                char ch = str.charAt(i);
                if (ch == prev) count++;
                else {
                    tempstr.append(count).append(prev);
                    prev = ch;
                    count = 1;
                }
            }
            tempstr.append(count).append(prev);
            str.setLength(0); /* We cannot use str = new StringBuilder(temp) here because, this will make the str a new StringBuilder, thereby losing the reference of the StringBuilder with which we were working from the beginning. This is why we set the length of str 0 thereby making it as an empty StringBuilder and then appending whatever result is stored in tempstr */
            str.append(tempstr);
        }
        countAndSayUtil(curr+1, n, str);
    }
    public String countAndSay(int n) {
        StringBuilder s = new StringBuilder();
        countAndSayUtil(1, n, s);
        return s.toString();
    }
}