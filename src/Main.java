//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
void main() {

    MySet<Integer> set1 = new MySet<>();
    set1.add(1); set1.add(2); set1.add(3); set1.add(4);
    MySet<Integer> set2 = new MySet<>();
    set2.add(1); set2.add(2); set2.add(5); set2.add(6);

    System.out.println( set2.symmetricDifference(set1).items );

    MySet<Integer> set3 = new MySet<>();
    set3.add(1); set3.add(2); set3.add(3); set3.add(4);
    System.out.println(set1.isSubset(set3));


}
