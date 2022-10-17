package pkgdiyqueue;

/**
 *
 * @author arthu
 * @param <T>
 */

public interface DIYQueueInterface<T> {
    
    public void enqueue(T e);
    
    public T dequeue();
    
    public T peek();
    
    public boolean isEmpty();
    
    public int size();
    
    @Override
    public String toString();
}
