import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
public class CloneGraph {
    public static class Node {
        public int val;
        public List<Node> neighbors;
        public Node() {
            val = 0;
            neighbors = new ArrayList<>();
        }
        public Node(int _val) {
            val = _val;
            neighbors = new ArrayList<>();
        }
        public Node(int _val, ArrayList<Node> _neighbors) {
            val = _val;
            neighbors = _neighbors;
        }
    }
    public static Node cloneUtil(Node curr, HashMap<Node, Node> map) {
        Node newNode = new Node(curr.val, new ArrayList<>());
        map.put(curr, newNode);
        for (int i=0; i<curr.neighbors.size(); i++) {
            Node ngh = curr.neighbors.get(i);
            if (!map.containsKey(ngh)) {
                Node cloned = cloneUtil(ngh, map);
                newNode.neighbors.add(cloned);
                map.put(ngh, cloned);
            } else
                newNode.neighbors.add(map.get(ngh));
        }

        return newNode;
    }
    public Node cloneGraph(Node node) {
        if (node == null) return null;
        HashMap<Node, Node> map = new HashMap<>();
        return cloneUtil(node, map);
    }
}
