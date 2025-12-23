import java.util.Scanner; class LeetCode567 {
    public static boolean getPms(String str, int i, String res, boolean[] visited, String cmpstr) {
        if(i == str.length()) {
            return cmpstr.contains(res);
        }
        for(int k=0;k<str.length();k++) {
            if(!visited[k]) {
                visited[k] = true;
                if(getPms(str, i+1, res + str.charAt(k), visited, cmpstr)) return true;
                visited[k] = false;
            }
        }
        return false;
    }
    public static boolean checkInclusion(String s1, String s2) {
        if(s1.length() > s2.length()) return false;
        boolean[] visited = new boolean[s1.length()];
        return getPms(s1, 0, "", visited, s2);
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the first string: ");
        String s1 = sc.next();
        System.out.print("Enter the second string: ");
        String s2 = sc.next();
        System.out.println("Result: " + checkInclusion(s1, s2));
        sc.close();
    }
}
/* Code for small strings: To be optimised later */