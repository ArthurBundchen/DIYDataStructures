package pkgdiystack;

public interface DIYStackInterface<T> {
    
    public void add(T e);
    
    public T pop();
    
    public T peek();
    
    public boolean isEmpty();
    
    public int size();
    
    @Override
    public String toString();
}
