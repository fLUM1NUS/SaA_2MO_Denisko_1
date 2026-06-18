public class MyBinaryTree<T extends Comparable<T>> {
    MyBinaryTreeNode<T> root = new MyBinaryTreeNode<>();
    int len;

    protected static class MyBinaryTreeNode<T extends Comparable<T>> implements Comparable<T> {
        T value;
        MyBinaryTreeNode<T> left, right;
        @Override
        public int compareTo(T o) {
            return this.value.compareTo(o);
        }

        public MyBinaryTreeNode() {
            this.value = null; this.left = null; this.right = null;
        }
        public MyBinaryTreeNode(T value) {
            this.value = value;
            this.left = null; this.right = null;
        }

        @Override
        public String toString() {
            return "MyBinaryTreeNode{" +
                    "value=" + value +
                    ", left=" + left +
                    ", right=" + right +
                    '}';
        }
    }

    public MyBinaryTree() {
        root.value = null;
        len = 0;
    }
    public MyBinaryTree(T value) {
        root.value = value;
        len = 1;
    }

    public boolean isEmpty(){return len == 0;}
    public int count(){return len;}

    public void add(T value) {
        if (isEmpty()) {root.value = value;}
        else {
            addTo(root, value);
        }
        len++;
    }

    private void addTo(MyBinaryTreeNode<T> node, T value) {
        if (value.compareTo(node.value) < 0) {
            if (node.left == null) {node.left = new MyBinaryTreeNode<>(value);}
            else addTo(node.left, value);
        } else if (value.compareTo(node.value) > 0) {
            if (node.right == null) {node.right = new MyBinaryTreeNode<>(value);}
            else addTo(node.right, value);
        }

    }

    public boolean contains(T value) {
        return findNode(value) != null;
    }

    public MyBinaryTreeNode findNode(T value) {
        if (isEmpty()) return null;
        return findNodeP(root, value);
    }
    private MyBinaryTreeNode findNodeP(MyBinaryTreeNode node, T value) {
        if (node.value.compareTo(value) > 0) {
            if (node.left != null) return findNodeP(node.left, value);
            else return null;
        } else
        if (node.value.compareTo(value) < 0) {
            if (node.right != null) return findNodeP(node.right, value);
            else return null;
        }
        else return node;
    }

    public boolean remove(T value) {
        if (isEmpty()) return false;
        root = removeNode(root, value);
        return true;
    }
    private MyBinaryTreeNode<T> removeNode(MyBinaryTreeNode<T> node, T value) {
        if (node == null) return null;

        int cmp = value.compareTo(node.value);

        if (cmp < 0) {
            node.left = removeNode(node.left, value);
        } else if (cmp > 0) {
            node.right = removeNode(node.right, value);
        } else {
            if (node.right == null) {
                return node.left;
            }
            if (node.left == null) {
                return node.right;
            }
            MyBinaryTreeNode<T> minRight = findMinNode(node.right);
            node.value = minRight.value;
            node.right = removeNode(node.right, minRight.value);
            len--;
        }

        return node;
    }
    private MyBinaryTreeNode<T> findMinNode(MyBinaryTreeNode<T> node) {
        while (node.left != null) {
            node = node.left;
        }
        return node;
    }

    public void clear() {
        root = new MyBinaryTreeNode<>();
        len = 0;
    }


    @FunctionalInterface
    public interface Action<T> {
        void perform(T value);
    }

    public void preOrder(Action<T> action) {
        preOrderTraversal(root, action);
    }
    private void preOrderTraversal(MyBinaryTreeNode<T> node, Action<T> action) {
        if (node == null || node.value == null) return;
        action.perform(node.value);
        preOrderTraversal(node.left, action);
        preOrderTraversal(node.right, action);
    }

    public void postOrder(Action<T> action) {
        postOrderTraversal(root, action);
    }
    private void postOrderTraversal(MyBinaryTreeNode<T> node, Action<T> action) {
        if (node == null || node.value == null) return;
        postOrderTraversal(node.left, action);
        postOrderTraversal(node.right, action);
        action.perform(node.value);
    }

    public void inOrder(Action<T> action) {
        if (isEmpty()) return;

        MyStack<MyBinaryTreeNode<T>> stack = new MyStack<>();
        MyBinaryTreeNode<T> current = root;

        while (current != null || !stack.isEmpty()) {
            while (current != null && current.value != null) {
                stack.push(current);
                current = current.left;
            }
            current = stack.pop();
            action.perform(current.value);
            current = current.right;
        }
    }

}
