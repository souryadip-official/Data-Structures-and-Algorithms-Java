public class LeetCode14 {
    public String longestCommonPrefix(String[] strs) {
        if(strs == null || strs.length == 0) return "";
        StringBuilder pr = new StringBuilder();
        boolean isPrefix = true;
        for(int i=0; i<strs[0].length(); i++) {
            isPrefix = true;
            char ch = strs[0].charAt(i);
            for(int j=0; j<strs.length; j++) {
                if(i >= strs[j].length())
                    return pr.toString();
                if(strs[j].charAt(i) != ch) isPrefix = false;
            }
            if(!isPrefix) return pr.toString();
            pr.append(ch);
        }
        return pr.toString();
    }
    public static void main(String[] args) {
        LeetCode14 sol = new LeetCode14();
        String[] strs = {"flower", "flow", "flight"};
        String result = sol.longestCommonPrefix(strs);
        System.out.println("Longest Common Prefix: " + result);
    }
}