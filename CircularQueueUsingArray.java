class CircQueue {
    int[] arr;
    int maxSize, currSize;
    int front, rear;
    /* Rear stores the index of the cell where a new element is to be inserted. On the other hand, front stores the index of the cell from which the stored element is to be dequeued */
    CircQueue(int n) {
        arr = new int[n];
        maxSize = n;
        currSize = 0;
        front = rear = 0;
        for(int i=0; i<n; i++)
            arr[i] = -99999;
    }
    public boolean isEmpty() {
        if(currSize == 0) {
            front = rear = 0;
            return true;
        }
        return false;
    }
    public boolean isFull() {
        return currSize == maxSize;
    }
    public void enqueue(int data) {
        if(isFull()) {
            System.out.println("Queue is full! Failed to insert " + data);
            return;
        }
        this.arr[rear] = data;
        rear = (rear + 1) % this.maxSize;
        currSize++;
        System.out.println(data + " is enqueued successfully!");
    }
    public int dequeue() {
        if(isEmpty()) {
            System.out.println("Queue is empty!");
            return -99999;
        }
        int data = this.arr[front];
        this.arr[front] = -99999;
        front = (front + 1) % this.maxSize;
        currSize--;
        System.out.println(data + " is dequeued successfully!");
        return data;
    }
    public int peek() {
        if(isEmpty()) {
            System.out.println("Queue is empty!");
            return -99999;
        }
        int data = this.arr[front];
        System.out.println("Peek result: " + data);
        return data;
    }
    public int getFront() {
        if(!this.isEmpty())
            return this.arr[front];
        return -1;
    }
    public int getRear() {
        if(!this.isEmpty()) {
            if(this.rear == 0) return this.arr[maxSize-1];
            else return this.arr[rear-1];
            /* or simply write, return this.arr[(rear + maxSize - 1) % this.maxSize]; */
        }
        return -1;
        /* We had to move a position back because rear stores the index of an empty slot, basically the index where a new element is to be stored. So, to get the element stored last or basically the rearmost element, we need to move a position back. But, in case this.rear == 0, we cannot directly do this.arr[rear-1], hence we did a safety check */
    }
    public void display() {
        if(isEmpty()) {
            System.out.println("Queue is empty!");
            return;
        }
        System.out.print("Queue status: ");
        for(int ele: this.arr)
            System.out.print(ele + " ");
        System.out.println();
    }
}
public class CircularQueueUsingArray {
    public static void main(String[] args) {
        CircQueue cq = new CircQueue(5);
        for(int i=1; i<=5; i++) cq.enqueue(i);
        cq.display();
        for(int i=1; i<=3; i++) cq.dequeue();
        cq.display();
        for(int i=1; i<=2; i++) cq.enqueue(9+i);
        cq.display();
        cq.dequeue();
        cq.display();
        for(int i=1; i<=3; i++) cq.enqueue(11+i);
        cq.display();
        for(int i=0; i<=5; i++) cq.dequeue();
        for(int i=1; i<=5; i++) cq.enqueue(i);
        cq.display();
    }
}
