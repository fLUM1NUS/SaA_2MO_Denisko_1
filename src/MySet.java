import java.util.ArrayList;
import java.util.Iterator;

public class MySet<T extends Comparable<T>> implements Iterable<T> {
    ArrayList<T> items = new ArrayList<>();

    public MySet() {}
    public MySet(Iterable<T> items) {addRange(items);}

    public boolean isEmpty() {return items.isEmpty();}
    public boolean contains(T value){return items.contains(value);}
    public void add(T value){
        if (!contains(value)) items.add(value);
        //else throw new RuntimeException("duli");
    }
    public void addRange(Iterable<T> items) {
        for (T item : items) {add(item);}
    }
    public void remove(T value){items.remove(value);}
    public int size(){return items.size();}

    public MySet<T> union(MySet<T> set2){
        MySet<T> res = new MySet<>(items);
        res.addRange(set2.items);
        return res;
    }

    public MySet<T> intersection(MySet<T> set2){
        MySet<T> res = new MySet<>();
        for (T item : set2.items) {
            if (contains(item)) res.add(item);
        }
        return res;
    }

    public MySet<T> difference(MySet<T> set2){
        MySet<T> res = new MySet<>(items);
        for (T item : set2.items) {
            res.remove(item);
        }
        return res;
    }
    public MySet<T> symmetricDifference(MySet<T> set2){
        MySet<T> s1 = this.union(set2);
        MySet<T> s2 = this.intersection(set2);
        return s1.difference(s2);
    }

    public boolean isSubset(MySet<T> set2){
        MySet<T> s1 = this.difference(set2);
        return s1.isEmpty();
    }

    @Override
    public Iterator<T> iterator() {
        return items.iterator();
    }
}