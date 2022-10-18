package pkgdiygraph;

/**
 *
 * @author arthu
 */
public class VertexesBond<T> {
    
    private Vertex<T> origin;
    private Vertex<T> destiny;
    private int weight;

    public VertexesBond(Vertex<T> origin, Vertex<T> destiny) {
        this.origin = origin;
        this.destiny = destiny;
    }

    
    public Vertex<T> getOrigin() {
        return origin;
    }

    public Vertex<T> getDestiny() {
        return destiny;
    }

    public int getWeight() {
        return weight;
    }   
    
}
