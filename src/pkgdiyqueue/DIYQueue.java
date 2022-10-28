package pkgdiyqueue;


public class DIYQueue<T> implements DIYQueueInterface<T>{
    
    private Node first;
    
    private Node last;
    
    private int counter;

    @Override
    public void enqueue(T e) {
        Node<T> newNode = new Node(e);
        if(first == null){
            first = newNode;
            last = newNode;
        } else{
            last.next = newNode;
            last = newNode;
        }
        counter++;
    }

    @Override
    public T dequeue() {
        if(!this.isEmpty()){
            T p = this.peek();
            first = first.next;
            counter--;
            return p;
        } else{
            return null;
        }
    }

    @Override
    public T peek() {
        return (T) first.data;
    }

    @Override
    public boolean isEmpty() {
        if(counter == 0 && first == null){
            return true;
        } else{
            return false;
        }
    }

    @Override
    public int size() {
        return this.counter;
    }
    
    @Override
    public String toString(){
        String s = "";
        Node p = first;
        if(this.isEmpty()){
            s = "Empty";
        } else{
            while(p != null){
                s += p.data + " ";
                p = p.next;
            }
        }    
        return s;
    }
    
}
