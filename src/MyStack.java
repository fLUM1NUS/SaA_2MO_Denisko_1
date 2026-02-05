public class MyStack<T> {

    MyNode<T> top;
    int len;

    public MyStack() {
        this.top = null;
        this.len = 0;
    }
    public MyStack(T value) {
        this.top = new MyNode<T>(value);
        this.len = 1;
    }

    public void push(T value) {
        MyNode<T> newTop = new MyNode<>(value);
        newTop.next = top;
        top = newTop;
        this.len++;
    }
    public boolean isEmpty() {return len == 0;}
    public T pop() {
        if (!isEmpty()) {
            T value = top.data;
            top = top.next;
            len--;
            return value;
        } else throw new RuntimeException("Stack is empty!");
    }
    public T peek() {
        if (!isEmpty()) {
            return top.data;
        } else throw new RuntimeException("Stack is empty!");
    }

    public String print() {
        MyStack<T> a = this;
        StringBuilder str = new StringBuilder("MyStack{\n");
        while (!a.isEmpty()) {
            str.append(a.pop()).append("\n");
        }
        str.append("}");
        return String.valueOf(str);
    }
}
