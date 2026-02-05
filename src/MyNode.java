public class MyNode<T> {

    T data;
    MyNode<T> next;

    public MyNode() {
        this.data = null;
        this.next = null;
    }
    public MyNode(T data) {
        this.data = data;
        this.next = null;
    }
}
