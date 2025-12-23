import java.util.ArrayList;
class Trie02 {
    class Node {
        Node[] children = new Node[26];
        boolean isEndOfWord = false;
        int count = 0;

        Node() {
            for (int i=0; i<26; i++)
                children[i] = null;
        }
    }
    public Node root = null;

    Trie02() {
        root = new Node();
    }

    void insert(String str, Node root) {
        for (int i=0; i<str.length(); i++) {
            char ch = str.charAt(i);
            if (root.children[ch - 'a'] == null) {
                Node newNode = new Node();
                newNode.count = 1;
                root.children[ch - 'a'] = newNode;
            } else {
                root.children[ch - 'a'].count++;
            }
            root = root.children[ch - 'a'];
            if (i+1 == str.length()) {
                root.isEndOfWord = true;
            }
        }
        System.out.println(str + " inserted successfully!");
    }

    String modifiedPrefixSearch(String str, Node root) {
        StringBuilder res = new StringBuilder();
        for(int i=0; i<str.length(); i++) {
            char ch = str.charAt(i);
            res.append(ch);
            if (root.children[ch - 'a'].count == 1) {
                return res.toString();
            }
            root = root.children[ch - 'a'];
        }
        return res.toString();
    }

    ArrayList<String> createPrefix(String[] words, Node root) {
        ArrayList<String> res = new ArrayList<>();
        for (int i=0; i<words.length; i++) {
            String word = words[i];
            res.add(modifiedPrefixSearch(word, root));
        }
        return res;
    }
}
public class TrieMain02 {
    public static void main(String[] args) {
        Trie02 t = new Trie02();
        String[] words = {"zebra", "dog", "duck", "dove", "zavier"};
        for (String word : words) {
            t.insert(word, t.root);
        }

        for (String word : words)
            System.out.print(word + " | ");
        System.out.println();
        ArrayList<String> prefixList = new ArrayList<>();
        prefixList = t.createPrefix(words, t.root);

        for (String prefix: prefixList)
            System.out.print(prefix + " | ");
    }
}
