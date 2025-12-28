import java.util.LinkedList;
import java.util.ArrayList;
public class MyHashSet {
    private class Node {
        int key;
        Node(int k) {
            this.key = k;
        }
    }
    private final double load_factor = 0.75;
    private int size = 0;
    private LinkedList<Node>[] buckets;
    public MyHashSet() {
        this.size = 0;
        this.buckets = new LinkedList[16];
        for (int i=0; i< buckets.length; i++)
            this.buckets[i] = new LinkedList<>();
    }

    private int hashFunc(int key) {
        int hashcode = Integer.hashCode(key);
        hashcode = Math.abs(hashcode);
        return hashcode % (this.buckets.length);
    }

    private int find_data(int key, int bucket_idx) {
        LinkedList<Node> list = this.buckets[bucket_idx];
        for (int i=0; i<list.size(); i++) {
            Node curr = list.get(i);
            if (curr.key == key) return i;
        }
        return -1;
    }

    private void remove_data(int bucket_idx, int data_idx) {
        LinkedList<Node> list = this.buckets[bucket_idx];
        list.remove(data_idx);
    }

    private void rehash() {
        int newLength = this.buckets.length * 2;
        ArrayList<Node> nodes = new ArrayList<>();
        for (int i=0; i<this.buckets.length; i++) {
            LinkedList<Node> list = this.buckets[i];
            nodes.addAll(list);
        }
        this.buckets = null;
        this.buckets = new LinkedList[newLength];
        this.size = 0;
        for (int i=0; i< buckets.length; i++)
            this.buckets[i] = new LinkedList<>();
        for (Node n: nodes) add(n.key);
    }

    public void add(int key) {
        if ((double) (this.size + 1) / this.buckets.length > load_factor) rehash();
        int bucket_idx = hashFunc(key);
        int data_idx = find_data(key, bucket_idx);
        if (data_idx == -1) {
            this.buckets[bucket_idx].add(new Node(key));
            this.size++;
        }
    }

    public void remove(int key) {
        int bucket_idx = hashFunc(key);
        int data_idx = find_data(key, bucket_idx);
        if (data_idx == -1) return;
        remove_data(bucket_idx, data_idx);
        this.size--;
        return;
    }

    public boolean contains(int key) {
        int bucket_idx = hashFunc(key);
        int data_idx = find_data(key, bucket_idx);
        return data_idx != -1;
    }
}
