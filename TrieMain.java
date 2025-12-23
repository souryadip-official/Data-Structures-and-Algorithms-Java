import java.util.ArrayList;
class Trie {
    class Node {
        Node[] children = new Node[26];
        boolean isEndOfWord = false;

        Node() {
            for (int i=0; i<26; i++)
                children[i] = null;
        }
    }
    public Node root = null; // root node
    Trie() {
        root = new Node();
    }

    void insert(String str, Node root) { // O(L) where L is the length of the largest word
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

    boolean search(String str, Node root) { // O(L) where L is the length of the word to be searched
        for (int i=0; i<str.length(); i++) {
            char ch = str.charAt(i);
            if (root.children[ch - 'a'] == null) {
                return false;
            }
            root = root.children[ch - 'a'];
        }
        return root.isEndOfWord;
    }

    boolean wordBreak(String key, Node root) {
        if (key.isEmpty() || (key.length() == 1 && search(key, root)) || search(key, root)) {
            return true;
        }
        for (int i=1; i<key.length(); i++) { // i=1 because we will check for substrings till i (exclusive)
            if(search(key.substring(0, i), root) && wordBreak(key.substring(i), root)) {
                return true;
            }
        }
        return false;
    }
}
public class TrieMain {
    public static void main(String[] args) {
        Trie t = new Trie();
        String[] words = {"i", "like", "sam", "samsung", "mobile", "ice"};
        for (int i=0; i<words.length; i++) {
            t.insert(words[i], t.root);
        }
        System.out.println(t.search("any", t.root));
        System.out.println(t.wordBreak("ilikesamsung", t.root));
    }
}
