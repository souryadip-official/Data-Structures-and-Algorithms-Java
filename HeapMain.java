import java.util.ArrayList;
import java.util.Random;

public class HeapMain {
    // Min Heap
    static class Heap {
        ArrayList<Integer> arr = new ArrayList<>();
        public void add(int data) {
            this.arr.add(data);
            int currNode = this.arr.size()-1;
            int parentNode = (currNode-1)/2;
            while(arr.get(parentNode) > arr.get(currNode)) {
                // condition for constructing a min heap
                int temp = arr.get(currNode);
                arr.set(currNode, arr.get(parentNode));
                arr.set(parentNode, temp);

                currNode = parentNode;
                parentNode = (currNode-1)/2;
            }
        }
        public boolean isEmpty() {
            return this.arr.size() == 0;
        }
        public int peek() {
            return this.arr.get(0);
        }
        private void heapify(int index) {
            int left = 2*index+1;
            int right = 2*index+2;
            int minIndex = index;
            int size = this.arr.size();
            if(left < size && arr.get(left) < arr.get(minIndex)) minIndex = left;
            if(right < size && arr.get(right) < arr.get(minIndex)) minIndex = right;
            if(minIndex != index) {
                int temp = arr.get(minIndex);
                arr.set(minIndex, arr.get(index));
                arr.set(index, temp);
                heapify(minIndex);
            }
        }
        public int remove() {
            int root = this.arr.get(0);
            arr.set(0, arr.get(arr.size()-1));
            arr.set(arr.size()-1, root);
            arr.remove(arr.size()-1);
            heapify(0);
            return root;
        }
    }
    public static void main(String[] args) {
        Heap heap = new Heap();
        for(int i = 0; i<10; i++) {
            Random r = new Random();
            int randomNum = r.nextInt(50);
            heap.add(randomNum);
            System.out.println("Current heap view: " + heap.arr);
        }

        while(!heap.isEmpty()) {
            System.out.println("Before delete: " + heap.arr);
            int ele = heap.remove();
            System.out.println("Deleted " + ele + "\nAfter delete: " + heap.arr);
        }
    }
}
