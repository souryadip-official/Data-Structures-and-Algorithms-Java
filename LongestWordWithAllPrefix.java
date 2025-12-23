import java.util.ArrayList;
import java.util.Scanner;
import java.util.Stack;

class Trie04 {
    class Node {
        Node[] children = new Node[26];
        boolean isEndOfWord = false;
        Node() {
            for (int i=0; i<26; i++)
                children[i] = null;
        }
    }
    public Node root = null;
    Trie04() {
        root = new Node();
    }

    void insert(String str, Node root) {
        for (int i=0; i<str.length(); i++) {
            char ch = str.charAt(i);
            if (root.children[ch - 'a'] == null) {
                Node newNode = new Node();
                root.children[ch - 'a'] = newNode;
            }
            root = root.children[ch - 'a'];
            if (i+1 == str.length()) {
                root.isEndOfWord = true;
            }
        }
        System.out.println(str + " inserted successfully!");
    }

    static StringBuilder longestWordWithAllPrefix = new StringBuilder();
    void longestWord(StringBuilder temp, Node root) {
        if (root == null) return;
        for (int i=0; i<root.children.length; i++) {
            if (root.children[i] != null && root.children[i].isEndOfWord) {
                temp.append((char)(i+'a'));
                if (temp.length() > longestWordWithAllPrefix.length()) {
                    // strictly greater than condition also ensures lexicographical selection
                    longestWordWithAllPrefix = new StringBuilder(temp.toString());
                }
                longestWord(temp, root.children[i]);
                temp.deleteCharAt(temp.length()-1);
            }
        }
    }
}
public class LongestWordWithAllPrefix {
    public static void main(String[] args) {
        String[] words = {"a", "banana", "app", "appl", "ap", "apply", "apple"};
        Trie04 t = new Trie04();
        for (String word: words)
            t.insert(word, t.root);

        t.longestWord(new StringBuilder(), t.root);
        System.out.print("Longest word with all prefixes: " + Trie04.longestWordWithAllPrefix);
    }
}
