//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
void main() {
    MyQueue<Integer> q = new MyQueue<>();
    q.enqueue(1);
    q.enqueue(2);
    q.enqueue(3);
    q.enqueue(4);

    for (int i = 0; i < 3; i++) {
        System.out.println(q.dequeue());
    }
    System.out.println(q.peek());
    System.out.println(q.dequeue());
    q.enqueue(5);
    q.enqueue(6);
    System.out.println(q.dequeue());
    q.enqueue(7);
    while (q.len != 0) {
        System.out.println(q.dequeue());
    }

    System.out.println("try to dequeue() from empty queue? 'y' for yes");
    try {
        if (System.in.read() == 121) {
            q.dequeue();
        }
    } catch (IOException e) {
        throw new RuntimeException(e);
    }
}
