package pkgdiylinkedlist;

public interface DIYLinkedListInterface<T> {
    
    public void add(T e);
    
    public boolean pop(T e);
    
    public T get(int index);
    
    public int indexOf(T e);
    
    public void print();
    
    public boolean isEmpty();
    
    public boolean isFull();
    
    public int size();
}
