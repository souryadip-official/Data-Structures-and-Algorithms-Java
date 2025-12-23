import java.util.ArrayList;
import java.util.Scanner;
class Trie03 {
    class Node {
        Node[] children = new Node[26];
        boolean isEndOfWord = false;
        Node() {
            for (int i=0; i<26; i++)
                children[i] = null;
        }
    }
    public Node root = null;
    static int totalNodes = 1;
    Trie03() {
        root = new Node();
    }

    void insert(String str, Node root) {
        for (int i=0; i<str.length(); i++) {
            char ch = str.charAt(i);
            if (root.children[ch - 'a'] == null) {
                Node newNode = new Node();
                root.children[ch - 'a'] = newNode;
                totalNodes++;
            }
            root = root.children[ch - 'a'];
            if (i+1 == str.length()) {
                root.isEndOfWord = true;
            }
        }
        System.out.println(str + " inserted successfully!");
    }

}
public class UnqiueSubstring {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the word: ");
        String word = sc.next().toLowerCase();

        ArrayList<String> suffix = new ArrayList<>();
        for (int i=0; i<word.length(); i++) {
            suffix.add(word.substring(i));
        }
        Trie04 t = new Trie04();
        for (String s: suffix)
            t.insert(s, t.root);

        System.out.print("Total unique/distinct substring: " + Trie03.totalNodes);

    }
}
