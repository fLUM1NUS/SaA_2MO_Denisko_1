//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
void main() {
    MyStack<Integer> a = new MyStack<>(1);
    a.push(2);
    System.out.println("peek:" + a.peek());
    System.out.println("pop:" + a.pop());
    a.push(22);
    a.push(33);
    System.out.println(a.print());
    while (!a.isEmpty()) {
        System.out.println(a.pop());
    }

    System.out.println("try to pop from empty stack? 'y' for yes");
    try {
        if (System.in.read() == 121) {
            a.pop();
        }
    } catch (IOException e) {
        throw new RuntimeException(e);
    }
}
