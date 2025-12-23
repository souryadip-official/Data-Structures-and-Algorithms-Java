class Queue {
    int[] arr;
    int size;
    int rear;
    Queue(int n) {
        arr = new int[n];
        for(int i=0; i<n; i++)
            arr[i] = -99999;
        size = n;
        rear = -1;
    }
    public void display() {
        for(int ele : this.arr)
            System.out.print(ele + " ");
        System.out.println();
    }
    public boolean isEmpty() {
        return rear == -1;
    }
    public void enqueue(int val) {
        if(this.rear == this.size - 1) {
            System.out.println("Queue is full!");
            return;
        }
        this.arr[++rear] = val;
        System.out.println(val + " is successfully enqueued!");
    }

    public int dequeue() {
        if(this.isEmpty()) return -1;
        int ele = this.arr[0];
        int i;
        for(i=0; i<rear; i++)
            this.arr[i] = this.arr[i+1];
        this.arr[i] = -99999;
        rear--;
        System.out.println(ele + " is dequeued successfully!");
        return ele;
    }

    public int peek() {
        if(this.isEmpty()) return -1;
        return this.arr[0];
    }
}
public class QueueUsingArray {
    public static void main(String[] args) {
        Queue q = new Queue(5);
        q.enqueue(5);
        q.display();
        System.out.println("Peek result: " + q.peek());
        q.dequeue();
        q.display();
    }
}
