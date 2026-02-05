public class MyQueue<T> {

    MyNode<T> top, tail;
    int len;

    public MyQueue() {
        top = null; tail = null;
        len = 0;
    }
    public MyQueue(T data) {
        top = tail = new MyNode<>(data);
        len = 1;
    }

    boolean isEmpty() {return len <= 0;}

    void enqueue(T data) {
        MyNode<T> newNode = new MyNode<>(data);
        if (isEmpty()) {
            top = tail = newNode;
        } else {
            tail.next = newNode;
            tail = newNode;
        }
        len++;
    }

    T dequeue() {
        if (isEmpty()) throw new RuntimeException("Queue is empty");

        var val = top.data;
        top = top.next;
        if (top == null) tail = null;
        len --;

        return val;
    }

    T peek() {
        if (isEmpty()) throw new RuntimeException("Queue is empty");
        return top.data;
    }
}
