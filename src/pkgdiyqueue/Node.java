package pkgdiyqueue;

public class Node<T> {
    
    public T data;
    
    protected Node next;

    public Node(T data) {
        this.data = data;
    }
}
