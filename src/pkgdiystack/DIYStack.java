
package pkgdiystack;

public class DIYStack<T> implements DIYStackInterface<T> {
    
    protected Node top;
    
    protected Node bottom;
    
    protected int counter;

    @Override
    public void add(T e) {
        Node<T> newNode = new Node(e);
        if(this.isEmpty()){
            //Se estiver vazia
            top = newNode;
            bottom = newNode;
        } else{
            top.next = newNode;
            top = newNode;
        }
        counter++;
    }

    @Override
    public T pop() {
        if(!this.isEmpty()){
            T p = this.peek();
            if(this.counter == 1){
                bottom = top = null;
            } else {
                Node temp = bottom;
                while(temp.next.next != null){
                    temp = temp.next;
                }
                top = temp;
                temp.next = null;
            }
            counter--;
            return p;
        } else {
            return null;
        }        
    }

    @Override
    public T peek() {
        if(!this.isEmpty()){
            return (T) top.data;
        } else {
            return null;
        }
    }

    @Override
    public boolean isEmpty() {
        if(counter == 0){
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
        Node p = bottom;
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
