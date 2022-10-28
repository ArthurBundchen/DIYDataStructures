package pkgdiylinkedlist;

public class DIYLinkedList<T> implements DIYLinkedListInterface<T> {
    
    private Node head;
    
    private Node tail;
    
    private int counter;
    
    @Override
    public void add(T e) {
        Node<T> newNode = new Node(e);
        if(head == null){
            head = newNode;
            tail = newNode;
        } else {
            tail.next = newNode;
            tail = newNode;
        }
        counter++;
    }
    
    @Override
    public boolean pop(T e) {
        boolean r = false;
        if(!this.isEmpty()){ //If isn't empty
            if(head.data.equals(e)){ //If the element to pop is the head
                head = head.next;
                if(this.isEmpty()){
                    tail = null;
                }
                counter--;
                r = true;
            } else { //If the element to pop is any other element except the head
                Node p = head;
                while (p.next != null) {
                    if (p.next.data.equals(e)) { //Found the element
                        p.next = p.next.next;
                        counter--;
                        r = true;
                        if(p.next == null){ //If the element is the tail, make it the tail
                            tail = p;
                        }
                        break;
                    }
                    p = p.next;
                }
            }
        }
        return r;
    }

    @Override
    public T get(int index) {
        T r = null;
        int k = 0;
        Node<T> p = head;
        while(p != null && k < index){
            p = p.next;
            k++;
        }
        if(k == index && p != null){
            return  p.data;
        }
        return r;
    }

    @Override
    public int indexOf(T e) {
        Node<T> p = this.head;
        int i = -1;
        int k = 0;
        if(!this.isEmpty()){
            while(p != null){
                if(p.data.equals(e)){
                    i = k;
                    break;
                }
                k++;
                p = p.next;
            }
        }
        return i;
    }
    
    @Override
    public void print(){
        System.out.println(this);
    }

    @Override
    public boolean isEmpty() {
        if(head == null){
            return true;
        } else {
            return false;
        }
    }

    @Override
    public boolean isFull() {
        return false;
    }

    @Override
    public int size() {
        return counter;
    }
    
    public String toString() {
        String s = "Inicio ";
        Node p = head;
        while(p != null){
            s += "-> " + p.data + " ";
            p = p.next;
        }
        return s;
    }
}
