import java.util.HashMap;
public class CopyListWithRandomPointer {
    public static class Node {
        int val;
        Node next;
        Node random;

        public Node(int val) {
            this.val = val;
            this.next = null;
            this.random = null;
        }
    }

    public static Node copyRandomList(Node head) {
        HashMap<Node, Node> map = new HashMap<>();
        Node temp = head;
        Node newHead = null;
        Node tail = null;
        while (temp != null) {
            Node newNode = null;
            if (map.containsKey(temp))
                newNode = map.get(temp);
            else {
                newNode = new Node(temp.val);
                map.put(temp, newNode);
            }

            if (newHead == null) {
                newHead = tail = newNode;
                if (temp.random == null)
                    newNode.random = null;
                else {
                    Node ans = map.getOrDefault(temp.random, null);
                    if (ans == null) {
                        /* It points to a node that is not being created yet */
                        Node futureNode = new Node(temp.random.val);
                        newNode.random = futureNode;
                        map.put(temp.random, futureNode);
                    } else {
                        newNode.random = ans;
                    }
                }
            } else {
                tail.next = newNode;
                tail = tail.next;
                if (temp.random == null)
                    newNode.random = null;
                else {
                    Node ans = map.getOrDefault(temp.random, null);
                    if (ans == null) {
                        Node futureNode = new Node(temp.random.val);
                        newNode.random = futureNode;
                        map.put(temp.random, futureNode);
                    } else {
                        newNode.random = ans;
                    }
                }
            }

            temp = temp.next;
        }
        return newHead;
    }
}
