import java.util.Scanner;
public class RemoveStringDuplicates {
    static StringBuilder res = new StringBuilder();
    public StringBuilder rmvDupl(String str, int i, boolean[] map) {
        boolean tmp = map[(char) str.charAt(i) - 'a'] == false;
        /* str.charAt(i) is wrapped with String.valueOf because this is how StringBuilder accepts a parameter for the function indexOf() */
        if(i == str.length()-1) {
            if(tmp){
                map[str.charAt(i) - 'a'] = true;
                return res.append(str.charAt(i));
            }
            return res;
        }
        if(tmp){
            map[str.charAt(i) - 'a'] = true;
            res.append(str.charAt(i));
        }
        return rmvDupl(str,i+1, map);
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the string: ");
        String str = sc.next();
        RemoveStringDuplicates r = new RemoveStringDuplicates();
        boolean[] map = new boolean[26];
        System.out.println("String after removing duplicates: " + r.rmvDupl(str,0, map));
    }
}