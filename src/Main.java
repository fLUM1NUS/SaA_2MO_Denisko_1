//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
void main() {
    MyBinaryTree<Integer> tree = new MyBinaryTree<>();

    System.out.println("5, 3, 7, 2, 4, 6, 8");
    tree.add(5);
    tree.add(3);
    tree.add(7);
    tree.add(2);
    tree.add(4);
    tree.add(6);
    tree.add(8);
    System.out.println(tree.count());

    System.out.println("4 in: " + tree.contains(4));
    System.out.println("10 in: " + tree.contains(10));

    System.out.print("Preorder:\t");
    tree.preOrder(value -> System.out.print(value + " "));
    System.out.println();

    System.out.print("Inorder:\t");
    tree.inOrder(value -> System.out.print(value + " "));
    System.out.println();

    System.out.print("Postorder:\t");
    tree.postOrder(value -> System.out.print(value + " "));
    System.out.println();

    System.out.println("-2" + tree.remove(2));
    tree.inOrder(value -> System.out.print(value + " "));
    System.out.println();

    System.out.println("-3" + tree.remove(3));
    tree.inOrder(value -> System.out.print(value + " "));
    System.out.println();

    System.out.println("-5" + tree.remove(5));
    tree.inOrder(value -> System.out.print(value + " "));
    System.out.println();

    System.out.println(tree.isEmpty());
    tree.clear();
    System.out.println(tree.isEmpty());

}
