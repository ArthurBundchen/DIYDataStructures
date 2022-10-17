package pkgdiystack;

import pkgdiyqueue.*;

public class Node<T> {
    
    protected T data;
    
    protected Node next;

    public Node(T data) {
        this.data = data;
    }
}
