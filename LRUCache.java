import java.util.HashMap;
public class LRUCache {
    public static class Node {
        int key;
        int val;
        Node prev;
        Node next;
        Node (int k, int v) {
            this.key = k;
            this.val = v;
            this.prev = null;
            this.next = null;
        }
    }
    private int maxCapacity; /* to track the maximum capacity of the LRU cache */
    private int size; /* to track the current size of the LRU Cache */
    HashMap<Integer, Node> map; /* to ensure O(1) operations */
    Node head, tail; /* to track the head and the tail of the doubly linked list */

    public LRUCache(int capacity) {
        this.size = 0;
        this.maxCapacity = capacity;
        this.map = new HashMap<>();
        this.head = this.tail = null;
    }

    public int get(int key) {
        if (this.map.containsKey(key)) {
            Node ans = this.map.get(key);
            int val = ans.val;
            if (ans == head || this.size == 1)
                return val; /* no shifting is required as the most recently used item is accessed */
            else if (ans == tail) {
                this.tail.prev.next = null;
                this.tail = this.tail.prev;
                ans.prev = null;
                ans.next = this.head;
                this.head.prev = ans;
                this.head = ans;
            } else {
                /* the queried node is somewhere in the middle */
                ans.prev.next = ans.next;
                ans.next.prev = ans.prev;
                ans.prev = null;
                ans.next = this.head;
                this.head.prev = ans;
                this.head = ans;
            }
            return val;
        }
        return -1; /* the key is not present */
    }

    public void put(int key, int value) {
        int val = this.get(key);
        if (val == -1) {
            /* the key is not present */
            if (this.size == this.maxCapacity) {
                if (this.size == 1) {
                    this.map.remove(this.head.key);
                    this.head = this.tail = null;
                } else {
                    this.map.remove(this.tail.key);
                    this.tail.prev.next = null;
                    this.tail = this.tail.prev;
                }
                this.size--;
            }
            Node newNode = new Node(key, value);
            if (this.head == null)
                this.head = this.tail = newNode;
            else {
                newNode.next = this.head;
                this.head.prev = newNode;
                this.head = newNode;
            }
            this.map.put(key, newNode);
            this.size++;
        } else {
            /* If we are here, it means that the key was already present and since the "get" function shifts the recently used to the front of the linked list, hence the node is already brought to the front and is marked as the most recently used. Our task is just to update the value now. */
            Node ans = this.map.get(key);
            ans.val = value;
        }
    }
}
