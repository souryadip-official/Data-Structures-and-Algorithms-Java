import java.util.ArrayList;
import java.util.LinkedList;

public class HashMapScratchImplementation {
    public static class HashMap<T1, T2> { // T1 and T2 are type parameters called as generics
        private class Node {
            T1 key;
            T2 value;
            Node(T1 k, T2 v) {
                this.key = k;
                this.value = v;
            }
        }
        private final double load_factor = 0.75; /* 0.75 is a standard design choice */
        private int size = 0; /* to track the size of the hashmap (number of key-value pairs) */
        private LinkedList<Node>[] buckets; /* Bucket to store the key-value pairs. With the .length property we can track the bucket size */

        /* To ensure that code runs smoothly without explicitly requiring to mention the type of the array (may or may not require all versions) */
        @SuppressWarnings("unchecked")
        public HashMap() {
            this.size = 0; /* To track the number of key-value pairs in the buckets */
            this.buckets = new LinkedList[16]; /* Creating a 16-sized bucket */
            for (int i=0; i< buckets.length; i++)
                this.buckets[i] = new LinkedList<>(); /* Initializing an empty linked list at every index */
        }

        private int hashFunc(T1 key) {
            int hashcode = key.hashCode(); /* This will perform hashing on the key and will return the hashed value */
            hashcode = Math.abs(hashcode); /* to properly handle negative hashcode */
            return hashcode % (this.buckets.length); /* To keep the hashed value in range of the bucket (0...buckets.length-1) */
        }

        private int find_data(T1 key, int bucket_idx) {
            LinkedList<Node> list = this.buckets[bucket_idx];
            for (int i=0; i<list.size(); i++) {
                Node curr = list.get(i);
                if (curr.key.equals(key)) return i;
                /* equals() correctly compares logical equality for objects (unlike == which compares references), provided the class properly overrides equals() and hashCode(). If a.equals(b) is true, then, a.hashCode() == b.hashCode() */
            }
            return -1;
        }

        private void remove_data(int bucket_idx, int data_idx) {
            LinkedList<Node> list = this.buckets[bucket_idx];
            list.remove(data_idx);
        }

        @SuppressWarnings("unchecked")
        private void rehash() {
            int newLength = this.buckets.length * 2;
            ArrayList<Node> nodes = new ArrayList<>();
            for (int i=0; i<this.buckets.length; i++) {
                LinkedList<Node> list = this.buckets[i];
                nodes.addAll(list); /* This will add all the nodes in the list all at once directly to the nodes arraylist */
            }
            this.buckets = null;
            /* Java Garbage Collector will automatically collect these leftovers */
            this.buckets = new LinkedList[newLength];
            this.size = 0;
            for (int i=0; i< buckets.length; i++)
                this.buckets[i] = new LinkedList<>();
            for (Node n: nodes) put(n.key, n.value);
        }

        public void put(T1 key, T2 value) {
            if ((double) (this.size + 1) / this.buckets.length > load_factor)
                /* We have exceeded the load factor and now we must rehash. Also, we wrote this.size+1 because it means whether the load_factor is affected by adding this new key */
                rehash();
            int bucket_idx = hashFunc(key);
            int data_idx = find_data(key, bucket_idx); /* If the key already exists, a valid index will be returned. If it does not exist, we will get -1 */
            if (data_idx == -1) { // not found
                this.buckets[bucket_idx].add(new Node(key, value));
                this.size++;
            }
            else { // found
                Node data = this.buckets[bucket_idx].get(data_idx);
                data.value = value;
            }
        }

        public boolean containsKey(T1 key) {
            int bucket_idx = hashFunc(key);
            int data_idx = find_data(key, bucket_idx);
            return data_idx != -1;
        }

        public T2 get(T1 key) {
            int bucket_idx = hashFunc(key);
            int data_idx = find_data(key, bucket_idx);
            if (data_idx == -1) return null;
            return this.buckets[bucket_idx].get(data_idx).value;
        }

        public T2 remove(T1 key) {
            int bucket_idx = hashFunc(key);
            int data_idx = find_data(key, bucket_idx);
            if (data_idx == -1) return null;
            T2 data = this.buckets[bucket_idx].get(data_idx).value;
            remove_data(bucket_idx, data_idx);
            this.size--;
            return data;
        }
        @Override
        public String toString() {
            StringBuilder str = new StringBuilder();
            str.append("{");
            for(int i=0; i<this.buckets.length; i++) {
                LinkedList<Node> list = this.buckets[i];
                for (int j=0; j<list.size(); j++) {
                    Node n = list.get(j);
                    str.append(n.key).append(" = ").append(n.value);
                    if (j+1 != list.size()) // this was not the last element
                        str.append(", ");
                }
            }
            str.append("}");
            return str.toString();
        }
    }

    public static void main(String[] args) {
        HashMap<String, Integer> hm = new HashMap<>();
        hm.put("India", 150);
        hm.put("China", 60);
        System.out.println(hm);
    }
}
