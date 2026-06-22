//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
void main() {

    MyLinkedList<Integer> list = new MyLinkedList<>();
    list.add(1);
    list.add(2);
    list.add(3);

    System.out.println(list.getFirstO() + " " + list.getLastO());
    System.out.println(list.getFirst() + " " + list.getLast());
    System.out.println(list.removeLast());
    System.out.println(list.remove());
    System.out.println(list.getFirstO() + " " + list.getLastO());
    System.out.println(list.getFirst() + " " + list.getLast());
    list.add(10); list.add(20);
    System.out.println(Arrays.toString(list.toArray()));

    System.out.println();

    LinkedList<Integer> list2 = new LinkedList<>();
    list2.add(1);
    list2.add(2);
    list2.add(3);
    System.out.println(list2.getFirst() + " " + list2.getLast());
    System.out.println(list2.pop());
    list2.add(1,0);
    System.out.println(list2.pop());
    System.out.println(list2.pop());
    System.out.println(list2.pop());


}
