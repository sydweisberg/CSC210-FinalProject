public class Node<T> {
    private T data;
    private Node<T> left;
    private Node<T> right;

    public Node(T d) {
        data = d;
        left = null;
        right = null;
    }

    // Getters //
    public Node<T> getLeft() {
        if(left == null) {
            return null;
        }
        return left;
    }

    public Node<T> getRight() {
        if(right == null) {
            return null;
        }
        return right;
    }

    public T getData() {
        return data;
    }

    // Setters //
    public void setLeft(Node<T> l) {
        left = l;
    }

    public void setRight(Node<T> r) {
        right = r;
    }

    public void setData(T da) {
        data = da;
    }

}