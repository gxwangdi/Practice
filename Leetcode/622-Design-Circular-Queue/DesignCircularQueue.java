
class MyCircularQueue {

    private final int[] a;
    private final int len;
    private int front = -1;
    private int rear = -1;

    public MyCircularQueue(int k) {
        len = k;
        a = new int[k];
    }

    public boolean enQueue(int value) {
        if (isFull()) {
            return false;
        }
        if (front == -1) {
            front = 0;
        }
        rear = (rear+1)%len;
        a[rear] = value;
        return true;
    }

    public boolean deQueue() {
        if (isEmpty()) {
            return false;
        }
        int result = a[front];
        if (front == rear) {
            front = rear = -1;
        } else {
            front = (front+1)%len;
        }
        return true;
    }

    public int Front() {
        if (isEmpty()) {
            return -1;
        }
        return a[front];
    }

    public int Rear() {
        if (isEmpty()) {
            return -1;
        }
        return a[rear];
    }

    public boolean isEmpty() {
        return front == -1;
    }

    public boolean isFull() {
        return (rear+1)%len == front;
    }
}

/**
 * Your MyCircularQueue object will be instantiated and called as such:
 * MyCircularQueue obj = new MyCircularQueue(k);
 * boolean param_1 = obj.enQueue(value);
 * boolean param_2 = obj.deQueue();
 * int param_3 = obj.Front();
 * int param_4 = obj.Rear();
 * boolean param_5 = obj.isEmpty();
 * boolean param_6 = obj.isFull();
 */
 
