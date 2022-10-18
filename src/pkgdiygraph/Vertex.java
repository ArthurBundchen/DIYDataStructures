package pkgdiygraph;

/**
 *
 * @author arthu
 */
public class Vertex<T> {
    private T info;
    
    public int hashcode(){
        return info.hashCode();
    }

    public T getInfo() {
        return info;
    }
    
}
