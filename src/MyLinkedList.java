import java.util.LinkedList;

public class MyLinkedList<T> {

    private static class Node<T> {
        T data;
        Node<T> left;
        Node<T> right;

        public Node(T data,  Node<T> left, Node<T> right) {
            this.data = data;
            this.left = left;
            this.right = right;
        }
        public Node(T data) {
            this.data = data;
            this.left = null;
            this.right = null;
        }
        public Node() {
            this.data = null;
            this.left = null;
            this.right = null;
        }

    }

    Node<T> first;
    Node<T> last;
    int size;


    public MyLinkedList() {
        size = 0;
    }

    public boolean isEmpty() {return size == 0;}
    public int size() {return size;}
    Node<T> node(int index) {
        if (index < (size / 2)) {
            Node<T> x = first;
            for (int i = 0; i < index; i++)
                x = x.right;
            return x;
        } else {
            Node<T> x = last;
            for (int i = size - 1; i > index; i--)
                x = x.left;
            return x;
        }
    }
    public void add(int index, T value) {
        Node<T> succ = node(index);
        Node<T> pred = succ.left;
        Node<T> newNode = new Node<>(value, pred, succ);
        succ.left = newNode;
        if (pred == null)
            first = newNode;
        else
            pred.right = newNode;
        size++;
    }
    public void add(T value) {addLast(value);}
    public void addFirst(T data) {
        Node<T> f = first;
        Node<T> nf = new Node<>(data, null, f);
        first = nf;
        if (f == null)
            last = nf;
        else
            f.left = nf;
        size++;
    }
    public void addLast(T data) {
        Node<T> l = last;
        Node<T> nl = new Node<>(data, l, null);
        last = nl;
        if (l == null) {
            first = nl;
        } else {
            l.right = nl;
        }
        size++;
    }
    public T getFirst() {return first.data;}
    public T getLast() {return last.data;}
    public T get(int index) {return node(index).data;}

    public T peek(){return peekFirst();}
    public T peekFirst() {return first.data;}
    public T peekLast() {return last.data;}

    public T remove(){return removeFirst();}
    public T remove(int index){
        Node<T> x = node(index);
        T dd = x.data;
        Node<T> next = x.right;
        Node<T> prev = x.left;

        if (prev == null) {
            first = next;
        } else {
            prev.right = next;
            x.left = null;
        }

        if (next == null) {
            last = prev;
        } else {
            next.left = prev;
            x.right = null;
        }

        x.data = null;
        size--;
        return dd;
    }
    public T removeFirst() {
        T dd = first.data;
        Node<T> next = first.right;
        first.data = null;
        first.right = null;
        first = next;
        if (next == null)
            last = null;
        else
            next.left = null;
        size--;
        return dd;
    }
    public T removeLast() {return remove(size);}

    public Object[] toArray() {
        Object[] result = new Object[size];
        int i = 0;
        for (Node<T> x = first; x != null; x = x.right)
            result[i++] = x.data;
        return result;
    }

    public Node<T> getFirstO() {return first;}
    public Node<T> getLastO() {return last;}
    public Node<T> getO(int index) {return node(index);}


}
