package pkgdiygraph;

import java.util.Objects;

/**
 *
 * @author arthu
 */
public class Vertex<T> {
    
    private T info;

    public Vertex(T info) {
        this.info = info;
    }

    public T getInfo() {
        return info;
    }

    @Override
    public String toString() {
        return "-> " + info;
    }
    
    @Override
    public int hashCode(){
        return info.hashCode();
    }
    
    @Override
    public boolean equals(Object o){
        boolean answer = false;
        if(o instanceof Vertex){
            answer =  info.equals(((Vertex) o).info);
        }
        return answer;
    }
    
    
}
